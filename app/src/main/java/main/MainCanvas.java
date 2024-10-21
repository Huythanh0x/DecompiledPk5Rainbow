package main;

import com.android.Util.AndroidUtil;
import com.nokia.mid.ui.DirectUtils;
import dm.Ui;
import android.util.Log;
import dm.Sound;
import dm.Ms;
import javax.microedition.lcdui.Image;
import dm.Sprite;
import javax.microedition.lcdui.Graphics;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.FullCanvas;

public final class MainCanvas extends FullCanvas implements Runnable
{
    private static DirectGraphics dg;
    private static Graphics g;
    public static float mainxx;
    public static float mainyy;
    public static float mapxx;
    public static float mapyy;
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
    
    public MainCanvas(final XConnection game) {
        super();
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
        MainCanvas.mainxx = Constants_H.WIDTH__ / 640.0f;
        MainCanvas.mapxx = Constants_H.WIDTH__ / (float)Constants_H.WIDTH;
        MainCanvas.mainyy = Constants_H.HEIGHT__ / 360.0f;
        MainCanvas.mapyy = Constants_H.HEIGHT__ / (float)Constants_H.HEIGHT;
    }
    
    private final void game_init() {
        this.gr.initOffG();
    }
    
    private void goQuit() {
        this.game_state = 101;
    }
    
    private final void keyProcess() {
        this.error = 3;
        Label_0068: {
            switch (this.game_state) {
                case 98: {
                    if (Ms.i().key_Num0() || Ms.i().key_S1_Num5()) {
                        System.out.println("\u6309\u952e\u5904\u7406\u8fd9\u91cc\u6267\u884c\u5417");
                        this.doShowNotify();
                    }
                    Ms.i().keyRelease();
                    break;
                }
                case 10: {
                    if (Ms.i().key_S1() || Ms.i().key_S2()) {
                        this.logo_c = 0;
                        Sound.i().setSoundON(Ms.i().key_S1());
                        final Sound i = Sound.i();
                        int volume;
                        if (Ms.i().key_S1()) {
                            volume = 30;
                        }
                        else {
                            volume = 0;
                        }
                        i.setVolume(volume);
                        Ms.i().keyRelease();
                        this.gr.goMAIN_MENU();
                    }
                    Ms.i().keyRelease();
                    break;
                }
                case 30: {
                    this.gr.key_gameRun();
                    break;
                }
                case 11: {
                    if (Ms.i().key_S1_Num5()) {
                        Ms.i().keyRelease();
                        this.gr.goMAIN_MENU();
                        break;
                    }
                    break;
                }
                case 101: {
                    this.quitGame = true;
                    Ms.i().keyRelease();
                    break;
                }
                case 40: {
                    switch (this.menu_state) {
                        default: {
                            break Label_0068;
                        }
                        case 0: {
                            Ms.i().keyRelease();
                            if (Ms.i().key_Num0()) {
                                this.ma = 0;
                                this.mt = 0;
                                this.load_c = 1;
                            }
                            else if (this.load_c == 0) {
                                break Label_0068;
                            }
                            if (Ms.i().key_S1_Num5()) {
                                switch (this.gr.selectx) {
                                    default: {
                                        break Label_0068;
                                    }
                                    case 0: {
                                        this.gr.skyCheckRegFull(2);
                                        break Label_0068;
                                    }
                                    case 1: {
                                        this.gr.skyCheckRegFull(1);
                                        break Label_0068;
                                    }
                                    case 2: {
                                        Sound.i().keyVolume(0);
                                        Sound.i().setMusicForMenu(true);
                                        break Label_0068;
                                    }
                                    case 3: {
                                        this.goHELP_dialog(0);
                                        break Label_0068;
                                    }
                                    case 4: {
                                        Log.e("soars", "ABOUT_BUTTON");
                                        this.goABOUT();
                                        break Label_0068;
                                    }
                                    case 5: {
                                        Log.e("soars", "EXIT_BUTTON");
                                        this.quitGame = true;
                                        this.game.destroyApp(true);
                                        break Label_0068;
                                    }
                                }
                            }
                            else {
                                if (Ms.i().key_Left_Right()) {
                                    final GameRun gr = this.gr;
                                    final Ms j = Ms.i();
                                    final byte selectx = this.gr.selectx;
                                    int n;
                                    if (this.gr.rmsOther[0] == -1) {
                                        n = 1;
                                    }
                                    else {
                                        n = 0;
                                    }
                                    gr.selectx = j.select(selectx, n, this.gr.action_str.length - 1);
                                    break Label_0068;
                                }
                                break Label_0068;
                            }
                            break;
                        }
                        case 2: {
                            if (Ms.i().key_S1_Num5()) {
                                this.newGame();
                            }
                            else if (Ms.i().key_S2()) {
                                this.menu_state = 0;
                                this.gr.about_a = null;
                            }
                            Ms.i().keyRelease();
                            break Label_0068;
                        }
                        case 4: {
                            if (Ms.i().key_S2()) {
                                this.gr.about_a = null;
                                if (this.help_state == 1) {
                                    this.game_state = 30;
                                    this.gr.doPaint(0);
                                    this.gr.goYouPAUSE(2);
                                    this.gr.selectx = 1;
                                    this.gr.selecty = 2;
                                    this.gr.setPauseS(this.gr.selectx);
                                }
                                else {
                                    this.goMain_menu();
                                    this.gr.select[0][0] = 3;
                                }
                            }
                            else if (Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
                                this.gr.help_page = Ms.i().select(this.gr.help_page, 0, this.gr.page_max - 1);
                            }
                            Ms.i().keyRelease();
                            break Label_0068;
                        }
                        case 5: {
                            if (Ms.i().key_S2()) {
                                Ms.i().keyRelease();
                                this.gr.about_a = null;
                                Log.e("soars", "gr.about_a dfd");
                                this.goMain_menu();
                            }
                            else if (Ms.i().key_Up_Down() || Ms.i().key_Left_Right()) {
                                this.gr.help_page = Ms.i().select(this.gr.help_page, 0, this.gr.page_max - 1);
                            }
                            Log.e("soars", "s.i().key_Up_Down()||Ms.i().key");
                            Ms.i().keyRelease();
                            break Label_0068;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    private void newGame() {
        this.gr.data_init();
        Log.e("test", "new game " + Ms.i().rmsOptions(0, null, 5));
        if (Ms.i().rmsOptions(0, null, 5) == null) {
            this.gr.map.firstDrawMap = 0;
            Ms.i().rmsOptions(0, null, 3);
            this.gr.initRmsOther();
            Ms.i().rmsOptions(10, this.gr.rmsOther, 2);
            this.goGameLoading();
            this.gr.map.initSrcEffect(1);
        }
        else {
            this.gr.say("\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff01", 0);
        }
        this.gr.about_a = null;
    }
    
    private void setMenuFrame_C() {
        final byte mt = (byte)(this.mt + 1);
        this.mt = mt;
        if (mt > this.flashSP.action(this.load_c, this.ma, 1)) {
            this.mt = 0;
            if (++this.ma >= this.flashSP.aLength(this.load_c)) {
                this.ma = 0;
                if (this.load_c == 0) {
                    this.load_c = 1;
                }
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
        if (this.flashSP == null) {
            this.flashSP = Ms.i().createSprite("data/fm", false);
        }
        this.mt = 0;
        this.ma = 0;
        this.load_c = 0;
    }
    
    public void doShowNotify() {
        this.game_state = this.temp_gamestate;
        if (!this.checkSmsRun_stateIsTrue()) {
            System.out.println("\u5728\u8fd9\uff1f");
            GameRun.run_state = this.temp_state;
        }
        else {
            this.setSmsIsSetRun_state(false);
            if (GameRun.run_state == 98) {
                System.out.println("\u5728\u8fd9\uff1f\uff1f");
                GameRun.run_state = this.temp_state;
            }
        }
        if (this.checkHaveSoundBeforeHideNotify()) {
            Sound.i().setMusic(true);
            Sound.i().setSoundON(true);
            Sound.i().soundPlay();
            Sound.i().soundStart();
        }
    }
    
    public void drawRectBG() {
        Ui.i().fillRectB();
        final int[] array = { 0, 10, 20, 10 };
        final int[] array2 = { 10, 0, 10, 20 };
        for (int i = 0; i < 360 / 20 + 1; i = (byte)(i + 1)) {
            for (int j = 0; j < 640 / 20 + 1; j = (byte)(j + 1)) {
                MainCanvas.g.translate(j * 20, i * 20);
                MainCanvas.dg.fillPolygon(array, 0, array2, 0, 4, -11548673);
                MainCanvas.g.translate(j * -20, i * -20);
            }
        }
        final int[] array3 = (int[])null;
        final int[] array4 = (int[])null;
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
        this.gr.setStringB("\u5ba0\u7269\u738b\u56fd5-\u5f69\u8679#n\u5f00\u53d1\u5546\uff1a\u534e\u5a31\u65e0\u7ebf#n\u5ba2\u670d\u7535\u8bdd\uff1a#n010-88901665#n\u5ba2\u670dEmail:#ngeekan@imy.cn", Constants_H.WIDTH - 50, 0);
    }
    
    public void goGameLoading() {
        Log.e("loading", "\u6e38\u620f\u72b6\u6001\uff1aGAME_LOADING");
        this.game_state = 20;
        this.gr.time_count = 0;
        this.flashSP = null;
        this.gr.map.loadDate_Rms();
        this.gr.loadRmsOther();
        this.gr.map.anole_temp = this.gr.map.anole_type;
        final Map map = this.gr.map;
        Ms.i();
        map.anole_type = (byte)Ms.getRandom(5);
        this.gr.map.setAnole();
        this.paint();
        new CreateThread(this.gr, 0);
    }
    
    void goHELP_dialog(final int n) {
        this.game_state = 40;
        this.menu_state = 4;
        this.gr.help_page = 0;
        this.logo_c = 0;
        this.help_state = (byte)n;
        this.gr.line_max = 11;
        this.gr.setStringB("\u6e38\u620f\u5e2e\u52a9#n\u73a9\u5bb6\u626e\u6f14\u4e00\u540d\u5ba0\u7269\u8bad\u7ec3\u5e08\uff0c\u4e3a\u4e86\u89e3\u51b3\u56fd\u5bb6\u7684\u5371\u673a\u800c\u8e0f\u4e0a\u4e86\u5192\u9669\u4e4b\u65c5\u3002#n\u64cd\u4f5c\u63d0\u793a#n\u70b9\u51fb\u4e3b\u7ebf\u4efb\u52a1\u56fe\u6807\uff1a\u4e3b\u7ebf\u4efb\u52a1#n\u70b9\u51fb\u652f\u7ebf\u4efb\u52a1\u56fe\u6807\uff1a\u652f\u7ebf\u4efb\u52a1#n\u70b9\u51fb\u5730\u56fe\u56fe\u6807\uff1a\u6e38\u620f\u5730\u56fe#n\u70b9\u51fb\u5c4f\u5e55\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8#n\u672c\u7248\u672c\u53ea\u652f\u6301\u6a2a\u5c4f\u6e38\u620f", Constants_H.WIDTH - 50, 0);
    }
    
    void goMain_menu() {
        Sound.i().setMusicId(7);
        Sound.i().setMusic(false);
        this.game_state = 40;
        this.menu_state = 0;
        this.fisrt_paint = 0;
    }
    
    @Override
    public void hideNotify() {
        this.hideNotifyMy();
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
    
    public void initGraphics(final Graphics g) {
        MainCanvas.g = g;
        MainCanvas.dg = DirectUtils.getDirectGraphics(g);
        this.gr.initGraphics(MainCanvas.g);
        Ui.i().initGraphics(MainCanvas.g);
    }
    
    @Override
    protected final void keyPressed(final int key) {
        if (SMSSender.isWorking) {
            System.out.println("");
        }
        else {
            Ms.keyRepeat = true;
            Ms.key = key;
        }
    }
    
    @Override
    protected final void keyReleased(final int n) {
        Ms.i().keyRelease();
    }
    
    public void paint() {
        this.repaint();
        this.serviceRepaints();
    }
    
    @Override
    protected void paint(final Graphics graphics) {
        if (this.game_state != 0) {
            this.setScale(MainCanvas.mainxx, MainCanvas.mainyy);
        }
        this.keyxx = MainCanvas.mainxx;
        this.keyyy = MainCanvas.mainyy;
        this.initGraphics(graphics);
        Ms.i();
        graphics.setFont(Ms.font);
        graphics.setClip(0, 0, 640, 360);
        Label_0144: {
            switch (this.game_state) {
                case 98: {
                    this.drawRectBG();
                    Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
                    this.gr.showStringM("\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002", 320, 360 - 50 - 2, 9, 3);
                    break;
                }
                case 30: {
                    this.gr.paint_gameRun(graphics);
                    break;
                }
                case 0: {
                    this.paintMobileLogo();
                    break;
                }
                case 10: {
                    Ui.i().fillRect(0, 0, 0, 640, 360);
                    Ui.i().drawString("\u662f\u5426\u6253\u5f00\u97f3\u4e50?", 320, 180 - 25, 0x1 | 0x10, 0, 0);
                    Ui.i().drawString("\uff08\u5173\u95ed\u58f0\u97f3\u6e38\u620f\u66f4\u6d41\u7545\uff09", 320, 180, 0x1 | 0x10, 5, 0);
                    Ui.i().drawString("\u662f", 4, 360, 0x4 | 0x20, 0, 0);
                    Ui.i().drawString("\u5426", 640 - 4, 360, 0x8 | 0x20, 0, 0);
                    break;
                }
                case 20: {
                    this.gr.drawChangeMap(true, this.gr.time_count, 30, 360 - 38, 640 - 60);
                    break;
                }
                case 11: {
                    Ui.i().drawImage(this.image_logo, 0, 0, 0);
                    break;
                }
                case 40: {
                    switch (this.menu_state) {
                        default: {
                            break Label_0144;
                        }
                        case 0: {
                            Ui.i().fillRect(0, 0, 0, 640, 360);
                            Ui.i().drawFrameOne(this.flashSP, this.flashSP.action(this.load_c, (int)this.ma, 0), 320, 180, 0);
                            this.setMenuFrame_C();
                            if (this.load_c == 1) {
                                graphics.setClip(0, 0, 640, 360);
                                Ui.i().drawK0(320 - 125 - 5, 360 - 25 - 6, 260, 31, 0);
                                if (this.gr.selectx == 2) {
                                    Ui.i().drawVolume(320 + 6 + 70, 360 - 19, Sound.i().getVolume(), true);
                                }
                                Ui.i().drawString(this.gr.action_str[this.gr.selectx], 320, 360 + 6, 0x1 | 0x20, 3, 1);
                                Ui.i().drawTriangle1(320, 360 - 13, 125, true, true);
                                Ui.i().drawYesNo(true, false);
                                break Label_0144;
                            }
                            Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55\u8df3\u8fc7", 320, 360, 0x1 | 0x20, 1, 2);
                            break Label_0144;
                        }
                        case 2: {
                            Ui.i().drawKuang(0, 360 - 87, 640, 58);
                            this.gr.showStringM(this.gr.gogoString, 320, 360 - 87 + 2, 10, 3);
                            Ui.i().drawYesNo(true, true);
                            break Label_0144;
                        }
                        case 4: {
                            Ui.i().drawK0(0, 0, 640, 360, 2);
                            this.gr.drawHelpStr(graphics, this.gr.about_a, this.gr.line_max, 320, 10, 0x1 | 0x10);
                            Ui.i().drawYesNo(false, true);
                            break Label_0144;
                        }
                        case 5: {
                            Ui.i().drawK0(0, 0, 640, 360, 2);
                            this.gr.setStringB("\u5ba0\u7269\u738b\u56fd5-\u5f69\u8679#n\u5f00\u53d1\u5546\uff1a#n\u534e\u5a31\u65e0\u7ebf#n\u5ba2\u670d\u7535\u8bdd\uff1a#n010-88901665#n\u5ba2\u670dEmail:#ngeekan@imy.cn", 640 - 50, 0);
                            this.gr.drawHelpStr(graphics, this.gr.about_a, this.gr.line_max, 320, 10, 0x1 | 0x10);
                            Ui.i().drawYesNo(false, true);
                            break Label_0144;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    protected void paintMobileLogo() {
        final int width__ = Constants_H.WIDTH__;
        final int height__ = Constants_H.HEIGHT__;
        final int n = Constants_H.WIDTH__ / 2;
        final int n2 = Constants_H.HEIGHT__ / 2;
        if (this.load_c < 0) {
            this.load_c = 0;
        }
        else {
            MainCanvas.g.setClip(0, 0, width__, height__);
            if (this.load_c >= 0 && this.load_c < 18) {
                MainCanvas.g.setClip(0, 0, width__, height__);
                Ui.i().fillRect(16777215, 0, 0, width__, height__);
                if (this.load_c == 0) {
                    GameRun.g = MainCanvas.g;
                    this.image_logo = Ms.i().createImage("qq/qqlogo");
                }
                MainCanvas.g.drawImage(this.image_logo, n, n2, 0x1 | 0x2);
            }
            else if (this.load_c >= 19 && this.load_c < 37) {
                if (this.load_c == 19) {
                    this.image_logo = null;
                    this.image_logo = Ms.i().createImage("cwa");
                }
                MainCanvas.g.setColor(0);
                Ui.i().fillRect(0, 0, 0, width__, height__);
                MainCanvas.g.drawImage(this.image_logo, n, n2, 0x1 | 0x2);
            }
            else if (this.load_c > 37) {
                this.image_logo = null;
                this.gr.popMenu = 0;
                this.game_state = 10;
                this.strTemp = "\u662f\u5426\u6253\u5f00\u97f3\u4e50?";
                this.game_init();
            }
            ++this.load_c;
        }
    }
    
    public void pointerPressed(final int n, final int n2) {
        if (!SMSSender.isWorking) {
            this.pkey.process(n, n2);
        }
    }
    
    public void pointerReleased(final int n, final int n2) {
        Ms.i().keyRelease();
    }
    
    @Override
    public void run() {
        while (true) {
        Label_0329:
            while (true) {
                Label_0218: {
                    Label_0180: {
                        while (true) {
                            try {
                                while (!this.quitGame) {
                                    this.starttime = System.currentTimeMillis();
                                    if (!SMSSender.isWorking) {
                                        AndroidUtil.cv.block();
                                        AndroidUtil.cv.close();
                                        if (this.game_state != 98) {
                                            Sound.i().soundPlay();
                                        }
                                        switch (this.game_state) {
                                            default: {
                                                Ms.i();
                                                if (Ms.keyRepeat) {
                                                    this.keyProcess();
                                                }
                                                Ms.i().runDelay();
                                                this.paint();
                                                break;
                                            }
                                            case 30: {
                                                break Label_0180;
                                            }
                                            case 20: {
                                                break Label_0218;
                                            }
                                        }
                                    }
                                    this.timetaken = System.currentTimeMillis() - this.starttime;
                                    if (Ms.i().getSleep() <= 0) {
                                        break Label_0329;
                                    }
                                    Thread.sleep(Ms.i().getSleep());
                                    Ms.i().sleep(0);
                                }
                                this.game.destroyApp(true);
                                return;
                            }
                            catch (final Exception ex) {
                                ex.printStackTrace();
                                while (!Ms.i().key_Num0()) {}
                                continue;
                            }
                            break;
                        }
                    }
                    this.gr.run_gameRun();
                    if (!this.gr.runPauseIco()) {
                        this.pkey.runMove();
                        continue;
                    }
                    this.pkey.isGo = false;
                    continue;
                }
                if (this.gr.createOver == -1) {
                    this.gr.time_count = 60;
                    this.paint();
                }
                else if (this.gr.time_count < 60) {
                    final GameRun gr = this.gr;
                    ++gr.time_count;
                }
                if (this.gr.threadType == 0 && this.gr.createOver == -1 && this.gr.time_count == 60) {
                    Ms.i().rmsOptions(0, null, 4);
                    this.gr.start();
                    continue;
                }
                continue;
            }
            long n;
            if ((n = 60L - this.timetaken) < 10L) {
                n = 10L;
            }
            Thread.sleep(n);
        }
    }
    
    public void setSmsIsSetRun_state(final boolean b) {
        System.out.println("setSmsIsSetRun_state state= " + b);
        this.smsIsSetRun_state = b;
    }
    
    @Override
    public void showNotify() {
        this.showNotifyMy();
    }
    
    public void showNotifyMy() {
        System.out.println("showNotifyMy() run_state= " + GameRun.run_state + " game_state= " + this.game_state);
        if (this.game_state == 98) {
            if (GameRun.run_state != -20 && GameRun.run_state != -21) {
                this.game_state = 30;
                System.out.println("\u5728\u8fd9?");
            }
            this.repaint();
            GameRun.run_state = 98;
            this.game_state = 98;
            System.out.println("\u8fd8\u662f\u5728\u8fd9?");
            Sound.i().soundStop();
        }
        else {
            this.fisrt_paint = 0;
            System.out.println("\u4e0d\u4f1a\u5728\u8fd9\u5427\uff1f");
        }
    }
    
    public void skyContinueGame() {
        this.gr.data_init();
        System.gc();
        this.gr.map.firstDrawMap = 0;
        this.goGameLoading();
        this.pkey.stopMove();
    }
    
    public void skyNewGame() {
        if (this.gr.rmsOther[0] == -1) {
            this.newGame();
        }
        else {
            this.menu_state = 2;
            this.gr.gogoString = "\u8fd9\u5c06\u6e05\u9664\u60a8\u4e4b\u524d\u7684\u6240\u6709\u8bb0\u5f55\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
        }
    }
}
