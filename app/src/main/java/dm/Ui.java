package dm;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;
import main.Key_H;

/* loaded from: classes.dex */
/**
 * The Ui class is responsible for managing and rendering various UI components in the application.
 * It provides methods to draw images, shapes, text, and other UI elements on the screen.
 * 
 * <h2>Dependencies:</h2>
 * <ul>
 *   <li>DirectGraphics</li>
 *   <li>Graphics</li>
 *   <li>Image</li>
 *   <li>Sprite</li>
 *   <li>Ms</li>
 *   <li>Constants_H</li>
 * </ul>
 * 
 * <h2>Usage:</h2>
 * <p>To use the Ui class, follow these steps:</p>
 * <ol>
 *   <li>Initialize the Ui instance using the constructor or the static method {@link #i()}.</li>
 *   <li>Initialize the graphics context using {@link #initGraphics(Graphics)}.</li>
 *   <li>Use the various drawing methods to render UI components on the screen.</li>
 * </ol>
 * 
 * <h2>Methods:</h2>
 * <ul>
 *   <li>{@link #initGraphics(Graphics)}: Initializes the graphics context.</li>
 *   <li>{@link #drawRegion(Image, int, int, int, int, int, int, int, int, Graphics)}: Draws a region of an image.</li>
 *   <li>{@link #drawModuleOne(Sprite, int, int, int, int, int)}: Draws a module of a sprite.</li>
 *   <li>{@link #drawFrameOne(Sprite, int, int, int, int)}: Draws a frame of a sprite.</li>
 *   <li>{@link #drawActionOne(Sprite, int, int, int, byte[], int, boolean)}: Draws an action of a sprite.</li>
 *   <li>{@link #drawImage(Image, int, int, int)}: Draws an image.</li>
 *   <li>{@link #drawImage(Image, int, int, int, int)}: Draws an image with transformation.</li>
 *   <li>{@link #fillRect(int, int, int, int, int)}: Fills a rectangle with a color.</li>
 *   <li>{@link #drawLine(int, int, int, int, int)}: Draws a line with a color.</li>
 *   <li>{@link #drawRect(int, int, int, int, int)}: Draws a rectangle with a color.</li>
 *   <li>{@link #fillArc(int, int, int, int, int, int)}: Fills an arc with a color.</li>
 *   <li>{@link #drawString(String, int, int, int, int, int)}: Draws a string with a color and mode.</li>
 *   <li>{@link #drawStringColor(String, int, int, int, int)}: Draws a string with multiple colors.</li>
 *   <li>{@link #drawStringY(StringBuffer[], int, int, int, int, int)}: Draws multiple strings vertically.</li>
 *   <li>{@link #initUiModules()}: Initializes UI modules.</li>
 *   <li>{@link #drawUi(int, int, int, int, int)}: Draws a UI component.</li>
 *   <li>{@link #drawBDir(int, int, int, int)}: Draws a directional button.</li>
 *   <li>{@link #drawVolume(int, int, int, boolean)}: Draws a volume indicator.</li>
 *   <li>{@link #drawK(int, int, int, int, int)}: Draws a filled rectangle with a specific color.</li>
 *   <li>{@link #drawK0(int, int, int, int, int)}: Draws a bordered rectangle with a specific color.</li>
 *   <li>{@link #drawK1(int, int, int, int, int)}: Draws a bordered rectangle with a different style.</li>
 *   <li>{@link #drawK2(int, int, int, int, int)}: Draws a filled rectangle with a border.</li>
 *   <li>{@link #drawK3(int, int, int, int)}: Draws a filled rectangle with a border and background color.</li>
 *   <li>{@link #drawK4(int, int, int, int)}: Draws a bordered rectangle with a different style.</li>
 *   <li>{@link #drawKuang(int, int, int, int)}: Draws a bordered rectangle with a background color.</li>
 *   <li>{@link #drawKuangSelect(int, int, int, int, int)}: Draws a selectable bordered rectangle.</li>
 *   <li>{@link #drawKuangMap(int, int, int, int, boolean)}: Draws a map bordered rectangle.</li>
 *   <li>{@link #drawKuangAdorn(int, int, int, int, int)}: Draws an adorned bordered rectangle.</li>
 *   <li>{@link #drawBarOne(int, int, int, int, int, int)}: Draws a progress bar.</li>
 *   <li>{@link #sliding(int, int, int, int, int, boolean)}: Draws a sliding bar.</li>
 *   <li>{@link #drawNum(String, int, int, int, int)}: Draws a number string.</li>
 *   <li>{@link #drawRectZ(int, int, int, int, int, int)}: Draws a rectangle with a specific color and size.</li>
 *   <li>{@link #fillRectB()}: Fills the entire screen with a background color.</li>
 *   <li>{@link #drawTriangle(int, int, int, boolean, boolean)}: Draws a triangle.</li>
 *   <li>{@link #drawTriangle1(int, int, int, boolean, boolean)}: Draws a triangle with a different style.</li>
 *   <li>{@link #drawYesNo(boolean, boolean)}: Draws Yes/No options.</li>
 *   <li>{@link #drawYesNo_(boolean, boolean)}: Draws Yes/No options with a different style.</li>
 *   <li>{@link #drawYesNo__(boolean, boolean)}: Draws Yes/No options with another style.</li>
 *   <li>{@link #drawListSY(Object[], int, int, int, int, int, int, int, int)}: Draws a list of items vertically.</li>
 *   <li>{@link #drawListKY(int, int, int, int, int, int, int, int, int, int)}: Draws a list of items with a different style.</li>
 *   <li>{@link #drawStringY(Object[], int, int, int, int, int, int, int)}: Draws multiple strings vertically with a specific range.</li>
 *   <li>{@link #drawListSYHasSound(Object[], int, int, int, int, int, int, int, int)}: Draws a list of items with sound options.</li>
 * </ul>
 */
public class Ui {
    public static DirectGraphics dg;
    public static Graphics g;
    private static final short[] transforms = {0, 5, 3, 6, 2, 4, 1, 7};
    private static Ui uiListener;
    private byte rz;
    private Image ui_img;
    private short[][] ui_modules;
    private byte[][] MIRROR2 = {new byte[]{0, 1, 2, 3, 4, 5, 6, 7}, new byte[]{4, 5, 6, 7, 0, 1, 2, 3}};
    private byte[] MIRROR3 = {1, -1};
    private int[] MIRROR = {4 | 16, 8 | 16};
    public byte cTriangle = 0;

    public Ui() {
        uiListener = this;
    }

    public static Ui i() {
        if (uiListener == null) {
            uiListener = new Ui();
        }
        return uiListener;
    }

    public void initGraphics(Graphics _g) {
        g = _g;
        dg = DirectUtils.getDirectGraphics(_g);
    }

    public void drawRegion(Image image, int mx, int my, int mw, int mh, int realX, int realY, int anchor, int manipulation, Graphics g2) {
        g2.drawRegion(image, mx, my, mw, mh, transforms[manipulation], realX, realY, anchor);
    }

    public void drawModuleOne(Sprite sp, int m_id, int x, int y, int dir, int manipulation) {
        drawRegion(sp.img, sp.module(m_id, 0), sp.module(m_id, 1), sp.module(m_id, 2), sp.module(m_id, 3), x, y, this.MIRROR[dir], this.MIRROR2[dir][manipulation], g);
    }

    public void drawFrameOne(Sprite sp, int f_id, int x, int y, int dir) {
        for (short now_frame = 0; now_frame < sp.fLength(f_id); now_frame = (short) (now_frame + 1)) {
            drawModuleOne(sp, sp.frame(f_id, now_frame, 0), x + (sp.frame(f_id, now_frame, 1) * this.MIRROR3[dir]), y + sp.frame(f_id, now_frame, 2), dir, sp.frame(f_id, now_frame, 3));
        }
    }

    public boolean drawActionOne(Sprite sp, int a_id, int x, int y, byte[] now_a, int dir, boolean mode) {
        drawFrameOne(sp, sp.action(a_id, now_a[0], 0), x, y, dir);
        byte b = (byte) (now_a[1] + 1);
        now_a[1] = b;
        if (b > sp.action(a_id, now_a[0], 1)) {
            now_a[1] = 0;
            byte b2 = (byte) (now_a[0] + 1);
            now_a[0] = b2;
            if (b2 >= sp.aLength(a_id)) {
                if (!mode) {
                    now_a[0] = (byte) (sp.aLength(a_id) - 1);
                    return true;
                }
                now_a[0] = 0;
            }
        }
        return false;
    }

    public void drawImage(Image image, int x, int y, int archor) {
        g.drawImage(image, x, y, archor);
    }

    public void drawImage(Image image, int x, int y, int archor, int trans) {
        if (trans != 0) {
            dg.drawImage(image, x, y, archor, trans);
        } else {
            g.drawImage(image, x, y, archor);
        }
    }

    public void fillRect(int c, int x, int y, int w, int h) {
        g.setColor(c);
        g.fillRect(x, y, w, h);
    }

    public void drawLine(int c, int x0, int y0, int x1, int y1) {
        g.setColor(c);
        g.drawLine(x0, y0, x1, y1);
    }

    public void drawRect(int c, int x0, int y0, int w, int h) {
        g.setColor(c);
        g.drawRect(x0, y0, w, h);
    }

    public void fillArc(int c, int x, int y, int w, int h, int a0, int a1) {
        g.setColor(c);
        g.fillArc(x, y, w, h, a0, a1);
    }

    public void drawString(String str_hit, int x, int y, int anchor, int color, int mode) {
        int c0 = 13281366;
        int c1 = 3676168;
        int y2 = y + 1;
        switch (color) {
            case 0:
                c0 = 0;
                c1 = 16777215;
                break;
            case 1:
                c0 = 5461075;
                c1 = 7727871;
                break;
            case 2:
                c0 = 2707928;
                c1 = 43016;
                break;
            case 3:
                c0 = 1908277;
                c1 = 24295;
                break;
            case 4:
                c0 = 1314307;
                c1 = 5228543;
                break;
            case 5:
                c0 = 2233603;
                c1 = 16739328;
                break;
            case 6:
                c0 = 8075577;
                c1 = 16189448;
                break;
            case 7:
                c0 = 4467457;
                c1 = 16757760;
                break;
            case 8:
                c0 = 10122756;
                c1 = 12583167;
                break;
            case 9:
                c0 = 11563064;
                c1 = 3676168;
                break;
            case 10:
                c0 = 1311269;
                c1 = 8816262;
                break;
        }
        if (mode == 2) {
            g.setColor(c0);
            g.drawString(str_hit, x - 1, y2, anchor);
            g.drawString(str_hit, x + 1, y2, anchor);
            g.drawString(str_hit, x, y2 - 1, anchor);
            g.drawString(str_hit, x, y2 + 1, anchor);
            g.drawString(str_hit, x + 1, y2 + 1, anchor);
            g.drawString(str_hit, x - 1, y2 + 1, anchor);
            g.drawString(str_hit, x - 1, y2 - 1, anchor);
            g.drawString(str_hit, x + 1, y2 - 1, anchor);
        }
        g.setColor(c1);
        if (mode == 1) {
            g.drawString(str_hit, x + 1, y2, anchor);
        }
        g.drawString(str_hit, x, y2, anchor);
    }

    public void drawStringColor(String str, int x, int y, int color, int mode) {
        byte end;
        byte c = (byte) color;
        byte start = 0;
        short tw = 0;
        do {
            end = (byte) str.indexOf("#", start);
            if (end != -1) {
                String ssub = str.substring(start, end);
                drawString(ssub, x + tw, y, 0, c, mode);
                tw = (short) (Ms.i().getStringWidth(ssub) + tw);
                c = (byte) (Integer.parseInt(str.substring(end + 1, end + 2)) - 1);
                start = (byte) (end + 2);
                if (c == -1) {
                    c = (byte) color;
                }
            } else {
                drawString(str.substring(start, str.length()), x + tw, y, 0, c, mode);
            }
        } while (end != -1);
    }

    public void drawStringY(StringBuffer[] showS, int x, int y, int fh, int color, int mode) {
        for (byte d = 0; d < showS.length; d = (byte) (d + 1)) {
            drawStringColor(showS[d].toString(), x, y + 4 + (d * fh), color, mode);
        }
    }

    public void initUiModules() {
        this.ui_img = Ms.i().createImage("data/ui");
        Ms.i();
        Ms.skip = 0;
        this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
    }

    public void drawUi(int action, int x, int y, int anchor, int manipulation) {
        drawRegion(this.ui_img, this.ui_modules[action][0], this.ui_modules[action][1], this.ui_modules[action][2], this.ui_modules[action][3], x, y, anchor, manipulation, g);
    }

    public void drawBDir(int x, int y, int w, int h) {
        g.setColor(8310516);
        g.drawRect(x, y, w * 3, h << 1);
        g.drawRect(x + w, y, w, h << 1);
        g.drawLine(x, y + h, (w * 3) + x, y + h);
    }

    public void drawVolume(int x, int y, int v, boolean bb) {
        g.setColor(bb ? 458827 : 11563064);
        g.drawRect((x - 1) + 3, y + 5, 7, 10);
        g.drawRect(x + 5 + 2 + 3, y + 2, 7, 13);
        g.drawRect(x + 11 + 4 + 3, y - 1, 8, 16);
        g.setColor(bb ? 16048400 : 3676168);
        g.drawRect(x + 3, y + 6, 6, 8);
        g.drawRect(x + 6 + 2 + 3, y + 3, 6, 11);
        g.drawRect(x + 12 + 4 + 3, y, 6, 14);
        if (v > 0) {
            g.fillRect(x + 1 + 3, y + 7, 5, 7);
        }
        if (v > 30) {
            g.fillRect(x + 7 + 2 + 3, y + 4, 5, 10);
        }
        if (v > 60) {
            g.fillRect(x + 13 + 4 + 3, y + 1, 5, 13);
        }
    }

    public void drawK(int x, int y, int w, int h, int c) {
        int c2;
        if (c == 0) {
            c2 = 15400191;
        } else if (c == 1) {
            c2 = 12352252;
        } else if (c == 2) {
            c2 = 12313343;
        } else if (c == 3) {
            c2 = 5228543;
        } else {
            c2 = c == 4 ? 30975 : 11121884;
        }
        g.setColor(c2);
        g.fillRect(x + 1, y, w - 2, h);
        g.fillRect(x, y + 1, w, h - 2);
    }

    public void drawK0(int x, int y, int w, int h, int c) {
        byte c0 = (byte) c;
        g.setColor(c == 2 ? 15400191 : 1908277);
        g.drawRect(x + 1, y, w - 3, h - 1);
        g.drawRect(x, y + 1, w - 1, h - 3);
        drawK(x + 1, y + 1, w - 2, h - 2, c0);
    }

    public void drawK1(int x, int y, int w, int h, int c) {
        int c2;
        g.setColor(c == 0 ? 5461075 : 1908277);
        g.drawRect(x, y + 2, w, h - 3);
        g.drawLine(x + 1, y + h, (x + w) - 1, y + h);
        if (c == 0 || c == 1) {
            c2 = 15400191;
        } else if (c == 2) {
            c2 = 13892607;
        } else {
            c2 = c == 3 ? 7727871 : 12352252;
        }
        g.setColor(c2);
        g.fillRect(x + 1, y, w - 2, h);
        g.fillRect(x, y + 1, w, h - 2);
    }

    public void drawK2(int x, int y, int w, int h, int arc) {
        if (arc == 0) {
        }
        g.setColor(0);
        g.fillRect(x, y, w, h);
        g.setColor(30975);
        g.fillRect(x + 2, y + 2, w - 4, h - 4);
    }

    public void drawK3(int x, int y, int w, int h) {
        drawK0(x, y, w - 1, h - 1, 0);
        g.setColor(1908277);
        g.fillRect(x + 2, y + 2, w - 2, h - 2);
    }

    public void drawK4(int x, int y, int w, int h) {
        g.setColor(16771373);
        g.drawLine(x + 1, y, (x + w) - 2, y);
        g.drawLine(x + 1, (y + h) - 1, (x + w) - 2, (y + h) - 1);
        g.drawLine(x, y + 1, x, (y + h) - 2);
        g.drawLine((x + w) - 1, y + 1, (x + w) - 1, (y + h) - 2);
        g.drawLine(x, y + 1, x + 1, y + 1);
        g.drawLine((x + w) - 2, y + 1, (x + w) - 1, y + 1);
        g.drawLine(x, (y + h) - 2, x + 1, (y + h) - 2);
        g.drawLine((x + w) - 2, (y + h) - 2, (x + w) - 2, (y + h) - 2);
    }

    public void drawKuang(int x, int y, int w, int h) {
        g.setColor(1908277);
        g.drawRect(x + 1, y, w - 4, h - 2);
        g.drawRect(x + 2, y + 1, w - 4, h - 2);
        g.drawLine(x, y + 1, x, (y + h) - 3);
        g.drawLine((x + w) - 1, y + 2, (x + w) - 1, (y + h) - 2);
        fillRect(15400191, x + 1, y + 1, w - 3, h - 3);
    }

    public void drawKuangSelect(int x, int y, int w, int h, int mode) {
        int color = 13281366;
        if (mode == 1) {
            color = 11370036;
        } else if (mode == 2) {
            color = 2233088;
        } else if (mode == 3) {
            color = 15129744;
        } else if (mode == 4) {
            color = 16762112;
        } else if (mode == 5) {
            color = 6168835;
        }
        g.setColor(color);
        g.fillRect(x + 1, y, w - 2, h);
        g.drawRect(x, y + 1, w - 1, h - 3);
    }

    public void drawKuangMap(int x, int y, int w, int h, boolean mode) {
        fillRect(mode ? 14961 : 16762112, x, y, w, h);
        fillRect(mode ? 6724095 : 11370036, x + 1, y + 1, w - 2, h - 2);
    }

    public void drawKuangAdorn(int x, int y, int w, int h, int mode) {
        if (mode == 0) {
            g.setColor(1842484);
            g.drawRect(x + 20, y - 22, w - 21, 20);
            g.drawRect(x + 20, y - 22, w - 22, 21);
            fillRect(15129744, x + 20, y - 22, w - 22, 20);
            drawUi(33, x, y, 36, 0);
            drawUi(31, (x + w) - 4, y, 36, 0);
            return;
        }
        if (mode == 1) {
            drawUi(32, x, y - 7, 0, 0);
            drawUi(32, x + w + 5, y - 7, 8 | 16, 0);
            fillRect(13550445, x + 15, y - 5, w - 25, 13);
            fillRect(16116383, x + 15, y - 3, w - 25, 10);
            fillRect(13078326, x + 15, y + 10, w - 25, 5);
            drawLine(1842484, x + 15, y - 7, (x + w) - 11, y - 7);
            drawLine(16446403, x + 15, y - 6, (x + w) - 11, y - 6);
            drawLine(6168835, x + 15, y + 12, (x + w) - 11, y + 12);
            g.setColor(13281366);
            g.drawRect(x + 15, y + 8, w - 26, 1);
            return;
        }
        if (mode == 2) {
            drawUi(32, x, (y + h) - 1, 36, 6);
            drawUi(32, x + w + 5, (y + h) - 1, 40, 6);
            fillRect(13550445, x + 15, (y + h) - 16, w - 25, 13);
            fillRect(16116383, x + 15, (y + h) - 15, w - 25, 10);
            fillRect(13078326, x + 15, (y + h) - 23, w - 25, 5);
            drawLine(1842484, x + 15, (y + h) - 2, (x + w) - 11, (y + h) - 2);
            drawLine(16446403, x + 15, (y + h) - 3, (x + w) - 11, (y + h) - 3);
            drawLine(6168835, x + 15, (y + h) - 21, (x + w) - 11, (y + h) - 21);
            g.setColor(13281366);
            g.drawRect(x + 15, (y + h) - 18, w - 26, 1);
        }
    }

    public void drawBarOne(int x, int y, int w, int cMin, int cMax, int mode) {
        int c0 = 16125468;
        if (mode == 1) {
            c0 = 55551;
        } else if (mode == 2) {
            c0 = 60177;
        }
        fillRect(4067649, x + 1, y, w - 1, 5);
        g.drawRect(x, y + 1, w, 5 - 3);
        int h = 5 - 2;
        fillRect(16752385, x + 1, y + 1, cMin, h);
        fillRect(c0, x + 1, y + 1, cMin > cMax ? cMax : cMin, h);
    }

    public void sliding(int x, int y, int h, int now, int all, boolean type) {
        if (!type) {
            drawK(x - 2, y - 2, 10 + 4, h + 4, 0);
        }
        drawK(x, y, 10, h, type ? 0 : 3);
        drawK(x, y, 10, 11, type ? 3 : 0);
        drawK(x, (y + h) - 11, 10, 11, type ? 3 : 0);
        int h2 = h - 22;
        int all2 = all - 1;
        if (all2 < 1) {
            drawK(x + 1, y + 12, 10 - 2, h2 - 2, type ? 3 : 0);
            return;
        }
        byte kh = (byte) (h2 / (all2 + 1));
        if (kh < 15) {
            kh = 15;
        }
        short k2 = (short) ((((h2 - 2) - kh) * now) / all2);
        drawK(x + 1, y + 12 + k2, 10 - 2, kh, type ? 3 : 0);
    }

    public void drawNum(String str, int x, int y, int anchor, int type) {
        byte w;
        if (str.length() != 0) {
            byte i = (byte) (anchor == 0 ? 0 : str.length() - 1);
            short sw = 0;
            while (true) {
                if (type == 0) {
                    w = 8;
                } else {
                    w = type == 1 ? (byte) 10 : (byte) 14;
                }
                byte bid = -1;
                char cr = str.charAt(i);
                if (cr >= '0' && cr <= '9') {
                    byte bid2 = (byte) (cr - '0');
                    if (type == 0) {
                        bid = (byte) (bid2 + 10);
                    } else {
                        bid = type == 1 ? (byte) (bid2 + 35) : (byte) (bid2 + Key_H.KEY_NUM9);
                    }
                } else if (cr == '/') {
                    bid = 20;
                } else if (cr == '-') {
                    bid = (byte) (type == 2 ? 56 : 46);
                } else if (cr == '+') {
                    bid = Constants_H.f20;
                } else if (cr == '%') {
                    bid = 45;
                    w = 14;
                } else if (cr == 32423) {
                    bid = 29;
                    w = 12;
                }
                if (bid != -1) {
                    if (anchor == 0) {
                        drawUi(bid, x + sw, y, 36, 0);
                    } else {
                        drawUi(bid, x - sw, y, 40, 0);
                    }
                    sw = (short) (sw + w);
                } else {
                    if (anchor == 0) {
                        drawString(new StringBuilder().append(cr).toString(), x + sw, y + 5, 36, 3, 0);
                    } else {
                        drawString(new StringBuilder().append(cr).toString(), x - sw, y + 5, 40, 3, 0);
                    }
                    sw = (short) (sw + 25);
                }
                i = anchor == 0 ? (byte) (i + 1) : (byte) (i - 1);
                if (anchor == 0) {
                    if (i >= str.length()) {
                        return;
                    }
                } else if (i <= -1) {
                    return;
                }
            }
        }
    }

    public void drawRectZ(int color, int x, int y, int w, int h, int s) {
        g.setColor(color);
        Graphics graphics = g;
        Ms.i();
        int abs = x - Ms.abs(this.rz);
        Ms.i();
        int abs2 = y - Ms.abs(this.rz);
        Ms.i();
        int abs3 = (Ms.abs(this.rz) << 1) + w;
        Ms.i();
        graphics.drawRect(abs, abs2, abs3, (Ms.abs(this.rz) << 1) + h);
        byte b = (byte) (this.rz + 1);
        this.rz = b;
        if (b > s) {
            this.rz = (byte) (-s);
        }
    }

    public void fillRectB() {
        fillRect(5422575, 0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
    }

    public void drawTriangle(int x, int y, int w, boolean dir, boolean ct) {
    }

    public void drawTriangle1(int x, int y, int w, boolean dir, boolean ct) {
        Ms.i();
        drawUi(30, (x - w) - Ms.abs(this.cTriangle), y, 4 | 2, 4);
        Ms.i();
        drawUi(30, Ms.abs(this.cTriangle) + x + w, y, 8 | 2, 0);
        if (ct) {
            byte b = (byte) (this.cTriangle + 1);
            this.cTriangle = b;
            if (b > 4) {
                this.cTriangle = (byte) -3;
            }
        }
    }

    public void drawYesNo(boolean a, boolean b) {
        if (a) {
            drawUi(27, 0, Constants_H.HEIGHT_, 36, 0);
        }
        if (b) {
            drawUi(28, Constants_H.WIDTH_, Constants_H.HEIGHT_, 40, 0);
        }
    }

    public void drawYesNo_(boolean a, boolean b) {
        if (a) {
            drawUi(27, 0, Constants_H.HEIGHT, 36, 0);
        }
        if (b) {
            drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0);
        }
    }

    public void drawYesNo__(boolean a, boolean b) {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        if (a) {
            drawUi(27, 0, HEIGHT, 36, 0);
        }
        if (b) {
            drawUi(28, WIDTH, HEIGHT, 40, 0);
        }
    }

    public void drawListSY(Object[] menu, int x, int y, int w, int sh, int sel, int c0, int c1, int strT) {
        byte d = 0;
        while (d < menu.length) {
            drawString(menu[d].toString(), x + (w >> 1), (d * sh) + y + 2, 17, d == sel ? c0 : c1, strT);
            d = (byte) (d + 1);
        }
        Log.e("sk", "drawListSY");
    }

    public void drawListKY(int length, int x, int y, int w, int kw, int kh, int dis, int sel, int c0, int c1) {
        for (byte d = 0; d < length; d = (byte) (d + 1)) {
            if (d != sel) {
                drawK0(x + kw, y + ((kh + dis) * d), w - (kw << 1), kh, c1);
            }
        }
        if (sel != -1) {
            drawK1(x, y + ((kh + dis) * sel), w, kh, c0);
        }
    }

    public void drawStringY(Object[] str, int x, int y, int start, int end, int sh, int c, int strT) {
        for (byte i = (byte) start; i < end && i < str.length; i = (byte) (i + 1)) {
            i().drawString(str[i].toString(), x, y + ((i - start) * sh), 0, c, strT);
        }
    }

    public void drawListSYHasSound(Object[] menu, int x, int y, int w, int sh, int sel, int c0, int c1, int strT) {
        byte d = 0;
        while (d < menu.length) {
            drawString(menu[d].toString(), x + (w >> 1), (d * sh) + y + 2, menu[d].toString().equals(Constants_H.PAUSE_TXT_6) ? 20 : 17, d == sel ? c0 : c1, strT);
            d = (byte) (d + 1);
        }
    }
}
