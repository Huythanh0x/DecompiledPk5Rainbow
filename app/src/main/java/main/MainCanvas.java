package main.MainCanvas;
import java.lang.Runnable;
import com.nokia.mid.ui.FullCanvas;
import main.XConnection;
import main.GameRun;
import main.SMSSender;
import main.PointerKey;
import main.Map;
import main.Constants_H;
import dm.Ms;
import java.lang.System;
import java.lang.String;
import java.io.PrintStream;
import dm.Sound;
import android.util.Log;
import java.lang.StringBuilder;
import java.lang.Object;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Graphics;
import com.nokia.mid.ui.DirectGraphics;
import java.lang.Thread;
import main.CreateThread;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import java.lang.StringBuffer;
import com.android.Util.AndroidUtil;
import android.os.ConditionVariable;
import java.lang.Exception;

public final class MainCanvas extends FullCanvas implements Runnable	// class@000165 from classes.dex
{
    byte battle_c;
    boolean bblack;
    public boolean createStop;
    StringBuffer[] dialog;
    int error;
    String errorString;
    private byte fisrt_paint;
    private Sprite flashSP;
    XConnection game;
    public int game_state;
    GameRun gr;
    private boolean haveSoundBeforeHideNotify;
    private byte help_state;
    byte iii;
    int[] imageData;
    Image image_logo;
    Image image_logo_word;
    int load_c;
    int logo_c;
    int loop_s;
    private byte ma;
    public int menu_state;
    private byte mt;
    PointerKey pkey;
    public int prevGameState;
    public int prevMenuState;
    public int prevRunState;
    boolean quitGame;
    public SMSSender sender;
    private boolean smsIsSetRun_state;
    long starttime;
    String strTemp;
    int temp_gamestate;
    int temp_loop;
    public int temp_state;
    long timetaken;
    private static DirectGraphics dg;
    private static Graphics g;
    public static float mainxx;
    public static float mainyy;
    public static float mapxx;
    public static float mapyy;

    public void MainCanvas(XConnection game){
       super();
       this.errorString = "";
       this.quitGame = false;
       this.logo_c = 0;
       this.temp_loop = 0;
       this.starttime = 0;
       this.timetaken = 0;
       this.battle_c = 9;
       this.strTemp = "";
       this.imageData = null;
       this.bblack = false;
       this.temp_state = 0;
       this.temp_gamestate = 0;
       this.haveSoundBeforeHideNotify = false;
       this.smsIsSetRun_state = false;
       this.load_c = -1;
       this.game = game;
       this.gr = new GameRun(this);
       this.sender = SMSSender.i(this.gr);
       this.pkey = new PointerKey(this);
       this.gr.map.pkey = this.pkey;
       this.gr.pkey = this.pkey;
       this.sender.pkey = this.pkey;
       MainCanvas.mainxx = (float)Constants_H.WIDTH__ / 640.00f;
       MainCanvas.mapxx = (float)Constants_H.WIDTH__ / (float)Constants_H.WIDTH;
       MainCanvas.mainyy = (float)Constants_H.HEIGHT__ / 360.00f;
       MainCanvas.mapyy = (float)Constants_H.HEIGHT__ / (float)Constants_H.HEIGHT;
    }
    private final void game_init(){
       this.gr.initOffG();
    }
    private void goQuit(){
       this.game_state = 101;
    }
    private final void keyProcess(){
       MainCanvas tgr;
       Ms ms;
       GameRun selectx;
       int i = 3;
       StringBuffer[] stringBuffer = null;
       int i1 = 2;
       this.error = i;
       switch (this.game_state){
           case 10:
             if (Ms.i().key_S1() || Ms.i().key_S2()) {
                this.logo_c = 0;
                Sound.i().setSoundON(Ms.i().key_S1());
                Sound sound = Sound.i();
                i1 = (Ms.i().key_S1())? 30: 0;
                sound.setVolume(i1);
                Ms.i().keyRelease();
                this.gr.goMAIN_MENU();
             }
             Ms.i().keyRelease();
             break;
           case 11:
             if (Ms.i().key_S1_Num5()) {
                Ms.i().keyRelease();
                this.gr.goMAIN_MENU();
             }
             break;
           case 30:
             this.gr.key_gameRun();
             break;
           case 40:
             switch (this.menu_state){
                 case 0:
                   Ms.i().keyRelease();
                   if (Ms.i().key_Num0()) {
                      this.ma = 0;
                      this.mt = 0;
                      this.load_c = 1;
                   }else if(this.load_c == null){
                   }
                   break;
                 case 2:
                   if (Ms.i().key_S1_Num5()) {
                      this.newGame();
                   }else if(Ms.i().key_S2()){
                      this.menu_state = 0;
                      this.gr.about_a = stringBuffer;
                   }
                   Ms.i().keyRelease();
                   break;
                 case 4:
                   if (Ms.i().key_S2()) {
                      if ((this.gr.about_a = stringBuffer) == 1) {
                         this.game_state = 30;
                         this.gr.doPaint(0);
                         this.gr.goYouPAUSE(i1);
                         this.gr.selectx = 1;
                         this.gr.selecty = i1;
                         this.gr.setPauseS(this.gr.selectx);
                      }else {
                         this.goMain_menu();
                         this.gr.select[0][0] = i;
                      }
                   }else if(!Ms.i().key_Up_Down() && !Ms.i().key_Left_Right()){
                      this.gr.help_page = Ms.i().select(this.gr.help_page, 0, (this.gr.page_max - 1));
                   }
                   Ms.i().keyRelease();
                   break;
                 case 5:
                   if (Ms.i().key_S2()) {
                      Ms.i().keyRelease();
                      this.gr.about_a = stringBuffer;
                      Log.e("soars", "gr.about_a dfd");
                      this.goMain_menu();
                   }else if(!Ms.i().key_Up_Down() && !Ms.i().key_Left_Right()){
                      this.gr.help_page = Ms.i().select(this.gr.help_page, 0, (this.gr.page_max - 1));
                   }
                   Log.e("soars", "s.i\(\).key_Up_Down\(\)||Ms.i\(\).key");
                   Ms.i().keyRelease();
                   break;
                 default:
             }
             break;
           case 'b':
             if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                System.out.println("\x63\x02\x95\x02\x59\x02\x74\x02\x8f\x02\x91\x02\x62\x02\x88\x02\x54\x02");
                this.doShowNotify();
             }
             Ms.i().keyRelease();
             break;
           case 'e':
             this.quitGame = true;
             Ms.i().keyRelease();
             break;
       }
       return;
    }
    private void newGame(){
       int i = 0;
       this.gr.data_init();
       Log.e("test", "new game "+Ms.i().rmsOptions(i, null, 5));
       if (Ms.i().rmsOptions(i, null, 5) == null) {
          this.gr.map.firstDrawMap = i;
          Ms.i().rmsOptions(i, null, 3);
          this.gr.initRmsOther();
          Ms.i().rmsOptions(10, this.gr.rmsOther, 2);
          this.goGameLoading();
          this.gr.map.initSrcEffect(1);
       }else {
          this.gr.say("\x5b\x02\x50\x02\x7a\x02\x95\x02\x4e\x02\x8d\x02\xff\x02", i);
       }
       this.gr.about_a = null;
       return;
    }
    private void setMenuFrame_C(){
       byte b = (byte)(this.mt + 1);
       this.mt = b;
       if (b > this.flashSP.action(this.load_c, this.ma, 1)) {
          this.mt = 0;
          b = (byte)(this.ma + 1);
          this.ma = b;
          if (b >= this.flashSP.aLength(this.load_c)) {
             this.ma = 0;
             if (this.load_c == null) {
                this.load_c = 1;
             }
          }
       }
       return;
    }
    public boolean checkHaveSoundBeforeHideNotify(){
       System.out.println("checkHaveSoundBeforeHideNotify haveSoundBeforeHideNotify= "+this.haveSoundBeforeHideNotify);
       return this.haveSoundBeforeHideNotify;
    }
    public boolean checkSmsRun_stateIsTrue(){
       System.out.println("checkSmsRun_stateIsTrue smsIsSetRun_state= "+this.smsIsSetRun_state);
       return this.smsIsSetRun_state;
    }
    void createFlashImage(){
       if (this.flashSP == null) {
          this.flashSP = Ms.i().createSprite("data/fm", false);
       }
       this.mt = false;
       this.ma = false;
       this.load_c = 0;
       return;
    }
    public void doShowNotify(){
       this.game_state = this.temp_gamestate;
       if (!this.checkSmsRun_stateIsTrue()) {
          System.out.println("\x57\x02\x8f\x02\xff\x02");
          GameRun.run_state = this.temp_state;
       }else {
          this.setSmsIsSetRun_state(false);
          if (GameRun.run_state == 98) {
             System.out.println("\x57\x02\x8f\x02\xff\x02\xff\x02");
             GameRun.run_state = this.temp_state;
          }
       }
       if (this.checkHaveSoundBeforeHideNotify()) {
          Sound.i().setMusic(true);
          Sound.i().setSoundON(true);
          Sound.i().soundPlay();
          Sound.i().soundStart();
       }
       return;
    }
    public void drawRectBG(){
       int ix = 2;
       int ix1 = 10;
       int WIDTH = 640;
       int HEIGHT = 360;
       Ui.i().fillRectB();
       int[] ointArray = new int[4];
       ointArray[1] = ix1;
       ointArray[2] = 20;
       ointArray[3] = ix1;
       int[] ointArray1 = new int[4];
       ointArray1[0] = ix1;
       ointArray1[2] = ix1;
       ointArray1[3] = 20;
       byte j = 0;
       while (true) {
          int ix2 = HEIGHT / 20;
          ix2 = ix2 + 1;
          if (j >= ix2) {
             break ;
          }else {
             byte i = 0;
             while (true) {
                ix2 = WIDTH / 20;
                ix2 = ix2 + 1;
                if (i >= ix2) {
                   break ;
                }else {
                   ix1 = i * 20;
                   ix = j * 20;
                   MainCanvas.g.translate(ix1, ix);
                   MainCanvas.dg.fillPolygon(ointArray, 0, ointArray1, 0, 4, -11548673);
                   ix1 = i * -20;
                   ix = j * -20;
                   MainCanvas.g.translate(ix1, ix);
                   ix2 = i + 1;
                   i = (byte)ix2;
                }
             }
             ix2 = j + 1;
             j = (byte)ix2;
          }
       }
       ointArray = null;
       ointArray1 = null;
       return;
    }
    public final void game_start(){
       new Thread(this).start();
    }
    public final void game_stop(){
       Ms.i().rmsOptions(0, null, 4);
       Sound.i().soundStop();
    }
    void goABOUT(){
       Log.e("soars", "goAbout");
       this.game_state = 40;
       this.menu_state = 5;
       this.gr.help_page = 0;
       this.logo_c = 0;
       this.gr.line_max = 11;
       this.help_state = 0;
       this.gr.setStringB("\x5b\x02\x72\x02\x73\x02\x56\x025-\x5f\x02\x86\x02#n\x5f\x02\x53\x02\x55\x02\xff\x02\x53\x02\x5a\x02\x65\x02\x7e\x02#n\x5b\x02\x67\x02\x75\x02\x8b\x02\xff\x02#n010-88901665#n\x5b\x02\x67\x02Email:#ngeekan@imy.cn", (Constants_H.WIDTH - 50), 0);
    }
    public void goGameLoading(){
       Log.e("loading", "\x6e\x02\x62\x02\x72\x02\x60\x02\xff\x02GAME_LOADING");
       this.game_state = 20;
       this.gr.time_count = 0;
       this.flashSP = null;
       this.gr.map.loadDate_Rms();
       this.gr.loadRmsOther();
       this.gr.map.anole_temp = this.gr.map.anole_type;
       Ms.i();
       this.gr.map.anole_type = (byte)Ms.getRandom(5);
       this.gr.map.setAnole();
       this.paint();
       CreateThread uCreateThrea = new CreateThread(this.gr, 0);
    }
    void goHELP_dialog(int mode){
       this.game_state = 40;
       this.menu_state = 4;
       this.gr.help_page = 0;
       this.logo_c = 0;
       this.help_state = (byte)mode;
       this.gr.line_max = 11;
       this.gr.setStringB("\x6e\x02\x62\x02\x5e\x02\x52\x02#n\x73\x02\x5b\x02\x62\x02\x6f\x02\x4e\x02\x54\x02\x5b\x02\x72\x02\x8b\x02\x7e\x02\x5e\x02\xff\x02\x4e\x02\x4e\x02\x89\x02\x51\x02\x56\x02\x5b\x02\x76\x02\x53\x02\x67\x02\x80\x02\x8e\x02\x4e\x02\x4e\x02\x51\x02\x96\x02\x4e\x02\x65\x02\x30\x02#n\x64\x02\x4f\x02\x63\x02\x79\x02#n\x70\x02\x51\x02\x4e\x02\x7e\x02\x4e\x02\x52\x02\x56\x02\x68\x02\xff\x02\x4e\x02\x7e\x02\x4e\x02\x52\x02#n\x70\x02\x51\x02\x65\x02\x7e\x02\x4e\x02\x52\x02\x56\x02\x68\x02\xff\x02\x65\x02\x7e\x02\x4e\x02\x52\x02#n\x70\x02\x51\x02\x57\x02\x56\x02\x56\x02\x68\x02\xff\x02\x6e\x02\x62\x02\x57\x02\x56\x02#n\x70\x02\x51\x02\x5c\x02\x5e\x02\x63\x02\x52\x02\x4e\x02\x4e\x02\x5d\x02\x53\x02\x79\x02\x52\x02#n\x67\x02\x72\x02\x67\x02\x53\x02\x65\x02\x63\x02\x6a\x02\x5c\x02\x6e\x02\x62\x02", (Constants_H.WIDTH - 50), 0);
    }
    void goMain_menu(){
       Sound.i().setMusicId(7);
       Sound.i().setMusic(false);
       this.game_state = 40;
       this.menu_state = 0;
       this.fisrt_paint = false;
    }
    public void hideNotify(){
       this.hideNotifyMy();
    }
    public void hideNotifyMy(){
       System.out.println("hideNotifyMy\(\) run_state= "+GameRun.run_state+" game_state= "+this.game_state);
       Ms.keyRepeat = false;
       if (this.game_state != 98 && GameRun.run_state != 98) {
          this.haveSoundBeforeHideNotify = Sound.i().getHaveSoundPlayState();
          Sound.i().soundStop();
          if (this.game_state != 98) {
             this.temp_gamestate = this.game_state;
          }
          if (GameRun.run_state != 98) {
             this.temp_state = GameRun.run_state;
          }
          GameRun.run_state = 98;
          this.game_state = 98;
       }
       return;
    }
    public void initGraphics(Graphics _g){
       MainCanvas.g = _g;
       MainCanvas.dg = DirectUtils.getDirectGraphics(_g);
       this.gr.initGraphics(MainCanvas.g);
       Ui.i().initGraphics(MainCanvas.g);
    }
    protected final void keyPressed(int key){
       if (SMSSender.isWorking) {
          System.out.println("");
       }else {
          Ms.keyRepeat = true;
          Ms.key = key;
       }
       return;
    }
    protected final void keyReleased(int key){
       Ms.i().keyRelease();
    }
    public void paint(){
       this.repaint();
       this.serviceRepaints();
    }
    protected void paint(Graphics g){
       if (this.game_state != null) {
          this.setScale(MainCanvas.mainxx, MainCanvas.mainyy);
       }
       this.keyxx = MainCanvas.mainxx;
       this.keyyy = MainCanvas.mainyy;
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       this.initGraphics(g);
       Ms.i();
       g.setFont(Ms.font);
       g.setClip(0, 0, WIDTH, HEIGHT);
       switch (this.game_state){
           case 0:
             this.paintMobileLogo();
             break;
           case 10:
             Ui.i().fillRect(0, 0, 0, WIDTH, HEIGHT);
             Ui.i().drawString("\x66\x02\x54\x02\x62\x02\x5f\x02\x97\x02\x4e\x02?", WIDTH_H, (HEIGHT_H - 25), (1 | 0x10), 0, 0);
             Ui.i().drawString("\xff\x02\x51\x02\x95\x02\x58\x02\x97\x02\x6e\x02\x62\x02\x66\x02\x6d\x02\x75\x02\xff\x02", WIDTH_H, HEIGHT_H, (1 | 0x10), 5, 0);
             HEIGHT_H = 4 | 0x20;
             Ui.i().drawString("\x66\x02", 4, HEIGHT, HEIGHT_H, 0, 0);
             Ui.i().drawString("\x54\x02", (WIDTH - 4), HEIGHT, (8 | 0x20), 0, 0);
             break;
           case 11:
             WIDTH = 0;
             Ui.i().drawImage(this.image_logo, 0, 0, WIDTH);
             break;
           case 20:
             HEIGHT_H = HEIGHT - 38;
             this.gr.drawChangeMap(true, this.gr.time_count, 30, HEIGHT_H, (WIDTH - 60));
             break;
           case 30:
             this.gr.paint_gameRun(g);
             break;
           case 40:
             switch (this.menu_state){
                 case 0:
                   Ui.i().fillRect(0, 0, 0, WIDTH, HEIGHT);
                   Ui.i().drawFrameOne(this.flashSP, this.flashSP.action(this.load_c, this.ma, 0), WIDTH_H, HEIGHT_H, 0);
                   this.setMenuFrame_C();
                   if (this.load_c == 1) {
                      g.setClip(0, 0, WIDTH, HEIGHT);
                      Ui.i().drawK0(((WIDTH_H - 125) - 5), ((HEIGHT - 25) - 6), 260, 31, 0);
                      if (this.gr.selectx == 2) {
                         WIDTH = 1;
                         Ui.i().drawVolume(((WIDTH_H + 6) + 70), (HEIGHT - 19), Sound.i().getVolume(), WIDTH);
                      }
                      Ui.i().drawString(this.gr.action_str[this.gr.selectx], WIDTH_H, (HEIGHT + 6), (1 | 0x20), 3, 1);
                      Ui.i().drawTriangle1(WIDTH_H, (HEIGHT - 13), 125, true, true);
                      Ui.i().drawYesNo(true, false);
                   }else {
                      Ui.i().drawString("\x70\x02\x51\x02\x5c\x02\x5e\x02\x8d\x02\x8f\x02", WIDTH_H, HEIGHT, (1 | 0x20), 1, 2);
                   }
                   break;
                 case 2:
                   Ui.i().drawKuang(0, (HEIGHT - 87), WIDTH, 58);
                   this.gr.showStringM(this.gr.gogoString, WIDTH_H, ((HEIGHT - 87) + 2), 10, 3);
                   Ui.i().drawYesNo(true, true);
                   break;
                 case 4:
                   Ui.i().drawK0(0, 0, WIDTH, HEIGHT, 2);
                   this.gr.drawHelpStr(g, this.gr.about_a, this.gr.line_max, WIDTH_H, 10, (1 | 0x10));
                   Ui.i().drawYesNo(false, true);
                   break;
                 case 5:
                   Ui.i().drawK0(0, 0, WIDTH, HEIGHT, 2);
                   this.gr.setStringB("\x5b\x02\x72\x02\x73\x02\x56\x025-\x5f\x02\x86\x02#n\x5f\x02\x53\x02\x55\x02\xff\x02#n\x53\x02\x5a\x02\x65\x02\x7e\x02#n\x5b\x02\x67\x02\x75\x02\x8b\x02\xff\x02#n010-88901665#n\x5b\x02\x67\x02Email:#ngeekan@imy.cn", (WIDTH - 50), 0);
                   this.gr.drawHelpStr(g, this.gr.about_a, this.gr.line_max, WIDTH_H, 10, (1 | 0x10));
                   Ui.i().drawYesNo(false, true);
                   break;
                 default:
             }
             break;
           case 60:
           case 'e':
           case 'b':
             this.drawRectBG();
             WIDTH = 75;
             Ui.i().drawK1(-5, (HEIGHT - 75), (WIDTH + 10), WIDTH, 3);
             this.gr.showStringM("\x6e\x02\x62\x02\x66\x02\x50\x02\xff\x02\x70\x02\x51\x02\x5c\x02\x5e\x02\x8f\x02\x56\x02\x30\x02", WIDTH_H, ((HEIGHT - 50) - 2), 9, 3);
             break;
       }
       return;
    }
    protected void paintMobileLogo(){
       int i = 19;
       int i1 = 0;
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = Constants_H.HEIGHT__;
       int WIDTH_H = Constants_H.WIDTH__ / 2;
       int HEIGHT_H = Constants_H.HEIGHT__ / 2;
       if (this.load_c < null) {
          this.load_c = i1;
       }else {
          MainCanvas.g.setClip(i1, i1, WIDTH, HEIGHT);
          if (this.load_c >= null && this.load_c < 18) {
             MainCanvas.g.setClip(i1, i1, WIDTH, HEIGHT);
             Ui.i().fillRect(0xffffff, i1, i1, WIDTH, HEIGHT);
             if (this.load_c == null) {
                GameRun.g = MainCanvas.g;
                this.image_logo = Ms.i().createImage("qq/qqlogo");
             }
             MainCanvas.g.drawImage(this.image_logo, WIDTH_H, HEIGHT_H, (1 | 0x02));
          }else if(this.load_c >= i && this.load_c < 37){
             if (this.load_c == i) {
                this.image_logo = null;
                this.image_logo = Ms.i().createImage("cwa");
             }
             MainCanvas.g.setColor(i1);
             Ui.i().fillRect(i1, i1, i1, WIDTH, HEIGHT);
             MainCanvas.g.drawImage(this.image_logo, WIDTH_H, HEIGHT_H, (1 | 0x02));
          }else if(this.load_c > 37){
             this.image_logo = null;
             this.gr.popMenu = i1;
             this.game_state = 10;
             this.strTemp = "\x66\x02\x54\x02\x62\x02\x5f\x02\x97\x02\x4e\x02?";
             this.game_init();
          }
          this.load_c = this.load_c + 1;
       }
       return;
    }
    public void pointerPressed(int x,int y){
       if (!SMSSender.isWorking) {
          this.pkey.process(x, y);
       }
       return;
    }
    public void pointerReleased(int x,int y){
       Ms.i().keyRelease();
    }
    public void run(){
       int i = 60;
       try{
          while (this.quitGame == null) {
             this.starttime = System.currentTimeMillis();
             if (!SMSSender.isWorking) {
                AndroidUtil.cv.block();
                AndroidUtil.cv.close();
                if (this.game_state != 98) {
                   Sound.i().soundPlay();
                }
                switch (this.game_state){
                    case 20:
                      if (this.gr.createOver == -1) {
                         this.gr.time_count = 60;
                         this.paint();
                      }else if(this.gr.time_count < i){
                         MainCanvas tgr = this.gr;
                         int i1 = tgr.time_count + 1;
                         tgr.time_count = (byte)i1;
                      }
                      if (this.gr.threadType == null && (this.gr.createOver == -1 && this.gr.time_count == i)) {
                         Ms.i().rmsOptions(0, null, 4);
                         this.gr.start();
                      }
                      break;
                    case 30:
                      this.gr.run_gameRun();
                      if (!this.gr.runPauseIco()) {
                         this.pkey.runMove();
                      }else {
                         this.pkey.isGo = false;
                      }
                      break;
                    case 40:
                }
                Ms.i();
                if (Ms.keyRepeat) {
                   this.keyProcess();
                }
                Ms.i().runDelay();
                this.paint();
             }
             long l = System.currentTimeMillis() - this.starttime;
             this.timetaken = l;
             if (Ms.i().getSleep() > 0) {
                Thread.sleep((long)Ms.i().getSleep());
                Ms.i().sleep(0);
             }else {
                long useTime = 60 - this.timetaken;
                if ((useTime - 10) < 0) {
                   useTime = 10;
                }
                Thread.sleep(useTime);
             }
          }
       }catch(java.lang.Exception e3){
          Exception ex = e3;
          ex.printStackTrace();
       label_0075 :
          if (Ms.i().key_Num0()) {
          }else {
             goto label_0075 ;
          }
       }
       this.game.destroyApp(true);
       return;
    }
    public void setSmsIsSetRun_state(boolean state){
       System.out.println("setSmsIsSetRun_state state= "+state);
       this.smsIsSetRun_state = state;
    }
    public void showNotify(){
       this.showNotifyMy();
    }
    public void showNotifyMy(){
       System.out.println("showNotifyMy\(\) run_state= "+GameRun.run_state+" game_state= "+this.game_state);
       if (this.game_state == 98) {
          if (GameRun.run_state != -20 && GameRun.run_state != -21) {
             this.game_state = 30;
             System.out.println("\x57\x02\x8f\x02?");
          }
          this.repaint();
          GameRun.run_state = 98;
          this.game_state = 98;
          System.out.println("\x8f\x02\x66\x02\x57\x02\x8f\x02?");
          Sound.i().soundStop();
       }else {
          this.fisrt_paint = 0;
          System.out.println("\x4e\x02\x4f\x02\x57\x02\x8f\x02\x54\x02\xff\x02");
       }
       return;
    }
    public void skyContinueGame(){
       this.gr.data_init();
       System.gc();
       this.gr.map.firstDrawMap = 0;
       this.goGameLoading();
       this.pkey.stopMove();
    }
    public void skyNewGame(){
       if (this.gr.rmsOther[0] == -1) {
          this.newGame();
       }else {
          this.menu_state = 2;
          this.gr.gogoString = "\x8f\x02\x5c\x02\x6e\x02\x96\x02\x60\x02\x4e\x02\x52\x02\x76\x02\x62\x02\x67\x02\x8b\x02\x5f\x02\xff\x02\x66\x02\x54\x02\x7e\x02\x7e\x02\xff\x02";
       }
       return;
    }
}
