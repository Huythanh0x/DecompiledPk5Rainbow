/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.nokia.mid.ui.DirectGraphics
 *  com.nokia.mid.ui.DirectUtils
 *  com.nokia.mid.ui.FullCanvas
 *  dm.Ms
 *  dm.Sound
 *  dm.Sprite
 *  dm.Ui
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  main.Constants_H
 *  main.CreateThread
 *  main.GameRun
 *  main.Map
 *  main.PointerKey
 *  main.SMSSender
 *  main.XConnection
 */
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
import main.Constants_H;
import main.CreateThread;
import main.GameRun;
import main.Map;
import main.PointerKey;
import main.SMSSender;
import main.XConnection;

public final class MainCanvas
extends FullCanvas
implements Runnable {
    private static DirectGraphics dg;
    private static Graphics g;
    public static float mainxx;
    public static float mainyy;
    public static float mapxx;
    public static float mapyy;
    byte battle_c = (byte)9;
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

    public MainCanvas(XConnection xConnection) {
        this.game = xConnection;
        this.gr = new GameRun(this);
        this.sender = SMSSender.i((GameRun)this.gr);
        this.gr.map.pkey = this.pkey = new PointerKey(this);
        this.gr.pkey = this.pkey;
        this.sender.pkey = this.pkey;
        mainxx = (float)Constants_H.WIDTH__ / 640.0f;
        mapxx = (float)Constants_H.WIDTH__ / (float)Constants_H.WIDTH;
        mainyy = (float)Constants_H.HEIGHT__ / 360.0f;
        mapyy = (float)Constants_H.HEIGHT__ / (float)Constants_H.HEIGHT;
    }

    private final void game_init() {
        this.gr.initOffG();
    }

    private void goQuit() {
        this.game_state = 101;
    }

    /*
     * Exception decompiling
     */
    private final void keyProcess() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    private void newGame() {
        this.gr.data_init();
        Log.e((String)"test", (String)("new game " + Ms.i().rmsOptions(0, null, 5)));
        if (Ms.i().rmsOptions(0, null, 5) == null) {
            this.gr.map.firstDrawMap = 0;
            Ms.i().rmsOptions(0, null, 3);
            this.gr.initRmsOther();
            Ms.i().rmsOptions(10, this.gr.rmsOther, 2);
            this.goGameLoading();
            this.gr.map.initSrcEffect(1);
lbl14:
            // 2 sources

            while (true) {
                this.gr.about_a = null;
                return;
            }
        }
        this.gr.say("\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff01", 0);
        ** while (true)
    }

    private void setMenuFrame_C() {
        byte by;
        this.mt = by = (byte)(this.mt + 1);
        if (by > this.flashSP.action(this.load_c, (int)this.ma, 1)) {
            this.mt = 0;
            this.ma = by = (byte)(this.ma + 1);
            if (by >= this.flashSP.aLength(this.load_c)) {
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

    /*
     * Unable to fully structure code
     */
    public void doShowNotify() {
        this.game_state = this.temp_gamestate;
        if (!this.checkSmsRun_stateIsTrue()) {
            System.out.println("\u5728\u8fd9\uff1f");
            GameRun.run_state = this.temp_state;
lbl5:
            // 3 sources

            while (true) {
                if (this.checkHaveSoundBeforeHideNotify()) {
                    Sound.i().setMusic(true);
                    Sound.i().setSoundON(true);
                    Sound.i().soundPlay();
                    Sound.i().soundStart();
                }
                return;
            }
        }
        this.setSmsIsSetRun_state(false);
        if (GameRun.run_state != 98) ** GOTO lbl5
        System.out.println("\u5728\u8fd9\uff1f\uff1f");
        GameRun.run_state = this.temp_state;
        ** while (true)
    }

    public void drawRectBG() {
        Ui.i().fillRectB();
        int[] nArray = new int[4];
        nArray[1] = 10;
        nArray[2] = 20;
        nArray[3] = 10;
        int[] nArray2 = new int[4];
        nArray2[0] = 10;
        nArray2[2] = 10;
        nArray2[3] = 20;
        int n = 0;
        block0: while (true) {
            if (n >= 360 / 20 + 1) {
                nArray = null;
                nArray = null;
                return;
            }
            int n2 = 0;
            while (true) {
                if (n2 >= 640 / 20 + 1) {
                    n = (byte)(n + 1);
                    continue block0;
                }
                g.translate(n2 * 20, n * 20);
                dg.fillPolygon(nArray, 0, nArray2, 0, 4, -11548673);
                g.translate(n2 * -20, n * -20);
                n2 = (byte)(n2 + 1);
            }
            break;
        }
    }

    public final void game_start() {
        new Thread(this).start();
    }

    public final void game_stop() {
        Ms.i().rmsOptions(0, null, 4);
        Sound.i().soundStop();
    }

    void goABOUT() {
        Log.e((String)"soars", (String)"goAbout");
        this.game_state = 40;
        this.menu_state = 5;
        this.gr.help_page = 0;
        this.logo_c = 0;
        this.gr.line_max = (byte)11;
        this.help_state = 0;
        this.gr.setStringB("\u5ba0\u7269\u738b\u56fd5-\u5f69\u8679#n\u5f00\u53d1\u5546\uff1a\u534e\u5a31\u65e0\u7ebf#n\u5ba2\u670d\u7535\u8bdd\uff1a#n010-88901665#n\u5ba2\u670dEmail:#ngeekan@imy.cn", Constants_H.WIDTH - 50, 0);
    }

    public void goGameLoading() {
        Log.e((String)"loading", (String)"\u6e38\u620f\u72b6\u6001\uff1aGAME_LOADING");
        this.game_state = 20;
        this.gr.time_count = 0;
        this.flashSP = null;
        this.gr.map.loadDate_Rms();
        this.gr.loadRmsOther();
        this.gr.map.anole_temp = this.gr.map.anole_type;
        Map map = this.gr.map;
        Ms.i();
        map.anole_type = (byte)Ms.getRandom((int)5);
        this.gr.map.setAnole();
        this.paint();
        new CreateThread(this.gr, 0);
    }

    void goHELP_dialog(int n) {
        this.game_state = 40;
        this.menu_state = 4;
        this.gr.help_page = 0;
        this.logo_c = 0;
        this.help_state = (byte)n;
        this.gr.line_max = (byte)11;
        this.gr.setStringB("\u6e38\u620f\u5e2e\u52a9#n\u73a9\u5bb6\u626e\u6f14\u4e00\u540d\u5ba0\u7269\u8bad\u7ec3\u5e08\uff0c\u4e3a\u4e86\u89e3\u51b3\u56fd\u5bb6\u7684\u5371\u673a\u800c\u8e0f\u4e0a\u4e86\u5192\u9669\u4e4b\u65c5\u3002#n\u64cd\u4f5c\u63d0\u793a#n\u70b9\u51fb\u4e3b\u7ebf\u4efb\u52a1\u56fe\u6807\uff1a\u4e3b\u7ebf\u4efb\u52a1#n\u70b9\u51fb\u652f\u7ebf\u4efb\u52a1\u56fe\u6807\uff1a\u652f\u7ebf\u4efb\u52a1#n\u70b9\u51fb\u5730\u56fe\u56fe\u6807\uff1a\u6e38\u620f\u5730\u56fe#n\u70b9\u51fb\u5c4f\u5e55\u63a7\u5236\u4e0a\u4e0b\u5de6\u53f3\u79fb\u52a8#n\u672c\u7248\u672c\u53ea\u652f\u6301\u6a2a\u5c4f\u6e38\u620f", Constants_H.WIDTH - 50, 0);
    }

    void goMain_menu() {
        Sound.i().setMusicId(7);
        Sound.i().setMusic(false);
        this.game_state = 40;
        this.menu_state = 0;
        this.fisrt_paint = 0;
    }

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

    public void initGraphics(Graphics graphics) {
        g = graphics;
        dg = DirectUtils.getDirectGraphics((Graphics)graphics);
        this.gr.initGraphics(g);
        Ui.i().initGraphics(g);
    }

    /*
     * Enabled force condition propagation
     */
    protected final void keyPressed(int n) {
        if (SMSSender.isWorking) {
            System.out.println("");
            return;
        }
        Ms.keyRepeat = true;
        Ms.key = n;
    }

    protected final void keyReleased(int n) {
        Ms.i().keyRelease();
    }

    public void paint() {
        this.repaint();
        this.serviceRepaints();
    }

    /*
     * Unable to fully structure code
     */
    protected void paint(Graphics var1_1) {
        if (this.game_state != 0) {
            this.setScale(MainCanvas.mainxx, MainCanvas.mainyy);
        }
        this.keyxx = MainCanvas.mainxx;
        this.keyyy = MainCanvas.mainyy;
        this.initGraphics(var1_1);
        Ms.i();
        var1_1.setFont(Ms.font);
        var1_1.setClip(0, 0, 640, 360);
        switch (this.game_state) lbl-1000:
        // 7 sources

        {
            default: lbl-1000:
            // 7 sources

            {
                return;
            }
            case 98: {
                this.drawRectBG();
                Ui.i().drawK1(-5, 360 - 75, 640 + 10, 75, 3);
                this.gr.showStringM("\u6e38\u620f\u6682\u505c\uff0c\u70b9\u51fb\u5c4f\u5e55\u8fd4\u56de\u3002", 320, 360 - 50 - 2, 9, 3);
                ** GOTO lbl-1000
            }
            case 30: {
                this.gr.paint_gameRun(var1_1);
                ** GOTO lbl-1000
            }
            case 0: {
                this.paintMobileLogo();
                ** GOTO lbl-1000
            }
            case 10: {
                Ui.i().fillRect(0, 0, 0, 640, 360);
                Ui.i().drawString("\u662f\u5426\u6253\u5f00\u97f3\u4e50?", 320, 180 - 25, 1 | 16, 0, 0);
                Ui.i().drawString("\uff08\u5173\u95ed\u58f0\u97f3\u6e38\u620f\u66f4\u6d41\u7545\uff09", 320, 180, 1 | 16, 5, 0);
                Ui.i().drawString("\u662f", 4, 360, 4 | 32, 0, 0);
                Ui.i().drawString("\u5426", 640 - 4, 360, 8 | 32, 0, 0);
                ** GOTO lbl-1000
            }
            case 20: {
                this.gr.drawChangeMap(true, (int)this.gr.time_count, 30, 360 - 38, 640 - 60);
                ** GOTO lbl-1000
            }
            case 11: {
                Ui.i().drawImage(this.image_logo, 0, 0, 0);
                ** GOTO lbl-1000
            }
            case 40: 
        }
        switch (this.menu_state) {
            default: {
                ** GOTO lbl-1000
            }
            case 0: {
                Ui.i().fillRect(0, 0, 0, 640, 360);
                Ui.i().drawFrameOne(this.flashSP, this.flashSP.action(this.load_c, (int)this.ma, 0), 320, 180, 0);
                this.setMenuFrame_C();
                if (this.load_c != 1) ** GOTO lbl55
                var1_1.setClip(0, 0, 640, 360);
                Ui.i().drawK0(320 - 125 - 5, 360 - 25 - 6, 260, 31, 0);
                if (this.gr.selectx == 2) {
                    Ui.i().drawVolume(320 + 6 + 70, 360 - 19, (int)Sound.i().getVolume(), true);
                }
                Ui.i().drawString(this.gr.action_str[this.gr.selectx], 320, 360 + 6, 1 | 32, 3, 1);
                Ui.i().drawTriangle1(320, 360 - 13, 125, true, true);
                Ui.i().drawYesNo(true, false);
                ** GOTO lbl-1000
lbl55:
                // 1 sources

                Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55\u8df3\u8fc7", 320, 360, 1 | 32, 1, 2);
                ** GOTO lbl-1000
            }
            case 2: {
                Ui.i().drawKuang(0, 360 - 87, 640, 58);
                this.gr.showStringM(this.gr.gogoString, 320, 360 - 87 + 2, 10, 3);
                Ui.i().drawYesNo(true, true);
                ** GOTO lbl-1000
            }
            case 4: {
                Ui.i().drawK0(0, 0, 640, 360, 2);
                this.gr.drawHelpStr(var1_1, this.gr.about_a, (int)this.gr.line_max, 320, 10, 1 | 16);
                Ui.i().drawYesNo(false, true);
                ** GOTO lbl-1000
            }
            case 5: 
        }
        Ui.i().drawK0(0, 0, 640, 360, 2);
        this.gr.setStringB("\u5ba0\u7269\u738b\u56fd5-\u5f69\u8679#n\u5f00\u53d1\u5546\uff1a#n\u534e\u5a31\u65e0\u7ebf#n\u5ba2\u670d\u7535\u8bdd\uff1a#n010-88901665#n\u5ba2\u670dEmail:#ngeekan@imy.cn", 640 - 50, 0);
        this.gr.drawHelpStr(var1_1, this.gr.about_a, (int)this.gr.line_max, 320, 10, 1 | 16);
        Ui.i().drawYesNo(false, true);
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    protected void paintMobileLogo() {
        block6: {
            var3_1 = Constants_H.WIDTH__;
            var2_2 = Constants_H.HEIGHT__;
            var1_3 = Constants_H.WIDTH__ / 2;
            var4_4 = Constants_H.HEIGHT__ / 2;
            if (this.load_c < 0) {
                this.load_c = 0;
lbl7:
                // 2 sources

                return;
            }
            MainCanvas.g.setClip(0, 0, var3_1, var2_2);
            if (this.load_c >= 0 && this.load_c < 18) {
                MainCanvas.g.setClip(0, 0, var3_1, var2_2);
                Ui.i().fillRect(0xFFFFFF, 0, 0, var3_1, var2_2);
                if (this.load_c == 0) {
                    GameRun.g = MainCanvas.g;
                    this.image_logo = Ms.i().createImage("qq/qqlogo");
                }
                MainCanvas.g.drawImage(this.image_logo, var1_3, var4_4, 1 | 2);
lbl17:
                // 4 sources

                while (true) {
                    ++this.load_c;
                    ** continue;
                    break;
                }
            }
            if (this.load_c < 19 || this.load_c >= 37) break block6;
            if (this.load_c == 19) {
                this.image_logo = null;
                this.image_logo = Ms.i().createImage("cwa");
            }
            MainCanvas.g.setColor(0);
            Ui.i().fillRect(0, 0, 0, var3_1, var2_2);
            MainCanvas.g.drawImage(this.image_logo, var1_3, var4_4, 1 | 2);
            ** GOTO lbl17
        }
        if (this.load_c <= 37) ** GOTO lbl17
        this.image_logo = null;
        this.gr.popMenu = 0;
        this.game_state = 10;
        this.strTemp = "\u662f\u5426\u6253\u5f00\u97f3\u4e50?";
        this.game_init();
        ** while (true)
    }

    /*
     * Enabled force condition propagation
     */
    public void pointerPressed(int n, int n2) {
        if (SMSSender.isWorking) {
            return;
        }
        this.pkey.process(n, n2);
    }

    public void pointerReleased(int n, int n2) {
        Ms.i().keyRelease();
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.IllegalStateException: Backjump on non jumping statement @NONE, blocks:[3, 5] lbl31 : TryStatement: try { 2[TRYBLOCK]
         * 
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:44)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner$1.call(Cleaner.java:22)
         *     at org.benf.cfr.reader.util.graph.GraphVisitorDFS.process(GraphVisitorDFS.java:68)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Cleaner.removeUnreachableCode(Cleaner.java:54)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:550)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:111)
         *     at java.base/java.lang.Thread.run(Thread.java:840)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void setSmsIsSetRun_state(boolean bl) {
        System.out.println("setSmsIsSetRun_state state= " + bl);
        this.smsIsSetRun_state = bl;
    }

    public void showNotify() {
        this.showNotifyMy();
    }

    /*
     * Enabled force condition propagation
     */
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
            return;
        }
        this.fisrt_paint = 0;
        System.out.println("\u4e0d\u4f1a\u5728\u8fd9\u5427\uff1f");
    }

    public void skyContinueGame() {
        this.gr.data_init();
        System.gc();
        this.gr.map.firstDrawMap = 0;
        this.goGameLoading();
        this.pkey.stopMove();
    }

    /*
     * Enabled force condition propagation
     */
    public void skyNewGame() {
        if (this.gr.rmsOther[0] == -1) {
            this.newGame();
            return;
        }
        this.menu_state = 2;
        this.gr.gogoString = "\u8fd9\u5c06\u6e05\u9664\u60a8\u4e4b\u524d\u7684\u6240\u6709\u8bb0\u5f55\uff0c\u662f\u5426\u7ee7\u7eed\uff1f";
    }
}
