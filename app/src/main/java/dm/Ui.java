package dm;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;

public class Ui {
    private int[] MIRROR;
    private byte[][] MIRROR2;
    private byte[] MIRROR3;
    public byte cTriangle;
    public static DirectGraphics dg;
    public static Graphics g;
    private byte rz;
    private static final short[] transforms;
    private static Ui uiListener;
    private Image ui_img;
    private short[][] ui_modules;

    static {
        Ui.transforms = new short[]{0, 5, 3, 6, 2, 4, 1, 7};
    }

    public Ui() {
        this.MIRROR2 = new byte[][]{new byte[]{0, 1, 2, 3, 4, 5, 6, 7}, new byte[]{4, 5, 6, 7, 0, 1, 2, 3}};
        this.MIRROR3 = new byte[]{1, -1};
        this.MIRROR = new int[]{20, 24};
        this.cTriangle = 0;
        Ui.uiListener = this;
    }

    public boolean drawActionOne(Sprite sp, int a_id, int x, int y, byte[] now_a, int dir, boolean mode) {
        this.drawFrameOne(sp, sp.action(a_id, ((int)now_a[0]), 0), x, y, dir);
        byte b = (byte)(now_a[1] + 1);
        now_a[1] = b;
        if(b > sp.action(a_id, ((int)now_a[0]), 1)) {
            now_a[1] = 0;
            byte b1 = (byte)(now_a[0] + 1);
            now_a[0] = b1;
            if(b1 >= sp.aLength(a_id)) {
                if(!mode) {
                    now_a[0] = (byte)(sp.aLength(a_id) - 1);
                    return true;
                }
                now_a[0] = 0;
            }
        }
        return false;
    }

    public void drawBDir(int x, int y, int w, int h) {
        Ui.g.setColor(0x7ECEF4);
        Ui.g.drawRect(x, y, w * 3, h << 1);
        Ui.g.drawRect(x + w, y, w, h << 1);
        Ui.g.drawLine(((float)x), ((float)(y + h)), ((float)(w * 3 + x)), ((float)(y + h)));
    }

    public void drawBarOne(int x, int y, int w, int cMin, int cMax, int mode) {
        int c0 = 0xF60E1C;
        if(mode == 1) {
            c0 = 0xD8FF;
        }
        else if(mode == 2) {
            c0 = 60177;
        }
        this.fillRect(4067649, x + 1, y, w - 1, 5);
        Ui.g.drawRect(x, y + 1, w, 2);
        this.fillRect(0xFF9F01, x + 1, y + 1, cMin, 3);
        this.fillRect(c0, x + 1, y + 1, (cMin <= cMax ? cMin : cMax), 3);
    }

    public void drawFrameOne(Sprite sp, int f_id, int x, int y, int dir) {
        for(int now_frame = 0; now_frame < sp.fLength(f_id); now_frame = (short)(now_frame + 1)) {
            int v5 = y + sp.frame(f_id, now_frame, 2);
            int v6 = sp.frame(f_id, now_frame, 3);
            this.drawModuleOne(sp, sp.frame(f_id, now_frame, 0), x + sp.frame(f_id, now_frame, 1) * this.MIRROR3[dir], v5, dir, v6);
        }
    }

    public void drawImage(Image image, int x, int y, int archor) {
        Ui.g.drawImage(image, x, y, archor);
    }

    public void drawImage(Image image, int x, int y, int archor, int trans) {
        if(trans == 0) {
            Ui.g.drawImage(image, x, y, archor);
            return;
        }
        Ui.dg.drawImage(image, x, y, archor, trans);
    }

    public void drawK(int x, int y, int w, int h, int c) {
        int v5;
        switch(c) {
            case 0: {
                v5 = 0xEAFCFF;
                break;
            }
            case 1: {
                v5 = 0xBC7AFC;
                break;
            }
            case 2: {
                v5 = 0xBBE2FF;
                break;
            }
            case 3: {
                v5 = 0x4FC7FF;
                break;
            }
            case 4: {
                v5 = 0x78FF;
                break;
            }
            default: {
                v5 = 0xA9B4DC;
            }
        }
        Ui.g.setColor(v5);
        Ui.g.fillRect(x + 1, y, w - 2, h);
        Ui.g.fillRect(x, y + 1, w, h - 2);
    }

    public void drawK0(int x, int y, int w, int h, int c) {
        Ui.g.setColor((c == 2 ? 0xEAFCFF : 1908277));
        Ui.g.drawRect(x + 1, y, w - 3, h - 1);
        Ui.g.drawRect(x, y + 1, w - 1, h - 3);
        this.drawK(x + 1, y + 1, w - 2, h - 2, ((int)(((byte)c))));
    }

    public void drawK1(int x, int y, int w, int h, int c) {
        int v5;
        Ui.g.setColor((c == 0 ? 5461075 : 1908277));
        Ui.g.drawRect(x, y + 2, w, h - 3);
        Ui.g.drawLine(((float)(x + 1)), ((float)(y + h)), ((float)(x + w - 1)), ((float)(y + h)));
        switch(c) {
            case 0: 
            case 1: {
                v5 = 0xEAFCFF;
                break;
            }
            case 2: {
                v5 = 0xD3FBFF;
                break;
            }
            case 3: {
                v5 = 0x75EAFF;
                break;
            }
            default: {
                v5 = 0xBC7AFC;
            }
        }
        Ui.g.setColor(v5);
        Ui.g.fillRect(x + 1, y, w - 2, h);
        Ui.g.fillRect(x, y + 1, w, h - 2);
    }

    public void drawK2(int x, int y, int w, int h, int arc) {
        Ui.g.setColor(0);
        Ui.g.fillRect(x, y, w, h);
        Ui.g.setColor(0x78FF);
        Ui.g.fillRect(x + 2, y + 2, w - 4, h - 4);
    }

    public void drawK3(int x, int y, int w, int h) {
        this.drawK0(x, y, w - 1, h - 1, 0);
        Ui.g.setColor(1908277);
        Ui.g.fillRect(x + 2, y + 2, w - 2, h - 2);
    }

    public void drawK4(int x, int y, int w, int h) {
        Ui.g.setColor(0xFFE92D);
        Ui.g.drawLine(((float)(x + 1)), ((float)y), ((float)(x + w - 2)), ((float)y));
        Ui.g.drawLine(((float)(x + 1)), ((float)(y + h - 1)), ((float)(x + w - 2)), ((float)(y + h - 1)));
        Ui.g.drawLine(((float)x), ((float)(y + 1)), ((float)x), ((float)(y + h - 2)));
        Ui.g.drawLine(((float)(x + w - 1)), ((float)(y + 1)), ((float)(x + w - 1)), ((float)(y + h - 2)));
        Ui.g.drawLine(((float)x), ((float)(y + 1)), ((float)(x + 1)), ((float)(y + 1)));
        Ui.g.drawLine(((float)(x + w - 2)), ((float)(y + 1)), ((float)(x + w - 1)), ((float)(y + 1)));
        Ui.g.drawLine(((float)x), ((float)(y + h - 2)), ((float)(x + 1)), ((float)(y + h - 2)));
        Ui.g.drawLine(((float)(x + w - 2)), ((float)(y + h - 2)), ((float)(x + w - 2)), ((float)(y + h - 2)));
    }

    public void drawKuang(int x, int y, int w, int h) {
        Ui.g.setColor(1908277);
        Ui.g.drawRect(x + 1, y, w - 4, h - 2);
        Ui.g.drawRect(x + 2, y + 1, w - 4, h - 2);
        Ui.g.drawLine(((float)x), ((float)(y + 1)), ((float)x), ((float)(y + h - 3)));
        Ui.g.drawLine(((float)(x + w - 1)), ((float)(y + 2)), ((float)(x + w - 1)), ((float)(y + h - 2)));
        this.fillRect(0xEAFCFF, x + 1, y + 1, w - 3, h - 3);
    }

    public void drawKuangAdorn(int x, int y, int w, int h, int mode) {
        switch(mode) {
            case 0: {
                Ui.g.setColor(0x1C1D34);
                Ui.g.drawRect(x + 20, y - 22, w - 21, 20);
                Ui.g.drawRect(x + 20, y - 22, w - 22, 21);
                this.fillRect(0xE6DC90, x + 20, y - 22, w - 22, 20);
                this.drawUi(33, x, y, 36, 0);
                this.drawUi(0x1F, x + w - 4, y, 36, 0);
                return;
            }
            case 1: {
                this.drawUi(0x20, x, y - 7, 0, 0);
                this.drawUi(0x20, x + w + 5, y - 7, 24, 0);
                this.fillRect(13550445, x + 15, y - 5, w - 25, 13);
                this.fillRect(0xF5EA9F, x + 15, y - 3, w - 25, 10);
                this.fillRect(0xC78F36, x + 15, y + 10, w - 25, 5);
                this.drawLine(0x1C1D34, x + 15, y - 7, x + w - 11, y - 7);
                this.drawLine(0xFAF3C3, x + 15, y - 6, x + w - 11, y - 6);
                this.drawLine(0x5E2103, x + 15, y + 12, x + w - 11, y + 12);
                Ui.g.setColor(0xCAA856);
                Ui.g.drawRect(x + 15, y + 8, w - 26, 1);
                return;
            }
            case 2: {
                this.drawUi(0x20, x, y + h - 1, 36, 6);
                this.drawUi(0x20, x + w + 5, y + h - 1, 40, 6);
                this.fillRect(13550445, x + 15, y + h - 16, w - 25, 13);
                this.fillRect(0xF5EA9F, x + 15, y + h - 15, w - 25, 10);
                this.fillRect(0xC78F36, x + 15, y + h - 23, w - 25, 5);
                this.drawLine(0x1C1D34, x + 15, y + h - 2, x + w - 11, y + h - 2);
                this.drawLine(0xFAF3C3, x + 15, y + h - 3, x + w - 11, y + h - 3);
                this.drawLine(0x5E2103, x + 15, y + h - 21, x + w - 11, y + h - 21);
                Ui.g.setColor(0xCAA856);
                Ui.g.drawRect(x + 15, y + h - 18, w - 26, 1);
            }
        }
    }

    public void drawKuangMap(int x, int y, int w, int h, boolean mode) {
        this.fillRect((mode ? 0x3A71 : 0xFFC500), x, y, w, h);
        this.fillRect((mode ? 0x6699FF : 11370036), x + 1, y + 1, w - 2, h - 2);
    }

    public void drawKuangSelect(int x, int y, int w, int h, int mode) {
        int color = 0xCAA856;
        if(mode == 1) {
            color = 11370036;
        }
        else if(mode == 2) {
            color = 0x221300;
        }
        else if(mode == 3) {
            color = 0xE6DC90;
        }
        else {
            switch(mode) {
                case 4: {
                    color = 0xFFC500;
                    break;
                }
                case 5: {
                    color = 0x5E2103;
                }
            }
        }
        Ui.g.setColor(color);
        Ui.g.fillRect(x + 1, y, w - 2, h);
        Ui.g.drawRect(x, y + 1, w - 1, h - 3);
    }

    public void drawLine(int c, int x0, int y0, int x1, int y1) {
        Ui.g.setColor(c);
        Ui.g.drawLine(((float)x0), ((float)y0), ((float)x1), ((float)y1));
    }

    public void drawListKY(int length, int x, int y, int w, int kw, int kh, int dis, int sel, int c0, int c1) {
        for(int d = 0; d < length; d = (byte)(d + 1)) {
            if(d != sel) {
                this.drawK0(x + kw, y + (kh + dis) * d, w - (kw << 1), kh, c1);
            }
        }
        if(sel != -1) {
            this.drawK1(x, y + (kh + dis) * sel, w, kh, c0);
        }
    }

    public void drawListSY(Object[] menu, int x, int y, int w, int sh, int sel, int c0, int c1, int strT) {
        for(int d = 0; d < menu.length; d = (byte)(d + 1)) {
            this.drawString(menu[d].toString(), x + (w >> 1), d * sh + (y + 2), 17, (d == sel ? c0 : c1), strT);
        }
        Log.e("sk", "drawListSY");
    }

    public void drawListSYHasSound(Object[] menu, int x, int y, int w, int sh, int sel, int c0, int c1, int strT) {
        for(int d = 0; d < menu.length; d = (byte)(d + 1)) {
            this.drawString(menu[d].toString(), x + (w >> 1), d * sh + (y + 2), (menu[d].toString().equals("声音") ? 20 : 17), (d == sel ? c0 : c1), strT);
        }
    }

    public void drawModuleOne(Sprite sp, int m_id, int x, int y, int dir, int manipulation) {
        int v5 = sp.module(m_id, 0);
        int v6 = sp.module(m_id, 1);
        int v7 = sp.module(m_id, 2);
        int v8 = sp.module(m_id, 3);
        this.drawRegion(sp.img, v5, v6, v7, v8, x, y, this.MIRROR[dir], ((int)this.MIRROR2[dir][manipulation]), Ui.g);
    }

    public void drawNum(String str, int x, int y, int anchor, int type) {
        int w;
        if(str.length() == 0) {
            return;
        }
        int i = (byte)(anchor == 0 ? 0 : str.length() - 1);
        int sw = 0;
        while(true) {
            if(type == 0) {
                w = 8;
            }
            else {
                w = type == 1 ? 10 : 14;
            }
            int bid = -1;
            int v8 = str.charAt(i);
            if(v8 >= 0x30 && v8 <= 57) {
                switch(type) {
                    case 0: {
                        bid = (byte)(((byte)(v8 - 0x30)) + 10);
                        break;
                    }
                    case 1: {
                        bid = (byte)(((byte)(v8 - 0x30)) + 35);
                        break;
                    }
                    default: {
                        bid = (byte)(((byte)(v8 - 0x30)) + 57);
                    }
                }
            }
            else {
                switch(v8) {
                    case 37: {
                        bid = 45;
                        w = 14;
                        break;
                    }
                    case 43: {
                        bid = 0x2F;
                        break;
                    }
                    case 45: {
                        bid = (byte)(type == 2 ? 56 : 46);
                        break;
                    }
                    case 0x2F: {
                        bid = 20;
                        break;
                    }
                    case 0x7EA7: {
                        w = 12;
                        bid = 29;
                    }
                }
            }
            if(bid == -1) {
                if(anchor == 0) {
                    this.drawString(((char)v8), x + sw, y + 5, 36, 3, 0);
                }
                else {
                    this.drawString(((char)v8), x - sw, y + 5, 40, 3, 0);
                }
                sw = (short)(sw + 25);
            }
            else {
                if(anchor == 0) {
                    this.drawUi(bid, x + sw, y, 36, 0);
                }
                else {
                    this.drawUi(bid, x - sw, y, 40, 0);
                }
                sw = (short)(sw + w);
            }
            i = anchor == 0 ? ((byte)(i + 1)) : ((byte)(i - 1));
            if(anchor == 0) {
                if(i < str.length()) {
                    continue;
                }
                return;
            }
            if(i <= -1) {
                break;
            }
        }
    }

    public void drawRect(int c, int x0, int y0, int w, int h) {
        Ui.g.setColor(c);
        Ui.g.drawRect(x0, y0, w, h);
    }

    public void drawRectZ(int color, int x, int y, int w, int h, int s) {
        Ui.g.setColor(color);
        Graphics graphics0 = Ui.g;
        Ms.i();
        int v6 = x - Ms.abs(this.rz);
        Ms.i();
        int v7 = y - Ms.abs(this.rz);
        Ms.i();
        int v8 = (Ms.abs(this.rz) << 1) + w;
        Ms.i();
        graphics0.drawRect(v6, v7, v8, (Ms.abs(this.rz) << 1) + h);
        byte b = (byte)(this.rz + 1);
        this.rz = b;
        if(b > s) {
            this.rz = (byte)(-s);
        }
    }

    public void drawRegion(Image image, int mx, int my, int mw, int mh, int realX, int realY, int anchor, int manipulation, Graphics g) {
        g.drawRegion(image, mx, my, mw, mh, ((int)Ui.transforms[manipulation]), realX, realY, anchor);
    }

    public void drawString(String str_hit, int x, int y, int anchor, int color, int mode) {
        int c0 = 0xCAA856;
        int c1 = 0x381808;
        switch(color) {
            case 0: {
                c0 = 0;
                c1 = 0xFFFFFF;
                break;
            }
            case 1: {
                c0 = 5461075;
                c1 = 0x75EAFF;
                break;
            }
            case 2: {
                c0 = 2707928;
                c1 = 0xA808;
                break;
            }
            case 3: {
                c0 = 1908277;
                c1 = 0x5EE7;
                break;
            }
            case 4: {
                c0 = 0x140E03;
                c1 = 0x4FC7FF;
                break;
            }
            case 5: {
                c0 = 0x221503;
                c1 = 0xFF6C00;
                break;
            }
            case 6: {
                c0 = 8075577;
                c1 = 0xF70808;
                break;
            }
            case 7: {
                c0 = 0x442B01;
                c1 = 0xFFB400;
                break;
            }
            case 8: {
                c0 = 0x9A7604;
                c1 = 0xC000FF;
                break;
            }
            case 9: {
                c0 = 0xB07038;
                break;
            }
            case 10: {
                c0 = 0x140225;
                c1 = 0x868686;
            }
        }
        if(mode == 2) {
            Ui.g.setColor(c0);
            Ui.g.drawString(str_hit, x - 1, y + 1, anchor);
            Ui.g.drawString(str_hit, x + 1, y + 1, anchor);
            Ui.g.drawString(str_hit, x, y, anchor);
            Ui.g.drawString(str_hit, x, y + 2, anchor);
            Ui.g.drawString(str_hit, x + 1, y + 2, anchor);
            Ui.g.drawString(str_hit, x - 1, y + 2, anchor);
            Ui.g.drawString(str_hit, x - 1, y, anchor);
            Ui.g.drawString(str_hit, x + 1, y, anchor);
        }
        Ui.g.setColor(c1);
        if(mode == 1) {
            Ui.g.drawString(str_hit, x + 1, y + 1, anchor);
        }
        Ui.g.drawString(str_hit, x, y + 1, anchor);
    }

    public void drawStringColor(String str, int x, int y, int color, int mode) {
        int c = (byte)color;
        int start = 0;
        int tw = 0;
        do {
            int end = (byte)str.indexOf("#", start);
            if(end == -1) {
                this.drawString(str.substring(start, str.length()), x + tw, y, 0, c, mode);
            }
            else {
                String s1 = str.substring(start, end);
                this.drawString(s1, x + tw, y, 0, c, mode);
                tw = (short)(Ms.i().getStringWidth(s1) + tw);
                c = (byte)(Integer.parseInt(str.substring(end + 1, end + 2)) - 1);
                start = (byte)(end + 2);
                if(c == -1) {
                    c = (byte)color;
                }
            }
        }
        while(end != -1);
    }

    public void drawStringY(Object[] str, int x, int y, int start, int end, int sh, int c, int strT) {
        for(int i = (byte)start; i < end && i < str.length; i = (byte)(i + 1)) {
            Ui.i().drawString(str[i].toString(), x, y + (i - start) * sh, 0, c, strT);
        }
    }

    public void drawStringY(StringBuffer[] showS, int x, int y, int fh, int color, int mode) {
        for(int d = 0; d < showS.length; d = (byte)(d + 1)) {
            this.drawStringColor(showS[d].toString(), x, y + 4 + d * fh, color, mode);
        }
    }

    public void drawTriangle(int x, int y, int w, boolean dir, boolean ct) {
    }

    public void drawTriangle1(int x, int y, int w, boolean dir, boolean ct) {
        Ms.i();
        this.drawUi(30, x - w - Ms.abs(this.cTriangle), y, 6, 4);
        Ms.i();
        this.drawUi(30, Ms.abs(this.cTriangle) + (x + w), y, 10, 0);
        if(ct) {
            byte b = (byte)(this.cTriangle + 1);
            this.cTriangle = b;
            if(b > 4) {
                this.cTriangle = -3;
            }
        }
    }

    public void drawUi(int action, int x, int y, int anchor, int manipulation) {
        this.drawRegion(this.ui_img, ((int)this.ui_modules[action][0]), ((int)this.ui_modules[action][1]), ((int)this.ui_modules[action][2]), ((int)this.ui_modules[action][3]), x, y, anchor, manipulation, Ui.g);
    }

    public void drawVolume(int x, int y, int v, boolean bb) {
        Ui.g.setColor((bb ? 0x7004B : 0xB07038));
        Ui.g.drawRect(x + 2, y + 5, 7, 10);
        Ui.g.drawRect(x + 10, y + 2, 7, 13);
        Ui.g.drawRect(x + 18, y - 1, 8, 16);
        Ui.g.setColor((bb ? 16048400 : 0x381808));
        Ui.g.drawRect(x + 3, y + 6, 6, 8);
        Ui.g.drawRect(x + 11, y + 3, 6, 11);
        Ui.g.drawRect(x + 19, y, 6, 14);
        if(v > 0) {
            Ui.g.fillRect(x + 4, y + 7, 5, 7);
        }
        if(v > 30) {
            Ui.g.fillRect(x + 12, y + 4, 5, 10);
        }
        if(v > 60) {
            Ui.g.fillRect(x + 20, y + 1, 5, 13);
        }
    }

    public void drawYesNo(boolean a, boolean b) {
        if(a) {
            this.drawUi(27, 0, 360, 36, 0);
        }
        if(b) {
            this.drawUi(28, 640, 360, 40, 0);
        }
    }

    public void drawYesNo_(boolean a, boolean b) {
        if(a) {
            this.drawUi(27, 0, Constants_H.HEIGHT, 36, 0);
        }
        if(b) {
            this.drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0);
        }
    }

    public void drawYesNo__(boolean a, boolean b) {
        int WIDTH = Constants_H.WIDTH__;
        int HEIGHT = Constants_H.HEIGHT__;
        if(a) {
            this.drawUi(27, 0, HEIGHT, 36, 0);
        }
        if(b) {
            this.drawUi(28, WIDTH, HEIGHT, 40, 0);
        }
    }

    public void fillArc(int c, int x, int y, int w, int h, int a0, int a1) {
        Ui.g.setColor(c);
        Ui.g.fillArc(x, y, w, h, a0, a1);
    }

    public void fillRect(int c, int x, int y, int w, int h) {
        Ui.g.setColor(c);
        Ui.g.fillRect(x, y, w, h);
    }

    public void fillRectB() {
        this.fillRect(0x52BDEF, 0, 0, 640, 360);
    }

    public static Ui i() {
        if(Ui.uiListener == null) {
            Ui.uiListener = new Ui();
        }
        return Ui.uiListener;
    }

    public void initGraphics(Graphics _g) {
        Ui.g = _g;
        Ui.dg = DirectUtils.getDirectGraphics(_g);
    }

    public void initUiModules() {
        this.ui_img = Ms.i().createImage("data/ui");
        Ms.i();
        Ms.skip = 0;
        this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
    }

    public void sliding(int x, int y, int h, int now, int all, boolean type) {
        if(!type) {
            this.drawK(x - 2, y - 2, 14, h + 4, 0);
        }
        this.drawK(x, y, 10, h, (type ? 0 : 3));
        this.drawK(x, y, 10, 11, (type ? 3 : 0));
        this.drawK(x, y + h - 11, 10, 11, (type ? 3 : 0));
        if(all - 1 < 1) {
            this.drawK(x + 1, y + 12, 8, h - 24, (type ? 3 : 0));
            return;
        }
        int kh = (byte)((h - 22) / all);
        if(kh < 15) {
            kh = 15;
        }
        this.drawK(x + 1, y + 12 + ((short)((h - 24 - kh) * now / (all - 1))), 8, kh, (type ? 3 : 0));
    }
}

