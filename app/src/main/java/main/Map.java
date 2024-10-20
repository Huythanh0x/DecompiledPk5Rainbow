package main;

import android.util.Log;
import dm.Ms;
import dm.Npc;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import java.io.ByteArrayOutputStream;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import minigame.Mg;

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
  
  public Map(GameRun paramGameRun) {
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte2 = new byte[2];
    arrayOfByte2[1] = -1;
    byte[] arrayOfByte5 = new byte[2];
    arrayOfByte5[1] = 1;
    byte[] arrayOfByte3 = new byte[2];
    arrayOfByte3[0] = -1;
    byte[] arrayOfByte4 = new byte[2];
    arrayOfByte4[0] = 1;
    this.dir_select = new byte[][] { arrayOfByte1, arrayOfByte2, arrayOfByte5, arrayOfByte3, arrayOfByte4 };
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
    this.gr = paramGameRun;
    System.gc();
    init();
  }
  
  private void addCloud(int paramInt) {
    short[] arrayOfShort = this.cloud[paramInt];
    short s = this.leftCol;
    int i = Constants_H.WIDTH;
    Ms.i();
    arrayOfShort[0] = (short)(s * 20 + i + Ms.getRandom(Constants_H.WIDTH_H));
    arrayOfShort = this.cloud[paramInt];
    i = this.topRow;
    Ms.i();
    arrayOfShort[1] = (short)(i * 20 + 20 + 2 + (Ms.getRandom(25) + 55) * paramInt);
    arrayOfShort = this.cloud[paramInt];
    Ms.i();
    arrayOfShort[2] = (short)(Ms.getRandom(3) + 1);
  }
  
  private void canMove(int paramInt1, int paramInt2) {
    this.my.speed_x = (byte)paramInt1;
    this.my.speed_y = (byte)paramInt2;
    if (this.my.x + this.my.speed_x >= 0 && this.my.x + this.my.speed_x + 19 < this.cols * 20 && this.my.y + this.my.speed_y >= 0 && this.my.y + this.my.speed_y + 19 < this.rows * 20) {
      this.roadType = checkMap(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y);
      if (this.roadType == 0) {
        initMoveMy();
        return;
      } 
      if (checkMoveOff(this.checkNpcT)) {
        initMoveMy();
        return;
      } 
      if (this.checkNpcT == -1 || isCheckNpcOff()) {
        this.roadType = isMapChenk(this.roadType);
        if (this.roadType == -1) {
          moveOff((byte)3, (byte)1, -this.my.speed);
          return;
        } 
        if (this.roadType == -2) {
          moveOff((byte)4, (byte)2, this.my.speed);
          return;
        } 
        checkAnole();
        return;
      } 
      Ms.i().keyRelease();
      setMoveStop_m();
      return;
    } 
    setMoveStop_m();
    this.checkType = checkIfOther(this.door, this.my.x, this.my.y);
    if (this.checkType != -1 && this.door[this.checkType][5] == 0 && this.map_key == this.door[this.checkType][2]) {
      this.my.state = 5;
      this.get_meet = this.checkType;
    } 
  }
  
  private void checkAnole() {
    this.checkType = checkWorld(this.my.x, this.my.y, this.my.speed_x, this.my.speed_y, true);
    if (this.checkType == 2) {
      if (isCheckAnole(4))
        return; 
    } else {
      if (this.checkType == 3) {
        if (!isCheckAnole(0)) {
          Ms.i().keyRelease();
          setMoveStop_m();
          return;
        } 
        return;
      } 
      if (this.checkType == 4) {
        if (isCheckAnole(2))
          return; 
      } else if (this.checkType == 0 && this.anole_type == 4) {
        if (this.anole_type != 3 && isAnoleType(3)) {
          this.anole_type = 3;
        } else {
          this.anole_type = -1;
        } 
        setAnole();
        initMoveMy();
        return;
      } 
    } 
    Ms.i().keyRelease();
    setMoveStop_m();
  }
  
  private byte checkIfNpc(Npc[] paramArrayOfNpc, int paramInt1, int paramInt2) {
    byte b = (byte)(paramArrayOfNpc.length - 1);
    while (true) {
      if (b <= -1)
        return -1; 
      if (!Ms.i().isRect(paramInt1, paramInt2, 19, 19, (paramArrayOfNpc[b]).x, (paramArrayOfNpc[b]).y, 20, 20) || ((paramArrayOfNpc[b]).other[4] != 1 && (paramArrayOfNpc[b]).other[4] != 3)) {
        b = (byte)(b - 1);
        continue;
      } 
      return b;
    } 
  }
  
  private byte checkIfOther(byte[][] paramArrayOfbyte, int paramInt1, int paramInt2) {
    byte b = (byte)(paramArrayOfbyte.length - 1);
    while (true) {
      if (b <= -1)
        return -1; 
      if (!Ms.i().isRect(paramInt1, paramInt2, 19, 19, paramArrayOfbyte[b][0] * 20, paramArrayOfbyte[b][1] * 20, 20, 20)) {
        b = (byte)(b - 1);
        continue;
      } 
      return b;
    } 
  }
  
  private byte checkMap(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.checkNpcT = -1;
    this.checkType = checkIfOther(this.item, paramInt1 + paramInt3, paramInt2 + paramInt4);
    if (this.checkType != -1) {
      this.checkNpcT = -2;
      return 1;
    } 
    if (paramInt1 + paramInt3 < 0 || paramInt1 + paramInt3 >= this.cols * 20 || paramInt2 + paramInt4 < 0 || paramInt2 + paramInt4 >= this.rows * 20)
      return 1; 
    this.checkType = checkIfNpc(this.npc[0], paramInt1 + paramInt3, paramInt2 + paramInt4);
    if (this.checkType != -1) {
      if (!this.npcNameData[this.checkType].equals("路人") || (this.npc[0][this.checkType]).other[5] > 0)
        this.checkNpcT = this.checkType; 
      return 1;
    } 
    this.checkType = checkIfOther(this.door, paramInt1 + paramInt3, paramInt2 + paramInt4);
    if (this.checkType != -1 && (this.door[this.checkType][5] == 2 || this.map_key == this.door[this.checkType][2])) {
      this.my.state = 5;
      this.get_meet = this.checkType;
      return 0;
    } 
    return checkWorld(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  private boolean checkMoveOff(int paramInt) {
    if (paramInt > -1) {
      byte b3 = (byte)((this.npc[0][paramInt]).x + 20 - this.my.x);
      byte b4 = (byte)((this.npc[0][paramInt]).x - this.my.x - 20);
      byte b2 = (byte)((this.npc[0][paramInt]).y + 20 - this.my.y);
      byte b1 = (byte)((this.npc[0][paramInt]).y - this.my.y - 20);
      if (this.my.speed_x < 0 && b3 != 0) {
        Npc npc = this.my;
        if (b3 < this.my.speed_x) {
          b1 = this.my.speed_x;
        } else {
          b1 = b3;
        } 
        npc.speed_x = b1;
        return true;
      } 
      if (this.my.speed_x > 0 && b4 != 0) {
        Npc npc = this.my;
        if (b4 < this.my.speed_x) {
          b1 = b4;
        } else {
          b1 = this.my.speed_x;
        } 
        npc.speed_x = b1;
        return true;
      } 
      if (this.my.speed_y < 0 && b2 != 0) {
        Npc npc = this.my;
        if (b2 < this.my.speed_y) {
          b1 = this.my.speed_y;
        } else {
          b1 = b2;
        } 
        npc.speed_y = b1;
        return true;
      } 
      if (this.my.speed_y > 0 && b1 != 0) {
        Npc npc = this.my;
        if (b1 >= this.my.speed_y)
          b1 = this.my.speed_y; 
        npc.speed_y = b1;
        return true;
      } 
    } else {
      paramInt = this.my.getIx_off();
      byte b2 = (byte)(20 - this.my.getIx_off());
      byte b3 = this.my.getIy_off();
      byte b1 = (byte)(20 - this.my.getIy_off());
      if (this.my.speed_x != 0 && paramInt != 0) {
        if (this.my.speed_x < 0) {
          Npc npc = this.my;
          if (-paramInt < this.my.speed_x) {
            paramInt = this.my.speed_x;
          } else {
            paramInt = -paramInt;
          } 
          npc.speed_x = (byte)paramInt;
        } else {
          Npc npc = this.my;
          if (b2 < this.my.speed_x) {
            b1 = b2;
          } else {
            b1 = this.my.speed_x;
          } 
          npc.speed_x = b1;
        } 
        return true;
      } 
      if (this.my.speed_y != 0 && b3 != 0) {
        if (this.my.speed_y < 0) {
          Npc npc = this.my;
          if (-b3 < this.my.speed_y) {
            paramInt = this.my.speed_y;
          } else {
            paramInt = -b3;
          } 
          npc.speed_y = (byte)paramInt;
        } else {
          Npc npc = this.my;
          if (b1 >= this.my.speed_y)
            b1 = this.my.speed_y; 
          npc.speed_y = b1;
        } 
        return true;
      } 
    } 
    return false;
  }
  
  private byte checkWorld(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #9
    //   3: iconst_1
    //   4: istore #10
    //   6: iload_3
    //   7: ifne -> 17
    //   10: iload_1
    //   11: bipush #20
    //   13: irem
    //   14: ifne -> 45
    //   17: iload #10
    //   19: istore #7
    //   21: iload #9
    //   23: istore #8
    //   25: iload #4
    //   27: ifne -> 52
    //   30: iload #10
    //   32: istore #7
    //   34: iload #9
    //   36: istore #8
    //   38: iload_2
    //   39: bipush #20
    //   41: irem
    //   42: ifeq -> 52
    //   45: iconst_2
    //   46: istore #7
    //   48: iload #9
    //   50: istore #8
    //   52: iload #8
    //   54: iload #7
    //   56: if_icmplt -> 65
    //   59: iconst_0
    //   60: istore #6
    //   62: iload #6
    //   64: ireturn
    //   65: iload #4
    //   67: ifne -> 148
    //   70: iload #8
    //   72: bipush #20
    //   74: imul
    //   75: iload_2
    //   76: iadd
    //   77: bipush #20
    //   79: idiv
    //   80: i2b
    //   81: istore #10
    //   83: iload_3
    //   84: iflt -> 137
    //   87: iload_1
    //   88: iload_3
    //   89: iadd
    //   90: bipush #19
    //   92: iadd
    //   93: bipush #20
    //   95: idiv
    //   96: istore #9
    //   98: iload #9
    //   100: i2b
    //   101: istore #9
    //   103: iload #5
    //   105: ifeq -> 206
    //   108: aload_0
    //   109: getfield worldData : [[S
    //   112: iload #9
    //   114: aaload
    //   115: iload #10
    //   117: saload
    //   118: ifeq -> 223
    //   121: aload_0
    //   122: getfield worldData : [[S
    //   125: iload #9
    //   127: aaload
    //   128: iload #10
    //   130: saload
    //   131: i2b
    //   132: istore #6
    //   134: goto -> 62
    //   137: iload_1
    //   138: iload_3
    //   139: iadd
    //   140: bipush #20
    //   142: idiv
    //   143: istore #9
    //   145: goto -> 98
    //   148: iload #8
    //   150: bipush #20
    //   152: imul
    //   153: iload_1
    //   154: iadd
    //   155: bipush #20
    //   157: idiv
    //   158: i2b
    //   159: istore #10
    //   161: iload #4
    //   163: iflt -> 194
    //   166: iload_2
    //   167: iload #4
    //   169: iadd
    //   170: bipush #19
    //   172: iadd
    //   173: bipush #20
    //   175: idiv
    //   176: istore #9
    //   178: iload #9
    //   180: i2b
    //   181: istore #11
    //   183: iload #10
    //   185: istore #9
    //   187: iload #11
    //   189: istore #10
    //   191: goto -> 103
    //   194: iload_2
    //   195: iload #4
    //   197: iadd
    //   198: bipush #20
    //   200: idiv
    //   201: istore #9
    //   203: goto -> 178
    //   206: aload_0
    //   207: iload #9
    //   209: iload #10
    //   211: invokespecial isCan_not_pass : (II)Z
    //   214: ifeq -> 223
    //   217: iconst_1
    //   218: istore #6
    //   220: goto -> 62
    //   223: iload #8
    //   225: iconst_1
    //   226: iadd
    //   227: i2b
    //   228: istore #8
    //   230: goto -> 52
  }
  
  private void configureNpc() {
    npcSp[0] = new Sprite[100];
    npcSp[1] = new Sprite[5];
    npcSp[2] = new Sprite[60];
  }
  
  private void createMap() {
    loadMapModuleAndImage();
    loadMapData(this.mapNo);
  }
  
  private void dialog(String paramString) {
    int n = Constants_H.WIDTH__;
    int j = Constants_H.HEIGHT__;
    int k = j - 8 - 25 * 2;
    int m = 25 * 2 + 11;
    byte b = 0;
    Ui.i().drawKuang(4, j - m - 4, n - 4, m + 4);
    int i = b;
    if (paramString != null) {
      if (this.faceDir) {
        i = n - 50;
      } else {
        i = 50;
      } 
      if (this.faceDir) {
        j = j - m - 4;
      } else {
        j = j - m - 4 - 25;
      } 
      drawNpcFace(i, j, 0x1 | 0x20);
      Ui.i().drawKuang(0, k - m + 25, Ms.i().getStringWidth(paramString) + 16, 25 + 8);
      Ui.i().drawString(paramString, 8, k - m + 2 + 25, 0, 9, 1);
      Log.e("sk", "dialog");
      i = b;
    } 
    while (true) {
      if (i >= 2 || this.dialog_no + i >= this.dialog.length)
        return; 
      Ui.i().drawStringColor(this.dialog[this.dialog_no + i].toString(), 10, i * 25 + k - 2, -1, 1);
      i++;
    } 
  }
  
  private void drawAnoleSel() {
    this.gr.cur_a = (byte)Ms.i().mathSpeedN(this.gr.cur_a, 25 * 2 + 12, 8, false);
    Ui.i().drawK1(0, Constants_H.HEIGHT - this.gr.cur_a - 2, 119, 25 + 4 + 2, 2);
    Ui.i().drawK2(0, Constants_H.HEIGHT + 25 + 4 - this.gr.cur_a, Constants_H.WIDTH, 25 + 8, 0);
    for (byte b = 0;; b = (byte)(b + 1)) {
      int i;
      byte b1;
      if (b >= 5) {
        if (this.anoleSel == this.anole_type) {
          i = 0;
        } else {
          if (isAnoleType(this.anoleSel)) {
            i = this.anoleSel + 1;
          } else {
            i = 6;
          } 
          i = (byte)i;
        } 
        Log.e("sk", "drawAnoleSel");
        Ui.i().drawString(this.gr.about_a[i].toString(), 60, Constants_H.HEIGHT - this.gr.cur_a - 2, 17, 1, 2);
        Ui.i().drawK4(this.anoleSel * Constants_H.WIDTH / 6 + 41 + this.gr.cur_b / 3, Constants_H.HEIGHT + 25 + 7 - this.gr.cur_a + this.gr.cur_b / 3, 22 - (this.gr.cur_b / 3 << 1), 22 - (this.gr.cur_b / 3 << 1));
        GameRun gameRun = this.gr;
        i = gameRun.cur_b;
        gameRun.cur_b = (byte)(i + 1);
        if (i > 4)
          this.gr.cur_b = 0; 
        Ui.i().drawYesNo_(false, true);
        return;
      } 
      if (!isAnoleType(b)) {
        b1 = 6;
        i = (byte)(b + 70);
      } else {
        if (b == this.anoleSel) {
          i = 1;
        } else {
          i = 0;
        } 
        b1 = (byte)i;
        if (b == this.anole_type) {
          i = 69;
        } else {
          if (b == this.anoleSel) {
            i = b + 5;
          } else {
            i = b;
          } 
          i = (byte)i;
        } 
      } 
      Ui.i().drawK0(Constants_H.WIDTH * b / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20, b1);
      Ui.i().drawUi(i, Constants_H.WIDTH * b / 6 + 42 + 10, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a + 18, 33, 0);
      if (this.pkey.isSelect(Constants_H.WIDTH * b / 6 + 42, Constants_H.HEIGHT + 25 + 8 - this.gr.cur_a, 20, 20))
        if (this.anoleSel == b) {
          this.pkey.setKeySoftkey1();
        } else {
          this.anoleSel = b;
        }  
    } 
  }
  
  private void drawBrow() {
    for (byte b = 0;; b = (byte)(b + 1)) {
      if (b >= this.npcList.length)
        return; 
      byte b1 = this.npcList[b];
      if (b1 >= -1) {
        if (b1 == -1) {
          cur_npc = this.my;
        } else {
          cur_npc = this.npc[0][b1];
        } 
        if ((cur_npc.other[4] == 1 || cur_npc.other[4] == 2) && (cur_npc.brow_type > -1 || cur_npc.other[6] != 0) && (b1 <= -1 || isNpcSrc(cur_npc.x, cur_npc.y))) {
          if (cur_npc.other[6] != 0)
            cur_npc.brow_type = cur_npc.other[6]; 
          if (cur_npc.brow_action >= this.brow.aLength(cur_npc.brow_type))
            if (cur_npc.other[6] != 0) {
              cur_npc.brow_action = 0;
            } else {
              cur_npc.brow_type = -1;
              b = (byte)(b + 1);
            }  
          Ui.i().drawFrameOne(this.brow, this.brow.action(cur_npc.brow_type, cur_npc.brow_action, 0), this.map_x + cur_npc.x + 14, this.map_y + cur_npc.y - 15 - 10, 0);
          Npc npc = cur_npc;
          byte b2 = (byte)(npc.brow_time + 1);
          npc.brow_time = b2;
          if (b2 > this.brow.action(cur_npc.brow_type, cur_npc.brow_action, 1)) {
            npc = cur_npc;
            npc.brow_action = (byte)(npc.brow_action + 1);
            cur_npc.brow_time = 0;
          } 
        } 
      } 
    } 
  }
  
  private void drawCheck5(int paramInt) {
    if (this.checkNpcT != -1 && this.my.state == 0) {
      drawHudong();
      if (this.checkNpcT >= 0 && (this.npc[0][this.checkNpcT]).other[6] == 0) {
        drawHudong();
        Ui.i().drawFrameOne(this.brow, this.brow.action(paramInt, this.action_5, 0), this.map_x + (this.npc[0][this.checkNpcT]).x + 10, this.map_y + (this.npc[0][this.checkNpcT]).y - 16 - 10, 0);
        byte b = (byte)(this.time_5 + 1);
        this.time_5 = b;
        if (b > this.brow.action(paramInt, this.action_5, 1)) {
          b = (byte)(this.action_5 + 1);
          this.action_5 = b;
          if (b >= this.brow.aLength(paramInt))
            this.action_5 = 0; 
          this.time_5 = 0;
        } 
      } 
    } 
  }
  
  private void drawCloud() {
    if (this.imgCloud != null)
      for (byte b = 0;; b = (byte)(b + 1)) {
        if (b >= this.cloud.length) {
          b = 0;
          while (true) {
            if (b < this.cloud.length) {
              if (!isNpcSrc(this.cloud[b][0], this.cloud[b][1])) {
                addCloud(b);
              } else {
                short[] arrayOfShort = this.cloud[b];
                arrayOfShort[0] = (short)(arrayOfShort[0] - this.cloud[b][2]);
              } 
              b = (byte)(b + 1);
              continue;
            } 
            return;
          } 
          break;
        } 
        Ui.i().drawImage(this.imgCloud, this.map_x + this.cloud[b][0], this.map_y + this.cloud[b][1], 0);
      }  
  }
  
  private void drawHudong() {
    Ui.i().drawImage(this.hudong, Constants_H.WIDTH_H, Constants_H.HEIGHT - 30, 3);
  }
  
  private void drawMapRect(byte paramByte1, byte paramByte2, int paramInt, boolean paramBoolean) {
    byte b;
    int i = paramByte1 * 6;
    int j = paramByte2 * 6;
    if (this.miniMapMode) {
      i = this.mapdataMap[paramInt][6] * paramByte1;
      j = this.mapdataMap[paramInt][7] * paramByte2;
    } 
    if (paramBoolean) {
      Ui.i().drawRectZ(12352252, this.mapdataMap[paramInt][0] * paramByte1 + this.mapoffx, this.mapdataMap[paramInt][1] * paramByte2 + this.mapoffy, i, j, 5);
      return;
    } 
    if (paramInt == this.myMiniMap) {
      Ui ui = Ui.i();
      byte b4 = this.mapdataMap[paramInt][0];
      b = this.mapoffx;
      byte b3 = this.mapdataMap[paramInt][1];
      ui.drawK1(b + b4 * paramByte1, this.mapoffy + b3 * paramByte2, i, j, 4);
    } else {
      Ui ui = Ui.i();
      byte b3 = this.mapdataMap[paramInt][0];
      short s = this.mapoffx;
      b = this.mapdataMap[paramInt][1];
      ui.drawK0(s + b3 * paramByte1, this.mapoffy + b * paramByte2, i, j, 2);
    } 
    GameRun gameRun = this.gr;
    String str = this.gr.getNameCity(paramInt);
    byte b1 = this.mapdataMap[paramInt][0];
    short s1 = this.mapoffx;
    byte b2 = this.mapdataMap[paramInt][1];
    short s2 = this.mapoffy;
    if (paramInt == this.myMiniMap) {
      b = 0;
    } else {
      b = 3;
    } 
    gameRun.showStringM(str, b1 * paramByte1 + s1 + (i >> 1), b2 * paramByte2 + s2 + (j >> 1) - 25, 4, b);
    if (paramInt == this.myMiniMap)
      Ui.i().drawUi(67, this.mapdataMap[paramInt][0] * paramByte1 + this.mapoffx + (i >> 1), this.mapdataMap[paramInt][1] * paramByte2 + this.mapoffy + (j >> 1), 3, 0); 
  }
  
  private void drawMapRect(Graphics paramGraphics) {
    byte b = 0;
    paramGraphics.setColor(0);
    label13: while (true) {
      if (b >= this.gr.mapRect.length)
        return; 
      if (Ms.i().isRect(this.my.x, this.my.y, 19, 19, this.gr.mapRect[b][0] * 20, this.gr.mapRect[b][1] * 20, (this.gr.mapRect[b][2] - this.gr.mapRect[b][0] + 1) * 20, (this.gr.mapRect[b][3] - this.gr.mapRect[b][1] + 1) * 20))
        continue; 
      byte b1 = 4;
      while (true) {
        if (b1 < (this.gr.mapRect[b]).length) {
          paramGraphics.fillRect(this.map_x + this.gr.mapRect[b][b1] * 20, this.map_y + this.gr.mapRect[b][b1 + 1] * 20, (this.gr.mapRect[b][b1 + 2] - this.gr.mapRect[b][b1] + 1) * 20, (this.gr.mapRect[b][b1 + 3] - this.gr.mapRect[b][b1 + 1] + 1) * 20);
          b1 = (byte)(b1 + 4);
          continue;
        } 
        b = (byte)(b + 1);
        continue label13;
      } 
      break;
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
      Ui.i().drawString("该区域没有地图！", 320, 360 - 4 - 29 * 2, 0x10 | 0x1, 3, 0);
      return;
    } 
    this.gr.showStringM("人物当前位置：" + this.gr.getNameCity(this.myMiniMap), 320, 360 - 4 - 29 * 2, 10, 3);
    g.setClip(6, 33, 640 - 12, 360 - 15 - 29 * 3);
    boolean bool = false;
    byte b = this.mapdataMap[this.selectMap][0];
    if (this.miniMapMode) {
      i = this.mapdataMap[this.selectMap][6] * 18 / 2;
    } else {
      i = 25;
    } 
    this.mapoffx = Ms.i().mathSpeedN(this.mapoffx, 320 - b * 18 - i, 10, false);
    int j = this.littleMapClipY / 2;
    b = this.mapdataMap[this.selectMap][1];
    if (this.miniMapMode) {
      i = this.mapdataMap[this.selectMap][7] * 12 / 2;
    } else {
      i = 15;
    } 
    this.mapoffy = Ms.i().mathSpeedN(this.mapoffy, j - b * 12 - i, 10, false);
    for (int i = bool;; i = (byte)(i + 1)) {
      if (i >= (this.mapdataArea[this.showArea]).length) {
        if (!this.miniMapMode)
          drawMapRect((byte)18, (byte)12, this.myMiniMap, false); 
        drawMapRect((byte)18, (byte)12, this.selectMap, true);
        g.setClip(0, 0, 640, 360);
        return;
      } 
      byte b1 = this.mapdataArea[this.showArea][i];
      if (b1 >= 0 && (this.mapdataMap[b1]).length > 0) {
        if (this.pkey.isSelect(this.mapdataMap[b1][0] * 18 + this.mapoffx, this.mapdataMap[b1][1] * 12 + this.mapoffy, 18 * 6, 12 * 6))
          this.selectMap = b1; 
        if (this.miniMapMode || b1 != this.myMiniMap)
          drawMapRect((byte)18, (byte)12, b1, false); 
      } 
    } 
  }
  
  private void drawMission() {
    Ui.i().fillRectB();
    Ui.i().drawK2(1, 6, 640 - 2, 360 - 6, 0);
    Ui.i().drawK1(8, 41, 640 - 26, this.gr.line_max * 29 + 10, 1);
    Ui.i().drawK1(8, this.gr.line_max * 29 + 59, 640 - 16, 125, 2);
    byte b = this.gr.line_max;
    byte[] arrayOfByte = this.gr.select[0];
    if (this.gr.cur_a == 0) {
      i = this.bMission[14] + 1;
    } else {
      i = this.mDirect.length;
    } 
    drawMisstionList(8, 41 + 6, 640 - 26, 29, b, arrayOfByte, i);
    for (int i = 0;; i = (byte)(i + 1)) {
      if (this.gr.about_a == null || i >= this.gr.about_a.length) {
        String str;
        byte b1 = this.pkey.selectMenuX(2, 0, 0, 320, 40);
        if (b1 != -1) {
          this.gr.cur_a = b1;
          goMission(this.gr.cur_a, this.bPause);
        } 
        Ui ui1 = Ui.i();
        if (this.gr.cur_a == 0) {
          i = 320 - 125;
        } else {
          i = 320 + 25;
        } 
        ui1.drawK1(i, 9, 100, 29, 4);
        ui1 = Ui.i();
        if (this.gr.cur_a == 0) {
          i = 0;
        } else {
          i = 1;
        } 
        ui1.drawString("主线任务", 320 - 75, 9, 17, i, 0);
        ui1 = Ui.i();
        if (this.gr.cur_a == 1) {
          i = 0;
        } else {
          i = 1;
        } 
        ui1.drawString("分支任务", 320 + 75, 9, 17, i, 0);
        Ui.i().drawTriangle(320, 20, 150, true, true);
        Ui ui2 = Ui.i();
        if (this.gr.cur_a == 0) {
          str = "主线完成度：";
        } else {
          str = "分支完成度：";
        } 
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
        Ms ms = Ms.i();
        byte[] arrayOfByte1 = this.bMission;
        if (this.gr.cur_a == 0) {
          i = 14;
        } else {
          i = 15;
        } 
        b = arrayOfByte1[i];
        if (this.gr.cur_a == 0) {
          i = this.sMission.length - 1;
        } else {
          i = this.sMission.length;
        } 
        ui2.drawString(stringBuilder.append(ms.getPrecision(b * 1000 / i)).append("%").toString(), 320, 360 - 1, 33, -1, 1);
        Ui.i().drawYesNo(false, true);
        return;
      } 
      Ui.i().drawStringColor(this.gr.about_a[i].toString(), 25, this.gr.line_max * 29 + 61 + i * 25, 3, 0);
    } 
  }
  
  private void drawMisstionList(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfbyte, int paramInt6) {
    byte b = paramArrayOfbyte[1];
    Ui.i().drawListKY(paramInt5, paramInt1, paramInt2, paramInt3, 6, paramInt4, -1, paramArrayOfbyte[0] - paramArrayOfbyte[1], 4, 2);
    while (true) {
      if (b >= paramArrayOfbyte[1] + paramInt5) {
        Ui.i().sliding(paramInt1 + paramInt3 + 4, paramInt2, paramInt5 * paramInt4, paramArrayOfbyte[0], paramInt6, true);
        return;
      } 
      if (b < paramInt6) {
        byte b1;
        String str;
        if (this.gr.cur_a == 0) {
          str = String.valueOf(b + 1) + "、" + this.sMission[b][0].toString();
        } else {
          str = String.valueOf(b + 1) + "、" + this.sMission[this.mDirect[b]][0].toString();
        } 
        Log.e("sk", "drawMisstionList");
        Ui ui = Ui.i();
        byte b2 = paramArrayOfbyte[1];
        if (b < this.bMission[14]) {
          b1 = -1;
        } else if (paramArrayOfbyte[0] == b) {
          b1 = 0;
        } else {
          b1 = 3;
        } 
        ui.drawString(str, paramInt1 + 8, (b - b2) * (paramInt4 - 1) + paramInt2, 0, b1, 0);
        if (this.gr.cur_a == 0 && b != paramInt6 - 1) {
          Ui ui1 = Ui.i();
          b2 = paramArrayOfbyte[1];
          if (b < this.bMission[14]) {
            b1 = -1;
          } else if (paramArrayOfbyte[0] == b) {
            b1 = 0;
          } else {
            b1 = 3;
          } 
          ui1.drawString("完成", paramInt1 + paramInt3 - 8, paramInt2 + (b - b2) * (paramInt4 - 1), 24, b1, 0);
        } 
        if (this.pkey.isSelect(0, (b - paramArrayOfbyte[1]) * (paramInt4 - 1) + paramInt2, 640, paramInt4 - 1)) {
          paramArrayOfbyte[0] = b;
          if (b - paramArrayOfbyte[1] == 0 && paramArrayOfbyte[1] > 0) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] - 1);
          } else if (b - paramArrayOfbyte[1] == paramInt5 - 1 && paramArrayOfbyte[1] + paramInt5 < paramInt6) {
            paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] + 1);
          } 
          if (this.gr.cur_a == 0) {
            this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
          } else if (this.mDirect.length > 0) {
            this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
          } 
        } 
      } 
      b = (byte)(b + 1);
    } 
  }
  
  private void drawMySave() {
    this.gr.showString("是否存盘?", 285, 0);
    Ui.i().drawYesNo(true, true);
  }
  
  private void drawNMAni(Npc[] paramArrayOfNpc) {
    if (paramArrayOfNpc != null) {
      byte b = 0;
      while (true) {
        if (b < this.npcList.length) {
          byte b1 = this.npcList[b];
          if (b1 == -1) {
            if (this.my.other[4] == 1 || this.my.other[4] == 2)
              drawMyAni(this.my, 0, this.map_x + this.my.x + 10, this.map_y + this.my.y + 19, this.my.other[7]); 
          } else if (b1 < -1) {
            Ms.i();
            byte b2 = (byte)(Ms.abs(b1) - 2);
            if (isNpcSrc(this.item[b2][0] * 20, this.item[b2][1] * 20)) {
              Ui ui = Ui.i();
              if (this.item[b2][2] == 2) {
                b1 = 55;
              } else {
                b1 = 54;
              } 
              ui.drawUi(b1, this.map_x + this.item[b2][0] * 20 + 10, this.map_y + this.item[b2][1] * 20 + 20, 33, 0);
            } 
          } else {
            if (((paramArrayOfNpc[b1]).other[4] == 1 || (paramArrayOfNpc[b1]).other[4] == 2) && isNpcSrc((paramArrayOfNpc[b1]).x, (paramArrayOfNpc[b1]).y)) {
              if ((paramArrayOfNpc[b1]).other[8] != 3 && !this.npcNameData[b1].equals("路人"))
                g.drawImage(this.imgShadow, this.map_x + (paramArrayOfNpc[b1]).x + 10, this.map_y + (paramArrayOfNpc[b1]).y + 20, 33); 
              drawNpcAniOne(paramArrayOfNpc, b1);
            } 
            runNpcAniOne(paramArrayOfNpc, b1);
          } 
          b = (byte)(b + 1);
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void drawNpcAni(Npc[] paramArrayOfNpc) {
    if (paramArrayOfNpc != null) {
      byte b = 0;
      while (true) {
        if (b < paramArrayOfNpc.length) {
          if (((paramArrayOfNpc[b]).other[4] == 1 || (paramArrayOfNpc[b]).other[4] == 2) && isNpcSrc((paramArrayOfNpc[b]).x, (paramArrayOfNpc[b]).y))
            drawNpcAniOne(paramArrayOfNpc, b); 
          runNpcAniOne(paramArrayOfNpc, b);
          b = (byte)(b + 1);
          continue;
        } 
        return;
      } 
    } 
  }
  
  private void drawNpcAniOne(Npc[] paramArrayOfNpc, int paramInt) {
    byte b4 = (byte)((paramArrayOfNpc[paramInt]).other[3] - 1);
    byte b3 = (paramArrayOfNpc[paramInt]).other[2];
    byte b2 = (paramArrayOfNpc[paramInt]).other[7];
    byte b1 = (paramArrayOfNpc[paramInt]).now_action;
    int i = b2;
    if (b2 < 0) {
      (paramArrayOfNpc[paramInt]).dir = 4;
      i = (byte)-b2;
    } 
    if ((paramArrayOfNpc[paramInt]).now_action >= npcSp[b4][b3].aLength(i)) {
      Npc npc = paramArrayOfNpc[paramInt];
      b2 = 0;
      npc.now_action = 0;
      if ((paramArrayOfNpc[paramInt]).other[8] == -4) {
        (paramArrayOfNpc[paramInt]).other[8] = 0;
        (paramArrayOfNpc[paramInt]).other[4] = 0;
        return;
      } 
      b1 = b2;
      if (!(paramArrayOfNpc[paramInt]).bdir) {
        b1 = b2;
        if (setlastA(paramArrayOfNpc, paramInt)) {
          drawNpcAniOne(paramArrayOfNpc, paramInt);
          return;
        } 
      } 
    } 
    Ui ui = Ui.i();
    Sprite sprite = npcSp[b4][b3];
    int j = npcSp[b4][b3].action(i, b1, 0);
    int k = this.map_x;
    short s1 = (paramArrayOfNpc[paramInt]).x;
    i = this.map_y;
    short s2 = (paramArrayOfNpc[paramInt]).y;
    if ((paramArrayOfNpc[paramInt]).dir == 4) {
      paramInt = 1;
    } else {
      paramInt = 0;
    } 
    ui.drawFrameOne(sprite, j, k + s1 + 10, i + s2 + 19, paramInt);
  }
  
  private void drawNpcFace(int paramInt1, int paramInt2, int paramInt3) {
    if (this.imgFace != null)
      Ui.i().drawImage(this.imgFace, this.face_c + paramInt1, paramInt2, paramInt3); 
    this.face_c = Ms.i().mathSpeedN(this.face_c, 0, 20, false);
  }
  
  private void drawSrcEffect() {
    boolean bool = false;
    int i = Constants_H.WIDTH__;
    int j = Constants_H.HEIGHT__;
    if (this.srcFlash_c > 0) {
      byte b = this.srcFlash_c;
      this.srcFlash_c = (byte)(b - 1);
      if (b % 2 == 0)
        Ui.i().fillRect(16777215, 0, 0, i, j); 
    } 
    if (this.bSrc) {
      int k = Constants_H.SRC_BATTLE_H__;
      g.setColor(0);
      g.fillRect(0, this.black_width - k - this.bSrc_c, i, k);
      g.fillRect(0, j - this.black_width + this.bSrc_c, i, k);
    } 
    if (this.my.state == 22) {
      Graphics graphics = g;
      if (this.eventGoing == 2) {
        i = j - this.gr.about_d.length * 29 >> 1;
      } else {
        i = 45;
      } 
      if (this.eventGoing == 2)
        bool = true; 
      drawBlackSRC(graphics, i, bool);
    } 
  }
  
  private void drawStep(Graphics paramGraphics, int paramInt1, int paramInt2, int paramInt3) {
    if (this.bStep > 0) {
      paramGraphics.setColor(3947323);
      paramGraphics.drawRect(paramInt1 + 1, paramInt2, paramInt3 - 2, paramInt3);
      paramGraphics.drawRect(paramInt1, paramInt2 + 1, paramInt3, paramInt3 - 2);
      paramGraphics.setColor(13421772);
      paramGraphics.drawRect(paramInt1 + 2, paramInt2 + 1, paramInt3 - 4, paramInt3 - 2);
      paramGraphics.drawRect(paramInt1 + 1, paramInt2 + 2, paramInt3 - 2, paramInt3 - 4);
      Ui.i().fillRect(16777215, paramInt1 + 2, paramInt2 + 2, paramInt3 - 3, paramInt3 - 3);
      Ui.i().drawUi(67, (paramInt3 >> 1) + paramInt1, (paramInt3 >> 1) + paramInt2, 0x2 | 0x1, 0);
      if (this.bStep % 12 < 6) {
        Ui.i().drawLine(15597568, paramInt1 + paramInt3 - 1, paramInt2, paramInt1, paramInt2 + paramInt3 - 1);
        Ui.i().drawLine(0, paramInt1 + paramInt3, paramInt2, paramInt1, paramInt2 + paramInt3);
        Ui.i().drawLine(15597568, paramInt1 + paramInt3, paramInt2 + 1, paramInt1 + 1, paramInt2 + paramInt3);
      } 
      byte b = (byte)(this.bStep - 1);
      this.bStep = b;
      if (b < 2)
        this.bStep = 100; 
    } 
  }
  
  private void exitBoss(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    chuansong(paramInt1, 0);
    this.bExitBoss = true;
    this.my.setXY(paramInt2, paramInt3, 0, 0);
    this.my.dir = (byte)paramInt4;
  }
  
  private void getInMap(byte paramByte, byte[][] paramArrayOfbyte) {
    this.my.dir = (byte)((paramArrayOfbyte[paramByte][2] - 1) / 2 * 2 + 1 + paramArrayOfbyte[paramByte][2] % 2);
    this.my.setXY(paramArrayOfbyte[paramByte][0], paramArrayOfbyte[paramByte][1], 0, 0);
  }
  
  private void getItem() {
    if (this.item[this.get_meet][2] == 2) {
      this.gr.say("这个宝箱是空的。", 0);
      return;
    } 
    byte b = (byte)(this.item[this.get_meet][3] - 2);
    if (b == -2) {
      GameRun gameRun = this.gr;
      gameRun.money += this.item[this.get_meet][4] * 100;
      this.gr.say("获得金钱：" + (this.item[this.get_meet][4] * 100) + "金", 0);
    } else if (b == -1) {
      GameRun gameRun = this.gr;
      gameRun.coin += this.item[this.get_meet][4];
      this.gr.say("获得徽章：" + this.item[this.get_meet][4] + "徽章", 0);
    } else {
      this.gr.getItem(b, this.item[this.get_meet][4]);
    } 
    this.item[this.get_meet][2] = 2;
  }
  
  private void getItemData(ByteArrayOutputStream paramByteArrayOutputStream, byte[][] paramArrayOfbyte) {
    try {
      paramByteArrayOutputStream.write(paramArrayOfbyte.length);
      byte b = 0;
      while (true) {
        if (b < paramArrayOfbyte.length) {
          paramByteArrayOutputStream.write((paramArrayOfbyte[b]).length);
          paramByteArrayOutputStream.write(paramArrayOfbyte[b]);
          b++;
          continue;
        } 
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private void getNpcData(ByteArrayOutputStream paramByteArrayOutputStream, Npc[] paramArrayOfNpc) {
    byte b = 0;
    try {
      while (true) {
        if (b < paramArrayOfNpc.length) {
          if ((paramArrayOfNpc[b]).other[9] == 1)
            paramByteArrayOutputStream.write((paramArrayOfNpc[b]).other); 
          b++;
          continue;
        } 
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private byte[] getNpcData() {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    getNpcData(byteArrayOutputStream, this.npc[0]);
    getNpcData(byteArrayOutputStream, this.npc[1]);
    getNpcData(byteArrayOutputStream, this.npc[2]);
    getItemData(byteArrayOutputStream, this.item);
    getItemData(byteArrayOutputStream, this.door);
    return byteArrayOutputStream.toByteArray();
  }
  
  private byte getNpcId(int paramInt) {
    return (byte)(this.npcPos[paramInt] & 0x3F);
  }
  
  private byte getNpcLayer(int paramInt) {
    return (byte)((this.npcPos[paramInt] & 0xFF) >> 6);
  }
  
  private short getNpcListY(int paramInt) {
    if (this.npcList[paramInt] == -1)
      return (short)(this.my.y + this.dir_select[this.my.dir][1] * this.my.speed); 
    if (this.npcList[paramInt] < -1) {
      byte[][] arrayOfByte = this.item;
      Ms.i();
      return (short)(arrayOfByte[Ms.abs(this.npcList[paramInt]) - 2][1] * 20);
    } 
    return (this.npc[0][this.npcList[paramInt]]).y;
  }
  
  private void ifEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
    if (setSIfElse(paramInt4, paramBoolean, true)) {
      short[] arrayOfShort = this.event_now;
      arrayOfShort[paramInt1] = (short)(arrayOfShort[paramInt1] + paramInt2);
      nextEvent(paramInt3);
      return;
    } 
    if (setSIfElse(paramInt4, paramBoolean, false))
      setEventNow(paramInt1, false); 
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
    if (this.imgShadow == null)
      this.imgShadow = Ms.i().createImage("data/shadow"); 
  }
  
  private boolean initAuto(Npc paramNpc, int paramInt) {
    if (paramNpc.timeMove == 0) {
      if (paramNpc.frame_c == -1) {
        boolean bool;
        Ms.i();
        if (Ms.getRandom(100) < 50) {
          bool = true;
        } else {
          bool = false;
        } 
        paramNpc.b_auto = bool;
        Ms.i();
        if (Ms.getRandom(100) < 50) {
          Ms.i();
          paramNpc.timeMove = (byte)-(Ms.getRandom(paramInt) + 20);
          paramNpc.setActionNo(false);
          return false;
        } 
      } else {
        return false;
      } 
    } else if (paramNpc.timeMove < 0) {
      paramNpc.timeMove = (byte)(paramNpc.timeMove + 1);
      return false;
    } 
    return true;
  }
  
  private void initBoat(int paramInt) {
    this.my.state = 9;
    this.anole_type = 5;
    setAnole();
    this.boatSelect = (byte)paramInt;
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
      byte b = 0;
      while (true) {
        if (b < this.cloud.length) {
          addCloud(b);
          b = (byte)(b + 1);
          continue;
        } 
        return;
      } 
    } 
    this.cloud = null;
    this.imgCloud = null;
  }
  
  private void initHudong() {
    this.hudong = Ms.i().createImage("data/brow/hudong");
  }
  
  private void initMissionList() {
    byte[] arrayOfByte = Ms.i().rmsOptions(7, null, 1);
    if (arrayOfByte[0] == -1) {
      this.bMission = null;
    } else {
      this.bMission = arrayOfByte;
    } 
    arrayOfByte = (byte[])null;
    if (this.bMission == null)
      this.bMission = new byte[20]; 
    Ms.i();
    Ms.skip = 0;
    arrayOfByte = Ms.i().getStream("data/mission0.t", -1);
    this.sMission = Ms.i().createString2Array(arrayOfByte);
    this.smissionLength = this.sMission.length - 1;
    this.sMission = null;
  }
  
  private void initMoveMy() {
    this.my.frame_c = this.my.frame_num;
    this.my.setActionNo(true);
    if (this.my.state == 0 && this.gr.monPro.length > 0)
      meetGrass(); 
  }
  
  private void initNpcAni_1(int paramInt1, int paramInt2, byte[] paramArrayOfbyte) {
    paramInt1--;
    while (true) {
      if (paramInt1 <= 0)
        return; 
      if (paramArrayOfbyte[paramInt1] != 0) {
        if (npcSp[paramInt2][paramInt1] == null)
          initNpcAniOne(paramInt1, paramInt1, paramInt2); 
      } else {
        npcSp[paramInt2][paramInt1] = null;
      } 
      paramInt1--;
    } 
  }
  
  private boolean isAnole(int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt3 == 0) {
      paramInt3 = 3;
    } else if (paramInt3 == 2) {
      paramInt3 = 4;
    } else if (paramInt3 == 4) {
      paramInt3 = 2;
    } else {
      return false;
    } 
    byte b1 = 0;
    if (paramInt1 % 20 != 0)
      b1 = (byte)(0 + 1); 
    byte b2 = b1;
    if (paramInt2 % 20 != 0)
      b2 = (byte)(b1 + 1); 
    b1 = (byte)(1 << b2);
    if (b1 == 4 && this.worldData[(paramInt1 + 19) / 20][paramInt2 / 20] == paramInt3)
      return true; 
    if (b1 > 1) {
      if (paramInt1 % 20 != 0 && this.worldData[(paramInt1 + 19) / 20][(paramInt2 + 19) / 20] == paramInt3)
        return true; 
      if (paramInt2 % 20 != 0 && this.worldData[paramInt1 / 20][paramInt2 / 20] == paramInt3)
        return true; 
    } 
    return (this.worldData[paramInt1 / 20][paramInt2 / 20] == paramInt3);
  }
  
  private boolean isAnoleType(int paramInt) {
    return ((this.gr.rmsOther[2] & 1 << paramInt) != 0);
  }
  
  private boolean isAuto_canMove(Npc paramNpc, int paramInt1, int paramInt2) {
    return !(checkWorld(paramNpc.x, paramNpc.y, paramInt1, paramInt2, false) == 1 || Ms.i().isRect(paramNpc.x + paramInt1, paramNpc.y + paramInt2, 19, 19, this.my.x, this.my.y, 19, 19));
  }
  
  private boolean isCan_not_pass(int paramInt1, int paramInt2) {
    return (this.worldData[paramInt1][paramInt2] == 1) ? true : ((this.anole_type == 0) ? (!(this.worldData[paramInt1][paramInt2] != 2 && this.worldData[paramInt1][paramInt2] != 4)) : ((this.anole_type == 2) ? (!(this.worldData[paramInt1][paramInt2] != 3 && this.worldData[paramInt1][paramInt2] != 2)) : ((this.anole_type == 4) ? ((this.worldData[paramInt1][paramInt2] != 2)) : (!(this.worldData[paramInt1][paramInt2] != 2 && this.worldData[paramInt1][paramInt2] != 3 && this.worldData[paramInt1][paramInt2] != 4)))));
  }
  
  private boolean isCheckAnole(int paramInt) {
    if (this.anole_type != paramInt && isAnoleType(paramInt)) {
      this.anole_type = (byte)paramInt;
      setAnole();
      return true;
    } 
    if (!isAnoleType(paramInt))
      this.gr.say("没有" + this.gr.monsterT[paramInt] + "坐骑" + "，不能通过该地形", -1); 
    return false;
  }
  
  private boolean isCheckNpcOff() {
    if (this.checkNpcT < 0)
      return false; 
    if (this.my.speed_x != 0) {
      Ms.i();
      byte b = (byte)(20 - Ms.abs(this.my.y - (this.npc[0][this.checkNpcT]).y));
      if (b > 0 && b < 11)
        return true; 
    } else if (this.my.speed_y != 0) {
      Ms.i();
      byte b = (byte)(20 - Ms.abs(this.my.x - (this.npc[0][this.checkNpcT]).x));
      if (b > 0 && b < 11)
        return true; 
    } 
    return false;
  }
  
  private byte isMapChenk(byte paramByte) {
    int j = 0;
    int i = 0;
    byte b2 = (byte)(this.my.x / 20);
    byte b1 = (byte)(this.my.y / 20);
    if (this.my.speed_x == 0) {
      if (this.my.x % 20 != 0) {
        i = 0;
      } else {
        i = 1;
      } 
      if (this.my.speed_y >= 0) {
        j = 1;
      } else {
        j = -1;
      } 
      j = checkMap((b2 - i) * 20, (j + b1) * 20, 0, 0);
      if (this.my.speed_y >= 0) {
        i = 1;
      } else {
        i = -1;
      } 
      i = checkMap((b2 + 1) * 20, (i + b1) * 20, 0, 0);
    } else if (this.my.speed_y == 0) {
      if (this.my.speed_x >= 0) {
        i = 1;
      } else {
        i = -1;
      } 
      if (this.my.y % 20 != 0) {
        j = 0;
      } else {
        j = 1;
      } 
      j = checkMap((i + b2) * 20, (b1 - j) * 20, 0, 0);
      if (this.my.speed_x >= 0) {
        i = 1;
      } else {
        i = -1;
      } 
      i = checkMap((i + b2) * 20, (b1 + 1) * 20, 0, 0);
    } 
    if (j != 1 || i != 1) {
      if (j == 0) {
        byte b;
        if (this.my.speed_x == 0) {
          if (this.my.x % 20 != 0) {
            j = 0;
          } else {
            j = 1;
          } 
          j = b2 - j;
        } else {
          j = b2;
        } 
        if (this.my.speed_y == 0) {
          if (this.my.y % 20 != 0) {
            b = 0;
          } else {
            b = 1;
          } 
          b = b1 - b;
        } else {
          b = b1;
        } 
        if (checkMap(j * 20, b * 20, 0, 0) == 0)
          return -1; 
      } 
      if (i == 0) {
        int k;
        if (this.my.speed_x == 0) {
          if (this.my.x % 20 != 0) {
            i = 0;
          } else {
            i = 1;
          } 
          i += b2;
        } else {
          i = b2;
        } 
        if (this.my.speed_y == 0) {
          if (this.my.y % 20 != 0) {
            j = 0;
          } else {
            j = 1;
          } 
          k = j + b1;
        } 
        if (checkMap(i * 20, k * 20, 0, 0) == 0)
          paramByte = -2; 
      } 
    } 
    return paramByte;
  }
  
  private boolean isMapEvent(int paramInt1, int paramInt2) {
    return ((this.mapInfo[paramInt1 * 2 + 1] & 1 << paramInt2) != 0);
  }
  
  private boolean isMission(int paramInt) {
    byte b = (byte)(paramInt / 8);
    paramInt = (byte)(paramInt % 8);
    return ((this.bMission[b] & 1 << paramInt) != 0);
  }
  
  private boolean isNpcSrc(int paramInt1, int paramInt2) {
    return (this.map_x + paramInt1 >= -80 && this.map_x + paramInt1 <= Constants_H.WIDTH + 60 && this.map_y + paramInt2 >= -80 && this.map_y + paramInt2 <= Constants_H.HEIGHT + 60);
  }
  
  private boolean isTrundleNpc(int paramInt1, int paramInt2) {
    byte b = checkIfNpc(this.npc[0], paramInt1, paramInt2);
    return (b != -1) ? (((this.npc[0][b]).other[4] == 1 || (this.npc[0][b]).other[4] == 3)) : (!(paramInt1 >= 0 && paramInt1 < this.cols && paramInt2 >= 0 && paramInt2 < this.rows && this.worldData[paramInt1][paramInt2] != 1));
  }
  
  private void keyAnoleSel() {
    if (!Ms.i().key_delay()) {
      if (Ms.i().key_Left_Right()) {
        this.anoleSel = Ms.i().select(this.anoleSel, 0, 4);
        return;
      } 
      if (Ms.i().key_S1()) {
        if (!isAnoleType(this.anoleSel)) {
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
            if (this.anole_type == 3 && this.gr.rmsSms[0] == 0)
              this.gr.say("奇异兽不仅跑得快而且可以不遇敌，现提供试骑体验，正版验证后需购买！", -1); 
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
      if (Ms.i().key_S2() || Ms.i().key_Num9()) {
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
        return;
      } 
    } else {
      return;
    } 
    if ((Ms.i().key_Left_Right() || Ms.i().key_Up_Down()) && (this.mapdataMap[this.selectMap]).length >= 6 && this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1] != -1)
      this.selectMap = this.mapdataMap[this.selectMap][Ms.abs(Ms.key) + 1]; 
  }
  
  private void keyMission() {
    if (!Ms.i().key_delay()) {
      if (Ms.i().key_Left_Right() || (Ms.i().key_Num1() && this.gr.cur_a == 1) || (Ms.i().key_Num3() && this.gr.cur_a == 0)) {
        GameRun gameRun = this.gr;
        gameRun.cur_a = (byte)(gameRun.cur_a ^ 0x1);
        goMission(this.gr.cur_a, this.bPause);
        return;
      } 
      if (Ms.i().key_Up_Down()) {
        int i;
        if (this.gr.cur_a == 0) {
          if (this.bMission[14] + 1 > this.sMission.length) {
            i = this.sMission.length;
          } else {
            i = this.bMission[14] + 1;
          } 
          i = (byte)i;
        } else {
          i = (byte)this.mDirect.length;
        } 
        Ms.i().selectS(this.gr.select[0], 0, i, this.gr.line_max);
        if (this.gr.cur_a == 0) {
          this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
          return;
        } 
        if (this.mDirect.length > 0) {
          this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0);
          return;
        } 
        this.gr.about_a = null;
        return;
      } 
      if (Ms.i().key_S2() || Ms.i().key_Num1() || Ms.i().key_Num3()) {
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
    } 
  }
  
  private void keyMySave() {
    if (Ms.i().key_S1()) {
      this.my.state = 0;
      this.eventGoing = 2;
      return;
    } 
    if (Ms.i().key_S2()) {
      this.my.state = 0;
      this.eventGoing = 3;
    } 
  }
  
  private void keySelectMenu() {
    if (!Ms.i().key_delay()) {
      if (Ms.i().key_S1_Num5()) {
        this.my.state = 13;
        return;
      } 
      if (Ms.i().key_Up_Down())
        this.gr.cur_a = Ms.i().select(this.gr.cur_a, 0, this.gr.action_str.length - 1); 
    } 
  }
  
  private void loadMapData(int paramInt) {
    // Byte code:
    //   0: iconst_2
    //   1: newarray byte
    //   3: astore #12
    //   5: iconst_4
    //   6: newarray byte
    //   8: astore #14
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield bottomData : [S
    //   15: aload_0
    //   16: aconst_null
    //   17: putfield frontData : [S
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield worldData : [[S
    //   25: new java/io/DataInputStream
    //   28: astore #13
    //   30: new java/lang/StringBuilder
    //   33: astore #15
    //   35: aload #15
    //   37: ldc_w '/data/map/'
    //   40: invokespecial <init> : (Ljava/lang/String;)V
    //   43: aload #13
    //   45: aload #15
    //   47: iload_1
    //   48: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   51: ldc_w '.mid'
    //   54: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual toString : ()Ljava/lang/String;
    //   60: invokestatic getResourceAsStream : (Ljava/lang/String;)Ljava/io/InputStream;
    //   63: invokespecial <init> : (Ljava/io/InputStream;)V
    //   66: aload #13
    //   68: ldc2_w 2
    //   71: invokevirtual skip : (J)J
    //   74: pop2
    //   75: aload #13
    //   77: aload #14
    //   79: invokevirtual read : ([B)I
    //   82: pop
    //   83: invokestatic i : ()Ldm/Ms;
    //   86: pop
    //   87: aload_0
    //   88: aload #14
    //   90: invokestatic getNum : ([B)J
    //   93: l2i
    //   94: putfield bgColor : I
    //   97: aload #13
    //   99: invokevirtual readByte : ()B
    //   102: newarray byte
    //   104: astore #15
    //   106: aload #13
    //   108: aload #15
    //   110: invokevirtual read : ([B)I
    //   113: pop
    //   114: aload #13
    //   116: aload #15
    //   118: invokevirtual read : ([B)I
    //   121: pop
    //   122: invokestatic i : ()Ldm/Ms;
    //   125: pop
    //   126: aload_0
    //   127: aload #15
    //   129: invokestatic getNum : ([B)J
    //   132: l2i
    //   133: i2b
    //   134: putfield cols : S
    //   137: aload #13
    //   139: aload #15
    //   141: invokevirtual read : ([B)I
    //   144: pop
    //   145: invokestatic i : ()Ldm/Ms;
    //   148: pop
    //   149: aload_0
    //   150: aload #15
    //   152: invokestatic getNum : ([B)J
    //   155: l2i
    //   156: i2b
    //   157: putfield rows : S
    //   160: aload_0
    //   161: getfield cols : S
    //   164: istore_3
    //   165: aload_0
    //   166: getfield rows : S
    //   169: istore_1
    //   170: aload_0
    //   171: iload_3
    //   172: iload_1
    //   173: multianewarray[[S 2
    //   177: putfield worldData : [[S
    //   180: iconst_0
    //   181: istore_3
    //   182: iload_3
    //   183: iconst_3
    //   184: if_icmplt -> 211
    //   187: aload #13
    //   189: invokevirtual close : ()V
    //   192: aconst_null
    //   193: checkcast [B
    //   196: astore #12
    //   198: aconst_null
    //   199: checkcast [B
    //   202: astore #12
    //   204: aconst_null
    //   205: checkcast [B
    //   208: astore #12
    //   210: return
    //   211: aload #13
    //   213: invokevirtual readByte : ()B
    //   216: istore #5
    //   218: iload #5
    //   220: iconst_m1
    //   221: if_icmpne -> 232
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: i2b
    //   228: istore_3
    //   229: goto -> 182
    //   232: aload #13
    //   234: aload #14
    //   236: invokevirtual read : ([B)I
    //   239: pop
    //   240: invokestatic i : ()Ldm/Ms;
    //   243: pop
    //   244: aload #14
    //   246: invokestatic getNum : ([B)J
    //   249: l2i
    //   250: iconst_3
    //   251: imul
    //   252: istore #6
    //   254: iload #5
    //   256: tableswitch default -> 284, 1 -> 295, 2 -> 284, 3 -> 311
    //   284: iconst_0
    //   285: istore_1
    //   286: iload_1
    //   287: iload #6
    //   289: if_icmplt -> 322
    //   292: goto -> 224
    //   295: aload_0
    //   296: iload #6
    //   298: newarray short
    //   300: putfield bottomData : [S
    //   303: goto -> 284
    //   306: astore #12
    //   308: goto -> 210
    //   311: aload_0
    //   312: iload #6
    //   314: newarray short
    //   316: putfield frontData : [S
    //   319: goto -> 284
    //   322: aload #13
    //   324: aload #15
    //   326: invokevirtual read : ([B)I
    //   329: pop
    //   330: invokestatic i : ()Ldm/Ms;
    //   333: pop
    //   334: aload #15
    //   336: invokestatic getNum : ([B)J
    //   339: l2i
    //   340: i2s
    //   341: istore #4
    //   343: aload #13
    //   345: aload #15
    //   347: invokevirtual read : ([B)I
    //   350: pop
    //   351: aload_0
    //   352: getfield rows : S
    //   355: iconst_1
    //   356: isub
    //   357: i2l
    //   358: lstore #10
    //   360: invokestatic i : ()Ldm/Ms;
    //   363: pop
    //   364: lload #10
    //   366: aload #15
    //   368: invokestatic getNum : ([B)J
    //   371: lsub
    //   372: l2i
    //   373: i2s
    //   374: istore #8
    //   376: aload #13
    //   378: aload #12
    //   380: invokevirtual read : ([B)I
    //   383: pop
    //   384: invokestatic i : ()Ldm/Ms;
    //   387: pop
    //   388: aload #12
    //   390: invokestatic getNum : ([B)J
    //   393: l2i
    //   394: i2s
    //   395: istore #7
    //   397: iload #5
    //   399: tableswitch default -> 424, 1 -> 427, 2 -> 499, 3 -> 522
    //   424: goto -> 286
    //   427: aload_0
    //   428: getfield bottomData : [S
    //   431: astore #16
    //   433: iload_1
    //   434: iconst_1
    //   435: iadd
    //   436: i2s
    //   437: istore #9
    //   439: iload #4
    //   441: i2s
    //   442: istore_2
    //   443: aload #16
    //   445: iload_1
    //   446: iload_2
    //   447: sastore
    //   448: aload_0
    //   449: getfield bottomData : [S
    //   452: astore #16
    //   454: iload #9
    //   456: iconst_1
    //   457: iadd
    //   458: i2s
    //   459: istore #4
    //   461: iload #8
    //   463: i2s
    //   464: istore_2
    //   465: aload #16
    //   467: iload #9
    //   469: iload_2
    //   470: sastore
    //   471: iload #4
    //   473: istore_1
    //   474: aload_0
    //   475: getfield bottomData : [S
    //   478: astore #16
    //   480: iload #4
    //   482: iconst_1
    //   483: iadd
    //   484: i2s
    //   485: istore_1
    //   486: iload #7
    //   488: i2s
    //   489: istore_2
    //   490: aload #16
    //   492: iload #4
    //   494: iload_2
    //   495: sastore
    //   496: goto -> 286
    //   499: iload_1
    //   500: iconst_3
    //   501: iadd
    //   502: i2s
    //   503: istore_1
    //   504: aload_0
    //   505: getfield worldData : [[S
    //   508: iload #4
    //   510: aaload
    //   511: iload #8
    //   513: iload #7
    //   515: iconst_3
    //   516: ishr
    //   517: i2s
    //   518: sastore
    //   519: goto -> 286
    //   522: aload_0
    //   523: getfield frontData : [S
    //   526: astore #16
    //   528: iload_1
    //   529: iconst_1
    //   530: iadd
    //   531: i2s
    //   532: istore #9
    //   534: iload #4
    //   536: i2s
    //   537: istore_2
    //   538: aload #16
    //   540: iload_1
    //   541: iload_2
    //   542: sastore
    //   543: aload_0
    //   544: getfield frontData : [S
    //   547: astore #16
    //   549: iload #9
    //   551: iconst_1
    //   552: iadd
    //   553: i2s
    //   554: istore #4
    //   556: iload #8
    //   558: i2s
    //   559: istore_2
    //   560: aload #16
    //   562: iload #9
    //   564: iload_2
    //   565: sastore
    //   566: iload #4
    //   568: istore_1
    //   569: aload_0
    //   570: getfield frontData : [S
    //   573: astore #16
    //   575: iload #4
    //   577: iconst_1
    //   578: iadd
    //   579: i2s
    //   580: istore_1
    //   581: iload #7
    //   583: i2s
    //   584: istore_2
    //   585: aload #16
    //   587: iload #4
    //   589: iload_2
    //   590: sastore
    //   591: goto -> 286
    //   594: astore #12
    //   596: goto -> 210
    //   599: astore #12
    //   601: goto -> 210
    // Exception table:
    //   from	to	target	type
    //   25	180	306	java/lang/Exception
    //   187	210	306	java/lang/Exception
    //   211	218	306	java/lang/Exception
    //   232	254	306	java/lang/Exception
    //   295	303	306	java/lang/Exception
    //   311	319	306	java/lang/Exception
    //   322	397	594	java/lang/Exception
    //   427	433	594	java/lang/Exception
    //   448	454	306	java/lang/Exception
    //   474	480	599	java/lang/Exception
    //   504	519	306	java/lang/Exception
    //   522	528	594	java/lang/Exception
    //   543	549	306	java/lang/Exception
    //   569	575	599	java/lang/Exception
  }
  
  private void loadMapModuleAndImage() {
    byte[][] arrayOfByte1;
    Ms.i();
    Ms.skip = 0;
    byte[] arrayOfByte3 = Ms.i().getStream("data/map/area.dat", -1);
    byte[] arrayOfByte2 = Ms.i().createArray(arrayOfByte3);
    byte[][] arrayOfByte4 = Ms.i().create2Array(arrayOfByte3);
    arrayOfByte3 = (byte[])null;
    if (this.mapImg != null && arrayOfByte2[this.lastMap] == arrayOfByte2[this.mapNo]) {
      arrayOfByte2 = (byte[])null;
      arrayOfByte1 = (byte[][])null;
      return;
    } 
    Ms.i();
    Ms.skip = 0;
    this.moduleData = Ms.i().createShort2Array(Ms.i().getStream("data/map/" + arrayOfByte1[this.mapNo] + ".data", -1), 1);
    this.mapImg = null;
    this.mapImg = new Image[(arrayOfByte4[arrayOfByte1[this.mapNo]]).length];
    for (byte b = 0;; b = (byte)(b + 1)) {
      byte[][] arrayOfByte;
      if (b >= (arrayOfByte4[arrayOfByte1[this.mapNo]]).length) {
        byte[] arrayOfByte5 = (byte[])null;
        arrayOfByte = (byte[][])null;
        return;
      } 
      this.mapImg[b] = Ms.i().createImage("data/map/" + arrayOfByte4[arrayOfByte[this.mapNo]][b]);
    } 
  }
  
  private int map_set(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return (paramInt2 <= paramInt3) ? (paramInt5 - paramInt6 * paramInt2 >> 1) : ((paramInt1 + 1 <= paramInt4) ? 0 : ((paramInt1 >= paramInt2 - paramInt4) ? (paramInt5 - paramInt2 * paramInt6) : (paramInt5 / 2 - paramInt1 * paramInt6 - paramInt6 / 2)));
  }
  
  private void meetGrass() {
    if (this.meet_step < this.step_MEET) {
      if (this.worldData[this.my.getIx()][this.my.getIy()] != 7)
        this.meet_step = (short)(this.meet_step + 1); 
      return;
    } 
    if (this.gr.monPro.length > 1 && this.gr.immueEnemy == 0) {
      this.my.frame_c = 0;
      this.my.state = 8;
    } 
    notMeet(0, 0);
  }
  
  private void moveOff(byte paramByte1, byte paramByte2, int paramInt) {
    int i;
    if (this.my.speed_x == 0) {
      this.my.dir = paramByte1;
    } else if (this.my.speed_y == 0) {
      this.my.dir = paramByte2;
    } 
    Npc npc = this.my;
    if (this.my.speed_x != 0) {
      i = 0;
    } else {
      i = paramInt;
    } 
    npc.speed_x = (byte)i;
    npc = this.my;
    if (this.my.speed_y != 0)
      paramInt = 0; 
    npc.speed_y = (byte)paramInt;
    checkMoveOff(this.checkNpcT);
    initMoveMy();
  }
  
  private void nextEvent(int paramInt) {
    if ((paramInt & 0x1000) != 0) {
      this.now_eV1 = 0;
      this.now_eV2 = 0;
    } 
    if ((paramInt & 0x100) != 0)
      this.eventGoing = 0; 
    if ((paramInt & 0x10) != 0)
      this.event_state = 1; 
    if ((paramInt & 0x1) != 0)
      this.my.state = 0; 
    this.pkey.initPointer();
  }
  
  private void oneMove(Npc paramNpc, int paramInt) {
    if (paramNpc.frame_c > 0) {
      if (this.srcNpcNo == paramInt)
        mapMove(paramNpc.x, paramNpc.y, paramNpc.speed_x, paramNpc.speed_y); 
      paramNpc.x = (short)(paramNpc.x + paramNpc.speed_x);
      paramNpc.y = (short)(paramNpc.y + paramNpc.speed_y);
      paramNpc.frame_c = (byte)(paramNpc.frame_c - 1);
      return;
    } 
    if (paramNpc.frame_c != -1) {
      paramNpc.frame_c = -1;
      paramNpc.setActionNo(false);
    } 
  }
  
  private void runAutoMoveNpc(Npc paramNpc, int paramInt) {
    if (this.my.state == 1 && this.get_meet == paramInt) {
      byte[] arrayOfByte = paramNpc.other;
      Ms.i();
      int i = Ms.abs(paramNpc.other[7]) / 3;
      if (this.my.dir < 4) {
        paramInt = this.my.dir - 1;
      } else {
        paramInt = this.my.dir - 2;
      } 
      arrayOfByte[7] = (byte)(i * 3 + paramInt);
      if (this.my.dir == 3) {
        paramNpc.other[7] = (byte)-paramNpc.other[7];
        return;
      } 
      paramNpc.dir = 3;
      return;
    } 
    if (initAuto(paramNpc, 10)) {
      if (paramNpc.b_auto) {
        runAutoX(paramNpc, this.gr.mapMove[(paramNpc.other[8] - 5) * 2]);
        return;
      } 
      runAutoY(paramNpc, this.gr.mapMove[(paramNpc.other[8] - 5) * 2 + 1]);
    } 
  }
  
  private void runAutoX(Npc paramNpc, int paramInt) {
    if (paramNpc.timeMove == 0) {
      byte b;
      Ms.i();
      if (Ms.getRandom(100) < 50) {
        b = 3;
      } else {
        b = 4;
      } 
      paramNpc.dir = b;
      if (paramNpc.dir == 3) {
        paramInt = (short)(paramNpc.x - paramNpc.other[0] * 20);
      } else {
        paramInt = (short)((paramNpc.other[0] + paramInt) * 20 - paramNpc.x);
      } 
      if (paramInt <= 20) {
        paramNpc.timeMove = (byte)(paramInt / paramNpc.speed);
        return;
      } 
      Ms.i();
      paramNpc.timeMove = (byte)(Ms.getRandom((paramInt - 20) / paramNpc.speed + 1) + 20 / paramNpc.speed);
      return;
    } 
    if (paramNpc.timeMove > 0 && paramNpc.frame_c < 1) {
      if (paramNpc.dir == 3) {
        paramInt = -paramNpc.speed;
      } else {
        paramInt = paramNpc.speed;
      } 
      if (isAuto_canMove(paramNpc, paramInt, 0)) {
        if (paramNpc.dir == 3) {
          paramInt = -paramNpc.speed;
        } else {
          paramInt = paramNpc.speed;
        } 
        paramNpc.setSpeedXY(paramInt, 0);
        paramNpc.timeMove = (byte)(paramNpc.timeMove - 1);
        paramNpc.frame_c = 1;
        paramNpc.setActionNo(true);
        return;
      } 
      paramNpc.timeMove = -20;
      paramNpc.frame_c = -1;
      paramNpc.setActionNo(false);
    } 
  }
  
  private void runAutoY(Npc paramNpc, int paramInt) {
    if (paramNpc.timeMove == 0 && paramNpc.frame_c == -1) {
      byte b;
      Ms.i();
      if (Ms.getRandom(100) < 50) {
        b = 1;
      } else {
        b = 2;
      } 
      paramNpc.dir = b;
      if (paramNpc.dir == 1) {
        paramInt = (short)(paramNpc.y - paramNpc.other[1] * 20);
      } else {
        paramInt = (short)((paramNpc.other[1] + paramInt) * 20 - paramNpc.y);
      } 
      if (paramInt <= 20) {
        paramNpc.timeMove = (byte)(paramInt / paramNpc.speed);
        return;
      } 
      Ms.i();
      paramNpc.timeMove = (byte)(Ms.getRandom((paramInt - 20) / paramNpc.speed + 1) + 20 / paramNpc.speed);
      return;
    } 
    if (paramNpc.timeMove > 0 && paramNpc.frame_c < 1) {
      if (paramNpc.dir == 1) {
        paramInt = -paramNpc.speed;
      } else {
        paramInt = paramNpc.speed;
      } 
      if (isAuto_canMove(paramNpc, 0, paramInt)) {
        if (paramNpc.dir == 1) {
          paramInt = -paramNpc.speed;
        } else {
          paramInt = paramNpc.speed;
        } 
        paramNpc.setSpeedXY(0, paramInt);
        paramNpc.timeMove = (byte)(paramNpc.timeMove - 1);
        paramNpc.frame_c = 1;
        paramNpc.setActionNo(true);
        return;
      } 
      paramNpc.timeMove = -20;
      paramNpc.frame_c = -1;
      paramNpc.setActionNo(false);
    } 
  }
  
  private void runBoat() {
    if (this.boatSelect != -1 && this.my.ix == -1 && this.my.iy == -1) {
      this.my.state = 9;
      GameRun gameRun = this.gr;
      byte b = (byte)(gameRun.cur_a + 2);
      gameRun.cur_a = b;
      if (b >= (this.boatCourse[this.boatSelect]).length) {
        this.boatSelect = -1;
        this.my.state = 0;
        this.anole_type = -1;
        setAnole();
        return;
      } 
      this.checkType = checkIfOther(this.door, this.my.x, this.my.y);
      if (this.checkType != -1) {
        this.my.state = 5;
        this.get_meet = this.checkType;
      } 
      this.my.setIXY(this.boatCourse[this.boatSelect][this.gr.cur_a], this.boatCourse[this.boatSelect][this.gr.cur_a + 1]);
    } 
  }
  
  private void runEvent_brow(int paramInt) {
    int i = this.event[paramInt][this.event_now[paramInt] + 2] - 1;
    if (i == -1) {
      cur_npc = this.my;
    } else {
      cur_npc = this.npc[getNpcLayer(i)][getNpcId(i)];
    } 
    if (this.event[paramInt][this.event_now[paramInt] + 4] == 0) {
      cur_npc.brow_type = this.event[paramInt][this.event_now[paramInt] + 3];
      cur_npc.brow_action = 0;
      cur_npc.brow_time = 0;
    } else if (this.event[paramInt][this.event_now[paramInt] + 4] == 1) {
      cur_npc.other[6] = this.event[paramInt][this.event_now[paramInt] + 3];
    } else if (this.event[paramInt][this.event_now[paramInt] + 4] == 2) {
      cur_npc.brow_type = -1;
      cur_npc.other[6] = 0;
    } 
    short[] arrayOfShort = this.event_now;
    arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + 5);
    nextEvent(4112);
  }
  
  private void runEvent_dialog(int paramInt) {
    this.checkNpcT = -1;
    if (this.eventGoing == 0) {
      this.eventGoing = 1;
      if (this.anole_type == 1)
        setAnole(); 
      int i = this.event[paramInt][this.event_now[paramInt] + 2] - 1;
      if (i == -1) {
        this.npcName = "塞其";
        this.now_eV2 = 0;
      } else {
        this.now_eV1 = getNpcLayer(i);
        this.now_eV2 = getNpcId(i);
        this.npcName = this.npcNameData[this.now_eV2];
        if (this.npcName.equals("路人"))
          this.npcName = null; 
        this.now_eV2 = (this.npc[this.now_eV1][this.now_eV2]).other[2];
      } 
      initNpcFaceOne(this.npcName);
      Ms.i();
      Ms.font.setSize(22);
      this.dialog = Ms.i().groupString(Ms.i().getDialogs(this.event[paramInt], this.event_now[paramInt] + 5, this.event[paramInt][this.event_now[paramInt] + 4]), Constants_H.WIDTH__ - 20);
      if (!this.fontSizeControl) {
        Ms.i();
        Ms.font.setSize(26);
      } 
      this.dialog_no = 0;
      this.my.state = 1;
      this.bDirTalk = false;
      return;
    } 
    if (this.eventGoing == 2) {
      short[] arrayOfShort = this.event_now;
      arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + (this.event[paramInt][this.event_now[paramInt] + 4] << 1) + 5);
      nextEvent(4369);
    } 
  }
  
  private void runEvent_getMon(int paramInt) {
    this.gmErr = false;
    if (this.gr.getMonster(this.event[paramInt][this.event_now[paramInt] + 2], this.event[paramInt][this.event_now[paramInt] + 3], this.event[paramInt][this.event_now[paramInt] + 4], -1) == -1) {
      this.gr.say("宠物空间已满，无法获得新的宠物，请整理寄存所空出一个空间。", -1);
      this.gmErr = true;
      this.gr.mini_state = 6;
      this.gr.view_state = 1;
      this.gr.goVIEW_MONSTER();
      return;
    } 
    short[] arrayOfShort = this.event_now;
    arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + this.event[paramInt][this.event_now[paramInt] + 1] + 2);
    nextEvent(4368);
  }
  
  private void runEvent_goShop(int paramInt) {
    byte b = this.event[paramInt][this.event_now[paramInt] + 3];
    if (b == 4) {
      if (this.inShop == 0 && this.my.state != 16) {
        this.my.state = 16;
        this.inShop = 1;
        this.gr.setAction_str(new String[] { "回复", "不回复" });
        this.gr.popMenu = 0;
        this.gr.sell_money = 0;
        paramInt = 0;
        while (true) {
          if (paramInt < this.gr.myMon_length) {
            GameRun gameRun = this.gr;
            gameRun.sell_money += (this.gr.myMonsters[paramInt]).monster[4] * 20 + 40;
            paramInt = (byte)(paramInt + 1);
            continue;
          } 
          return;
        } 
      } 
      if (this.my.state == 0) {
        if (this.inShop == 1 && this.gr.popMenu == 0) {
          this.inShop = 2;
          if (!this.gr.checkMonster() && this.gr.isMoney(this.gr.sell_money, true))
            this.gr.healMonster(true); 
          return;
        } 
        if (this.gr.say_c == 0) {
          this.inShop = 0;
          short[] arrayOfShort1 = this.event_now;
          arrayOfShort1[paramInt] = (short)(arrayOfShort1[paramInt] + 4);
          nextEvent(0);
        } 
      } 
      return;
    } 
    if (b < 3) {
      this.gr.goBUY_ITEM(this.event[paramInt][this.event_now[paramInt] + 2], b);
    } else if (b == 3) {
      this.gr.goVIEW_COMPUTER(0);
    } else if (b == 5) {
      this.gr.goNidus(0);
    } else if (b == 6) {
      this.gr.view_state = 4;
      this.gr.popMenu = -1;
    } else if (b == 7) {
      this.gr.view_state = 1;
    } 
    short[] arrayOfShort = this.event_now;
    arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + 4);
    nextEvent(16);
  }
  
  private void runEvent_item_add_del(int paramInt) {
    boolean bool = false;
    if (this.eventGoing == 0) {
      this.now_eV1 = this.event[paramInt][this.event_now[paramInt] + 2];
      this.now_eV2 = this.event[paramInt][this.event_now[paramInt] + 3];
      if (this.event[paramInt][this.event_now[paramInt] + 3] >= 0) {
        paramInt = this.gr.addItem(this.now_eV1, this.now_eV2);
      } else {
        paramInt = this.gr.findItem(-2, this.now_eV1, true);
        Ms.i();
        if (paramInt >= Ms.abs(this.now_eV2)) {
          GameRun gameRun = this.gr;
          paramInt = this.now_eV1;
          Ms.i();
          gameRun.deleteItems(paramInt, Ms.abs(this.now_eV2));
          paramInt = bool;
        } else {
          paramInt = -1;
          this.gr.say("道具不足！", 0);
        } 
      } 
      if (paramInt != -1) {
        String str;
        GameRun gameRun = this.gr;
        if (this.now_eV2 >= 0) {
          str = "获得：";
        } else {
          str = "失去：";
        } 
        StringBuilder stringBuilder = (new StringBuilder(String.valueOf(str))).append(this.gr.getNameItem(this.now_eV1)).append("x");
        Ms.i();
        gameRun.say(stringBuilder.append(Ms.abs(this.now_eV2)).toString(), 0);
      } 
      this.eventGoing = 1;
      return;
    } 
    if (this.gr.say_c == 0) {
      if (-1 == 0) {
        setEventNow(paramInt, true);
        return;
      } 
      short[] arrayOfShort = this.event_now;
      arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + 4);
      nextEvent(4368);
    } 
  }
  
  private void runEvent_miniGame_myLevel(int paramInt) {
    byte b = this.event[paramInt][this.event_now[paramInt] + 2];
    if (b > 1) {
      short[] arrayOfShort = this.event_now;
      arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + 3);
      nextEvent(4368);
      return;
    } 
    if (this.eventGoing < 2) {
      if (b == 0) {
        if (this.gr.magic_id == -2) {
          if (this.gr.rmsOther[3] == 5) {
            this.gr.magic_id = -2;
            this.eventGoing = 2;
            this.gr.say("您当前的训练师等级已达到上限！", 0);
            return;
          } 
          this.gr.sell_money = this.gr.isMyLevel(true);
          if (this.gr.sell_money == -1) {
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
        if (this.gr.magic_id == -1) {
          this.gr.magic_id = -2;
          this.eventGoing = 2;
          this.gr.say("恭喜您的训练师等级已提升为#7" + this.gr.rmsOther[3] + "#0，您随身可携带宠物数量#7暴增到" + this.gr.max_takes + "#0，您商店能存放的宠物#7暴增到" + this.gr.max_monsters, -1);
        } 
        return;
      } 
      if (b == 1) {
        if (this.eventGoing == 0 && this.gr.monInfoList[104] == 0) {
          this.gr.sell_money = 0;
          this.eventGoing = 3;
          this.gr.say("此次您没有捕获到全新的宠物，捕获并不是唯一途径，有些宠物需要通过进化才能获得哦。", -1);
          return;
        } 
        if (this.eventGoing == 0) {
          this.eventGoing = 3;
          this.gr.sell_money = this.gr.monInfoList[104];
          this.gr.monInfoList[104] = 0;
          this.gr.say("此次您捕获了" + this.gr.sell_money + "个新宠物，这里是王国训练师机构奖励给您的" + this.gr.sell_money + "个徽章，希望再接再厉哦。", -1);
          GameRun gameRun = this.gr;
          gameRun.coin += this.gr.sell_money;
        } 
      } 
      return;
    } 
    if (this.gr.say_c == 0) {
      if (this.eventGoing == 2) {
        if (this.gr.rmsOther[3] == 5) {
          this.gr.say("您当前的训练师等级已达到上限！", 0);
        } else {
          this.gr.sell_money = (byte)(this.gr.isMyLevel(false) - this.gr.monInfoList[103]);
          if (this.gr.sell_money < 1)
            this.gr.sell_money = 0; 
          this.gr.say("当前训练师等级为#7" + this.gr.rmsOther[3] + "#0距离下次升级还需要捕捉#7" + this.gr.sell_money + "#0只不同的宠物，努力获得新宠吧。", -1);
        } 
        this.eventGoing = 4;
        return;
      } 
      if (this.eventGoing == 3 && this.gr.sell_money > 0) {
        this.gr.say("获得：徽章x" + this.gr.sell_money, 0);
        this.eventGoing = 4;
        return;
      } 
      short[] arrayOfShort = this.event_now;
      arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + 3);
      nextEvent(4368);
    } 
  }
  
  private void runEvent_select(int paramInt) {
    if (this.my.state != 12 && this.my.state != 13 && this.my.state != 14) {
      this.sEvent_eV2 = this.event[paramInt][this.event_now[paramInt] + 1];
      this.sEvent_eV1 = 0;
      this.gr.action_str = null;
      this.gr.action_str = new String[this.sEvent_eV2];
      byte b = 0;
      while (true) {
        if (b >= this.sEvent_eV2) {
          if (this.sIfElse != -1) {
            this.event_state = 1;
            this.gr.cur_a = this.sIfElse;
            this.my.state = 13;
            this.gr.action_str = null;
            this.sIfElse = -1;
            return;
          } 
        } else {
          this.gr.action_str[b] = Ms.i().getDialogs(this.event[paramInt], this.event_now[paramInt] + 2 + this.sEvent_eV1 + 1, this.event[paramInt][this.event_now[paramInt] + 2 + this.sEvent_eV1]);
          this.sEvent_eV1 = (byte)(this.sEvent_eV1 + (this.event[paramInt][this.event_now[paramInt] + 2 + this.sEvent_eV1] << 1) + 1);
          b = (byte)(b + 1);
          continue;
        } 
        this.gr.cur_a = 0;
        this.my.state = 12;
        return;
      } 
    } 
    if (this.my.state == 13) {
      this.sEvent_eV1 = (byte)(this.sEvent_eV1 + 2);
      short s = (short)((this.event[paramInt][this.event_now[paramInt] + this.sEvent_eV1 + (this.gr.cur_a << 1)] & 0xFF) << 8 | this.event[paramInt][this.event_now[paramInt] + this.sEvent_eV1 + (this.gr.cur_a << 1) + 1] & 0xFF);
      short[] arrayOfShort = this.event_now;
      arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + this.sEvent_eV1 + (this.sEvent_eV2 << 1) + s);
      nextEvent(17);
      return;
    } 
    if (this.my.state == 14)
      setEventNow(paramInt, true); 
  }
  
  private void runEvent_srcMove(int paramInt) {
    byte b;
    this.my.state = 10;
    int i = this.event[paramInt][this.event_now[paramInt] + 2] - 1;
    if (i == -1) {
      b = this.my.getIx();
      i = this.my.getIy();
      this.srcNpcNo = -1;
    } else {
      boolean bool;
      this.now_eV1 = getNpcLayer(i);
      this.now_eV2 = getNpcId(i);
      if (this.now_eV1 == 0) {
        bool = this.now_eV2;
      } else {
        bool = false;
      } 
      this.srcNpcNo = bool;
      b = (this.npc[this.now_eV1][this.now_eV2]).other[0];
      i = (this.npc[this.now_eV1][this.now_eV2]).other[1];
    } 
    int j = map_set(b, this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20) - this.map_x;
    i = map_set(i, this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20) - this.map_y;
    Ms.i();
    if (Ms.abs(i) < 10) {
      Ms.i();
      if (Ms.abs(j) < 10) {
        short[] arrayOfShort = this.event_now;
        arrayOfShort[paramInt] = (short)(arrayOfShort[paramInt] + 3);
        nextEvent(4112);
        return;
      } 
    } 
    Ms.i();
    if (Ms.abs(j) >= 10) {
      paramInt = this.map_x;
      Ms.i();
      this.map_x = paramInt + j / Ms.abs(j) * 10;
    } 
    Ms.i();
    if (Ms.abs(i) >= 10) {
      paramInt = this.map_y;
      Ms.i();
      this.map_y = paramInt + i / Ms.abs(i) * 10;
    } 
  }
  
  private void runMove() {
    if (this.my.ix != -1 || this.my.iy != -1) {
      runSeek(this.my, false);
    } else {
      runBoat();
    } 
    oneMove(this.my, -1);
    byte b = 0;
    label28: while (true) {
      if (b >= 3) {
        insertNpc();
        return;
      } 
      for (byte b1 = 0;; b1 = (byte)(b1 + 1)) {
        if (b1 >= (this.npc[b]).length) {
          b = (byte)(b + 2);
          continue label28;
        } 
        if ((this.npc[b][b1]).other[4] == 1 || (this.npc[b][b1]).other[4] == 2) {
          if ((this.npc[b][b1]).other[8] >= 5) {
            runAutoMoveNpc(this.npc[b][b1], b1);
          } else if ((this.npc[b][b1]).ix != -1 || (this.npc[b][b1]).iy != -1) {
            runSeek(this.npc[b][b1], true);
          } 
          oneMove(this.npc[b][b1], b1);
        } 
      } 
      break;
    } 
  }
  
  private void runNpcAniOne(Npc[] paramArrayOfNpc, int paramInt) {
    byte b3 = (byte)((paramArrayOfNpc[paramInt]).other[3] - 1);
    byte b2 = (paramArrayOfNpc[paramInt]).other[2];
    Ms.i();
    byte b4 = (byte)Ms.abs((paramArrayOfNpc[paramInt]).other[7]);
    if ((paramArrayOfNpc[paramInt]).now_action >= npcSp[b3][b2].aLength(b4)) {
      (paramArrayOfNpc[paramInt]).now_action = 0;
      setlastA(paramArrayOfNpc, paramInt);
    } 
    Npc npc = paramArrayOfNpc[paramInt];
    byte b1 = (byte)(npc.now_time + 1);
    npc.now_time = b1;
    if (b1 >= npcSp[b3][b2].action(b4, (paramArrayOfNpc[paramInt]).now_action, 1)) {
      npc = paramArrayOfNpc[paramInt];
      npc.now_action = (byte)(npc.now_action + 1);
      (paramArrayOfNpc[paramInt]).now_time = 0;
    } 
  }
  
  private void runSeek(Npc paramNpc, boolean paramBoolean) {
    boolean bool = paramNpc.b_check;
    short s2 = (short)(paramNpc.ix * 20);
    short s1 = (short)(paramNpc.iy * 20);
    if (paramNpc.x == s2 && paramNpc.y == s1) {
      if (paramNpc.frame_c == -1) {
        paramNpc.iy = -1;
        paramNpc.ix = -1;
        if (paramBoolean) {
          paramNpc.setIxIy_npc();
        } else {
          paramNpc.speed = getMySpeed();
        } 
        if (paramNpc.bdir) {
          byte b;
          paramNpc.other[7] = paramNpc.lastAction;
          if (paramNpc.lastAction < 0) {
            b = 4;
          } else {
            b = 3;
          } 
          paramNpc.dir = b;
          paramNpc.setLastAction(false, 127);
        } 
      } 
      return;
    } 
    if (paramNpc.frame_c < 1) {
      byte b;
      if (bool) {
        if (paramNpc.x != s2) {
          b = 1;
        } else {
          b = 0;
        } 
      } else if (paramNpc.y == s1) {
        b = 1;
      } else {
        b = 0;
      } 
      if (b) {
        if ((paramNpc.x > s2 && paramNpc.x - paramNpc.speed < s2) || (paramNpc.x < s2 && paramNpc.x + paramNpc.speed > s2)) {
          paramNpc.setSpeedXY(s2 - paramNpc.x, 0);
        } else {
          if (paramNpc.x > s2) {
            b = -paramNpc.speed;
          } else {
            b = paramNpc.speed;
          } 
          paramNpc.setSpeedXY(b, 0);
        } 
        if (!paramNpc.bdir) {
          byte b1;
          if (paramNpc.x > s2) {
            b1 = 3;
          } else {
            b1 = 4;
          } 
          paramNpc.dir = b1;
        } 
      } else {
        if ((paramNpc.y > s1 && paramNpc.y - paramNpc.speed < s1) || (paramNpc.y < s1 && paramNpc.y + paramNpc.speed > s1)) {
          paramNpc.setSpeedXY(0, s1 - paramNpc.y);
        } else {
          if (paramNpc.y > s1) {
            b = -paramNpc.speed;
          } else {
            b = paramNpc.speed;
          } 
          paramNpc.setSpeedXY(0, b);
        } 
        if (!paramNpc.bdir) {
          byte b1;
          if (paramNpc.y > s1) {
            b1 = 1;
          } else {
            b1 = 2;
          } 
          paramNpc.dir = b1;
        } 
      } 
      paramNpc.frame_c = paramNpc.frame_num;
      paramNpc.setActionNo(true);
    } 
  }
  
  private void setEventNow(int paramInt, boolean paramBoolean) {
    if (paramBoolean)
      this.my.state = 0; 
    this.now_eV1 = 0;
    this.now_eV2 = 0;
    this.eventGoing = 0;
    this.event_now[paramInt] = 0;
  }
  
  private void setMapData() {
    this.map_x = map_set(this.my.getIx(), this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
    this.map_y = map_set(this.my.getIy(), this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
    this.mapLeft_NOmove = (short)(Constants_H.WIDTH_H - 10);
    this.mapRight_NOmove = (short)(this.cols * 20 - Constants_H.WIDTH_H - 10);
    this.mapUp_NOmove = (short)(Constants_H.HEIGHT_H - 10);
    this.mapDown_NOmove = (short)(this.rows * 20 - Constants_H.HEIGHT_H - 10);
  }
  
  private void setMapOffer() {
    if (this.map_y + this.rows * 20 < Constants_H.HEIGHT && this.rows > Constants_H.YCELLS) {
      this.map_y = Constants_H.HEIGHT - this.rows * 20;
      return;
    } 
    if (this.map_y > 0 && this.rows > Constants_H.YCELLS) {
      this.map_y = 0;
      return;
    } 
    if (this.map_x > 0 && this.cols > Constants_H.XCELLS) {
      this.map_x = 0;
      return;
    } 
    if (this.map_x + this.cols * 20 < Constants_H.WIDTH && this.cols > Constants_H.XCELLS)
      this.map_x = Constants_H.WIDTH - this.cols * 20; 
  }
  
  private void setMoveStop_m() {
    this.my.speed_x = 0;
    this.my.speed_y = 0;
    this.my.frame_c = -1;
    this.my.setActionNo(false);
  }
  
  private boolean setSIfElse(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    if (paramInt == 2) {
      if (paramBoolean1) {
        paramInt = 0;
      } else {
        paramInt = 1;
      } 
      this.sIfElse = (byte)paramInt;
      return true;
    } 
    return (paramBoolean2 && paramBoolean1) ? true : ((!paramBoolean2 && paramInt == 1));
  }
  
  private boolean setlastA(Npc[] paramArrayOfNpc, int paramInt) {
    if ((paramArrayOfNpc[paramInt]).lastAction != Byte.MAX_VALUE) {
      (paramArrayOfNpc[paramInt]).other[7] = (paramArrayOfNpc[paramInt]).lastAction;
      (paramArrayOfNpc[paramInt]).lastAction = Byte.MAX_VALUE;
      return true;
    } 
    return false;
  }
  
  private void turnAround(int paramInt) {
    this.my.dir = (byte)paramInt;
    this.my.setActionNo(true);
  }
  
  public void addAnole(int paramInt) {
    if (paramInt == 13 || paramInt == 34 || paramInt == 49 || paramInt == 66 || paramInt == 82) {
      if (paramInt == 13) {
        paramInt = 0;
      } else if (paramInt == 34) {
        paramInt = 1;
      } else if (paramInt == 49) {
        paramInt = 2;
      } else if (paramInt == 66) {
        paramInt = 3;
      } else {
        paramInt = 4;
      } 
      byte[] arrayOfByte = this.gr.rmsOther;
      arrayOfByte[2] = (byte)(arrayOfByte[2] | 1 << paramInt);
    } 
  }
  
  public void bkEvent_getMon() {
    GameRun.run_state = -10;
  }
  
  public void bkgroundToPaint(short[] paramArrayOfshort, Image[] paramArrayOfImage, int paramInt1, int paramInt2, short[][] paramArrayOfshort1, Graphics paramGraphics, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean) {
    if (paramArrayOfshort != null) {
      if (paramBoolean) {
        paramGraphics.setClip(paramInt3, paramInt4, paramInt5 - paramInt3, paramInt6 - paramInt4);
        paramGraphics.setColor(this.bgColor);
        paramGraphics.fillRect(paramInt3, paramInt4, paramInt5 - paramInt3, paramInt6 - paramInt4);
      } 
      byte b = 0;
      while (true) {
        if (b < paramArrayOfshort.length) {
          if (paramArrayOfshort[b + 2] >= 0) {
            short s2;
            int i = paramArrayOfshort[b + 2] >> 3;
            short s1 = paramArrayOfshort[b + 2];
            int j = paramArrayOfshort[b] * 20 - paramInt1;
            int k = paramArrayOfshort[b + 1] * 20 - paramInt2 - 20;
            if ((s1 & 0x3) % 2 == 1) {
              s2 = paramArrayOfshort1[i][4];
              s1 = paramArrayOfshort1[i][3];
            } else {
              s2 = paramArrayOfshort1[i][3];
              s1 = paramArrayOfshort1[i][4];
            } 
            if (j + s2 >= paramInt3 && j <= paramInt5 && k >= paramInt4 && k - s1 <= paramInt6)
              Ui.i().drawRegion(paramArrayOfImage[paramArrayOfshort1[i][0]], paramArrayOfshort1[i][1], paramArrayOfshort1[i][2], paramArrayOfshort1[i][3], paramArrayOfshort1[i][4], j, k, 0x4 | 0x20, paramArrayOfshort[b + 2] & 0x7, paramGraphics); 
          } 
          b += 3;
          continue;
        } 
        return;
      } 
    } 
  }
  
  public void checkRegWhere0(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield isNeedWait : Z
    //   7: aload_0
    //   8: getfield gr : Lmain/GameRun;
    //   11: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   14: iconst_2
    //   15: iconst_1
    //   16: invokevirtual go : (IZ)V
    //   19: aload_0
    //   20: getfield gr : Lmain/GameRun;
    //   23: invokestatic i : (Lmain/GameRun;)Lmain/SMSSender;
    //   26: invokevirtual run : ()V
    //   29: aload_0
    //   30: getfield isNeedWait : Z
    //   33: istore_2
    //   34: iload_2
    //   35: ifeq -> 60
    //   38: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   41: ldc_w 'wait() start'
    //   44: invokevirtual println : (Ljava/lang/String;)V
    //   47: aload_0
    //   48: invokevirtual wait : ()V
    //   51: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   54: ldc_w 'wait() over'
    //   57: invokevirtual println : (Ljava/lang/String;)V
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual printStackTrace : ()V
    //   68: goto -> 51
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   2	34	71	finally
    //   38	51	63	java/lang/Exception
    //   38	51	71	finally
    //   51	60	71	finally
    //   64	68	71	finally
  }
  
  public byte checkSoftKey(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt1 + paramInt3 < 0 || paramInt1 + paramInt3 >= this.cols * 20 || paramInt2 + paramInt4 < 0 || paramInt2 + paramInt4 >= this.rows * 20)
      return 0; 
    null = checkIfNpc(this.npc[0], paramInt1 + paramInt3, paramInt2 + paramInt4);
    if (this.my.state == 0 && null != -1) {
      if (this.anole_type == 1 && (this.npc[0][null]).other[8] == 4) {
        (this.npc[0][null]).other[8] = -4;
        byte[] arrayOfByte = (this.npc[0][null]).other;
        arrayOfByte[7] = (byte)(arrayOfByte[7] + 1);
        (this.npc[0][null]).now_action = 0;
        (this.npc[0][null]).now_time = 0;
      } else if ((this.npc[0][null]).other[8] != -4) {
        this.my.state = 2;
        this.get_meet = null;
        if ((this.npc[0][null]).other[8] != 2 && (this.npc[0][null]).other[8] != 3 && !this.npcNameData[null].equals("路人")) {
          this.bDirTalk = true;
          this.npcDirTalk = (this.npc[0][null]).other[7];
          byte[] arrayOfByte = (this.npc[0][null]).other;
          Ms.i();
          paramInt2 = Ms.abs(this.npcDirTalk) / 3;
          if (this.my.dir < 4) {
            paramInt1 = this.my.dir - 1;
          } else {
            paramInt1 = this.my.dir - 2;
          } 
          arrayOfByte[7] = (byte)(paramInt2 * 3 + paramInt1);
          if (this.my.dir == 3) {
            (this.npc[0][null]).other[7] = (byte)-(this.npc[0][null]).other[7];
          } else {
            (this.npc[0][null]).dir = 3;
          } 
        } else {
          this.bDirTalk = false;
        } 
      } 
      return 9;
    } 
    null = checkIfOther(this.item, paramInt1 + paramInt3, paramInt2 + paramInt4);
    if (null != -1 && this.item[null][2] != -1) {
      Ms.i().keyRelease();
      this.get_meet = null;
      getItem();
      return 0;
    } 
    return -1;
  }
  
  public void chuansong(int paramInt1, int paramInt2) {
    this.my.state = 5;
    this.mapNotemp = (byte)paramInt1;
    this.go = (byte)paramInt2;
    setMoveStop_m();
  }
  
  public void createEvent() {
    // Byte code:
    //   0: invokestatic i : ()Ldm/Ms;
    //   3: ldc_w 'event'
    //   6: aload_0
    //   7: getfield mapNo : B
    //   10: invokevirtual getStream : (Ljava/lang/String;I)[B
    //   13: astore #5
    //   15: aload #5
    //   17: arraylength
    //   18: iconst_1
    //   19: if_icmpne -> 28
    //   22: aload_0
    //   23: iconst_0
    //   24: putfield eventCount : I
    //   27: return
    //   28: aload_0
    //   29: aload #5
    //   31: iconst_0
    //   32: baload
    //   33: putfield eventCount : I
    //   36: aload_0
    //   37: getfield mapInfo : [S
    //   40: aload_0
    //   41: getfield mapNo : B
    //   44: iconst_2
    //   45: imul
    //   46: saload
    //   47: iconst_1
    //   48: if_icmpge -> 185
    //   51: aload_0
    //   52: getfield event_now_list : [[S
    //   55: aload_0
    //   56: getfield mapNo : B
    //   59: aconst_null
    //   60: aastore
    //   61: aload_0
    //   62: getfield event_now_list : [[S
    //   65: aload_0
    //   66: getfield mapNo : B
    //   69: aload_0
    //   70: getfield eventCount : I
    //   73: newarray short
    //   75: aastore
    //   76: aload_0
    //   77: aload_0
    //   78: getfield event_now_list : [[S
    //   81: aload_0
    //   82: getfield mapNo : B
    //   85: aaload
    //   86: putfield event_now : [S
    //   89: aload_0
    //   90: aload_0
    //   91: getfield eventCount : I
    //   94: anewarray [B
    //   97: putfield event : [[B
    //   100: iconst_0
    //   101: istore_1
    //   102: iconst_0
    //   103: iconst_1
    //   104: iadd
    //   105: istore_2
    //   106: iload_1
    //   107: aload_0
    //   108: getfield eventCount : I
    //   111: if_icmpge -> 27
    //   114: iload_2
    //   115: iconst_1
    //   116: iadd
    //   117: istore_3
    //   118: aload #5
    //   120: iload_2
    //   121: baload
    //   122: istore #4
    //   124: iload_3
    //   125: iconst_1
    //   126: iadd
    //   127: istore_2
    //   128: iload #4
    //   130: bipush #8
    //   132: ishl
    //   133: aload #5
    //   135: iload_3
    //   136: baload
    //   137: sipush #255
    //   140: iand
    //   141: ior
    //   142: i2s
    //   143: istore_3
    //   144: aload_0
    //   145: getfield event : [[B
    //   148: iload_1
    //   149: iload_3
    //   150: newarray byte
    //   152: aastore
    //   153: aload #5
    //   155: iload_2
    //   156: aload_0
    //   157: getfield event : [[B
    //   160: iload_1
    //   161: aaload
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield event : [[B
    //   167: iload_1
    //   168: aaload
    //   169: arraylength
    //   170: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   173: iload_2
    //   174: iload_3
    //   175: iadd
    //   176: istore_2
    //   177: iload_1
    //   178: iconst_1
    //   179: iadd
    //   180: i2b
    //   181: istore_1
    //   182: goto -> 106
    //   185: iconst_0
    //   186: istore_1
    //   187: iload_1
    //   188: aload_0
    //   189: getfield eventCount : I
    //   192: if_icmpge -> 76
    //   195: aload_0
    //   196: aload_0
    //   197: getfield mapNo : B
    //   200: iload_1
    //   201: invokespecial isMapEvent : (II)Z
    //   204: ifeq -> 221
    //   207: aload_0
    //   208: getfield event_now_list : [[S
    //   211: aload_0
    //   212: getfield mapNo : B
    //   215: aaload
    //   216: iload_1
    //   217: sipush #24224
    //   220: sastore
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: i2b
    //   225: istore_1
    //   226: goto -> 187
  }
  
  byte[][] createItem(byte[] paramArrayOfbyte, byte[][] paramArrayOfbyte1) {
    paramArrayOfbyte1 = (byte[][])null;
    if (this.mapInfo[this.mapNo * 2] > 0) {
      byte[] arrayOfByte1 = this.mapTemp[this.mapNo];
      Ms.i();
      int j = Ms.skip2;
      Ms.skip2 = j + 1;
      paramArrayOfbyte1 = new byte[arrayOfByte1[j]][];
      j = 0;
      label25: while (true) {
        if (j < paramArrayOfbyte1.length) {
          Ms.i();
          int k = Ms.skip2;
          Ms.skip2 = k + 1;
          paramArrayOfbyte1[j] = new byte[arrayOfByte1[k]];
          for (k = 0;; k++) {
            if (k >= (paramArrayOfbyte1[j]).length) {
              j++;
              continue label25;
            } 
            paramArrayOfbyte = paramArrayOfbyte1[j];
            Ms.i();
            int m = Ms.skip2;
            Ms.skip2 = m + 1;
            paramArrayOfbyte[k] = arrayOfByte1[m];
          } 
          break;
        } 
        return paramArrayOfbyte1;
      } 
    } 
    Ms.i();
    int i = Ms.skip;
    Ms.skip = i + 1;
    byte[][] arrayOfByte = new byte[paramArrayOfbyte[i]][];
    i = 0;
    label26: while (true) {
      byte[] arrayOfByte1;
      paramArrayOfbyte1 = arrayOfByte;
      if (i < arrayOfByte.length) {
        Ms.i();
        int j = Ms.skip;
        Ms.skip = j + 1;
        arrayOfByte[i] = new byte[paramArrayOfbyte[j]];
        for (j = 0;; j++) {
          if (j >= (arrayOfByte[i]).length) {
            i++;
            continue label26;
          } 
          arrayOfByte1 = arrayOfByte[i];
          Ms.i();
          int k = Ms.skip;
          Ms.skip = k + 1;
          arrayOfByte1[j] = paramArrayOfbyte[k];
        } 
        break;
      } 
      return (byte[][])arrayOfByte1;
    } 
  }
  
  public void createLayer() {
    createMap();
    setMapData();
  }
  
  Npc[] createNpc(byte[] paramArrayOfbyte, Npc[] paramArrayOfNpc) {
    paramArrayOfNpc = (Npc[])null;
    Ms.i();
    int i = Ms.skip;
    Ms.skip = i + 1;
    paramArrayOfNpc = new Npc[paramArrayOfbyte[i]];
    i = 0;
    label27: while (true) {
      if (i >= paramArrayOfNpc.length) {
        if (this.mapInfo[this.mapNo * 2] > 0) {
          i = 0;
          label25: while (true) {
            if (i >= paramArrayOfNpc.length)
              return paramArrayOfNpc; 
            if ((paramArrayOfNpc[i]).other[9] == 1) {
              for (byte b = 0;; b++) {
                if (b >= (paramArrayOfNpc[i]).other.length) {
                  paramArrayOfNpc[i].setXY_npc();
                  i++;
                  continue label25;
                } 
                byte[] arrayOfByte = (paramArrayOfNpc[i]).other;
                paramArrayOfbyte = this.mapTemp[this.mapNo];
                Ms.i();
                int k = Ms.skip2;
                Ms.skip2 = k + 1;
                arrayOfByte[b] = paramArrayOfbyte[k];
              } 
              break;
            } 
            continue;
          } 
          break;
        } 
        continue;
      } 
      Ms.i();
      int j = Ms.skip;
      Ms.skip = j + 1;
      paramArrayOfNpc[i] = new Npc(paramArrayOfbyte[j]);
      for (j = 0;; j++) {
        if (j >= (paramArrayOfNpc[i]).other.length) {
          paramArrayOfNpc[i].setXY_npc();
          i++;
          continue label27;
        } 
        byte[] arrayOfByte = (paramArrayOfNpc[i]).other;
        Ms.i();
        int k = Ms.skip;
        Ms.skip = k + 1;
        arrayOfByte[j] = paramArrayOfbyte[k];
      } 
      break;
    } 
  }
  
  public byte[] createNpcPos(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    paramArrayOfbyte2 = (byte[])null;
    Ms.i();
    int i = Ms.skip;
    Ms.skip = i + 1;
    paramArrayOfbyte2 = new byte[paramArrayOfbyte1[i]];
    for (i = 0;; i++) {
      if (i >= paramArrayOfbyte2.length)
        return paramArrayOfbyte2; 
      Ms.i();
      int j = Ms.skip;
      Ms.skip = j + 1;
      paramArrayOfbyte2[i] = paramArrayOfbyte1[j];
    } 
  }
  
  public void createNpcString() {
    this.npcNameData = Ms.i().loadText(initData(this.gr.createData(1), this.mapNo));
    this.npcStringData = Ms.i().loadText(initData(this.gr.createData(2), this.mapNo));
  }
  
  public void createOther() {
    byte[] arrayOfByte = (byte[])null;
    Ms.i();
    Ms.skip = 0;
    Ms.i();
    Ms.skip2 = 0;
    arrayOfByte = initData(this.gr.createData(0), this.mapNo);
    this.npcPos = createNpcPos(arrayOfByte, this.npcPos);
    if (this.mapInfo[this.mapNo * 2] > 0 && this.mapTemp[this.mapNo] == null)
      this.mapTemp[this.mapNo] = Ms.i().rmsOptions(this.mapNo + 14, null, 1); 
    this.npc[0] = createNpc(arrayOfByte, this.npc[0]);
    this.npc[1] = createNpc(arrayOfByte, this.npc[1]);
    this.npc[2] = createNpc(arrayOfByte, this.npc[2]);
    this.item = createItem(arrayOfByte, this.item);
    this.door = createItem(arrayOfByte, this.door);
    this.npcList = null;
    this.npcList = new byte[(this.npc[0]).length + 1 + this.item.length];
    arrayOfByte = (byte[])null;
    initNpcAni();
  }
  
  public void doKey() {
    switch (this.map_key) {
      default:
        return;
      case 1:
      case 2:
      case 3:
      case 4:
        if (this.my.dir != this.map_key)
          turnAround(this.map_key); 
        canMove(this.dir_select[this.map_key][0] * this.my.speed, this.dir_select[this.map_key][1] * this.my.speed);
      case -53:
      case 5:
        if (this.gr.isTalk)
          checkSoftKey(this.my.x, this.my.y, this.dir_select[this.my.dir][0] * this.my.speed, this.dir_select[this.my.dir][1] * this.my.speed); 
      case -57:
        Ms.i().keyRelease();
        if (this.gr.rmsOther[2] > 0)
          initAnoleValue(); 
      case -51:
        goMission(1, false);
      case -49:
        goMission(0, false);
      case -48:
        break;
    } 
    goMiniMap();
  }
  
  public void drawBlackSRC(Graphics paramGraphics, int paramInt, boolean paramBoolean) {
    int i = Constants_H.WIDTH__;
    int k = Constants_H.HEIGHT__;
    int j = Constants_H.WIDTH__ / 2;
    paramGraphics.setColor(16777215);
    short s2 = 0;
    if (this.black_0 - 5 > 0) {
      s1 = this.black_0 - 5;
    } else {
      s1 = 0;
    } 
    byte b = (byte)s1;
    short s1 = s2;
    if (this.gr.about_d != null)
      while (true) {
        if (paramBoolean ? (s1 >= this.gr.about_d.length) : (s1 > this.black_0 || s1 >= this.gr.about_d.length)) {
          if (!paramBoolean) {
            paramGraphics.setColor(0);
            paramGraphics.fillRect(0, 0, i, 40);
            paramGraphics.fillRect(0, k - 40, i, 40);
          } 
          if (this.black_0 == this.gr.about_d.length) {
            this.gr.drawZero(j, k - 25 - 4, 0x1 | 0x20, 0);
            return;
          } 
          if (!paramBoolean) {
            short s = (short)(this.black_1 + 10);
            this.black_1 = s;
            if (s >= j) {
              this.black_1 = 0;
              this.black_0 = (short)(this.black_0 + 1);
              return;
            } 
          } 
          if (paramBoolean)
            this.black_0 = (byte)this.gr.about_d.length; 
          return;
        } 
        if (!paramBoolean) {
          if (this.black_0 == s1)
            paramGraphics.setClip(0, (s1 - b) * 29 + paramInt, this.black_1 << 1, 25 + 4); 
          Ui.i().drawStringColor(this.gr.about_d[s1].toString(), 25, (s1 - b) * 29 + paramInt, 0, 0);
          paramGraphics.setClip(0, 0, i, k);
        } else {
          s2 = (short)(Ms.i().getStringWidth(this.gr.about_d[s1].toString()) - this.gr.getSIndexW(this.gr.about_d[s1].toString()));
          Ui.i().drawStringColor(this.gr.about_d[s1].toString(), i - s2 >> 1, s1 * 29 + paramInt + 6, 0, 0);
        } 
        s1 = (short)(s1 + 1);
      }  
  }
  
  void drawMap(Graphics paramGraphics) {
    short s1 = this.leftCol;
    short s2 = this.topRow;
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
    int j = this.leftCol * 20;
    int i = this.topRow * 20;
    if (this.firstDrawMap == 0) {
      this.firstDrawMap = 1;
      bkgroundToPaint(this.bottomData, this.mapImg, j, i, this.moduleData, paramGraphics, 0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
    } else if (this.leftCol != s1 || this.topRow != s2) {
      paramGraphics.setClip(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT);
      paramGraphics.copyArea(0, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, (s1 - this.leftCol) * 20, (s2 - this.topRow) * 20, 20);
      if (this.leftCol < s1) {
        bkgroundToPaint(this.bottomData, this.mapImg, j, i, this.moduleData, paramGraphics, 0, 0, (s1 - this.leftCol) * 20, Constants_H.OFF_HEIGHT, true);
      } else if (this.leftCol > s1) {
        bkgroundToPaint(this.bottomData, this.mapImg, j, i, this.moduleData, paramGraphics, Constants_H.OFF_WIDTH + (s1 - this.leftCol) * 20, 0, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
      } 
      if (this.topRow < s2) {
        bkgroundToPaint(this.bottomData, this.mapImg, j, i, this.moduleData, paramGraphics, 0, 0, Constants_H.OFF_WIDTH, (s2 - this.topRow) * 20, true);
      } else if (this.topRow > s2) {
        bkgroundToPaint(this.bottomData, this.mapImg, j, i, this.moduleData, paramGraphics, 0, Constants_H.OFF_HEIGHT + (s2 - this.topRow) * 20, Constants_H.OFF_WIDTH, Constants_H.OFF_HEIGHT, true);
      } 
    } 
    g.drawImage(GameRun.scrT, this.map_left, this.map_top, 20);
  }
  
  public void drawMyAni(Npc paramNpc, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    byte b2 = (byte)paramInt1;
    if (paramNpc.now_action >= npcSp[1][b2].aLength(paramInt4))
      paramNpc.now_action = 0; 
    if (this.anole_type != 2 && this.anole_type != 4)
      Ui.i().drawImage(this.imgShadow, paramInt2, paramInt3, 33); 
    Ui ui = Ui.i();
    Sprite sprite = npcSp[1][b2];
    int i = npcSp[1][b2].action(paramInt4, paramNpc.now_action, 0);
    if (paramNpc.dir == 4) {
      paramInt1 = 1;
    } else {
      paramInt1 = 0;
    } 
    ui.drawFrameOne(sprite, i, paramInt2, paramInt3, paramInt1);
    byte b1 = (byte)(paramNpc.now_time + 1);
    paramNpc.now_time = b1;
    if (b1 > npcSp[1][b2].action(paramInt4, paramNpc.now_action, 1)) {
      paramNpc.now_action = (byte)(paramNpc.now_action + 1);
      paramNpc.now_time = 0;
    } 
  }
  
  public void eventCheck() {
    byte b = 0;
    label376: while (true) {
      if (this.event == null || b >= this.event.length)
        return; 
      if (this.event[b] != null) {
        if (this.event_now[b] >= (this.event[b]).length)
          continue; 
        label294: while (true) {
          byte b1;
          boolean bool;
          short[] arrayOfShort3;
          Npc npc;
          short[] arrayOfShort2;
          byte[] arrayOfByte;
          short[] arrayOfShort1;
          byte[][] arrayOfByte1;
          this.event_state = 0;
          if (this.event_now[b] >= (this.event[b]).length) {
            short[] arrayOfShort = this.mapInfo;
            int j = this.mapNo * 2 + 1;
            arrayOfShort[j] = (short)(arrayOfShort[j] | 1 << b);
            continue label376;
          } 
          switch (this.event[b][this.event_now[b]]) {
            default:
              continue;
            case 28:
              runEvent_dialog(b);
              continue;
            case 41:
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                this.my.setXY(this.event[b][this.event_now[b] + 3], this.event[b][this.event_now[b] + 4], 0, 0);
                this.my.frame_c = -1;
                if (this.srcNpcNo == -1) {
                  this.map_x = map_set(this.event[b][this.event_now[b] + 3], this.cols, Constants_H.XCELLS, Constants_H.HALF_XCELLS, Constants_H.WIDTH, 20);
                  this.map_y = map_set(this.event[b][this.event_now[b] + 4], this.rows, Constants_H.YCELLS, Constants_H.HALF_YCELLS, Constants_H.HEIGHT, 20);
                } 
              } else {
                this.now_eV1 = getNpcLayer(i);
                this.now_eV2 = getNpcId(i);
                (this.npc[this.now_eV1][this.now_eV2]).other[0] = this.event[b][this.event_now[b] + 3];
                (this.npc[this.now_eV1][this.now_eV2]).other[1] = this.event[b][this.event_now[b] + 4];
                this.npc[this.now_eV1][this.now_eV2].setXY_npc();
              } 
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 5);
              nextEvent(4112);
              continue;
            case 15:
              if (this.event[b][this.event_now[b] + 2] == 0) {
                bool = true;
              } else {
                bool = false;
              } 
              setEventNow(b, bool);
              continue;
            case 4:
              if (this.gr.monInfoList[103] >= this.event[b][this.event_now[b] + 2]) {
                bool = true;
              } else {
                bool = false;
              } 
              ifEvent(b, 4, 16, this.event[b][this.event_now[b] + 3], bool);
              continue;
            case 24:
              initBoat(this.event[b][this.event_now[b] + 2]);
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
              nextEvent(16);
              continue;
            case 25:
              this.gr.overMode = (byte)(this.event[b][this.event_now[b] + 2] + 1);
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
              continue;
            case 50:
              if (this.my.state == 24 || this.my.state == 25) {
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
                nextEvent(0);
                if (this.my.state == 24) {
                  this.gr.say("保存进度完成", 1);
                  this.gr.saveGame();
                } 
                this.my.state = 0;
                continue;
              } 
              if (this.my.frame_c == -1) {
                if (this.my.state != 23) {
                  this.my.state = 23;
                  continue;
                } 
                continue;
              } 
              continue;
            case 29:
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                cur_npc = this.my;
              } else {
                cur_npc = this.npc[getNpcLayer(i)][getNpcId(i)];
              } 
              cur_npc.setLastAction(false, this.event[b][this.event_now[b] + 4]);
              cur_npc.other[7] = this.event[b][this.event_now[b] + 3];
              cur_npc.now_action = 0;
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 5);
              nextEvent(4096);
              continue;
            case 39:
              this.now_eV1 = this.event[b][this.event_now[b] + 2];
              this.now_eV2 = this.event[b][this.event_now[b] + 3];
              if ((this.gr.rmsOther[this.now_eV1 * 2 + 4] & 1 << this.now_eV2) != 0) {
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + 4);
                nextEvent(4113);
                continue;
              } 
              continue;
            case 42:
              this.now_eV1 = this.event[b][this.event_now[b] + 2];
              this.now_eV2 = this.event[b][this.event_now[b] + 3];
              Mg.i().go(this.gr, this.now_eV1, -1, this.now_eV2);
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 4);
              nextEvent(4113);
              continue;
            case 18:
              runEvent_item_add_del(b);
              continue;
            case 49:
              if (this.gr.magic_id == -2) {
                this.my.state = 10;
                this.gr.magic_id = this.event[b][this.event_now[b] + 2];
                this.gr.magic_x = this.map_x + this.event[b][this.event_now[b] + 3] * 20 + 10;
                this.gr.magic_y = this.map_y + this.event[b][this.event_now[b] + 4] * 20 + 20;
                this.gr.setMagic(this.event[b][this.event_now[b] + 2] / 5);
                continue;
              } 
              if (this.gr.magic_id == -1) {
                this.gr.magic_id = -2;
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + 5);
                nextEvent(16);
                continue;
              } 
              continue;
            case 26:
              runEvent_getMon(b);
              continue;
            case 27:
              if (this.eventGoing == 0) {
                this.now_eV2 = this.gr.findMonsterMinLv(this.event[b][this.event_now[b] + 2], this.event[b][this.event_now[b] + 3]);
                if (this.now_eV2 != -1) {
                  this.now_eV1 = this.gr.delMonster(this.now_eV2);
                  this.eventGoing = 1;
                  continue;
                } 
                setEventNow(b, false);
                continue;
              } 
              if (this.gr.say_c == 0) {
                if (this.now_eV1 == -1) {
                  setEventNow(b, false);
                  continue;
                } 
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + this.event[b][this.event_now[b] + 1] + 2);
                nextEvent(4368);
                continue;
              } 
              continue;
            case 35:
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                this.my.other[4] = this.event[b][this.event_now[b] + 3];
                switch (this.event[b][this.event_now[b] + 3]) {
                  default:
                    arrayOfShort3 = this.event_now;
                    arrayOfShort3[b] = (short)(arrayOfShort3[b] + 4);
                    nextEvent(4112);
                    continue;
                  case 0:
                  case 2:
                    this.my.state = 0;
                  case 1:
                  case 3:
                    break;
                } 
                this.my.state = 10;
              } 
              this.now_eV1 = getNpcLayer(i);
              this.now_eV2 = getNpcId(i);
              (this.npc[this.now_eV1][this.now_eV2]).other[4] = this.event[b][this.event_now[b] + 3];
            case 32:
              runEvent_miniGame_myLevel(b);
              continue;
            case 46:
              Sound.i().setMusicId(this.event[b][this.event_now[b] + 2]);
              Sound.i().setMusic(false);
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
              nextEvent(16);
              continue;
            case 47:
              this.my.state = 10;
              b1 = (byte)(this.sleep_count + 1);
              this.sleep_count = b1;
              if (b1 == this.event[b][this.event_now[b] + 2]) {
                this.sleep_count = 0;
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
                nextEvent(17);
                continue;
              } 
              continue;
            case 52:
              this.my.state = 10;
              this.xxx = this.event[b][this.event_now[b] + 2];
              arrayOfShort3 = this.event_now;
              arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
              nextEvent(16);
              continue;
            case 16:
              runEvent_goShop(b);
              continue;
            case 53:
              if (initSrcEffect(this.event[b][this.event_now[b] + 2])) {
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + 3);
                nextEvent(16);
                continue;
              } 
              continue;
            case 13:
              if (this.eventGoing == 0) {
                this.eventGoing = 1;
                if (this.event[b][this.event_now[b] + 3] == 0) {
                  this.bMission[14] = this.event[b][this.event_now[b] + 2];
                  if (this.bMission[14] != -1) {
                    this.gr.say("#4主线任务#0已更新，点击#7工具包内的主线按钮#0可查看任务表。", -1);
                    continue;
                  } 
                  continue;
                } 
                i = this.event[b][this.event_now[b] + 2];
                if (this.event[b][this.event_now[b] + 3] == 2) {
                  bool = true;
                } else {
                  bool = false;
                } 
                setMission(i, bool);
                if (this.event[b][this.event_now[b] + 3] == 2) {
                  this.gr.say("#4分支任务#0已更新，点击#7工具包内的支线按钮#0可查看任务表。", -1);
                  continue;
                } 
                continue;
              } 
              if (this.gr.say_c == 0) {
                arrayOfShort3 = this.event_now;
                arrayOfShort3[b] = (short)(arrayOfShort3[b] + 4);
                nextEvent(272);
                continue;
              } 
              continue;
            case 30:
              this.my.state = 10;
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                cur_npc = this.my;
              } else {
                cur_npc = this.npc[getNpcLayer(i)][getNpcId(i)];
              } 
              cur_npc.setIXY(this.event[b][this.event_now[b] + 3], this.event[b][this.event_now[b] + 4]);
              cur_npc.speed = this.event[b][this.event_now[b] + 5];
              npc = cur_npc;
              if (this.event[b][this.event_now[b] + 6] == 0) {
                bool = true;
              } else {
                bool = false;
              } 
              npc.b_check = bool;
              cur_npc.setLastAction(false, 127);
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 7);
              nextEvent(16);
              continue;
            case 37:
              this.my.state = 10;
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                cur_npc = this.my;
              } else {
                cur_npc = this.npc[getNpcLayer(i)][getNpcId(i)];
              } 
              cur_npc.setLastAction(true, this.event[b][this.event_now[b] + 6]);
              cur_npc.setIXY(this.event[b][this.event_now[b] + 3], this.event[b][this.event_now[b] + 4]);
              cur_npc.other[7] = this.event[b][this.event_now[b] + 5];
              if (this.event[b][this.event_now[b] + 5] < 0)
                cur_npc.dir = 4; 
              cur_npc.speed = this.event[b][this.event_now[b] + 7];
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 8);
              nextEvent(16);
              continue;
            case 23:
              this.now_eV1 = this.event[b][this.event_now[b] + 2];
              this.now_eV2 = this.event[b][this.event_now[b] + 3];
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 4);
              setRestEvent(this.now_eV1, this.now_eV2);
              nextEvent(4112);
              continue;
            case 17:
              this.now_eV1 = this.event[b][this.event_now[b] + 2];
              this.now_eV2 = this.event[b][this.event_now[b] + 3];
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 4);
              setOverEvent(this.now_eV1, this.now_eV2);
              nextEvent(4112);
              continue;
            case 22:
              exitBoss(this.event[b][this.event_now[b] + 2], this.event[b][this.event_now[b] + 3], this.event[b][this.event_now[b] + 4], this.event[b][this.event_now[b] + 5]);
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 6);
              nextEvent(16);
              continue;
            case 36:
              i = this.event[b][this.event_now[b] + 2] - 1;
              this.now_eV1 = getNpcLayer(i);
              this.now_eV2 = getNpcId(i);
              (this.npc[this.now_eV1][this.now_eV2]).other[5] = (byte)(this.event[b][this.event_now[b] + 3] + 1);
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 4);
              nextEvent(4112);
              continue;
            case 2:
              this.now_eV1 = this.event[b][this.event_now[b] + 2];
              this.now_eV2 = this.event[b][this.event_now[b] + 3];
              ifEvent(b, 5, 4112, this.event[b][this.event_now[b] + 4], isMapEvent(this.now_eV1, this.now_eV2));
              continue;
            case 45:
              runEvent_srcMove(b);
              continue;
            case 48:
              this.my.state = 10;
              this.srcFlash_c = (byte)(this.event[b][this.event_now[b] + 2] << 1);
              arrayOfShort2 = this.event_now;
              arrayOfShort2[b] = (short)(arrayOfShort2[b] + 3);
              nextEvent(16);
              continue;
            case 38:
              runEvent_brow(b);
              continue;
            case 19:
              Ms.i();
              Ms.skip = 0;
              arrayOfByte = Ms.i().getStream("data/battle/boss.d", -1);
              arrayOfByte1 = Ms.i().create2Array(arrayOfByte);
              arrayOfByte = (byte[])null;
              i = this.event[b][this.event_now[b] + 1] >> 1;
              this.gr.enemyList = new byte[i][5];
              this.now_eV2 = 0;
              while (true) {
                if (this.now_eV2 >= i) {
                  byte[][] arrayOfByte2 = (byte[][])null;
                  Sound.i().setMusicId(6);
                  Sound.i().setMusic(false);
                  this.gr.battleType(3);
                  this.gr.goBattle();
                  short[] arrayOfShort = this.event_now;
                  arrayOfShort[b] = (short)(arrayOfShort[b] + this.event[b][this.event_now[b] + 1] + 2);
                  if (this.event_state != 1) {
                    b++;
                    continue label376;
                  } 
                  continue label294;
                } 
                this.now_eV1 = this.event[b][this.event_now[b] + 2 + this.now_eV2 * 2];
                this.gr.enemyList[this.now_eV2][0] = arrayOfByte1[this.now_eV1][0];
                this.gr.enemyList[this.now_eV2][1] = this.event[b][this.event_now[b] + 3 + this.now_eV2 * 2];
                this.gr.enemyList[this.now_eV2][2] = arrayOfByte1[this.now_eV1][1];
                this.gr.enemyList[this.now_eV2][3] = arrayOfByte1[this.now_eV1][2];
                this.gr.enemyList[this.now_eV2][4] = arrayOfByte1[this.now_eV1][3];
                this.now_eV2 = (byte)(this.now_eV2 + 1);
              } 
              break;
            case 6:
              bool = Ms.i().isRect(this.my.x, this.my.y, 19, 19, this.event[b][this.event_now[b] + 2] * 20, this.event[b][this.event_now[b] + 3] * 20, (this.event[b][this.event_now[b] + 4] - this.event[b][this.event_now[b] + 2] + 1) * 20, (this.event[b][this.event_now[b] + 5] - this.event[b][this.event_now[b] + 3] + 1) * 20);
              ifEvent(b, 7, 16, this.event[b][this.event_now[b] + 6], bool);
              continue;
            case 1:
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i != -1) {
                this.now_eV1 = getNpcLayer(i);
                this.now_eV2 = getNpcId(i);
                if (this.my.state == 2 && this.get_meet == this.now_eV2) {
                  bool = true;
                } else {
                  bool = false;
                } 
                ifEvent(b, 4, 16, this.event[b][this.event_now[b] + 3], bool);
                continue;
              } 
              continue;
            case 3:
              if (this.gr.money >= this.event[b][this.event_now[b] + 2] * 100) {
                bool = true;
              } else {
                bool = false;
              } 
              ifEvent(b, 4, 16, this.event[b][this.event_now[b] + 3], bool);
              continue;
            case 5:
              i = this.gr.findItem(-2, this.event[b][this.event_now[b] + 2], true);
              if (this.event[b][this.event_now[b] + 3] == 0) {
                if (i == 0) {
                  bool = true;
                } else {
                  bool = false;
                } 
              } else if (i >= this.event[b][this.event_now[b] + 3]) {
                bool = true;
              } else {
                bool = false;
              } 
              ifEvent(b, 5, 16, this.event[b][this.event_now[b] + 4], bool);
              continue;
            case 8:
              if (this.gr.findMonster(this.event[b][this.event_now[b] + 2], this.event[b][this.event_now[b] + 3]) != -1) {
                bool = true;
              } else {
                bool = false;
              } 
              ifEvent(b, 5, 16, this.event[b][this.event_now[b] + 4], bool);
              continue;
            case 12:
              runEvent_select(b);
              continue;
            case 11:
              i = this.event[b][this.event_now[b] + 2] - 1;
              this.now_eV1 = getNpcLayer(i);
              this.now_eV2 = getNpcId(i);
              if ((this.npc[this.now_eV1][this.now_eV2]).other[8] == this.event[b][this.event_now[b] + 3]) {
                short[] arrayOfShort = this.event_now;
                arrayOfShort[b] = (short)(arrayOfShort[b] + 4);
                nextEvent(16);
                continue;
              } 
              setEventNow(b, false);
              continue;
            case 40:
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                arrayOfByte = this.my.other;
                Ms.i();
                arrayOfByte[7] = (byte)Ms.abs(this.event[b][this.event_now[b] + 3]);
                if (this.event[b][this.event_now[b] + 3] < 0)
                  this.my.dir = 4; 
              } else {
                cur_npc = this.npc[getNpcLayer(i)][getNpcId(i)];
                cur_npc.other[7] = this.event[b][this.event_now[b] + 3];
                cur_npc.setNpcNum(npcSp[cur_npc.other[3] - 1][cur_npc.other[2]].aLength());
              } 
              arrayOfShort1 = this.event_now;
              arrayOfShort1[b] = (short)(arrayOfShort1[b] + 4);
              nextEvent(16);
              continue;
            case 43:
              i = this.event[b][this.event_now[b] + 2] - 1;
              this.now_eV1 = getNpcLayer(i);
              this.now_eV2 = getNpcId(i);
              (this.npc[this.now_eV1][this.now_eV2]).other[8] = this.event[b][this.event_now[b] + 3];
              arrayOfShort1 = this.event_now;
              arrayOfShort1[b] = (short)(arrayOfShort1[b] + 4);
              nextEvent(16);
              continue;
            case 21:
              if (this.eventGoing == 0) {
                this.eventGoing = 1;
                int j = this.event[b][this.event_now[b] + 2] * 100;
                if (j < 0) {
                  i = this.gr.money;
                  Ms.i();
                  if (i < Ms.abs(j)) {
                    this.gr.say("金钱不足！", 0);
                    this.eventGoing = 2;
                  } 
                } 
                if (this.eventGoing == 1) {
                  String str;
                  GameRun gameRun1 = this.gr;
                  gameRun1.money += j;
                  GameRun gameRun2 = this.gr;
                  if (j < 0) {
                    str = "失去：";
                  } else {
                    str = "获得：";
                  } 
                  StringBuilder stringBuilder = new StringBuilder(String.valueOf(str));
                  Ms.i();
                  gameRun2.say(stringBuilder.append(Ms.abs(j)).append("金").toString(), 0);
                  continue;
                } 
                continue;
              } 
              if (this.gr.say_c == 0) {
                if (this.eventGoing == 2) {
                  setEventNow(b, true);
                  continue;
                } 
                arrayOfShort1 = this.event_now;
                arrayOfShort1[b] = (short)(arrayOfShort1[b] + 3);
                nextEvent(272);
                continue;
              } 
              continue;
            case 33:
              this.anole_type = (byte)(this.event[b][this.event_now[b] + 2] - 1);
              setAnole();
              arrayOfShort1 = this.event_now;
              arrayOfShort1[b] = (short)(arrayOfShort1[b] + 3);
              nextEvent(16);
              continue;
            case 51:
              switch (this.event[b][this.event_now[b] + 2]) {
                default:
                  continue;
                case 0:
                  if (this.eventGoing == 0) {
                    this.gr.say(Ms.i().getDialogs(this.event[b], this.event_now[b] + 4, this.event[b][this.event_now[b] + 3]), -1);
                    this.eventGoing = 1;
                    continue;
                  } 
                  if (this.gr.say_c == 0) {
                    arrayOfShort1 = this.event_now;
                    arrayOfShort1[b] = (short)(arrayOfShort1[b] + (this.event[b][this.event_now[b] + 3] << 1) + 4);
                    nextEvent(272);
                    continue;
                  } 
                  continue;
                case 1:
                case 2:
                  break;
              } 
              if (this.eventGoing == 0) {
                this.my.state = 22;
                this.black_1 = 0;
                this.black_0 = 0;
                Ms.i();
                Ms.font.setSize(22);
                this.fontSizeControl = true;
                this.gr.setStringB(Ms.i().getDialogs(this.event[b], this.event_now[b] + 4, this.event[b][this.event_now[b] + 3]), Constants_H.WIDTH__ - 25 * 2, 3);
                Ms.i();
                Ms.font.setSize(26);
                this.fontSizeControl = false;
                this.eventGoing = this.event[b][this.event_now[b] + 2];
                continue;
              } 
              if (this.eventGoing == 3) {
                arrayOfShort1 = this.event_now;
                arrayOfShort1[b] = (short)(arrayOfShort1[b] + (this.event[b][this.event_now[b] + 3] << 1) + 4);
                nextEvent(272);
                this.gr.about_d = null;
                this.black_0 = -1;
                continue;
              } 
              continue;
            case 31:
              i = this.event[b][this.event_now[b] + 2] - 1;
              if (i == -1) {
                this.now_eV1 = this.event[b][this.event_now[b] + 3];
                this.my.dir = this.now_eV1;
                this.my.setActionNo(false);
              } else {
                this.now_eV1 = getNpcLayer(i);
                if (this.now_eV1 == 0) {
                  this.now_eV2 = getNpcId(i);
                  (this.npc[this.now_eV1][this.now_eV2]).dir = this.event[b][this.event_now[b] + 3];
                  this.npc[this.now_eV1][this.now_eV2].setActionNo(false);
                } 
              } 
              arrayOfShort1 = this.event_now;
              arrayOfShort1[b] = (short)(arrayOfShort1[b] + 4);
              nextEvent(4112);
              continue;
            case 44:
              break;
          } 
          int i = this.event[b][this.event_now[b] + 2];
          if (i == 0) {
            ifEvent(b, 3, 16, 2, this.gr.gameCheckRegIsOK());
            continue;
          } 
          if (i == 1) {
            if (!this.gr.gameCheckRegIsOK()) {
              arrayOfShort1 = this.event_now;
              arrayOfShort1[b] = (short)(arrayOfShort1[b] + 3);
              nextEvent(0);
              checkRegWhere0(b);
              continue;
            } 
            continue;
          } 
          if (i == 2) {
            ifEvent(b, 3, 16, 2, this.gr.gameCheckRegIsOK());
            continue;
          } 
          continue;
        } 
        break;
      } 
      continue;
    } 
  }
  
  public byte exitMap(byte[][] paramArrayOfbyte) {
    if (paramArrayOfbyte[this.get_meet][3] == -1) {
      null = this.mapNo;
      this.mapNo = this.lastMap;
      this.lastMap = null;
      this.lastExit = this.get_meet;
      return -1;
    } 
    null = this.mapNo;
    this.mapNo = paramArrayOfbyte[this.get_meet][4];
    this.lastMap = null;
    this.lastExit = this.get_meet;
    return paramArrayOfbyte[this.get_meet][3];
  }
  
  public byte getMySpeed() {
    return (this.anole_type == 0) ? 6 : ((this.anole_type == 1) ? 6 : ((this.anole_type == 2) ? 10 : ((this.anole_type == 4) ? 5 : ((this.anole_type == 3) ? 10 : 5))));
  }
  
  public void goMiniMap() {
    Ms.i().keyRelease();
    byte[] arrayOfByte = Ms.i().getStream("data/map.d", -1);
    Ms.skip = 0;
    this.mapdataArea = Ms.i().create2Array(arrayOfByte);
    this.mapdataMap = Ms.i().create2Array(arrayOfByte);
    arrayOfByte = (byte[])null;
    this.my.state = 17;
    this.showArea = -1;
    this.myMiniMap = -1;
    this.selectMap = 0;
    byte b = 0;
    label22: while (true) {
      if (b >= this.mapdataArea.length)
        continue; 
      for (byte b1 = 0;; b1 = (byte)(b1 + 1)) {
        if (b1 >= (this.mapdataArea[b]).length) {
          b = (byte)(b + 1);
          continue label22;
        } 
        if (this.mapNo == this.mapdataArea[b][b1]) {
          this.selectMap = this.mapNo;
          if ((this.mapdataMap[this.selectMap]).length > 0) {
            boolean bool;
            this.myMiniMap = this.selectMap;
            this.showArea = b;
            if (this.mapdataArea[this.showArea][0] > -1) {
              bool = true;
            } else {
              bool = false;
            } 
            this.miniMapMode = bool;
            return;
          } 
        } 
      } 
      break;
    } 
  }
  
  public void goMission(int paramInt, boolean paramBoolean) {
    if (this.my.state == 18 || this.my.state == 0) {
      Ms.i().keyRelease();
      this.bPause = paramBoolean;
      GameRun.run_state = -10;
      this.my.state = 18;
      this.gr.cur_a = (byte)paramInt;
      byte[] arrayOfByte = this.gr.select[0];
      this.gr.select[0][1] = 0;
      arrayOfByte[0] = 0;
      Ms.i();
      Ms.skip = 0;
      arrayOfByte = Ms.i().getStream("data/mission" + paramInt + ".t", -1);
      this.sMission = Ms.i().createString2Array(arrayOfByte);
      this.gr.line_max = 6;
      this.gr.about_a = null;
      if (paramInt == 1) {
        byte b = 0;
        paramInt = 0;
        arrayOfByte = new byte[50];
        while (true) {
          if (b >= this.sMission.length) {
            this.mDirect = null;
            this.mDirect = new byte[paramInt];
            System.arraycopy(arrayOfByte, 0, this.mDirect, 0, this.mDirect.length);
            if (this.mDirect.length > 0)
              this.gr.setStringB(this.sMission[this.mDirect[this.gr.select[0][0]]][1].toString(), 640 - 50, 0); 
            arrayOfByte = (byte[])null;
            return;
          } 
          int i = paramInt;
          if (isMission(b)) {
            i = (byte)(paramInt + 1);
            arrayOfByte[paramInt] = b;
          } 
          b = (byte)(b + 1);
          paramInt = i;
        } 
      } 
      this.gr.select[0][0] = this.bMission[14];
      if (this.bMission[14] >= this.gr.line_max) {
        this.gr.select[0][1] = (byte)(this.gr.select[0][0] - this.gr.line_max + 1);
      } else {
        this.gr.select[0][1] = 0;
      } 
      this.gr.setStringB(this.sMission[this.gr.select[0][0]][1].toString(), 640 - 50, 0);
    } 
  }
  
  public void goNextMap() {
    setfmap();
    this.firstDrawMap = 0;
    this.gr.doPaint(2);
    saveMapBak();
    byte b = this.lastExit;
    if (this.go != -2) {
      this.lastMap = this.mapNo;
      this.mapNo = this.mapNotemp;
      this.mapNotemp = 0;
      this.lastExit = this.go;
    } 
    this.gr.doPaint(5);
    if (this.go == -2)
      this.go = exitMap(this.door); 
    this.gr.setNull(false);
    this.gr.doPaint(8);
    createOther();
    this.gr.doPaint(10);
    if (this.go == -1)
      this.go = b; 
    if (!this.bExitBoss)
      getInMap(this.go, this.door); 
    createEvent();
    this.gr.doPaint(15);
    createNpcString();
    createLayer();
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
    setMapMusic(false);
    this.go = -2;
    this.gr.initMonPro(this.mapNo, true);
    this.gr.cityName_c = 25;
    this.srcNpcNo = -1;
    Ms.i().rmsOptions(1, null, 4);
    initCloud();
    this.bExitBoss = false;
    this.my.state = 9;
    if (this.boatSelect == -1) {
      this.my.state = 0;
      this.my.setIXY(-1, -1);
      this.my.speed = getMySpeed();
    } 
    this.checkNpcT = -1;
    this.pkey.stopMove();
  }
  
  public boolean initAnoleValue() {
    if (isAnole(this.my.x, this.my.y, this.anole_type)) {
      this.gr.say("不能更换坐骑", 0);
      return false;
    } 
    this.my.state = 20;
    this.gr.cur_a = 0;
    this.gr.cur_b = 0;
    this.gr.setStringB("下坐骑#n植物坐骑#n金属坐骑#n飞行坐骑#n野兽坐骑#n海洋坐骑#n无此坐骑", Constants_H.WIDTH, 0);
    return true;
  }
  
  public void initBrowImage() {
    if (this.brow == null)
      this.brow = Ms.i().createSprite("data/face/brow", true); 
  }
  
  public byte[] initData(byte[] paramArrayOfbyte, int paramInt) {
    byte b = 0;
    int i;
    for (i = 1;; i = j + 1 + ((i & 0xFF) << 8 | b1 & 0xFF)) {
      if (b >= paramInt) {
        paramInt = i + 1;
        byte[] arrayOfByte = new byte[(paramArrayOfbyte[i] & 0xFF) << 8 | paramArrayOfbyte[paramInt] & 0xFF];
        System.arraycopy(paramArrayOfbyte, paramInt + 1, arrayOfByte, 0, arrayOfByte.length);
        return arrayOfByte;
      } 
      int j = i + 1;
      i = paramArrayOfbyte[i];
      byte b1 = paramArrayOfbyte[j];
      b++;
    } 
  }
  
  public void initMap() {
    this.my.dir = 4;
    this.srcNpcNo = -1;
    this.gr.loadRmsSms();
    this.gr.loadRmsNidus();
    notMeet(0, 0);
    this.mapInfo = Ms.i().byteArrayToShortArray(Ms.i().rmsOptions(13, null, 1));
    this.mapChange = Ms.i().rmsOptions(1, null, 1);
    for (short s = 0;; s = (short)(s + 1)) {
      if (s >= this.mapChange.length) {
        System.gc();
        this.gr.createOver = 33;
        createOther();
        this.gr.createOver = 35;
        createLayer();
        this.gr.createOver = 37;
        createEvent();
        this.gr.createOver = 39;
        createNpcString();
        this.gr.createOver = 40;
        Ms.i().rmsOptions(1, null, 4);
        this.gr.initMonPro(this.mapNo, true);
        initMissionList();
        initCloud();
        return;
      } 
      if (this.mapChange[s] == 1)
        this.mapTemp[s] = Ms.i().rmsOptions(s + 14, null, 1); 
    } 
  }
  
  public void initNpcAni() {
    byte b = 0;
    byte[][] arrayOfByte = new byte[3][];
    arrayOfByte[0] = new byte[100];
    arrayOfByte[1] = new byte[5];
    arrayOfByte[2] = new byte[60];
    this.gr.initNidusMap(0);
    byte b1 = (byte)(this.npc.length - 1);
    label28: while (true) {
      if (b1 <= -1) {
        this.gr.initNidusMap(1);
        this.npcList[0] = -1;
        for (b = (byte)(this.item.length + (this.npc[0]).length);; b = (byte)(b - 1)) {
          if (b <= (this.npc[0]).length) {
            initNpcAni_1(100, 0, arrayOfByte[0]);
            initNpcAni_1(5, 1, arrayOfByte[1]);
            initNpcAni_1(60, 2, arrayOfByte[2]);
            byte[][] arrayOfByte1 = (byte[][])null;
            for (b = (byte)((this.npc[0]).length - 1);; b = (byte)(b - 1)) {
              if (b <= -1)
                return; 
              this.npc[0][b].setNpcNum(npcSp[(this.npc[0][b]).other[3] - 1][(this.npc[0][b]).other[2]].aLength());
            } 
            break;
          } 
          this.npcList[b] = (byte)(-2 - b + (this.npc[0]).length + 1);
        } 
        break;
      } 
      for (byte b2 = (byte)((this.npc[b1]).length - 1);; b2 = (byte)(b2 - 1)) {
        if (b2 <= -1) {
          b1 = (byte)(b1 - 1);
          continue label28;
        } 
        arrayOfByte[(this.npc[b1][b2]).other[3] - 1][(this.npc[b1][b2]).other[2]] = 1;
        if (b1 == 0) {
          this.npcList[b2 + 1] = b2;
          if ((this.npc[b1][b2]).other[8] == 1) {
            byte[] arrayOfByte1 = this.gr.nidusMap;
            byte b3 = (byte)(b + 1);
            arrayOfByte1[b] = b2;
            b = b3;
          } 
        } 
      } 
      break;
    } 
  }
  
  public void initNpcAniOne(String paramString, int paramInt1, int paramInt2) {
    boolean bool;
    Sprite[] arrayOfSprite = npcSp[paramInt2];
    Ms ms = Ms.i();
    String str = "data/npc" + paramInt2 + "/" + paramString;
    if (paramInt2 == 2) {
      bool = this.gr.isNpc2ImageType(Integer.parseInt(paramString));
    } else {
      bool = true;
    } 
    arrayOfSprite[paramInt1] = ms.createSprite(str, bool);
  }
  
  public void initNpcFaceOne(String paramString) {
    if (paramString != null) {
      byte b = -1;
      this.faceDir = true;
      if (paramString.equals("塞其")) {
        b = 0;
        this.faceDir = false;
      } else if (paramString.equals("安琪儿") || paramString.equals("蓝发女孩")) {
        b = 1;
      } else if (paramString.equals("幽暗鬼王")) {
        b = 2;
      } else if (paramString.equals("杰奇校长")) {
        b = 3;
      } else if (paramString.equals("普罗") || paramString.equals("普罗校长")) {
        b = 4;
      } else if (paramString.equals("神秘东方男子")) {
        b = 5;
      } else if (paramString.equals("南宫云")) {
        b = 6;
      } 
      if (b > -1) {
        if (this.imgFace == null || this.faceLast != b) {
          byte b1;
          if (this.faceDir) {
            b1 = 50;
          } else {
            b1 = -50;
          } 
          this.face_c = (short)b1;
          this.faceLast = b;
          this.imgFace = null;
          this.imgFace = Ms.i().createImage("data/face/" + b);
        } 
        return;
      } 
      nullNpcFace();
    } 
  }
  
  public boolean initSrcEffect(int paramInt) {
    int i = Constants_H.SRC_BATTLE_H__;
    this.my.state = 10;
    switch (paramInt) {
      default:
        return false;
      case 0:
      case 1:
      case 2:
        this.bSrc_c = 0;
        if (paramInt != 1)
          i = 0; 
        this.black_width = (short)i;
        if (paramInt == 1) {
          null = true;
        } else {
          null = false;
        } 
        this.bSrc = null;
        return true;
      case 3:
      case 4:
      case 5:
      case 6:
        break;
    } 
    this.bSrc = true;
    if (this.bSrc_c == 0)
      if (paramInt == 6 || paramInt == 5) {
        this.bSrc_c = -40;
        if (paramInt == 5) {
          i = 40;
        } else {
          i = 0;
        } 
        this.black_width = (short)i;
      } else {
        if (paramInt != 4)
          i = 40; 
        short s = (short)i;
        this.bSrc_c = s;
        this.black_width = s;
      }  
    this.bSrc_c = Ms.i().mathSpeedN(this.bSrc_c, 0, 12, false);
    if (this.bSrc_c == 0) {
      if (paramInt != 6) {
        null = true;
      } else {
        null = false;
      } 
      this.bSrc = null;
      return true;
    } 
  }
  
  public void initWalkIco() {
    if (this.walkIco == null)
      this.walkIco = Ms.i().createImageArray(3, "data/brow/w"); 
  }
  
  public void insertNpc() {
    if (this.npc != null) {
      byte b = 1;
      label19: while (true) {
        if (b < this.npcList.length) {
          byte b1 = b;
          while (true) {
            if (b1 > 0) {
              short s2 = getNpcListY(b1);
              short s1 = getNpcListY(b1 - 1);
              if (s2 <= s1) {
                if (s2 != s1 || (s2 == s1 && this.npcList[b1 - 1] == -1)) {
                  byte b2 = this.npcList[b1];
                  this.npcList[b1] = this.npcList[b1 - 1];
                  this.npcList[b1 - 1] = b2;
                } 
                b1 = (byte)(b1 - 1);
                continue;
              } 
            } 
            b = (byte)(b + 1);
            continue label19;
          } 
          break;
        } 
        return;
      } 
    } 
  }
  
  public void key_map() {
    if (this.my.state == 17) {
      keyMiniMap();
      return;
    } 
    if (this.my.state == 18) {
      keyMission();
      return;
    } 
    if (this.my.state == 12) {
      keySelectMenu();
      return;
    } 
    if (this.my.state == 19) {
      keyMySave();
      return;
    } 
    if (this.my.state == 22 && this.black_0 > -1 && this.black_0 == this.gr.about_d.length && Ms.i().key_Num0()) {
      this.eventGoing = 3;
      this.black_0 = -1;
      Ms.i().keyRelease();
      return;
    } 
    if (this.my.state == 16) {
      if (!Ms.i().key_delay()) {
        if (Ms.i().key_Up_Down()) {
          GameRun gameRun = this.gr;
          gameRun.popMenu = (byte)(gameRun.popMenu ^ 0x1);
        } else if (Ms.i().key_S1_Num5() || Ms.i().key_S2()) {
          if (Ms.i().key_S2())
            this.gr.popMenu = 1; 
          this.my.state = 0;
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
          this.my.state = 25;
        } else if (Ms.i().key_S1_Num5()) {
          this.my.state = 24;
        } 
        Ms.i().keyRelease();
        return;
      } 
      if (this.my.state == 11) {
        if (Ms.i().key_S1_Num5())
          this.gr.say_c = 0; 
        if (this.gr.say_c == 0)
          this.my.state = 0; 
        return;
      } 
      if (this.my.state == 20) {
        keyAnoleSel();
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
          (this.npc[0][this.get_meet]).other[7] = this.npcDirTalk;
          if ((this.npc[0][this.get_meet]).other[7] > -1)
            (this.npc[0][this.get_meet]).dir = 3; 
          this.bDirTalk = false;
        } 
        return;
      } 
      this.dialog_no = (byte)(this.dialog_no + 2);
      Ms.i().keyRelease();
    } 
    if (this.my.frame_c <= 0 && this.my.state == 0) {
      Ms.i();
      this.map_key = (byte)-Ms.key;
      doKey();
    } 
  }
  
  public void loadDate_Rms() {
    byte[] arrayOfByte = Ms.i().rmsOptions(2, null, 1);
    if (arrayOfByte[0] == -1) {
      byte[] arrayOfByte1 = new byte[16];
      arrayOfByte1[0] = 58;
      arrayOfByte1[1] = 9;
      arrayOfByte1[2] = 16;
      arrayOfByte1[3] = 2;
      arrayOfByte1[5] = 1;
      arrayOfByte1[6] = 2;
      arrayOfByte1[15] = -1;
      arrayOfByte = arrayOfByte1;
      Ms.i().rmsOptions(2, arrayOfByte1, 2);
      arrayOfByte1 = (byte[])null;
      this.event_now_list = new short[70][];
      Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
    } else {
      this.event_now_list = Ms.i().readEventNowData();
    } 
    this.mapNo = arrayOfByte[0];
    this.lastMap = arrayOfByte[5];
    this.lastExit = arrayOfByte[6];
    this.my.setXY(arrayOfByte[1], arrayOfByte[2], 0, 0);
    this.my.dir = arrayOfByte[3];
    this.my.setActionNo(false);
    this.gr.money = Ms.i().getInt(arrayOfByte, 7);
    this.gr.coin = Ms.i().getInt(arrayOfByte, 11);
    this.anole_type = arrayOfByte[15];
    arrayOfByte = (byte[])null;
  }
  
  public void mapMove(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if ((paramInt3 > 0 && paramInt1 >= this.mapLeft_NOmove && paramInt1 < this.mapRight_NOmove) || (paramInt3 < 0 && paramInt1 > this.mapLeft_NOmove && paramInt1 <= this.mapRight_NOmove))
      this.map_x -= paramInt3; 
    if ((paramInt4 > 0 && paramInt2 >= this.mapUp_NOmove && paramInt2 < this.mapDown_NOmove) || (paramInt4 < 0 && paramInt2 > this.mapUp_NOmove && paramInt2 <= this.mapDown_NOmove))
      this.map_y -= paramInt4; 
  }
  
  public void map_saveGame() {
    byte[] arrayOfByte = new byte[16];
    arrayOfByte[0] = this.mapNo;
    arrayOfByte[5] = this.lastMap;
    arrayOfByte[6] = this.lastExit;
    arrayOfByte[1] = (byte)(this.my.x / 20);
    arrayOfByte[2] = (byte)(this.my.y / 20);
    arrayOfByte[3] = this.my.dir;
    Ms.i().putInt(this.gr.money, arrayOfByte, 7);
    Ms.i().putInt(this.gr.coin, arrayOfByte, 11);
    arrayOfByte[15] = this.anole_type;
    Ms.i().rmsOptions(2, arrayOfByte, 2);
    arrayOfByte = (byte[])null;
  }
  
  public void notMeet(int paramInt1, int paramInt2) {
    if (paramInt1 == 0) {
      this.notMeet = 0;
      Ms.i();
      this.step_MEET = (short)(Ms.getRandom(30) + 1);
      this.meet_step = (short)((this.step_MEET - 15) * (this.step_MEET - 15));
      paramInt1 = this.meet_step;
      Ms.i();
      if (paramInt1 > Ms.getRandom(50)) {
        Ms.i();
        paramInt1 = Ms.getRandom(9);
        Ms.i();
        this.step_MEET = (byte)(paramInt1 + 17 - Ms.getRandom(7));
      } 
      this.step_MEET = (short)(this.step_MEET << 2);
      this.meet_step = 0;
      this.bStep = -1;
      return;
    } 
    if (paramInt1 == 1) {
      this.notMeet = 1;
      this.step_MEET = (short)((paramInt2 - 14 + 1) * 200);
      this.step_MEET = (short)(this.step_MEET << 2);
      this.meet_step = 0;
      this.bStep = 100;
    } 
  }
  
  public void nullNpcFace() {
    this.imgFace = null;
  }
  
  public void paint_map(Graphics paramGraphics) {
    g = paramGraphics;
    if (this.my.state == 6) {
      this.gr.drawChangeMap(false, this.gr.b_c, 30, 360 - 38, 640 - 60);
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
      this.xxx = (byte)(this.xxx - 1);
      paramGraphics.translate(this.xxx % 2, this.xxx % 2);
    } 
    drawMap(GameRun.offG);
    drawNpcAni(this.npc[2]);
    if (this.pkey.isGo) {
      int i = this.ii;
      this.ii = i + 1;
      if (i > 2) {
        this.ii = 0;
        i = this.i;
        this.i = i + 1;
        if (i < 2) {
          i = this.i;
        } else {
          i = 0;
        } 
        this.i = i;
      } 
      Ui.i().drawImage(this.walkIco[this.i], this.pkey.gox + this.map_x, this.pkey.goy + this.map_y, 3);
    } 
    drawNMAni(this.npc[0]);
    bkgroundToPaint(this.frontData, this.mapImg, -this.map_x, -this.map_y - 1, this.moduleData, paramGraphics, 0, 0, Constants_H.WIDTH, Constants_H.HEIGHT, false);
    drawNpcAni(this.npc[1]);
    drawMapRect(paramGraphics);
    drawStep(paramGraphics, Constants_H.WIDTH - 17, 0, 16);
    drawBrow();
    drawCheck5(4);
    drawCloud();
    if (this.gr.magic_id > -1) {
      int i;
      int j;
      int k;
      GameRun gameRun = this.gr;
      if (this.gr.magic_id / 5 > 5) {
        i = 5;
      } else {
        i = this.gr.magic_id / 5;
      } 
      if (this.gr.magic_id / 5 > 5) {
        j = 5;
      } else {
        j = this.gr.magic_id / 5;
      } 
      if (this.gr.magic_id / 5 >= 5) {
        k = this.gr.magic_id - 25;
      } else {
        k = this.gr.magic_id % 5;
      } 
      if (gameRun.drawMagicC(i, j, k, this.gr.magic_x, this.gr.magic_y + 16, 0)) {
        if (this.my.state == 21) {
          this.gr.magic_id = -2;
          setAnole();
        } else {
          this.gr.magic_id = -1;
        } 
        this.my.state = 0;
      } 
    } 
    paramGraphics.translate(-paramGraphics.getTranslateX(), -paramGraphics.getTranslateY());
    if (this.my.state == 20)
      drawAnoleSel(); 
    paramGraphics.restCanvas();
    if (!this.fontSizeControl) {
      Ms.i();
      Ms.font.setSize(22);
    } 
    drawSrcEffect();
    if (this.my.state == 12) {
      int i = Constants_H.WIDTH__ / 2;
      this.gr.drawSelectMenu_((Object[])this.gr.action_str, i - 25 * 3, Constants_H.HEIGHT__ / 2 - 100 + (this.gr.action_str.length >> 1) * 25, 25 * 6, 0, 0, this.gr.cur_a);
    } 
    if (this.gr.view_state == 4) {
      int k = Constants_H.WIDTH__;
      int j = Constants_H.HEIGHT__;
      int i = Constants_H.WIDTH__ / 2;
      Ui.i().drawKuang(0, j - 25 * 3, k, 25 * 3);
      GameRun gameRun1 = this.gr;
      GameRun gameRun2 = this.gr;
      k = this.gr.cur_a;
      (new byte[3])[0] = 4;
      (new byte[3])[1] = 25;
      (new byte[3])[2] = 56;
      gameRun1.showStringM_(gameRun2.getNameMonsterInfo((new byte[3])[k]), i, j - 25 * 2 - 8, 10, 3);
      byte[] arrayOfByte = (byte[])null;
    } else if (this.my.state == 16) {
      int j = Constants_H.WIDTH__;
      int k = Constants_H.HEIGHT__;
      int i = Constants_H.WIDTH__ / 2;
      int m = Constants_H.HEIGHT__ / 2;
      Ui.i().drawKuang(0, k - 25 * 4, j, 25 * 4);
      this.gr.showStringM_("是否回复所有宠物？", i, k - 25 * 4 + 4, 10, 3);
      this.gr.drawSelectMenu_((Object[])this.gr.action_str, i - 25 * 2, m - 25, 25 * 4, -1, 0, this.gr.popMenu);
      this.gr.showStringM_("所需金额：" + this.gr.sell_money, i, k - 25 * 3 + 4, 10, 3);
      this.gr.drawMoney(i, k - 25 + 15, 3, false);
    } 
    if (this.my.state != 20)
      this.gr.drawPauseIco(this.my.state); 
    if (this.my.state == 19) {
      drawMySave();
      return;
    } 
    byte b = this.gr.rmsOther[2];
    this.gr.drawCityName();
    if (this.my.state == 23) {
      int i = Constants_H.WIDTH__;
      int k = Constants_H.HEIGHT__;
      int j = Constants_H.WIDTH__ / 2;
      Ui.i().drawKuang(0, k - 25 * 2, i, 25 * 2);
      Ui.i().drawString("是否保存进度？", j, k - 25 * 2 + 6, 17, 3, 0);
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
  
  public void run_map() {
    if (this.my.state != 9 && this.my.state != 6)
      eventCheck(); 
    if (this.my.state == 5 && this.my.frame_c < 1) {
      setMoveStop_m();
      this.my.state = 6;
    } 
    if (this.my.state == 6) {
      this.gr.createOver = 1;
      goNextMap();
      return;
    } 
    if (this.my.state == 2 && this.eventGoing == 0) {
      if (((this.npc[0][this.get_meet]).other[4] == 1 || (this.npc[0][this.get_meet]).other[4] == 3) && (this.npc[0][this.get_meet]).other[5] > 0) {
        this.npcName = this.npcNameData[this.get_meet];
        if (this.npcName.equals("路人"))
          this.npcName = null; 
        initNpcFaceOne(this.npcName);
        Ms.i();
        Ms.font.setSize(22);
        this.dialog = Ms.i().groupString(this.npcStringData[(this.npc[0][this.get_meet]).other[5] - 1], Constants_H.WIDTH__ - 20);
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
        GameRun gameRun = this.gr;
        String[] arrayOfString = this.gr.battleSay;
        Ms.i();
        gameRun.say(arrayOfString[Ms.getRandom(3)], 0);
        GameRun.mc.repaint();
        this.gr.battleType(4);
        this.gr.goBattlePVC();
      } else {
        this.my.state = 0;
      } 
    } 
    runMove();
  }
  
  public void save() {
    map_saveGame();
    saveNpc();
    for (byte b = 0;; b++) {
      if (b >= this.mapInfo.length / 2) {
        Ms.i().rmsOptions(13, Ms.i().shortArrayToByteArray(this.mapInfo), 2);
        Ms.i().rmsOptions(12, Ms.i().getEventNowData(this.event_now_list), 2);
        Ms.i().rmsOptions(1, this.mapChange, 2);
        Ms.i().rmsOptions(7, this.bMission, 2);
        Ms.i().rmsOptions(5, this.gr.rmsSms, 2);
        Ms.i().rmsOptions(1, null, 4);
        return;
      } 
      if (this.mapChange[b] == 1) {
        this.mapChange[b] = 0;
        Ms.i().rmsOptions(b + 14, this.mapTemp[b], 2);
      } 
    } 
  }
  
  public void saveMapBak() {
    saveNpc();
    this.mapChange[this.mapNo] = 1;
    Ms.i().rmsOptions(1, this.mapChange, 2);
  }
  
  public void saveNpc() {
    this.mapTemp[this.mapNo] = null;
    this.mapTemp[this.mapNo] = getNpcData();
    this.mapInfo[this.mapNo * 2] = 1;
    this.mapChange[this.mapNo] = 1;
  }
  
  public void setAnole() {
    boolean bool1;
    boolean bool2;
    GameRun gameRun = this.gr;
    if (this.anole_type == 3) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    gameRun.immueEnemy = (byte)bool1;
    this.my.speed = getMySpeed();
    Ms ms = Ms.i();
    Sprite sprite = npcSp[1][0];
    StringBuilder stringBuilder = new StringBuilder("data/npc1/");
    if (this.anole_type == -1) {
      str = "0";
    } else {
      str = "r" + this.anole_type;
    } 
    String str = stringBuilder.append(str).toString();
    if (this.anole_type == -1) {
      bool2 = true;
    } else {
      bool2 = false;
    } 
    ms.setSprite(sprite, str, bool2);
    this.my.setActionNo(false);
  }
  
  public void setMapMusic(boolean paramBoolean) {
    Sound.i().setMusicId(this.gr.musicNo[this.mapNo]);
    Sound.i().setMusic(paramBoolean);
  }
  
  public void setMission(int paramInt, boolean paramBoolean) {
    byte b = (byte)(paramInt / 8);
    paramInt = (byte)(paramInt % 8);
    if (paramBoolean) {
      byte[] arrayOfByte = this.bMission;
      arrayOfByte[b] = (byte)(arrayOfByte[b] | 1 << paramInt);
      return;
    } 
    if ((this.bMission[b] & 1 << paramInt) != 0) {
      byte[] arrayOfByte = this.bMission;
      arrayOfByte[b] = (byte)(arrayOfByte[b] ^ 1 << paramInt);
      arrayOfByte = this.bMission;
      arrayOfByte[15] = (byte)(arrayOfByte[15] + 1);
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
  
  public void setOverEvent(int paramInt1, int paramInt2) {
    if (!isMapEvent(paramInt1, paramInt2)) {
      short[] arrayOfShort = this.mapInfo;
      int i = paramInt1 * 2 + 1;
      arrayOfShort[i] = (short)(arrayOfShort[i] | 1 << paramInt2);
    } 
    if (paramInt1 == this.mapNo) {
      this.event_now[paramInt2] = 24224;
      return;
    } 
    if (this.event_now_list[paramInt1] != null)
      this.event_now_list[paramInt1][paramInt2] = 24224; 
  }
  
  public void setRegState(boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   5: astore_3
    //   6: new java/lang/StringBuilder
    //   9: astore_2
    //   10: aload_2
    //   11: ldc_w 'setRegState() notifyAll start isSuccess= '
    //   14: invokespecial <init> : (Ljava/lang/String;)V
    //   17: aload_3
    //   18: aload_2
    //   19: iload_1
    //   20: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   23: invokevirtual toString : ()Ljava/lang/String;
    //   26: invokevirtual println : (Ljava/lang/String;)V
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield isNeedWait : Z
    //   34: aload_0
    //   35: invokevirtual notifyAll : ()V
    //   38: getstatic java/lang/System.out : Ljava/io/PrintStream;
    //   41: ldc_w 'setRegState() notifyAll over'
    //   44: invokevirtual println : (Ljava/lang/String;)V
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_2
    //   54: athrow
    // Exception table:
    //   from	to	target	type
    //   2	47	50	finally
  }
  
  public void setRestEvent(int paramInt1, int paramInt2) {
    if (isMapEvent(paramInt1, paramInt2)) {
      short[] arrayOfShort = this.mapInfo;
      int i = paramInt1 * 2 + 1;
      arrayOfShort[i] = (short)(arrayOfShort[i] ^ 1 << paramInt2);
    } 
    if (paramInt1 == this.mapNo) {
      this.event_now[paramInt2] = 0;
      return;
    } 
    if (this.event_now_list[paramInt1] != null)
      this.event_now_list[paramInt1][paramInt2] = 0; 
  }
  
  public void setTempNull() {
    this.mapTemp = null;
    this.mapTemp = new byte[70][];
  }
  
  public void setfmap() {
    this.fmap = 0;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */