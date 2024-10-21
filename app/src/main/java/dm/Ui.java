package dm;

import com.nokia.mid.ui.DirectUtils;
import main.Constants_H;
import android.util.Log;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import com.nokia.mid.ui.DirectGraphics;

public class Ui
{
    public static DirectGraphics dg;
    public static Graphics g;
    private static final short[] transforms;
    private static Ui uiListener;
    private int[] MIRROR;
    private byte[][] MIRROR2;
    private byte[] MIRROR3;
    public byte cTriangle;
    private byte rz;
    private Image ui_img;
    private short[][] ui_modules;
    
    static {
        transforms = new short[] { 0, 5, 3, 6, 2, 4, 1, 7 };
    }
    
    public Ui() {
        super();
        this.MIRROR2 = new byte[][] { { 0, 1, 2, 3, 4, 5, 6, 7 }, { 4, 5, 6, 7, 0, 1, 2, 3 } };
        this.MIRROR3 = new byte[] { 1, -1 };
        this.MIRROR = new int[] { 0x4 | 0x10, 0x8 | 0x10 };
        this.cTriangle = 0;
        Ui.uiListener = this;
    }
    
    public static Ui i() {
        if (Ui.uiListener == null) {
            Ui.uiListener = new Ui();
        }
        return Ui.uiListener;
    }
    
    public boolean drawActionOne(final Sprite sprite, final int n, final int n2, final int n3, final byte[] array, final int n4, final boolean b) {
        this.drawFrameOne(sprite, sprite.action(n, (int)array[0], 0), n2, n3, n4);
        final byte b2 = (byte)(array[1] + 1);
        array[1] = b2;
        if (b2 <= sprite.action(n, array[0], 1)) {
            return false;
        }
        array[1] = 0;
        if (++array[0] < sprite.aLength(n)) {
            return false;
        }
        if (b) {
            array[0] = 0;
            return false;
        }
        array[0] = (byte)(sprite.aLength(n) - 1);
        return true;
        b3 = false;
        return b3;
    }
    
    public void drawBDir(final int n, final int n2, final int n3, final int n4) {
        Ui.g.setColor(8310516);
        Ui.g.drawRect(n, n2, n3 * 3, n4 << 1);
        Ui.g.drawRect(n + n3, n2, n3, n4 << 1);
        Ui.g.drawLine((float)n, (float)(n2 + n4), (float)(n3 * 3 + n), (float)(n2 + n4));
    }
    
    public void drawBarOne(final int n, final int n2, int n3, final int n4, int n5, final int n6) {
        int n7 = 16125468;
        if (n6 == 1) {
            n7 = 55551;
        }
        else if (n6 == 2) {
            n7 = 60177;
        }
        this.fillRect(4067649, n + 1, n2, n3 - 1, 5);
        Ui.g.drawRect(n, n2 + 1, n3, 5 - 3);
        n3 = 5 - 2;
        this.fillRect(16752385, n + 1, n2 + 1, n4, n3);
        if (n4 <= n5) {
            n5 = n4;
        }
        this.fillRect(n7, n + 1, n2 + 1, n5, n3);
    }
    
    public void drawFrameOne(final Sprite sprite, final int n, final int n2, final int n3, final int n4) {
        for (int i = 0; i < sprite.fLength(n); i = (short)(i + 1)) {
            this.drawModuleOne(sprite, sprite.frame(n, i, 0), n2 + sprite.frame(n, i, 1) * this.MIRROR3[n4], n3 + sprite.frame(n, i, 2), n4, sprite.frame(n, i, 3));
        }
    }
    
    public void drawImage(final Image image, final int n, final int n2, final int n3) {
        Ui.g.drawImage(image, n, n2, n3);
    }
    
    public void drawImage(final Image image, final int n, final int n2, final int n3, final int n4) {
        if (n4 == 0) {
            Ui.g.drawImage(image, n, n2, n3);
        }
        else {
            Ui.dg.drawImage(image, n, n2, n3, n4);
        }
    }
    
    public void drawK(final int n, final int n2, final int n3, final int n4, int color) {
        if (color == 0) {
            color = 15400191;
        }
        else if (color == 1) {
            color = 12352252;
        }
        else if (color == 2) {
            color = 12313343;
        }
        else if (color == 3) {
            color = 5228543;
        }
        else if (color == 4) {
            color = 30975;
        }
        else {
            color = 11121884;
        }
        Ui.g.setColor(color);
        Ui.g.fillRect(n + 1, n2, n3 - 2, n4);
        Ui.g.fillRect(n, n2 + 1, n3, n4 - 2);
    }
    
    public void drawK0(final int n, final int n2, final int n3, final int n4, int color) {
        final byte b = (byte)color;
        if (color == 2) {
            color = 15400191;
        }
        else {
            color = 1908277;
        }
        Ui.g.setColor(color);
        Ui.g.drawRect(n + 1, n2, n3 - 3, n4 - 1);
        Ui.g.drawRect(n, n2 + 1, n3 - 1, n4 - 3);
        this.drawK(n + 1, n2 + 1, n3 - 2, n4 - 2, b);
    }
    
    public void drawK1(final int n, final int n2, final int n3, final int n4, int color) {
        final Graphics g = Ui.g;
        int color2;
        if (color == 0) {
            color2 = 5461075;
        }
        else {
            color2 = 1908277;
        }
        g.setColor(color2);
        Ui.g.drawRect(n, n2 + 2, n3, n4 - 3);
        Ui.g.drawLine((float)(n + 1), (float)(n2 + n4), (float)(n + n3 - 1), (float)(n2 + n4));
        if (color == 0 || color == 1) {
            color = 15400191;
        }
        else if (color == 2) {
            color = 13892607;
        }
        else if (color == 3) {
            color = 7727871;
        }
        else {
            color = 12352252;
        }
        Ui.g.setColor(color);
        Ui.g.fillRect(n + 1, n2, n3 - 2, n4);
        Ui.g.fillRect(n, n2 + 1, n3, n4 - 2);
    }
    
    public void drawK2(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == 0) {}
        Ui.g.setColor(0);
        Ui.g.fillRect(n, n2, n3, n4);
        Ui.g.setColor(30975);
        Ui.g.fillRect(n + 2, n2 + 2, n3 - 4, n4 - 4);
    }
    
    public void drawK3(final int n, final int n2, final int n3, final int n4) {
        this.drawK0(n, n2, n3 - 1, n4 - 1, 0);
        Ui.g.setColor(1908277);
        Ui.g.fillRect(n + 2, n2 + 2, n3 - 2, n4 - 2);
    }
    
    public void drawK4(final int n, final int n2, final int n3, final int n4) {
        Ui.g.setColor(16771373);
        Ui.g.drawLine((float)(n + 1), (float)n2, (float)(n + n3 - 2), (float)n2);
        Ui.g.drawLine((float)(n + 1), (float)(n2 + n4 - 1), (float)(n + n3 - 2), (float)(n2 + n4 - 1));
        Ui.g.drawLine((float)n, (float)(n2 + 1), (float)n, (float)(n2 + n4 - 2));
        Ui.g.drawLine((float)(n + n3 - 1), (float)(n2 + 1), (float)(n + n3 - 1), (float)(n2 + n4 - 2));
        Ui.g.drawLine((float)n, (float)(n2 + 1), (float)(n + 1), (float)(n2 + 1));
        Ui.g.drawLine((float)(n + n3 - 2), (float)(n2 + 1), (float)(n + n3 - 1), (float)(n2 + 1));
        Ui.g.drawLine((float)n, (float)(n2 + n4 - 2), (float)(n + 1), (float)(n2 + n4 - 2));
        Ui.g.drawLine((float)(n + n3 - 2), (float)(n2 + n4 - 2), (float)(n + n3 - 2), (float)(n2 + n4 - 2));
    }
    
    public void drawKuang(final int n, final int n2, final int n3, final int n4) {
        Ui.g.setColor(1908277);
        Ui.g.drawRect(n + 1, n2, n3 - 4, n4 - 2);
        Ui.g.drawRect(n + 2, n2 + 1, n3 - 4, n4 - 2);
        Ui.g.drawLine((float)n, (float)(n2 + 1), (float)n, (float)(n2 + n4 - 3));
        Ui.g.drawLine((float)(n + n3 - 1), (float)(n2 + 2), (float)(n + n3 - 1), (float)(n2 + n4 - 2));
        this.fillRect(15400191, n + 1, n2 + 1, n3 - 3, n4 - 3);
    }
    
    public void drawKuangAdorn(final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 == 0) {
            Ui.g.setColor(1842484);
            Ui.g.drawRect(n + 20, n2 - 22, n3 - 21, 20);
            Ui.g.drawRect(n + 20, n2 - 22, n3 - 22, 21);
            this.fillRect(15129744, n + 20, n2 - 22, n3 - 22, 20);
            this.drawUi(33, n, n2, 36, 0);
            this.drawUi(31, n + n3 - 4, n2, 36, 0);
        }
        else if (n5 == 1) {
            this.drawUi(32, n, n2 - 7, 0, 0);
            this.drawUi(32, n + n3 + 5, n2 - 7, 0x8 | 0x10, 0);
            this.fillRect(13550445, n + 15, n2 - 5, n3 - 25, 13);
            this.fillRect(16116383, n + 15, n2 - 3, n3 - 25, 10);
            this.fillRect(13078326, n + 15, n2 + 10, n3 - 25, 5);
            this.drawLine(1842484, n + 15, n2 - 7, n + n3 - 11, n2 - 7);
            this.drawLine(16446403, n + 15, n2 - 6, n + n3 - 11, n2 - 6);
            this.drawLine(6168835, n + 15, n2 + 12, n + n3 - 11, n2 + 12);
            Ui.g.setColor(13281366);
            Ui.g.drawRect(n + 15, n2 + 8, n3 - 26, 1);
        }
        else if (n5 == 2) {
            this.drawUi(32, n, n2 + n4 - 1, 36, 6);
            this.drawUi(32, n + n3 + 5, n2 + n4 - 1, 40, 6);
            this.fillRect(13550445, n + 15, n2 + n4 - 16, n3 - 25, 13);
            this.fillRect(16116383, n + 15, n2 + n4 - 15, n3 - 25, 10);
            this.fillRect(13078326, n + 15, n2 + n4 - 23, n3 - 25, 5);
            this.drawLine(1842484, n + 15, n2 + n4 - 2, n + n3 - 11, n2 + n4 - 2);
            this.drawLine(16446403, n + 15, n2 + n4 - 3, n + n3 - 11, n2 + n4 - 3);
            this.drawLine(6168835, n + 15, n2 + n4 - 21, n + n3 - 11, n2 + n4 - 21);
            Ui.g.setColor(13281366);
            Ui.g.drawRect(n + 15, n2 + n4 - 18, n3 - 26, 1);
        }
    }
    
    public void drawKuangMap(final int n, final int n2, final int n3, final int n4, final boolean b) {
        int n5;
        if (b) {
            n5 = 14961;
        }
        else {
            n5 = 16762112;
        }
        this.fillRect(n5, n, n2, n3, n4);
        int n6;
        if (b) {
            n6 = 6724095;
        }
        else {
            n6 = 11370036;
        }
        this.fillRect(n6, n + 1, n2 + 1, n3 - 2, n4 - 2);
    }
    
    public void drawKuangSelect(final int n, final int n2, final int n3, final int n4, final int n5) {
        int color = 13281366;
        if (n5 == 1) {
            color = 11370036;
        }
        else if (n5 == 2) {
            color = 2233088;
        }
        else if (n5 == 3) {
            color = 15129744;
        }
        else if (n5 == 4) {
            color = 16762112;
        }
        else if (n5 == 5) {
            color = 6168835;
        }
        Ui.g.setColor(color);
        Ui.g.fillRect(n + 1, n2, n3 - 2, n4);
        Ui.g.drawRect(n, n2 + 1, n3 - 1, n4 - 3);
    }
    
    public void drawLine(final int color, final int n, final int n2, final int n3, final int n4) {
        Ui.g.setColor(color);
        Ui.g.drawLine((float)n, (float)n2, (float)n3, (float)n4);
    }
    
    public void drawListKY(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        for (int i = 0; i < n; i = (byte)(i + 1)) {
            if (i != n8) {
                this.drawK0(n2 + n5, n3 + (n6 + n7) * i, n4 - (n5 << 1), n6, n10);
            }
        }
        if (n8 != -1) {
            this.drawK1(n2, n3 + (n6 + n7) * n8, n4, n6, n9);
        }
    }
    
    public void drawListSY(final Object[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        for (int i = 0; i < array.length; i = (byte)(i + 1)) {
            final String string = array[i].toString();
            int n9;
            if (i == n5) {
                n9 = n6;
            }
            else {
                n9 = n7;
            }
            this.drawString(string, n + (n3 >> 1), i * n4 + (n2 + 2), 17, n9, n8);
        }
        Log.e("sk", "drawListSY");
    }
    
    public void drawListSYHasSound(final Object[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        for (int i = 0; i < array.length; i = (byte)(i + 1)) {
            final String string = array[i].toString();
            int n9;
            if (array[i].toString().equals("\u58f0\u97f3")) {
                n9 = 20;
            }
            else {
                n9 = 17;
            }
            int n10;
            if (i == n5) {
                n10 = n6;
            }
            else {
                n10 = n7;
            }
            this.drawString(string, n + (n3 >> 1), i * n4 + (n2 + 2), n9, n10, n8);
        }
    }
    
    public void drawModuleOne(final Sprite sprite, final int n, final int n2, final int n3, final int n4, final int n5) {
        this.drawRegion(sprite.img, sprite.module(n, 0), sprite.module(n, 1), sprite.module(n, 2), sprite.module(n, 3), n2, n3, this.MIRROR[n4], this.MIRROR2[n4][n5], Ui.g);
    }
    
    public void drawNum(final String s, final int n, final int n2, final int n3, final int n4) {
        if (s.length() != 0) {
            int n5;
            if (n3 == 0) {
                n5 = 0;
            }
            else {
                n5 = s.length() - 1;
            }
            int index = (byte)n5;
            int n6 = 0;
            while (true) {
                int n7;
                if (n4 == 0) {
                    n7 = 8;
                }
                else if (n4 == 1) {
                    n7 = 10;
                }
                else {
                    n7 = 14;
                }
                int n8 = -1;
                final char char1 = s.charAt(index);
                if (char1 >= '0' && char1 <= '9') {
                    final byte b = (byte)(char1 - '0');
                    if (n4 == 0) {
                        n8 = (byte)(b + 10);
                    }
                    else if (n4 == 1) {
                        n8 = (byte)(b + 35);
                    }
                    else {
                        n8 = (byte)(b + 57);
                    }
                }
                else if (char1 == '/') {
                    n8 = 20;
                }
                else if (char1 == '-') {
                    int n9;
                    if (n4 == 2) {
                        n9 = 56;
                    }
                    else {
                        n9 = 46;
                    }
                    n8 = (byte)n9;
                }
                else if (char1 == '+') {
                    n8 = 47;
                }
                else if (char1 == '%') {
                    n8 = 45;
                    n7 = 14;
                }
                else if (char1 == '\u7ea7') {
                    n8 = 29;
                    n7 = 12;
                }
                short n10;
                if (n8 != -1) {
                    if (n3 == 0) {
                        this.drawUi(n8, n + n6, n2, 36, 0);
                    }
                    else {
                        this.drawUi(n8, n - n6, n2, 40, 0);
                    }
                    n10 = (short)(n6 + n7);
                }
                else {
                    if (n3 == 0) {
                        this.drawString(new StringBuilder().append(char1).toString(), n + n6, n2 + 5, 36, 3, 0);
                    }
                    else {
                        this.drawString(new StringBuilder().append(char1).toString(), n - n6, n2 + 5, 40, 3, 0);
                    }
                    n10 = (short)(n6 + 25);
                }
                byte b2;
                if (n3 == 0) {
                    b2 = (byte)(index + 1);
                }
                else {
                    b2 = (byte)(index - 1);
                }
                if (n3 == 0) {
                    index = b2;
                    n6 = n10;
                    if (b2 >= s.length()) {
                        break;
                    }
                    continue;
                }
                else {
                    index = b2;
                    n6 = n10;
                    if (b2 <= -1) {
                        break;
                    }
                    continue;
                }
            }
        }
    }
    
    public void drawRect(final int color, final int n, final int n2, final int n3, final int n4) {
        Ui.g.setColor(color);
        Ui.g.drawRect(n, n2, n3, n4);
    }
    
    public void drawRectZ(int abs, final int n, final int n2, final int n3, final int n4, final int n5) {
        Ui.g.setColor(abs);
        final Graphics g = Ui.g;
        Ms.i();
        final int abs2 = Ms.abs(this.rz);
        Ms.i();
        abs = Ms.abs(this.rz);
        Ms.i();
        final int abs3 = Ms.abs(this.rz);
        Ms.i();
        g.drawRect(n - abs2, n2 - abs, (abs3 << 1) + n3, (Ms.abs(this.rz) << 1) + n4);
        final byte rz = (byte)(this.rz + 1);
        this.rz = rz;
        if (rz > n5) {
            this.rz = (byte)(-n5);
        }
    }
    
    public void drawRegion(final Image image, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final Graphics graphics) {
        graphics.drawRegion(image, n, n2, n3, n4, Ui.transforms[n8], n5, n6, n7);
    }
    
    public void drawString(final String s, final int n, int color, final int n2, int color2, final int n3) {
        final int n4 = 13281366;
        final int n5 = 3676168;
        final int n6 = color + 1;
        switch (color2) {
            default: {
                color2 = n5;
                color = n4;
                break;
            }
            case 0: {
                color = 0;
                color2 = 16777215;
                break;
            }
            case 1: {
                color = 5461075;
                color2 = 7727871;
                break;
            }
            case 2: {
                color = 2707928;
                color2 = 43016;
                break;
            }
            case 3: {
                color = 1908277;
                color2 = 24295;
                break;
            }
            case 4: {
                color = 1314307;
                color2 = 5228543;
                break;
            }
            case 5: {
                color = 2233603;
                color2 = 16739328;
                break;
            }
            case 6: {
                color = 8075577;
                color2 = 16189448;
                break;
            }
            case 7: {
                color = 4467457;
                color2 = 16757760;
                break;
            }
            case 8: {
                color = 10122756;
                color2 = 12583167;
                break;
            }
            case 9: {
                color = 11563064;
                color2 = 3676168;
                break;
            }
            case 10: {
                color = 1311269;
                color2 = 8816262;
                break;
            }
        }
        if (n3 == 2) {
            Ui.g.setColor(color);
            Ui.g.drawString(s, n - 1, n6, n2);
            Ui.g.drawString(s, n + 1, n6, n2);
            Ui.g.drawString(s, n, n6 - 1, n2);
            Ui.g.drawString(s, n, n6 + 1, n2);
            Ui.g.drawString(s, n + 1, n6 + 1, n2);
            Ui.g.drawString(s, n - 1, n6 + 1, n2);
            Ui.g.drawString(s, n - 1, n6 - 1, n2);
            Ui.g.drawString(s, n + 1, n6 - 1, n2);
        }
        Ui.g.setColor(color2);
        if (n3 == 1) {
            Ui.g.drawString(s, n + 1, n6, n2);
        }
        Ui.g.drawString(s, n, n6, n2);
    }
    
    public void drawStringColor(final String s, final int n, final int n2, final int n3, final int n4) {
        int n5 = (byte)n3;
        int beginIndex = 0;
        int n6 = 0;
        byte endIndex;
        do {
            endIndex = (byte)s.indexOf("#", beginIndex);
            if (endIndex != -1) {
                final String substring = s.substring(beginIndex, endIndex);
                this.drawString(substring, n + n6, n2, 0, n5, n4);
                final short n7 = (short)(Ms.i().getStringWidth(substring) + n6);
                final byte b = (byte)(Integer.parseInt(s.substring(endIndex + 1, endIndex + 2)) - 1);
                final byte b2 = (byte)(endIndex + 2);
                n5 = b;
                beginIndex = b2;
                n6 = n7;
                if (b == -1) {
                    n5 = (byte)n3;
                    n6 = n7;
                    beginIndex = b2;
                }
            }
            else {
                this.drawString(s.substring(beginIndex, s.length()), n + n6, n2, 0, n5, n4);
            }
        } while (endIndex != -1);
    }
    
    public void drawStringY(final Object[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        for (byte b = (byte)n3; b < n4 && b < array.length; ++b) {
            i().drawString(array[b].toString(), n, n2 + (b - n3) * n5, 0, n6, n7);
        }
    }
    
    public void drawStringY(final StringBuffer[] array, final int n, final int n2, final int n3, final int n4, final int n5) {
        for (int i = 0; i < array.length; i = (byte)(i + 1)) {
            this.drawStringColor(array[i].toString(), n, n2 + 4 + i * n3, n4, n5);
        }
    }
    
    public void drawTriangle(final int n, final int n2, final int n3, final boolean b, final boolean b2) {
    }
    
    public void drawTriangle1(final int n, final int n2, final int n3, final boolean b, final boolean b2) {
        Ms.i();
        this.drawUi(30, n - n3 - Ms.abs(this.cTriangle), n2, 0x4 | 0x2, 4);
        Ms.i();
        this.drawUi(30, Ms.abs(this.cTriangle) + (n + n3), n2, 0x8 | 0x2, 0);
        if (b2 && ++this.cTriangle > 4) {
            this.cTriangle = -3;
        }
    }
    
    public void drawUi(final int n, final int n2, final int n3, final int n4, final int n5) {
        this.drawRegion(this.ui_img, this.ui_modules[n][0], this.ui_modules[n][1], this.ui_modules[n][2], this.ui_modules[n][3], n2, n3, n4, n5, Ui.g);
    }
    
    public void drawVolume(final int n, final int n2, final int n3, final boolean b) {
        final Graphics g = Ui.g;
        int color;
        if (b) {
            color = 458827;
        }
        else {
            color = 11563064;
        }
        g.setColor(color);
        Ui.g.drawRect(n - 1 + 3, n2 + 5, 7, 10);
        Ui.g.drawRect(n + 5 + 2 + 3, n2 + 2, 7, 13);
        Ui.g.drawRect(n + 11 + 4 + 3, n2 - 1, 8, 16);
        final Graphics g2 = Ui.g;
        int color2;
        if (b) {
            color2 = 16048400;
        }
        else {
            color2 = 3676168;
        }
        g2.setColor(color2);
        Ui.g.drawRect(n + 3, n2 + 6, 6, 8);
        Ui.g.drawRect(n + 6 + 2 + 3, n2 + 3, 6, 11);
        Ui.g.drawRect(n + 12 + 4 + 3, n2, 6, 14);
        if (n3 > 0) {
            Ui.g.fillRect(n + 1 + 3, n2 + 7, 5, 7);
        }
        if (n3 > 30) {
            Ui.g.fillRect(n + 7 + 2 + 3, n2 + 4, 5, 10);
        }
        if (n3 > 60) {
            Ui.g.fillRect(n + 13 + 4 + 3, n2 + 1, 5, 13);
        }
    }
    
    public void drawYesNo(final boolean b, final boolean b2) {
        if (b) {
            this.drawUi(27, 0, 360, 36, 0);
        }
        if (b2) {
            this.drawUi(28, 640, 360, 40, 0);
        }
    }
    
    public void drawYesNo_(final boolean b, final boolean b2) {
        if (b) {
            this.drawUi(27, 0, Constants_H.HEIGHT, 36, 0);
        }
        if (b2) {
            this.drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0);
        }
    }
    
    public void drawYesNo__(final boolean b, final boolean b2) {
        final int width__ = Constants_H.WIDTH__;
        final int height__ = Constants_H.HEIGHT__;
        if (b) {
            this.drawUi(27, 0, height__, 36, 0);
        }
        if (b2) {
            this.drawUi(28, width__, height__, 40, 0);
        }
    }
    
    public void fillArc(final int color, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        Ui.g.setColor(color);
        Ui.g.fillArc(n, n2, n3, n4, n5, n6);
    }
    
    public void fillRect(final int color, final int n, final int n2, final int n3, final int n4) {
        Ui.g.setColor(color);
        Ui.g.fillRect(n, n2, n3, n4);
    }
    
    public void fillRectB() {
        this.fillRect(5422575, 0, 0, 640, 360);
    }
    
    public void initGraphics(final Graphics g) {
        Ui.g = g;
        Ui.dg = DirectUtils.getDirectGraphics(g);
    }
    
    public void initUiModules() {
        this.ui_img = Ms.i().createImage("data/ui");
        Ms.i();
        Ms.skip = 0;
        this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
    }
    
    public void sliding(final int n, final int n2, int n3, int n4, int n5, final boolean b) {
        if (!b) {
            this.drawK(n - 2, n2 - 2, 10 + 4, n3 + 4, 0);
        }
        int n6;
        if (b) {
            n6 = 0;
        }
        else {
            n6 = 3;
        }
        this.drawK(n, n2, 10, n3, n6);
        int n7;
        if (b) {
            n7 = 3;
        }
        else {
            n7 = 0;
        }
        this.drawK(n, n2, 10, 11, n7);
        int n8;
        if (b) {
            n8 = 3;
        }
        else {
            n8 = 0;
        }
        this.drawK(n, n2 + n3 - 11, 10, 11, n8);
        final int n9 = n3 - 22;
        final int n10 = n5 - 1;
        if (n10 < 1) {
            if (b) {
                n3 = 3;
            }
            else {
                n3 = 0;
            }
            this.drawK(n + 1, n2 + 12, 10 - 2, n9 - 2, n3);
        }
        else {
            n5 = (byte)(n9 / (n10 + 1));
            if ((n3 = n5) < 15) {
                n3 = 15;
            }
            n5 = (short)((n9 - 2 - n3) * n4 / n10);
            if (b) {
                n4 = 3;
            }
            else {
                n4 = 0;
            }
            this.drawK(n + 1, n2 + 12 + n5, 10 - 2, n3, n4);
        }
    }
}
