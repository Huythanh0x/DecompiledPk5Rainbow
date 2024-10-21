package main;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import dm.Ms;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class MainCanvas extends FullCanvas implements Runnable {
  private static DirectGraphics dg;
  
  private static Graphics g;
  
  public static float mainxx;
  
  public static float mainyy;
  
  public static float mapxx;
  
  public static float mapyy;
  
  byte battle_c = 9;
  
  boolean bblack = false;
  
  public boolean createStop;
  
  StringBuffer[] dialog;
  
  int error;
  
  String errorString = "";
  
  private byte fisrt_paint;
  
  private Sprite flashSP;
  
  XConnection game;
  
  public int game_state;
  
  GameRun gr;
  
  private boolean haveSoundBeforeHideNotify = false;
  
  private byte help_state;
  
  byte iii;
  
  int[] imageData = null;
  
  Image image_logo;
  
  Image image_logo_word;
  
  int load_c = -1;
  
  int logo_c = 0;
  
  int loop_s;
  
  private byte ma;
  
  public int menu_state;
  
  private byte mt;
  
  PointerKey pkey;
  
  public int prevGameState;
  
  public int prevMenuState;
  
  public int prevRunState;
  
  boolean quitGame = false;
  
  public SMSSender sender;
  
  private boolean smsIsSetRun_state = false;
  
  long starttime = 0L;
  
  String strTemp = "";
  
  int temp_gamestate = 0;
  
  int temp_loop = 0;
  
  public int temp_state = 0;
  
  long timetaken = 0L;
  
  public MainCanvas(XConnection paramXConnection) {
    this.game = paramXConnection;
    this.gr = new GameRun(this);
    this.sender = SMSSender.i(this.gr);
    this.pkey = new PointerKey(this);
    this.gr.map.pkey = this.pkey;
    this.gr.pkey = this.pkey;
    this.sender.pkey = this.pkey;
    mainxx = Constants_H.WIDTH__ / 640.0F;
    mapxx = Constants_H.WIDTH__ / Constants_H.WIDTH;
    mainyy = Constants_H.HEIGHT__ / 360.0F;
    mapyy = Constants_H.HEIGHT__ / Constants_H.HEIGHT;
  }
  
  private final void game_init() {
    this.gr.initOffG();
  }
  
  private void goQuit() {
    this.game_state = 101;
  }
  
  private final void keyProcess() {
    this.error = 3;
    switch (this.game_state) {
      default:
        return;
      case 98:
        if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
          System.out.println("按键处理这里执行吗");
          doShowNotify();
        } 
        Ms.i().keyRelease();
      case 10:
        if (Ms.i().key_S1() || Ms.i().key_S2()) {
          boolean bool;
          this.logo_c = 0;
          Sound.i().setSoundON(Ms.i().key_S1());
          Sound sound = Sound.i();
          if (Ms.i().key_S1()) {
            bool = true;
          } else {
            bool = false;
          } 
          sound.setVolume(bool);
          Ms.i().keyRelease();
          this.gr.goMAIN_MENU();
        } 
        Ms.i().keyRelease();
      case 30:
        this.gr.key_gameRun();
      case 11:
        if (Ms.i().key_S1_Num5()) {
          Ms.i().keyRelease();
          this.gr.goMAIN_MENU();
        } 
      case 101:
        this.quitGame = true;
        Ms.i().keyRelease();
      case 40:
        break;
    } 
    switch (this.menu_state) {
      default:
      
      case 0:
        Ms.i().keyRelease();
        if (Ms.i().key_Num0()) {
          this.ma = 0;
          this.mt = 0;
          this.load_c = 1;
        } else if (this.load_c == 0) {
        
        } 
        if (Ms.i().key_S1_Num5()) {
          switch (this.gr.selectx) {
            default:
            
            case 0:
              this.gr.skyCheckRegFull(2);
            case 1:
              this.gr.skyCheckRegFull(1);
            case 2:
              Sound.i().keyVolume(0);
              Sound.i().setMusicForMenu(true);
            case 3:
              goHELP_dialog(0);
            case 4:
              Log.e("soars", "ABOUT_BUTTON");
              goABOUT();
            case 5:
              break;
          } 
          Log.e("soars", "EXIT_BUTTON");
          this.quitGame = true;
          this.game.destroyApp(true);
        } 
        if (Ms.i().key_Left_Right()) {
          boolean bool;
          GameRun gameRun = this.gr;
          Ms ms = Ms.i();
          byte b = this.gr.selectx;
          if (this.gr.rmsOther[0] == -1) {
            bool = true;
          } else {
            bool = false;
          } 
          gameRun.selectx = ms.select(b, bool, this.gr.action_str.length - 1);
        } 
      case 2:
        if (Ms.i().key_S1_Num5()) {
          newGame();
        } else if (Ms.i().key_S2()) {
          this.menu_state = 0;
          this.gr.about_a = null;
        } 
        Ms.i().keyRelease();
      case 4:
        if (Ms.i().key_S2()) {
          this.gr.about_a = null;
          if (this.help_state == 1) {
            this.game_state = 30;
            this.gr.doPaint(0);
            this.gr.goYouPAUSE(2);
            this.gr.selectx = 1;
            this.gr.selecty = 2;
            this.gr.setPauseS(this.gr.selectx);
          } else {
            goMain_menu();
            this.gr.select[0][0] = 3;
          } 
        } else if (Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
          this.gr.help_page = Ms.i().select(this.gr.help_page, 0, this.gr.page_max - 1);
        } 
        Ms.i().keyRelease();
      case 5:
        break;
    } 
    if (Ms.i().key_S2()) {
      Ms.i().keyRelease();
      this.gr.about_a = null;
      Log.e("soars", "gr.about_a dfd");
      goMain_menu();
    } else if (Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
      this.gr.help_page = Ms.i().select(this.gr.help_page, 0, this.gr.page_max - 1);
    } 
    Log.e("soars", "s.i().key_Up_Down()||Ms.i().key");
    Ms.i().keyRelease();
  }
  
  private void newGame() {
    this.gr.data_init();
    Log.e("test", "new game " + Ms.i().rmsOptions(0, null, 5));
    if (Ms.i().rmsOptions(0, null, 5) == null) {
      this.gr.map.firstDrawMap = 0;
      Ms.i().rmsOptions(0, null, 3);
      this.gr.initRmsOther();
      Ms.i().rmsOptions(10, this.gr.rmsOther, 2);
      goGameLoading();
      this.gr.map.initSrcEffect(1);
    } else {
      this.gr.say("存储空间不足！", 0);
    } 
    this.gr.about_a = null;
  }
  
  private void setMenuFrame_C() {
    byte b = (byte)(this.mt + 1);
    this.mt = b;
    if (b > this.flashSP.action(this.load_c, this.ma, 1)) {
      this.mt = 0;
      b = (byte)(this.ma + 1);
      this.ma = b;
      if (b >= this.flashSP.aLength(this.load_c)) {
        this.ma = 0;
        if (this.load_c == 0)
          this.load_c = 1; 
      } 
    } 
  }
  
  public boolean checkHaveSoundBeforeHideNotify() {
    System.out.println("checkHaveSoundBeforeHideNotify haveSoundBeforeHideNotify= " + this.haveSoundBeforeHideNotify);
    return this.haveSoundBeforeHideNotify;
  }
  
  public boolean checkSmsRun_stateIsTrue() {
    System.out.println("checkSmsRun_stateIsTrue smsIsSetRun_state= " + this.smsIsSetRun_state);
    return this.smsIsSetRun_state;
  }
  
  void createFlashImage() {
    if (this.flashSP == null)
      this.flashSP = Ms.i().createSprite("data/fm", false); 
    this.mt = 0;
    this.ma = 0;
    this.load_c = 0;
  }
  
  public void doShowNotify() {
    this.game_state = this.temp_gamestate;
    if (!checkSmsRun_stateIsTrue()) {
      System.out.println("在这？");
      GameRun.run_state = this.temp_state;
    } else {
      setSmsIsSetRun_state(false);
      if (GameRun.run_state == 98) {
        System.out.println("在这？？");
        GameRun.run_state = this.temp_state;
      } 
    } 
    if (checkHaveSoundBeforeHideNotify()) {
      Sound.i().setMusic(true);
      Sound.i().setSoundON(true);
      Sound.i().soundPlay();
      Sound.i().soundStart();
    } 
  }
  
  public void drawRectBG() {
    Ui.i().fillRectB();
    int[] arrayOfInt1 = new int[4];
    arrayOfInt1[1] = 10;
    arrayOfInt1[2] = 20;
    arrayOfInt1[3] = 10;
    int[] arrayOfInt2 = new int[4];
    arrayOfInt2[0] = 10;
    arrayOfInt2[2] = 10;
    arrayOfInt2[3] = 20;
    byte b = 0;
    label13: while (true) {
      if (b >= 360 / 20 + 1) {
        arrayOfInt1 = (int[])null;
        arrayOfInt1 = (int[])null;
        return;
      } 
      for (byte b1 = 0;; b1 = (byte)(b1 + 1)) {
        if (b1 >= 640 / 20 + 1) {
          b = (byte)(b + 1);
          continue label13;
        } 
        g.translate(b1 * 20, b * 20);
        dg.fillPolygon(arrayOfInt1, 0, arrayOfInt2, 0, 4, -11548673);
        g.translate(b1 * -20, b * -20);
      } 
      break;
    } 
  }
  
  public final void game_start() {
    (new Thread(this)).start();
  }
  
  public final void game_stop() {
    Ms.i().rmsOptions(0, null, 4);
    Sound.i().soundStop();
  }
  
  void goABOUT() {
    Log.e("soars", "goAbout");
    this.game_state = 40;
    this.menu_state = 5;
    this.gr.help_page = 0;
    this.logo_c = 0;
    this.gr.line_max = 11;
    this.help_state = 0;
    this.gr.setStringB("宠物王国5-彩虹#n开发商：华娱无线#n客服电话：#n010-88901665#n客服Email:#ngeekan@imy.cn", Constants_H.WIDTH - 50, 0);
  }
  
  public void goGameLoading() {
    Log.e("loading", "游戏状态：GAME_LOADING");
    this.game_state = 20;
    this.gr.time_count = 0;
    this.flashSP = null;
    this.gr.map.loadDate_Rms();
    this.gr.loadRmsOther();
    this.gr.map.anole_temp = this.gr.map.anole_type;
    Map map = this.gr.map;
    Ms.i();
    map.anole_type = (byte)Ms.getRandom(5);
    this.gr.map.setAnole();
    paint();
    new CreateThread(this.gr, 0);
  }
  
  void goHELP_dialog(int paramInt) {
    this.game_state = 40;
    this.menu_state = 4;
    this.gr.help_page = 0;
    this.logo_c = 0;
    this.help_state = (byte)paramInt;
    this.gr.line_max = 11;
    this.gr.setStringB("游戏帮助#n玩家扮演一名宠物训练师，为了解决国家的危机而踏上了冒险之旅。#n操作提示#n点击主线任务图标：主线任务#n点击支线任务图标：支线任务#n点击地图图标：游戏地图#n点击屏幕控制上下左右移动#n本版本只支持横屏游戏", Constants_H.WIDTH - 50, 0);
  }
  
  void goMain_menu() {
    Sound.i().setMusicId(7);
    Sound.i().setMusic(false);
    this.game_state = 40;
    this.menu_state = 0;
    this.fisrt_paint = 0;
  }
  
  public void hideNotify() {
    hideNotifyMy();
  }
  
  public void hideNotifyMy() {
    System.out.println("hideNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
    Ms.keyRepeat = false;
    if (this.game_state != 98 && GameRun.run_state != 98) {
      this.haveSoundBeforeHideNotify = Sound.i().getHaveSoundPlayState();
      Sound.i().soundStop();
      if (this.game_state != 98)
        this.temp_gamestate = this.game_state; 
      if (GameRun.run_state != 98)
        this.temp_state = GameRun.run_state; 
      GameRun.run_state = 98;
      this.game_state = 98;
    } 
  }
  
  public void initGraphics(Graphics paramGraphics) {
    g = paramGraphics;
    dg = DirectUtils.getDirectGraphics(paramGraphics);
    this.gr.initGraphics(g);
    Ui.i().initGraphics(g);
  }
  
  protected final void keyPressed(int paramInt) {
    if (SMSSender.isWorking) {
      System.out.println("");
      return;
    } 
    Ms.keyRepeat = true;
    Ms.key = paramInt;
  }
  
  protected final void keyReleased(int paramInt) {
    Ms.i().keyRelease();
  }
  
  public void paint() {
    repaint();
    serviceRepaints();
  }
  
  protected void paint(Graphics paramGraphics) {
    if (this.game_state != 0)
      setScale(mainxx, mainyy); 
    this.keyxx = mainxx;
    this.keyyy = mainyy;
    initGraphics(paramGraphics);
    Ms.i();
    paramGraphics.setFont(Ms.font);
    paramGraphics.setClip(0, 0, 640, 360);
    switch (this.game_state) {
      default:
        return;
      case 98:
        drawRectBG();
        Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
        this.gr.showStringM("游戏暂停，点击屏幕返回。", 320, 360 - 50 - 2, 9, 3);
      case 30:
        this.gr.paint_gameRun(paramGraphics);
      case 0:
        paintMobileLogo();
      case 10:
        Ui.i().fillRect(0, 0, 0, 640, 360);
        Ui.i().drawString("是否打开音乐?", 320, 180 - 25, 0x1 | 0x10, 0, 0);
        Ui.i().drawString("（关闭声音游戏更流畅）", 320, 180, 0x1 | 0x10, 5, 0);
        Ui.i().drawString("是", 4, 360, 0x4 | 0x20, 0, 0);
        Ui.i().drawString("否", 640 - 4, 360, 0x8 | 0x20, 0, 0);
      case 20:
        this.gr.drawChangeMap(true, this.gr.time_count, 30, 360 - 38, 640 - 60);
      case 11:
        Ui.i().drawImage(this.image_logo, 0, 0, 0);
      case 40:
        break;
    } 
    switch (this.menu_state) {
      default:
      
      case 0:
        Ui.i().fillRect(0, 0, 0, 640, 360);
        Ui.i().drawFrameOne(this.flashSP, this.flashSP.action(this.load_c, this.ma, 0), 320, 180, 0);
        setMenuFrame_C();
        if (this.load_c == 1) {
          paramGraphics.setClip(0, 0, 640, 360);
          Ui.i().drawK0(320 - 125 - 5, 360 - 25 - 6, 260, 31, 0);
          if (this.gr.selectx == 2)
            Ui.i().drawVolume(320 + 6 + 70, 360 - 19, Sound.i().getVolume(), true); 
          Ui.i().drawString(this.gr.action_str[this.gr.selectx], 320, 360 + 6, 0x1 | 0x20, 3, 1);
          Ui.i().drawTriangle1(320, 360 - 13, 125, true, true);
          Ui.i().drawYesNo(true, false);
        } 
        Ui.i().drawString("点击屏幕跳过", 320, 360, 0x1 | 0x20, 1, 2);
      case 2:
        Ui.i().drawKuang(0, 360 - 87, 640, 58);
        this.gr.showStringM(this.gr.gogoString, 320, 360 - 87 + 2, 10, 3);
        Ui.i().drawYesNo(true, true);
      case 4:
        Ui.i().drawK0(0, 0, 640, 360, 2);
        this.gr.drawHelpStr(paramGraphics, this.gr.about_a, this.gr.line_max, 320, 10, 0x1 | 0x10);
        Ui.i().drawYesNo(false, true);
      case 5:
        break;
    } 
    Ui.i().drawK0(0, 0, 640, 360, 2);
    this.gr.setStringB("宠物王国5-彩虹#n开发商：#n华娱无线#n客服电话：#n010-88901665#n客服Email:#ngeekan@imy.cn", 640 - 50, 0);
    this.gr.drawHelpStr(paramGraphics, this.gr.about_a, this.gr.line_max, 320, 10, 0x1 | 0x10);
    Ui.i().drawYesNo(false, true);
  }
  
  protected void paintMobileLogo() {
    int k = Constants_H.WIDTH__;
    int j = Constants_H.HEIGHT__;
    int i = Constants_H.WIDTH__ / 2;
    int m = Constants_H.HEIGHT__ / 2;
    if (this.load_c < 0) {
      this.load_c = 0;
      return;
    } 
    g.setClip(0, 0, k, j);
    if (this.load_c >= 0 && this.load_c < 18) {
      g.setClip(0, 0, k, j);
      Ui.i().fillRect(16777215, 0, 0, k, j);
      if (this.load_c == 0) {
        GameRun.g = g;
        this.image_logo = Ms.i().createImage("qq/qqlogo");
      } 
      g.drawImage(this.image_logo, i, m, 0x1 | 0x2);
    } else if (this.load_c >= 19 && this.load_c < 37) {
      if (this.load_c == 19) {
        this.image_logo = null;
        this.image_logo = Ms.i().createImage("cwa");
      } 
      g.setColor(0);
      Ui.i().fillRect(0, 0, 0, k, j);
      g.drawImage(this.image_logo, i, m, 0x1 | 0x2);
    } else if (this.load_c > 37) {
      this.image_logo = null;
      this.gr.popMenu = 0;
      this.game_state = 10;
      this.strTemp = "是否打开音乐?";
      game_init();
    } 
    this.load_c++;
  }
  
  public void pointerPressed(int paramInt1, int paramInt2) {
    if (!SMSSender.isWorking)
      this.pkey.process(paramInt1, paramInt2); 
  }
  
  public void pointerReleased(int paramInt1, int paramInt2) {
    Ms.i().keyRelease();
  }
  
  public void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield quitGame : Z
    //   4: istore_1
    //   5: iload_1
    //   6: ifeq -> 18
    //   9: aload_0
    //   10: getfield game : Lmain/XConnection;
    //   13: iconst_1
    //   14: invokevirtual destroyApp : (Z)V
    //   17: return
    //   18: aload_0
    //   19: invokestatic currentTimeMillis : ()J
    //   22: putfield starttime : J
    //   25: getstatic main/SMSSender.isWorking : Z
    //   28: ifne -> 120
    //   31: getstatic com/android/Util/AndroidUtil.cv : Landroid/os/ConditionVariable;
    //   34: invokevirtual block : ()V
    //   37: getstatic com/android/Util/AndroidUtil.cv : Landroid/os/ConditionVariable;
    //   40: invokevirtual close : ()V
    //   43: aload_0
    //   44: getfield game_state : I
    //   47: bipush #98
    //   49: if_icmpeq -> 58
    //   52: invokestatic i : ()Ldm/Sound;
    //   55: invokevirtual soundPlay : ()V
    //   58: aload_0
    //   59: getfield game_state : I
    //   62: lookupswitch default -> 96, 20 -> 218, 30 -> 180, 40 -> 96
    //   96: invokestatic i : ()Ldm/Ms;
    //   99: pop
    //   100: getstatic dm/Ms.keyRepeat : Z
    //   103: ifeq -> 110
    //   106: aload_0
    //   107: invokespecial keyProcess : ()V
    //   110: invokestatic i : ()Ldm/Ms;
    //   113: invokevirtual runDelay : ()V
    //   116: aload_0
    //   117: invokevirtual paint : ()V
    //   120: aload_0
    //   121: invokestatic currentTimeMillis : ()J
    //   124: aload_0
    //   125: getfield starttime : J
    //   128: lsub
    //   129: putfield timetaken : J
    //   132: invokestatic i : ()Ldm/Ms;
    //   135: invokevirtual getSleep : ()I
    //   138: ifle -> 329
    //   141: invokestatic i : ()Ldm/Ms;
    //   144: invokevirtual getSleep : ()I
    //   147: i2l
    //   148: invokestatic sleep : (J)V
    //   151: invokestatic i : ()Ldm/Ms;
    //   154: iconst_0
    //   155: invokevirtual sleep : (I)V
    //   158: goto -> 0
    //   161: astore #6
    //   163: aload #6
    //   165: invokevirtual printStackTrace : ()V
    //   168: invokestatic i : ()Ldm/Ms;
    //   171: invokevirtual key_Num0 : ()Z
    //   174: ifeq -> 168
    //   177: goto -> 9
    //   180: aload_0
    //   181: getfield gr : Lmain/GameRun;
    //   184: invokevirtual run_gameRun : ()V
    //   187: aload_0
    //   188: getfield gr : Lmain/GameRun;
    //   191: invokevirtual runPauseIco : ()Z
    //   194: ifne -> 207
    //   197: aload_0
    //   198: getfield pkey : Lmain/PointerKey;
    //   201: invokevirtual runMove : ()V
    //   204: goto -> 96
    //   207: aload_0
    //   208: getfield pkey : Lmain/PointerKey;
    //   211: iconst_0
    //   212: putfield isGo : Z
    //   215: goto -> 96
    //   218: aload_0
    //   219: getfield gr : Lmain/GameRun;
    //   222: getfield createOver : B
    //   225: iconst_m1
    //   226: if_icmpne -> 295
    //   229: aload_0
    //   230: getfield gr : Lmain/GameRun;
    //   233: bipush #60
    //   235: putfield time_count : B
    //   238: aload_0
    //   239: invokevirtual paint : ()V
    //   242: aload_0
    //   243: getfield gr : Lmain/GameRun;
    //   246: getfield threadType : B
    //   249: ifne -> 96
    //   252: aload_0
    //   253: getfield gr : Lmain/GameRun;
    //   256: getfield createOver : B
    //   259: iconst_m1
    //   260: if_icmpne -> 96
    //   263: aload_0
    //   264: getfield gr : Lmain/GameRun;
    //   267: getfield time_count : B
    //   270: bipush #60
    //   272: if_icmpne -> 96
    //   275: invokestatic i : ()Ldm/Ms;
    //   278: iconst_0
    //   279: aconst_null
    //   280: iconst_4
    //   281: invokevirtual rmsOptions : (I[BI)[B
    //   284: pop
    //   285: aload_0
    //   286: getfield gr : Lmain/GameRun;
    //   289: invokevirtual start : ()V
    //   292: goto -> 96
    //   295: aload_0
    //   296: getfield gr : Lmain/GameRun;
    //   299: getfield time_count : B
    //   302: bipush #60
    //   304: if_icmpge -> 242
    //   307: aload_0
    //   308: getfield gr : Lmain/GameRun;
    //   311: astore #6
    //   313: aload #6
    //   315: aload #6
    //   317: getfield time_count : B
    //   320: iconst_1
    //   321: iadd
    //   322: i2b
    //   323: putfield time_count : B
    //   326: goto -> 242
    //   329: ldc2_w 60
    //   332: aload_0
    //   333: getfield timetaken : J
    //   336: lsub
    //   337: lstore #4
    //   339: lload #4
    //   341: lstore_2
    //   342: lload #4
    //   344: ldc2_w 10
    //   347: lcmp
    //   348: ifge -> 355
    //   351: ldc2_w 10
    //   354: lstore_2
    //   355: lload_2
    //   356: invokestatic sleep : (J)V
    //   359: goto -> 0
    // Exception table:
    //   from	to	target	type
    //   0	5	161	java/lang/Exception
    //   18	58	161	java/lang/Exception
    //   58	96	161	java/lang/Exception
    //   96	110	161	java/lang/Exception
    //   110	120	161	java/lang/Exception
    //   120	158	161	java/lang/Exception
    //   180	204	161	java/lang/Exception
    //   207	215	161	java/lang/Exception
    //   218	242	161	java/lang/Exception
    //   242	292	161	java/lang/Exception
    //   295	326	161	java/lang/Exception
    //   329	339	161	java/lang/Exception
    //   355	359	161	java/lang/Exception
  }
  
  public void setSmsIsSetRun_state(boolean paramBoolean) {
    System.out.println("setSmsIsSetRun_state state= " + paramBoolean);
    this.smsIsSetRun_state = paramBoolean;
  }
  
  public void showNotify() {
    showNotifyMy();
  }
  
  public void showNotifyMy() {
    System.out.println("showNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
    if (this.game_state == 98) {
      if (GameRun.run_state != -20 && GameRun.run_state != -21) {
        this.game_state = 30;
        System.out.println("在这?");
      } 
      repaint();
      GameRun.run_state = 98;
      this.game_state = 98;
      System.out.println("还是在这?");
      Sound.i().soundStop();
      return;
    } 
    this.fisrt_paint = 0;
    System.out.println("不会在这吧？");
  }
  
  public void skyContinueGame() {
    this.gr.data_init();
    System.gc();
    this.gr.map.firstDrawMap = 0;
    goGameLoading();
    this.pkey.stopMove();
  }
  
  public void skyNewGame() {
    if (this.gr.rmsOther[0] == -1) {
      newGame();
      return;
    } 
    this.menu_state = 2;
    this.gr.gogoString = "这将清除您之前的所有记录，是否继续？";
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/MainCanvas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */