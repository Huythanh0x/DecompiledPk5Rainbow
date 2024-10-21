package main;

import android.util.Log;
import com.android.Util.AndroidUtil;
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
    byte battle_c;
    boolean bblack;
    public boolean createStop;
    private static DirectGraphics dg;
    StringBuffer[] dialog;
    int error;
    String errorString;
    private byte fisrt_paint;
    private Sprite flashSP;
    private static Graphics g;
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
    public static float mainxx;
    public static float mainyy;
    public static float mapxx;
    public static float mapyy;
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

    public MainCanvas(XConnection game) {
        this.errorString = "";
        this.quitGame = false;
        this.logo_c = 0;
        this.temp_loop = 0;
        this.starttime = 0L;
        this.timetaken = 0L;
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
        MainCanvas.mainxx = ((float)Constants_H.WIDTH__) / 640.0f;
        MainCanvas.mapxx = ((float)Constants_H.WIDTH__) / ((float)Constants_H.WIDTH);
        MainCanvas.mainyy = ((float)Constants_H.HEIGHT__) / 360.0f;
        MainCanvas.mapyy = ((float)Constants_H.HEIGHT__) / ((float)Constants_H.HEIGHT);
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
        if(this.flashSP == null) {
            this.flashSP = Ms.i().createSprite("data/fm", false);
        }
        this.mt = 0;
        this.ma = 0;
        this.load_c = 0;
    }

    public void doShowNotify() {
        this.game_state = this.temp_gamestate;
        if(this.checkSmsRun_stateIsTrue()) {
            this.setSmsIsSetRun_state(false);
            if(GameRun.run_state == 98) {
                System.out.println("在这？？");
                GameRun.run_state = this.temp_state;
            }
        }
        else {
            System.out.println("在这？");
            GameRun.run_state = this.temp_state;
        }
        if(this.checkHaveSoundBeforeHideNotify()) {
            Sound.i().setMusic(true);
            Sound.i().setSoundON(true);
            Sound.i().soundPlay();
            Sound.i().soundStart();
        }
    }

    public void drawRectBG() {
        Ui.i().fillRectB();
        for(int j = 0; j < 19; j = (byte)(j + 1)) {
            for(int i = 0; i < 33; i = (byte)(i + 1)) {
                MainCanvas.g.translate(i * 20, j * 20);
                MainCanvas.dg.fillPolygon(new int[]{0, 10, 20, 10}, 0, new int[]{10, 0, 10, 20}, 0, 4, 0xFF4FC7FF);
                MainCanvas.g.translate(i * -20, j * -20);
            }
        }
    }

    private final void game_init() {
        this.gr.initOffG();
    }

    public final void game_start() {
        new Thread(this).start();
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
        Map map0 = this.gr.map;
        Ms.i();
        map0.anole_type = (byte)Ms.getRandom(5);
        this.gr.map.setAnole();
        this.paint();
        new CreateThread(this.gr, 0);
    }

    void goHELP_dialog(int mode) {
        this.game_state = 40;
        this.menu_state = 4;
        this.gr.help_page = 0;
        this.logo_c = 0;
        this.help_state = (byte)mode;
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

    private void goQuit() {
        this.game_state = 101;
    }

    @Override  // javax.microedition.lcdui.Canvas
    public void hideNotify() {
        this.hideNotifyMy();
    }

    public void hideNotifyMy() {
        System.out.println("hideNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
        Ms.keyRepeat = false;
        if(this.game_state != 98 && GameRun.run_state != 98) {
            this.haveSoundBeforeHideNotify = Sound.i().getHaveSoundPlayState();
            Sound.i().soundStop();
            if(this.game_state != 98) {
                this.temp_gamestate = this.game_state;
            }
            if(GameRun.run_state != 98) {
                this.temp_state = GameRun.run_state;
            }
            GameRun.run_state = 98;
            this.game_state = 98;
        }
    }

    public void initGraphics(Graphics _g) {
        MainCanvas.g = _g;
        MainCanvas.dg = DirectUtils.getDirectGraphics(_g);
        this.gr.initGraphics(MainCanvas.g);
        Ui.i().initGraphics(MainCanvas.g);
    }

    @Override  // javax.microedition.lcdui.Canvas
    protected final void keyPressed(int key) {
        if(SMSSender.isWorking) {
            System.out.println("");
            return;
        }
        Ms.keyRepeat = true;
        Ms.key = key;
    }

    private final void keyProcess() {
        this.error = 3;
    alab1:
        switch(this.game_state) {
            case 10: {
                if(Ms.i().key_S1() || Ms.i().key_S2()) {
                    this.logo_c = 0;
                    Sound.i().setSoundON(Ms.i().key_S1());
                    Sound.i().setVolume((Ms.i().key_S1() ? 30 : 0));
                    Ms.i().keyRelease();
                    this.gr.goMAIN_MENU();
                }
                Ms.i().keyRelease();
                return;
            }
            case 11: {
                if(Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    this.gr.goMAIN_MENU();
                    return;
                }
                break;
            }
            case 30: {
                this.gr.key_gameRun();
                return;
            }
            case 40: {
                switch(this.menu_state) {
                    case 0: {
                        Ms.i().keyRelease();
                        if(Ms.i().key_Num0()) {
                            this.ma = 0;
                            this.mt = 0;
                            this.load_c = 1;
                        }
                        else if(this.load_c == 0) {
                            return;
                        }
                        if(Ms.i().key_S1_Num5()) {
                            switch(this.gr.selectx) {
                                case 0: {
                                    this.gr.skyCheckRegFull(2);
                                    return;
                                }
                                case 1: {
                                    this.gr.skyCheckRegFull(1);
                                    return;
                                }
                                case 2: {
                                    Sound.i().keyVolume(0);
                                    Sound.i().setMusicForMenu(true);
                                    return;
                                }
                                case 3: {
                                    this.goHELP_dialog(0);
                                    return;
                                }
                                case 4: {
                                    Log.e("soars", "ABOUT_BUTTON");
                                    this.goABOUT();
                                    return;
                                }
                                case 5: {
                                    Log.e("soars", "EXIT_BUTTON");
                                    this.quitGame = true;
                                    this.game.destroyApp(true);
                                    return;
                                }
                                default: {
                                    return;
                                }
                            }
                        }
                        if(Ms.i().key_Left_Right()) {
                            GameRun gameRun2 = this.gr;
                            gameRun2.selectx = Ms.i().select(this.gr.selectx, (this.gr.rmsOther[0] == -1 ? 1 : 0), this.gr.action_str.length - 1);
                            return;
                        }
                        break alab1;
                    }
                    case 2: {
                        if(Ms.i().key_S1_Num5()) {
                            this.newGame();
                        }
                        else if(Ms.i().key_S2()) {
                            this.menu_state = 0;
                            this.gr.about_a = null;
                        }
                        Ms.i().keyRelease();
                        return;
                    }
                    case 4: {
                        if(Ms.i().key_S2()) {
                            this.gr.about_a = null;
                            if(this.help_state == 1) {
                                this.game_state = 30;
                                this.gr.doPaint(0);
                                this.gr.goYouPAUSE(2);
                                this.gr.selectx = 1;
                                this.gr.selecty = 2;
                                this.gr.setPauseS(((int)this.gr.selectx));
                            }
                            else {
                                this.goMain_menu();
                                this.gr.select[0][0] = 3;
                            }
                        }
                        else if(Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
                            GameRun gameRun0 = this.gr;
                            gameRun0.help_page = Ms.i().select(((int)this.gr.help_page), 0, this.gr.page_max - 1);
                        }
                        Ms.i().keyRelease();
                        return;
                    }
                    case 5: {
                        if(Ms.i().key_S2()) {
                            Ms.i().keyRelease();
                            this.gr.about_a = null;
                            Log.e("soars", "gr.about_a dfd");
                            this.goMain_menu();
                        }
                        else if(Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
                            GameRun gameRun1 = this.gr;
                            gameRun1.help_page = Ms.i().select(((int)this.gr.help_page), 0, this.gr.page_max - 1);
                        }
                        Log.e("soars", "s.i().key_Up_Down()||Ms.i().key");
                        Ms.i().keyRelease();
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            case 98: {
                if(Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                    System.out.println("按键处理这里执行吗");
                    this.doShowNotify();
                }
                Ms.i().keyRelease();
                return;
            }
            case 101: {
                this.quitGame = true;
                Ms.i().keyRelease();
            }
        }
    }

    @Override  // javax.microedition.lcdui.Canvas
    protected final void keyReleased(int key) {
        Ms.i().keyRelease();
    }

    private void newGame() {
        this.gr.data_init();
        Log.e("test", "new game " + Ms.i().rmsOptions(0, null, 5));
        if(Ms.i().rmsOptions(0, null, 5) == null) {
            this.gr.map.firstDrawMap = 0;
            Ms.i().rmsOptions(0, null, 3);
            this.gr.initRmsOther();
            Ms.i().rmsOptions(10, this.gr.rmsOther, 2);
            this.goGameLoading();
            this.gr.map.initSrcEffect(1);
        }
        else {
            this.gr.say("存储空间不足！", 0);
        }
        this.gr.about_a = null;
    }

    public void paint() {
        this.repaint();
    }

    @Override  // javax.microedition.lcdui.Canvas
    protected void paint(Graphics g) {
        if(this.game_state != 0) {
            this.setScale(MainCanvas.mainxx, MainCanvas.mainyy);
        }
        this.keyxx = MainCanvas.mainxx;
        this.keyyy = MainCanvas.mainyy;
        this.initGraphics(g);
        Ms.i();
        g.setFont(Ms.font);
        g.setClip(0, 0, 640, 360);
        switch(this.game_state) {
            case 0: {
                this.paintMobileLogo();
                return;
            }
            case 10: {
                Ui.i().fillRect(0, 0, 0, 640, 360);
                Ui.i().drawString("是否打开音乐?", 320, 0x9B, 17, 0, 0);
                Ui.i().drawString("（关闭声音游戏更流畅）", 320, 180, 17, 5, 0);
                Ui.i().drawString("是", 4, 360, 36, 0, 0);
                Ui.i().drawString("否", 636, 360, 40, 0, 0);
                return;
            }
            case 11: {
                Ui.i().drawImage(this.image_logo, 0, 0, 0);
                return;
            }
            case 20: {
                this.gr.drawChangeMap(true, ((int)this.gr.time_count), 30, 322, 580);
                return;
            }
            case 30: {
                this.gr.paint_gameRun(g);
                return;
            }
            case 40: {
                switch(this.menu_state) {
                    case 0: {
                        Ui.i().fillRect(0, 0, 0, 640, 360);
                        Ui ui0 = Ui.i();
                        int v = this.flashSP.action(this.load_c, ((int)this.ma), 0);
                        ui0.drawFrameOne(this.flashSP, v, 320, 180, 0);
                        this.setMenuFrame_C();
                        if(this.load_c == 1) {
                            g.setClip(0, 0, 640, 360);
                            Ui.i().drawK0(190, 329, 260, 0x1F, 0);
                            if(this.gr.selectx == 2) {
                                Ui.i().drawVolume(396, 341, Sound.i().getVolume(), true);
                            }
                            Ui.i().drawString(this.gr.action_str[this.gr.selectx], 320, 366, 33, 3, 1);
                            Ui.i().drawTriangle1(320, 347, 0x7D, true, true);
                            Ui.i().drawYesNo(true, false);
                            return;
                        }
                        Ui.i().drawString("点击屏幕跳过", 320, 360, 33, 1, 2);
                        return;
                    }
                    case 2: {
                        Ui.i().drawKuang(0, 273, 640, 58);
                        this.gr.showStringM(this.gr.gogoString, 320, 275, 10, 3);
                        Ui.i().drawYesNo(true, true);
                        return;
                    }
                    case 4: {
                        Ui.i().drawK0(0, 0, 640, 360, 2);
                        this.gr.drawHelpStr(g, this.gr.about_a, ((int)this.gr.line_max), 320, 10, 17);
                        Ui.i().drawYesNo(false, true);
                        return;
                    }
                    case 5: {
                        Ui.i().drawK0(0, 0, 640, 360, 2);
                        this.gr.setStringB("宠物王国5-彩虹#n开发商：#n华娱无线#n客服电话：#n010-88901665#n客服Email:#ngeekan@imy.cn", 590, 0);
                        this.gr.drawHelpStr(g, this.gr.about_a, ((int)this.gr.line_max), 320, 10, 17);
                        Ui.i().drawYesNo(false, true);
                        return;
                    }
                    default: {
                        return;
                    }
                }
            }
            case 98: {
                this.drawRectBG();
                Ui.i().drawK1(-5, 285, 650, 75, 3);
                this.gr.showStringM("游戏暂停，点击屏幕返回。", 320, 308, 9, 3);
            }
        }
    }

    protected void paintMobileLogo() {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        int HEIGHT_H = Constants_H.HEIGHT__ / 2;
        if(this.load_c < 0) {
            this.load_c = 0;
            return;
        }
        MainCanvas.g.setClip(0, 0, WIDTH, HEIGHT);
        if(this.load_c >= 0 && this.load_c < 18) {
            MainCanvas.g.setClip(0, 0, WIDTH, HEIGHT);
            Ui.i().fillRect(0xFFFFFF, 0, 0, WIDTH, HEIGHT);
            if(this.load_c == 0) {
                GameRun.g = MainCanvas.g;
                this.image_logo = Ms.i().createImage("qq/qqlogo");
            }
            MainCanvas.g.drawImage(this.image_logo, WIDTH_H, HEIGHT_H, 3);
        }
        else if(this.load_c >= 19 && this.load_c < 37) {
            if(this.load_c == 19) {
                this.image_logo = null;
                this.image_logo = Ms.i().createImage("cwa");
            }
            MainCanvas.g.setColor(0);
            Ui.i().fillRect(0, 0, 0, WIDTH, HEIGHT);
            MainCanvas.g.drawImage(this.image_logo, WIDTH_H, HEIGHT_H, 3);
        }
        else if(this.load_c > 37) {
            this.image_logo = null;
            this.gr.popMenu = 0;
            this.game_state = 10;
            this.strTemp = "是否打开音乐?";
            this.game_init();
        }
        ++this.load_c;
    }

    @Override  // javax.microedition.lcdui.Canvas
    public void pointerPressed(int x, int y) {
        if(SMSSender.isWorking) {
            return;
        }
        this.pkey.process(x, y);
    }

    @Override  // javax.microedition.lcdui.Canvas
    public void pointerReleased(int x, int y) {
        Ms.i().keyRelease();
    }

    @Override
    public void run() {
    label_0:
        while(!this.quitGame) {
            try {
                this.starttime = System.currentTimeMillis();
                if(!SMSSender.isWorking) {
                    AndroidUtil.cv.block();
                    AndroidUtil.cv.close();
                    if(this.game_state != 98) {
                        Sound.i().soundPlay();
                    }
                    switch(this.game_state) {
                        case 20: {
                            if(this.gr.createOver == -1) {
                                this.gr.time_count = 60;
                                this.paint();
                            }
                            else if(this.gr.time_count < 60) {
                                this.gr.time_count = (byte)(this.gr.time_count + 1);
                            }
                            if(this.gr.threadType == 0 && this.gr.createOver == -1 && this.gr.time_count == 60) {
                                Ms.i().rmsOptions(0, null, 4);
                                this.gr.start();
                            }
                            break;
                        }
                        case 30: {
                            this.gr.run_gameRun();
                            if(this.gr.runPauseIco()) {
                                this.pkey.isGo = false;
                            }
                            else {
                                this.pkey.runMove();
                            }
                        }
                    }
                    Ms.i();
                    if(Ms.keyRepeat) {
                        this.keyProcess();
                    }
                    Ms.i().runDelay();
                    this.paint();
                }
                this.timetaken = System.currentTimeMillis() - this.starttime;
                if(Ms.i().getSleep() > 0) {
                    Thread.sleep(Ms.i().getSleep());
                    Ms.i().sleep(0);
                    continue;
                }
                Thread.sleep((60L - this.timetaken >= 10L ? 60L - this.timetaken : 10L));
            }
            catch(Exception exception0) {
                exception0.printStackTrace();
                while(true) {
                    if(Ms.i().key_Num0()) {
                        break label_0;
                    }
                }
            }
        }
        this.game.destroyApp(true);
    }

    private void setMenuFrame_C() {
        byte b = (byte)(this.mt + 1);
        this.mt = b;
        if(b > this.flashSP.action(this.load_c, ((int)this.ma), 1)) {
            this.mt = 0;
            byte b1 = (byte)(this.ma + 1);
            this.ma = b1;
            if(b1 >= this.flashSP.aLength(this.load_c)) {
                this.ma = 0;
                if(this.load_c == 0) {
                    this.load_c = 1;
                }
            }
        }
    }

    public void setSmsIsSetRun_state(boolean state) {
        System.out.println("setSmsIsSetRun_state state= " + state);
        this.smsIsSetRun_state = state;
    }

    @Override  // javax.microedition.lcdui.Canvas
    public void showNotify() {
        this.showNotifyMy();
    }

    public void showNotifyMy() {
        System.out.println("showNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
        if(this.game_state == 98) {
            if(GameRun.run_state != -21 && GameRun.run_state != -20) {
                this.game_state = 30;
                System.out.println("在这?");
            }
            this.repaint();
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
        this.goGameLoading();
        this.pkey.stopMove();
    }

    public void skyNewGame() {
        if(this.gr.rmsOther[0] == -1) {
            this.newGame();
            return;
        }
        this.menu_state = 2;
        this.gr.gogoString = "这将清除您之前的所有记录，是否继续？";
    }
}

