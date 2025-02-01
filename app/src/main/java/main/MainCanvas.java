package main;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import com.nokia.mid.ui.FullCanvas;
import com.uc.paymentsdk.util.Constants;
import dm.Ms;
import dm.Sound;
import dm.Sprite;
import dm.Ui;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* loaded from: classes.dex */
/**
 * <h1>MainCanvas</h1>
 * <p>
 * MainCanvas is a core class that extends FullCanvas and implements Runnable. It handles the main game loop, 
 * rendering, and user input for the game. This class is responsible for initializing the game, starting and stopping 
 * the game loop, and managing the game's state transitions.
 * </p>
 * 
 * <h2>Dependencies</h2>
 * <ul>
 *   <li>FullCanvas</li>
 *   <li>Runnable</li>
 *   <li>DirectGraphics</li>
 *   <li>Graphics</li>
 *   <li>Sprite</li>
 *   <li>XConnection</li>
 *   <li>SMSSender</li>
 *   <li>PointerKey</li>
 *   <li>GameRun</li>
 *   <li>Sound</li>
 *   <li>Ms</li>
 *   <li>AndroidUtil</li>
 *   <li>Ui</li>
 *   <li>Constants_H</li>
 * </ul>
 * 
 * <h2>Usage</h2>
 * <p>
 * The MainCanvas class is instantiated with an XConnection object. It initializes various game parameters and 
 * starts the game loop in a new thread. The game loop handles the main game logic, including state transitions, 
 * rendering, and user input processing.
 * </p>
 * 
 * <h2>Key Methods</h2>
 * <ul>
 *   <li><code>game_init()</code>: Initializes the game.</li>
 *   <li><code>game_start()</code>: Starts the game loop in a new thread.</li>
 *   <li><code>game_stop()</code>: Stops the game and releases resources.</li>
 *   <li><code>run()</code>: The main game loop that handles game logic, rendering, and user input.</li>
 *   <li><code>paint(Graphics g)</code>: Renders the game screen based on the current game state.</li>
 *   <li><code>pointerPressed(int x, int y)</code>: Handles pointer press events.</li>
 *   <li><code>pointerReleased(int x, int y)</code>: Handles pointer release events.</li>
 *   <li><code>keyPressed(int key)</code>: Handles key press events.</li>
 *   <li><code>keyReleased(int key)</code>: Handles key release events.</li>
 * </ul>
 * 
 * <h2>Game States</h2>
 * <p>
 * The game has multiple states managed by the <code>game_state</code> variable. Key states include:
 * </p>
 * <ul>
 *   <li><code>0</code>: Initial state, displays the mobile logo.</li>
 *   <li><code>10</code>: Main menu state.</li>
 *   <li><code>20</code>: Game loading state.</li>
 *   <li><code>30</code>: Main game running state.</li>
 *   <li><code>40</code>: Help and About menu state.</li>
 *   <li><code>98</code>: Paused state.</li>
 *   <li><code>101</code>: Quit state.</li>
 * </ul>
 * 
 * <h2>Additional Features</h2>
 * <ul>
 *   <li>Handles sound management and state transitions.</li>
 *   <li>Supports pointer and key input for game control.</li>
 *   <li>Manages game resources and state persistence.</li>
 * </ul>
 * 
 * <h2>Logging</h2>
 * <p>
 * The class uses logging for debugging and state tracking, particularly in methods like <code>hideNotifyMy()</code> 
 * and <code>showNotifyMy()</code>.
 * </p>
 */
public final class MainCanvas extends FullCanvas implements Runnable {
    private static DirectGraphics dg;
    private static Graphics g;
    public static float mainxx;
    public static float mainyy;
    public static float mapxx;
    public static float mapyy;
    public boolean createStop;
    StringBuffer[] dialog;
    int error;
    private byte fisrt_paint;
    private Sprite flashSP;
    XConnection game;
    public int game_state;
    private byte help_state;
    byte iii;
    Image image_logo;
    Image image_logo_word;
    int loop_s;
    private byte ma;
    public int menu_state;
    private byte mt;
    public int prevGameState;
    public int prevMenuState;
    public int prevRunState;
    String errorString = "";
    boolean quitGame = false;
    int logo_c = 0;
    int temp_loop = 0;
    long starttime = 0;
    long timetaken = 0;
    byte battle_c = 9;
    String strTemp = "";
    int[] imageData = null;
    boolean bblack = false;
    public int temp_state = 0;
    int temp_gamestate = 0;
    private boolean haveSoundBeforeHideNotify = false;
    private boolean smsIsSetRun_state = false;
    int load_c = -1;
    GameRun gr = new GameRun(this);
    public SMSSender sender = SMSSender.i(this.gr);
    PointerKey pkey = new PointerKey(this);

    public MainCanvas(XConnection game) {
        this.game = game;
        this.gr.map.pkey = this.pkey;
        this.gr.pkey = this.pkey;
        this.sender.pkey = this.pkey;
        mainxx = Constants_H.WIDTH__ / 640.0f;
        mapxx = Constants_H.WIDTH__ / Constants_H.WIDTH;
        mainyy = Constants_H.HEIGHT__ / 360.0f;
        mapyy = Constants_H.HEIGHT__ / Constants_H.HEIGHT;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0034, code lost:
    
        dm.Ms.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (dm.Ms.keyRepeat == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        keyProcess();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        dm.Ms.i().runDelay();
        paint();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: main.MainCanvas.run():void");
    }

    public void createFlashImage() {
        if (this.flashSP == null) {
            this.flashSP = Ms.i().createSprite("data/fm", false);
        }
        this.mt = (byte) 0;
        this.ma = (byte) 0;
        this.load_c = 0;
    }

    private void setMenuFrame_C() {
        byte b = (byte) (this.mt + 1);
        this.mt = b;
        if (b > this.flashSP.action(this.load_c, this.ma, 1)) {
            this.mt = (byte) 0;
            byte b2 = (byte) (this.ma + 1);
            this.ma = b2;
            if (b2 >= this.flashSP.aLength(this.load_c)) {
                this.ma = (byte) 0;
                if (this.load_c == 0) {
                    this.load_c = 1;
                }
            }
        }
    }

    public void goMain_menu() {
        Sound.i().setMusicId(7);
        Sound.i().setMusic(false);
        this.game_state = 40;
        this.menu_state = 0;
        this.fisrt_paint = (byte) 0;
    }

    public void paint() {
        repaint();
        serviceRepaints();
    }

    public void initGraphics(Graphics _g) {
        g = _g;
        dg = DirectUtils.getDirectGraphics(_g);
        this.gr.initGraphics(g);
        Ui.i().initGraphics(g);
    }

    @Override // javax.microedition.lcdui.Canvas
    protected void paint(Graphics g2) {
        if (this.game_state != 0) {
            setScale(mainxx, mainyy);
        }
        this.keyxx = mainxx;
        this.keyyy = mainyy;
        initGraphics(g2);
        Ms.i();
        g2.setFont(Ms.font);
        g2.setClip(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
        switch (this.game_state) {
            case 0:
                paintMobileLogo();
                return;
            case 10:
                Ui.i().fillRect(0, 0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
                Ui.i().drawString(Constants_H.TXT_69, Constants_H.WIDTH_H_, Constants_H.HEIGHT_H_ - 25, 1 | 16, 0, 0);
                Ui.i().drawString(Constants_H.TXT_90, Constants_H.WIDTH_H_, Constants_H.HEIGHT_H_, 1 | 16, 5, 0);
                int HEIGHT_H = 4 | 32;
                Ui.i().drawString(Constants_H.PAUSE_TXT_22, 4, Constants_H.HEIGHT_, HEIGHT_H, 0, 0);
                Ui.i().drawString(Constants_H.PAUSE_TXT_23, Constants_H.WIDTH_ - 4, Constants_H.HEIGHT_, 8 | 32, 0, 0);
                return;
            case 11:
                Ui.i().drawImage(this.image_logo, 0, 0, 0);
                return;
            case 20:
                GameRun gameRun = this.gr;
                byte b = this.gr.time_count;
                int HEIGHT_H2 = Constants_H.HEIGHT_ - 38;
                gameRun.drawChangeMap(true, b, 30, HEIGHT_H2, Constants_H.WIDTH_ - 60);
                return;
            case 30:
                this.gr.paint_gameRun(g2);
                return;
            case 40:
                switch (this.menu_state) {
                    case 0:
                        Ui.i().fillRect(0, 0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
                        Ui.i().drawFrameOne(this.flashSP, this.flashSP.action(this.load_c, this.ma, 0), Constants_H.WIDTH_H_, Constants_H.HEIGHT_H_, 0);
                        setMenuFrame_C();
                        if (this.load_c == 1) {
                            g2.setClip(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
                            Ui.i().drawK0((Constants_H.WIDTH_H_ - 125) - 5, (Constants_H.HEIGHT_ - 25) - 6, 260, 31, 0);
                            if (this.gr.selectx == 2) {
                                Ui.i().drawVolume(Constants_H.WIDTH_H_ + 6 + 70, Constants_H.HEIGHT_ - 19, Sound.i().getVolume(), true);
                            }
                            Ui.i().drawString(this.gr.action_str[this.gr.selectx], Constants_H.WIDTH_H_, Constants_H.HEIGHT_ + 6, 1 | 32, 3, 1);
                            Ui.i().drawTriangle1(Constants_H.WIDTH_H_, Constants_H.HEIGHT_ - 13, 125, true, true);
                            Ui.i().drawYesNo(true, false);
                            return;
                        }
                        Ui.i().drawString(Constants_H.PAUSE_TXT_21, Constants_H.WIDTH_H_, Constants_H.HEIGHT_, 1 | 32, 1, 2);
                        return;
                    case 1:
                    case 3:
                    default:
                        return;
                    case 2:
                        Ui.i().drawKuang(0, Constants_H.HEIGHT_ - 87, Constants_H.WIDTH_, 58);
                        this.gr.showStringM(this.gr.gogoString, Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 87) + 2, 10, 3);
                        Ui.i().drawYesNo(true, true);
                        return;
                    case 4:
                        Ui.i().drawK0(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_, 2);
                        this.gr.drawHelpStr(g2, this.gr.about_a, this.gr.line_max, Constants_H.WIDTH_H_, 10, 1 | 16);
                        Ui.i().drawYesNo(false, true);
                        return;
                    case 5:
                        Ui.i().drawK0(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_, 2);
                        this.gr.setStringB("Pet Kingdom 5 - Rainbow#nDeveloper:#nHuayu Wireless#nCustomer Service Phone:#n010-88901665#nCustomer Service Email:#ngeekan@imy.cn", Constants_H.WIDTH_ - 50, 0);
                        this.gr.drawHelpStr(g2, this.gr.about_a, this.gr.line_max, Constants_H.WIDTH_H_, 10, 1 | 16);
                        Ui.i().drawYesNo(false, true);
                        return;
                }
            case Constants.JIFENGQUAN_G_RATIO /* 60 */:
            case 101:
            default:
                return;
            case 98:
                drawRectBG();
                Ui.i().drawK1(-5, Constants_H.HEIGHT_ - 75, Constants_H.WIDTH_ + 10, 75, 3);
                this.gr.showStringM(Constants_H.PAUSE_TXT_19, Constants_H.WIDTH_H_, (Constants_H.HEIGHT_ - 50) - 2, 9, 3);
                return;
        }
    }

    @Override // javax.microedition.lcdui.Canvas
    public void hideNotify() {
        hideNotifyMy();
    }

    public boolean checkHaveSoundBeforeHideNotify() {
        System.out.println("checkHaveSoundBeforeHideNotify haveSoundBeforeHideNotify= " + this.haveSoundBeforeHideNotify);
        return this.haveSoundBeforeHideNotify;
    }

    public void hideNotifyMy() {
        System.out.println("hideNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
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
    }

    @Override // javax.microedition.lcdui.Canvas
    public void showNotify() {
        showNotifyMy();
    }

    public void showNotifyMy() {
        System.out.println("showNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
        if (this.game_state == 98) {
            if (GameRun.run_state != -20 && GameRun.run_state != -21) {
                this.game_state = 30;
                System.out.println("Here?");
            }
            repaint();
            GameRun.run_state = 98;
            this.game_state = 98;
            System.out.println("Or here?");
            Sound.i().soundStop();
            return;
        }
        this.fisrt_paint = (byte) 0;
        System.out.println("It wouldn't be here, would it?");
    }

    public void setSmsIsSetRun_state(boolean state) {
        System.out.println("setSmsIsSetRun_state state= " + state);
        this.smsIsSetRun_state = state;
    }

    public boolean checkSmsRun_stateIsTrue() {
        System.out.println("checkSmsRun_stateIsTrue smsIsSetRun_state= " + this.smsIsSetRun_state);
        return this.smsIsSetRun_state;
    }

    public void doShowNotify() {
        this.game_state = this.temp_gamestate;
        if (!checkSmsRun_stateIsTrue()) {
            System.out.println("Here?");
            GameRun.run_state = this.temp_state;
        } else {
            setSmsIsSetRun_state(false);
            if (GameRun.run_state == 98) {
                System.out.println("Here??");
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

    @Override // javax.microedition.lcdui.Canvas
    public void pointerPressed(int x, int y) {
        if (!SMSSender.isWorking) {
            this.pkey.process(x, y);
        }
    }

    @Override // javax.microedition.lcdui.Canvas
    public void pointerReleased(int x, int y) {
        Ms.i().keyRelease();
    }

    @Override // javax.microedition.lcdui.Canvas
    protected final void keyPressed(int key) {
        if (SMSSender.isWorking) {
            System.out.println("");
        } else {
            Ms.keyRepeat = true;
            Ms.key = key;
        }
    }

    @Override // javax.microedition.lcdui.Canvas
    protected final void keyReleased(int key) {
        Ms.i().keyRelease();
    }

    private final void keyProcess() {
        this.error = 3;
        switch (this.game_state) {
            case 10:
                if (Ms.i().key_S1() || Ms.i().key_S2()) {
                    this.logo_c = 0;
                    Sound.i().setSoundON(Ms.i().key_S1());
                    Sound.i().setVolume(Ms.i().key_S1() ? 30 : 0);
                    Ms.i().keyRelease();
                    this.gr.goMAIN_MENU();
                }
                Ms.i().keyRelease();
                return;
            case 11:
                if (Ms.i().key_S1_Num5()) {
                    Ms.i().keyRelease();
                    this.gr.goMAIN_MENU();
                    return;
                }
                return;
            case 30:
                this.gr.key_gameRun();
                return;
            case 40:
                switch (this.menu_state) {
                    case 0:
                        Ms.i().keyRelease();
                        if (Ms.i().key_Num0()) {
                            this.ma = (byte) 0;
                            this.mt = (byte) 0;
                            this.load_c = 1;
                        } else if (this.load_c == 0) {
                            return;
                        }
                        if (Ms.i().key_S1_Num5()) {
                            switch (this.gr.selectx) {
                                case 0:
                                    this.gr.skyCheckRegFull(2);
                                    return;
                                case 1:
                                    this.gr.skyCheckRegFull(1);
                                    return;
                                case 2:
                                    Sound.i().keyVolume(0);
                                    Sound.i().setMusicForMenu(true);
                                    return;
                                case 3:
                                    goHELP_dialog(0);
                                    return;
                                case 4:
                                    Log.e("soars", "ABOUT_BUTTON");
                                    goABOUT();
                                    return;
                                case 5:
                                    Log.e("soars", "EXIT_BUTTON");
                                    this.quitGame = true;
                                    this.game.destroyApp(true);
                                    return;
                                default:
                                    return;
                            }
                        }
                        if (Ms.i().key_Left_Right()) {
                            this.gr.selectx = Ms.i().select(this.gr.selectx, this.gr.rmsOther[0] == -1 ? 1 : 0, this.gr.action_str.length - 1);
                            return;
                        }
                        return;
                    case 1:
                    case 3:
                    default:
                        return;
                    case 2:
                        if (Ms.i().key_S1_Num5()) {
                            newGame();
                        } else if (Ms.i().key_S2()) {
                            this.menu_state = 0;
                            this.gr.about_a = null;
                        }
                        Ms.i().keyRelease();
                        return;
                    case 4:
                        if (Ms.i().key_S2()) {
                            this.gr.about_a = null;
                            if (this.help_state == 1) {
                                this.game_state = 30;
                                this.gr.doPaint(0);
                                this.gr.goYouPAUSE(2);
                                this.gr.selectx = (byte) 1;
                                this.gr.selecty = (byte) 2;
                                this.gr.setPauseS(this.gr.selectx);
                            } else {
                                goMain_menu();
                                this.gr.select[0][0] = 3;
                            }
                        } else if (Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
                            this.gr.help_page = Ms.i().select(this.gr.help_page, 0, this.gr.page_max - 1);
                        }
                        Ms.i().keyRelease();
                        return;
                    case 5:
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
                        return;
                }
            case 98:
                if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                    System.out.println("Is the key processing done here?");
                    doShowNotify();
                }
                Ms.i().keyRelease();
                return;
            case 101:
                this.quitGame = true;
                Ms.i().keyRelease();
                return;
            default:
                return;
        }
    }

    private void goQuit() {
        this.game_state = 101;
    }

    public void drawRectBG() {
        Ui.i().fillRectB();
        int[] vertexX = {0, 10, 20, 10};
        int[] vertexY = {10, 0, 10, 20};
        for (byte j = 0; j < (Constants_H.HEIGHT_ / 20) + 1; j = (byte) (j + 1)) {
            for (byte i = 0; i < (Constants_H.WIDTH_ / 20) + 1; i = (byte) (i + 1)) {
                g.translate(i * 20, j * 20);
                dg.fillPolygon(vertexX, 0, vertexY, 0, 4, -11548673);
                g.translate(i * Constants_H.SMS_PAUSE, j * Constants_H.SMS_PAUSE);
            }
        }
    }

    protected void paintMobileLogo() {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        int HEIGHT_H = Constants_H.HEIGHT__ / 2;
        if (this.load_c < 0) {
            this.load_c = 0;
            return;
        }
        g.setClip(0, 0, WIDTH, HEIGHT);
        if (this.load_c >= 0 && this.load_c < 18) {
            g.setClip(0, 0, WIDTH, HEIGHT);
            Ui.i().fillRect(16777215, 0, 0, WIDTH, HEIGHT);
            if (this.load_c == 0) {
                GameRun.g = g;
                this.image_logo = Ms.i().createImage("qq/qqlogo");
            }
            g.drawImage(this.image_logo, WIDTH_H, HEIGHT_H, 1 | 2);
        } else if (this.load_c >= 19 && this.load_c < 37) {
            if (this.load_c == 19) {
                this.image_logo = null;
                this.image_logo = Ms.i().createImage("cwa");
            }
            g.setColor(0);
            Ui.i().fillRect(0, 0, 0, WIDTH, HEIGHT);
            g.drawImage(this.image_logo, WIDTH_H, HEIGHT_H, 1 | 2);
        } else if (this.load_c > 37) {
            this.image_logo = null;
            this.gr.popMenu = (byte) 0;
            this.game_state = 10;
            this.strTemp = Constants_H.TXT_69;
            game_init();
        }
        this.load_c++;
    }

    public void goHELP_dialog(int mode) {
        this.game_state = 40;
        this.menu_state = 4;
        this.gr.help_page = (byte) 0;
        this.logo_c = 0;
        this.help_state = (byte) mode;
        this.gr.line_max = (byte) 11;
        this.gr.setStringB("Game Help#nYou play as a pet trainer embarking on an adventure to solve the crisis of the country.#nOperation tips#nClick on the main quest icon: Main quest#nClick on the side quest icon: Side quest#nClick on the map icon: Game map#nClick on the screen to control the up, down, left and right movement#nThis version only supports landscape mode", Constants_H.WIDTH - 50, 0);
    }

    void goABOUT() {
        Log.e("soars", "goAbout");
        this.game_state = 40;
        this.menu_state = 5;
        this.gr.help_page = (byte) 0;
        this.logo_c = 0;
        this.gr.line_max = (byte) 11;
        this.help_state = (byte) 0;
        this.gr.setStringB("Pet Kingdom 5 - Rainbow#nDeveloper: Huayu Wireless#nCustomer Service Phone:#n010-88901665#nCustomer Service Email:#ngeekan@imy.cn", Constants_H.WIDTH - 50, 0);
    }

    private void newGame() {
        this.gr.data_init();
        Log.e("test", "new game " + Ms.i().rmsOptions(0, null, 5));
        if (Ms.i().rmsOptions(0, null, 5) == null) {
            this.gr.map.firstDrawMap = (byte) 0;
            Ms.i().rmsOptions(0, null, 3);
            this.gr.initRmsOther();
            Ms.i().rmsOptions(10, this.gr.rmsOther, 2);
            goGameLoading();
            this.gr.map.initSrcEffect(1);
        } else {
            this.gr.say(Constants_H.TXT_72, 0);
        }
        this.gr.about_a = null;
    }

    public void goGameLoading() {
        Log.e("loading", "Game State: GAME_LOADING");
        this.game_state = 20;
        this.gr.time_count = (byte) 0;
        this.flashSP = null;
        this.gr.map.loadDate_Rms();
        this.gr.loadRmsOther();
        this.gr.map.anole_temp = this.gr.map.anole_type;
        Map map = this.gr.map;
        Ms.i();
        map.anole_type = (byte) Ms.getRandom(5);
        this.gr.map.setAnole();
        paint();
        new CreateThread(this.gr, 0);
    }

    public void skyNewGame() {
        if (this.gr.rmsOther[0] == -1) {
            newGame();
        } else {
            this.menu_state = 2;
            this.gr.gogoString = Constants_H.TXT_68;
        }
    }

    public void skyContinueGame() {
        this.gr.data_init();
        System.gc();
        this.gr.map.firstDrawMap = (byte) 0;
        goGameLoading();
        this.pkey.stopMove();
    }
}
