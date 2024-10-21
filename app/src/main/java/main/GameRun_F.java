package main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import com.nokia.mid.ui.DirectUtils;
import android.util.Log;
import dm.Sound;
import dm.Ms;
import dm.Ui;
import dm.Monster;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Graphics;
import com.nokia.mid.ui.DirectGraphics;

public class GameRun_F implements Key_H
{
    static DirectGraphics dg;
    static Graphics g;
    public static MainCanvas mc;
    static Graphics offG;
    public static int run_state;
    static Image scrT;
    public StringBuffer[] about_a;
    public StringBuffer[] about_b;
    public StringBuffer[] about_c;
    public StringBuffer[] about_d;
    public String[] action_str;
    final byte[] anchor;
    private byte brow5;
    public byte cMon_count;
    public Monster[] cMonsters;
    public byte cur_a;
    public byte cur_b;
    public byte cur_c;
    public Monster cur_emon;
    public Monster cur_mon;
    public String gogoST;
    public String gogoString;
    public byte help_page;
    public byte[] info;
    public int introT;
    public int introX;
    public byte[][][] items;
    public byte[] itemsLength;
    public byte[] len;
    public Map map;
    public byte max_monsters;
    public byte max_takes;
    public byte[] monInfoList;
    public short move_x;
    public short move_y;
    public byte myMon_length;
    public Monster[] myMonsters;
    public byte[][] nidusList;
    public byte[] nidusMap;
    public byte page_max;
    public PointerKey pkey;
    public byte popMenu;
    public byte[] rmsNidus;
    public byte[] rmsOther;
    public byte[] rmsSms;
    public byte[][] select;
    public byte[][] selectBag;
    public byte[] select_it;
    public byte[] select_st;
    public byte selectx;
    public byte selecty;
    public StringBuffer[] showS;
    public byte[] src_c;
    public String str_cur;
    final short[] transB;
    
    static {
        GameRun_F.run_state = 1;
    }
    
    public GameRun_F() {
        super();
        this.anchor = new byte[] { 20, 36, 40, 24, 24, 40, 36, 20 };
        this.transB = new short[] { 0, 90, 180, 270, 8192, 8282, 8372, 8462 };
        this.introX = Constants_H.WIDTH_H;
        this.gogoString = "";
        this.introT = 640;
        this.gogoST = "";
        this.brow5 = 0;
        this.page_max = 0;
        this.help_page = 0;
        this.src_c = new byte[4];
        this.popMenu = -1;
        this.select_it = new byte[4];
        this.select_st = new byte[4];
        this.selectBag = new byte[4][2];
        this.select = new byte[2][2];
        this.max_takes = 3;
        this.max_monsters = 10;
    }
    
    private void drawSnare5(int brow5, final int n) {
        final Ui i = Ui.i();
        int n2;
        if (this.brow5 % 3 == 0) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        i.drawUi(8, brow5, n + n2, 0, 0);
        brow5 = this.brow5;
        this.brow5 = (byte)(brow5 + 1);
        if (brow5 > 100) {
            this.brow5 = 0;
        }
    }
    
    public boolean addNidus(final int n) {
        for (int i = 0; i < this.rmsNidus.length; i = (byte)(i + 5)) {
            if (this.rmsNidus[i] == -2) {
                this.rmsNidus[i] = (byte)n;
                Ms.i().putShort(0, this.rmsNidus, i + 1);
                Ms.i().putShort(200, this.rmsNidus, i + 3);
                return true;
            }
        }
        return false;
    }
    
    public byte[] createData(final int n) {
        return Ms.i().getStream("4", n);
    }
    
    public String createString(final String s) {
        Ms.i();
        Ms.skip = 0;
        return Ms.i().createStringArray(Ms.i().getStream(s, -1))[0].toString();
    }
    
    public void delNidus(final int n) {
        this.rmsNidus[n * 5] = -2;
    }
    
    public void drawHelpStr(final Graphics graphics, final StringBuffer[] array, int n, int n2, final int n3, final int n4) {
        byte b2;
        for (byte b = b2 = (byte)(this.help_page * n); b2 < b + n && b2 < array.length; ++b2) {
            Ui.i().drawString(array[b2].toString(), n2, n3 + (b2 - b) * 27, n4, 3, 0);
        }
        if (array.length > n) {
            n2 = array.length / n;
            if (array.length % n != 0) {
                n = 1;
            }
            else {
                n = 0;
            }
            this.page_max = (byte)(n2 + n);
            Ui.i().drawString(String.valueOf(this.help_page + 1) + "/" + this.page_max, Constants_H.WIDTH_H, Constants_H.HEIGHT - 2, 0x1 | 0x20, 3, 0);
            Ui.i().drawTriangle(Constants_H.WIDTH_H, Constants_H.HEIGHT - 12, 75, true, true);
        }
        else {
            this.page_max = 1;
        }
    }
    
    public void drawMenu(final StringBuffer[] array, final int n, final int n2, int n3) {
        int abs;
        if (n3 > 0) {
            Ui.i().drawKuang(n, n2, n3, array.length * 27 + 12);
            abs = n3;
        }
        else {
            Ms.i();
            abs = Ms.abs(n3);
        }
        for (byte b = 0; b < array.length; ++b) {
            if (b == 0) {
                n3 = 9;
            }
            else if (b == this.cur_a) {
                n3 = 8;
            }
            else {
                n3 = 0;
            }
            Ui.i().drawString(array[b].toString(), (abs >> 1) + n, n2 + 4 + b * 27, 0x1 | 0x10, n3, 0);
        }
    }
    
    public void drawPauseMenu(final int n, final int n2, final int n3, int volume) {
        Ui.i().drawK2(n, n2, n3, volume, 1);
        Ui.i().drawK1(n + 9, n2 + 25 + 11, n3 - 18, volume - 25 - 19, 0);
        Ui.i().drawListKY(6, n + 8, n2 + 25 + 13, n3 - 16, 1, 33, -1, this.selecty, 4, 2);
        this.pkey.selectListSY(this.action_str.length, n + 8, n2 + 25 + 13, n3 - 16, 1, 33, -1, this.selecty);
        final byte selectMenuX = this.pkey.selectMenuX(2, n, n2 + 3, n3 >> 1, 38);
        if (selectMenuX != -1) {
            this.selectx = selectMenuX;
            this.selecty = 0;
            this.setPauseS(this.selectx);
        }
        if (this.selectx == 1) {
            final Ui i = Ui.i();
            volume = Sound.i().getVolume();
            i.drawVolume((n3 >> 1) + n + 25 - 8 - 60, n2 + 25 + 16 + 33, volume, this.selecty == 1);
            Ui.i().drawListSYHasSound(this.action_str, n + 8, n2 + 25 + 13, n3 - 16, 32, this.selecty, 0, 3, 0);
        }
        else {
            Ui.i().drawListSY(this.action_str, n + 8, n2 + 25 + 13, n3 - 16, 32, this.selecty, 0, 3, 0);
        }
        final Ui j = Ui.i();
        if (this.selectx == 0) {
            volume = -60;
        }
        else {
            volume = 2;
        }
        j.drawK1((n3 >> 1) + n + volume, n2 + 4, 56, 29, 4);
        final Ui k = Ui.i();
        if (this.selectx == 0) {
            volume = 0;
        }
        else {
            volume = 1;
        }
        k.drawString("\u83dc\u5355", (n3 >> 1) + n - 25 - 3, n2 + 3, 0x1 | 0x10, volume, 0);
        final Ui l = Ui.i();
        if (this.selectx == 0) {
            volume = 1;
        }
        else {
            volume = 0;
        }
        l.drawString("\u7cfb\u7edf", (n3 >> 1) + n + 25 + 3, n2 + 3, 0x1 | 0x10, volume, 0);
        Ui.i().drawTriangle((n3 >> 1) + n, n2 + 12, 80, true, true);
    }
    
    public void drawSelectMenu(final Object[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        for (byte b = 0; b < array.length; ++b) {
            final Ui i = Ui.i();
            int n7;
            if (b == n6) {
                n7 = 1;
            }
            else {
                n7 = n5;
            }
            i.drawK0(n, n2 + (n4 + 33) * b, n3, 33, n7);
            final Ui j = Ui.i();
            final String string = array[b].toString();
            int n8;
            if (b == n6) {
                n8 = 0;
            }
            else {
                n8 = 3;
            }
            j.drawString(string, (n3 >> 1) + n, n2 + 2 + (n4 + 33) * b, 0x1 | 0x10, n8, 1);
            Log.e("sk", "drawSelectMenu");
            if (this.pkey.isSelect(n, (n4 + 33) * b + n2, n3, 33)) {
                if (this.map.my.state == 12) {
                    if (b == n6) {
                        this.map.my.state = 13;
                    }
                    else {
                        this.cur_a = b;
                    }
                }
                else if (GameRun_F.run_state == 35 || GameRun_F.run_state == 25 || this.map.my.state == 16 || GameRun_F.run_state == 65 || GameRun_F.run_state == 66 || GameRun_F.run_state == 61) {
                    if (b == n6) {
                        this.pkey.setKey5();
                    }
                    else {
                        this.popMenu = b;
                    }
                }
            }
        }
    }
    
    public void drawSelectMenu_(final Object[] array, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        for (byte b = 0; b < array.length; ++b) {
            final Ui i = Ui.i();
            int n7;
            if (b == n6) {
                n7 = 1;
            }
            else {
                n7 = n5;
            }
            i.drawK0(n, n2 + (n4 + 33) * b, n3, 25 + 8, n7);
            final Ui j = Ui.i();
            final String string = array[b].toString();
            int n8;
            if (b == n6) {
                n8 = 0;
            }
            else {
                n8 = 3;
            }
            j.drawString(string, (n3 >> 1) + n, n2 + 2 + (n4 + 33) * b, 0x1 | 0x10, n8, 1);
            GameRun_F.g.setColor(16711680);
            if (this.pkey.isSelect(Constants_H.WIDTH * n / Constants_H.WIDTH__, ((n4 + 33) * b + n2) * Constants_H.WIDTH / Constants_H.WIDTH__, Constants_H.WIDTH * n3 / Constants_H.WIDTH__, Constants_H.WIDTH * 33 / Constants_H.WIDTH__)) {
                if (this.map.my.state == 12) {
                    if (b == n6) {
                        this.map.my.state = 13;
                    }
                    else {
                        this.cur_a = b;
                    }
                }
                else if (GameRun_F.run_state == 35 || GameRun_F.run_state == 25 || this.map.my.state == 16 || GameRun_F.run_state == 65 || GameRun_F.run_state == 66) {
                    if (b == n6) {
                        this.pkey.setKey5();
                    }
                    else {
                        this.popMenu = b;
                    }
                }
            }
        }
    }
    
    public void drawSrcLine(final Graphics graphics, final int n, int n2, int i, final boolean b, final boolean b2) {
        int n3 = 0;
        final byte b3 = (byte)(n2 / i);
        graphics.setColor(0);
        if (!b) {
            int n4;
            int n5;
            for (n2 = (short)(2 << this.src_c[0]), i = (byte)(i - 1); i > -1; i = (byte)(i - 1), n2 = (short)(n2 / 2)) {
                if (b3 - n2 > 0) {
                    if (n2 < 2) {
                        n4 = 0;
                    }
                    else {
                        n4 = n2;
                    }
                    if (n2 < 2) {
                        n5 = 0;
                    }
                    else {
                        n5 = n2;
                    }
                    graphics.fillRect(0, i * b3 + n + n4, 640, b3 - n5);
                }
            }
            if (b2 && this.src_c[0] < 12) {
                final byte[] src_c = this.src_c;
                ++src_c[0];
            }
            else if (!b2 && this.src_c[0] > 0) {
                final byte[] src_c2 = this.src_c;
                --src_c2[0];
            }
        }
        else {
            int n6;
            for (n2 = (short)(2 << this.src_c[1]); b && n3 < i; n3 = (byte)(n3 + 1), n2 = (short)(n2 / 2)) {
                if (b3 - n2 > 0) {
                    if (n2 < 2) {
                        n6 = 0;
                    }
                    else {
                        n6 = n2;
                    }
                    graphics.fillRect(0, n3 * b3 + n, 640, b3 - n6);
                }
            }
            if (b2 && this.src_c[1] < 12) {
                final byte[] src_c3 = this.src_c;
                ++src_c3[1];
            }
            else if (!b2 && this.src_c[1] > 0) {
                final byte[] src_c4 = this.src_c;
                --src_c4[1];
            }
        }
    }
    
    public void drawZero(final int n, final int n2, final int n3, final int n4) {
        Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55\u7ee7\u7eed", n, n2, n3, n4, 0);
    }
    
    public void drawZero(final String str, final int n) {
        Ui.i().drawString("\u70b9\u51fb\u5c4f\u5e55" + str, Constants_H.WIDTH_H, n, 0x1 | 0x20, 0, 0);
    }
    
    public byte getNLevel(final int n) {
        return this.nidusList[1][this.getRid(n)];
    }
    
    public short getNexp(final int n, final int n2) {
        return Ms.i().getShort(this.rmsNidus, n * 5 + n2);
    }
    
    public byte getNid(final int n) {
        return this.nidusList[0][this.getRid(n)];
    }
    
    public byte getRid(final int n) {
        return this.rmsNidus[n * 5];
    }
    
    public short getSIndexW(final String s) {
        final int n = 0;
        final byte b = 0;
        byte b3;
        final byte b2 = b3 = (byte)s.indexOf("#", 0);
        int n2 = n;
        byte fromIndex = b;
        if (b2 == 0) {
            b3 = 1;
            fromIndex = b;
            n2 = n;
        }
        while (b3 != -1) {
            fromIndex += b3;
            b3 = (byte)s.indexOf("#", fromIndex);
            n2 = (byte)(n2 + 1);
        }
        return (short)(Ms.i().getStringWidth("#1") * n2);
    }
    
    public void gogoWord(final String s, final int introX, final int n, final int n2, final int n3, final int n4, final int n5) {
        final short n6 = (short)(Ms.i().getStringWidth(s) - this.getSIndexW(s));
        if (n6 > 640 - introX - n2) {
            this.introX -= n5;
            if (this.introX + n6 < introX) {
                this.introX = 640 - n2 - 75;
            }
        }
        else {
            this.introX = introX;
        }
        GameRun_F.g.clipRect(introX, n, 640 - n2 - introX, 30);
        Ui.i().drawStringColor(s, this.introX, n, n3, n4);
        GameRun_F.g.setClip(0, 0, 640, 360);
    }
    
    public void gogoWordM(final String s, final int n, final int n2, final int n3, final int n4, final int n5) {
        final short n6 = (short)Ms.i().getStringWidth(s);
        this.introT -= n5;
        if (this.introT + n6 < n2 << 1) {
            this.introT = 640 + 1;
        }
        GameRun_F.g.clipRect(n2, n, 640 - (n2 << 1), 30);
        Ui.i().drawString(s, this.introT, n, 0, n3, n4);
        GameRun_F.g.setClip(0, 0, 640, 360);
    }
    
    public void initGraphics(final Graphics g) {
        GameRun_F.g = g;
        GameRun_F.dg = DirectUtils.getDirectGraphics(g);
    }
    
    public void initOffG() {
        GameRun_F.scrT = Image.createImage(Constants_H.WIDTH + 20, Constants_H.HEIGHT + 20);
        GameRun_F.offG = GameRun_F.scrT.getGraphics();
    }
    
    public void initRmsOther() {
        this.rmsOther = null;
        final byte[] rmsOther = new byte[12];
        rmsOther[0] = -1;
        rmsOther[3] = 1;
        this.rmsOther = rmsOther;
    }
    
    public byte isMyLevel(final boolean b) {
        switch (this.rmsOther[3]) {
            case 1: {
                if (b && this.monInfoList[103] > 4) {
                    this.rmsOther[3] = 2;
                    break;
                }
                return 5;
            }
            case 2: {
                if (b && this.monInfoList[103] > 9) {
                    this.rmsOther[3] = 3;
                    break;
                }
                return 10;
            }
            case 3: {
                if (b && this.monInfoList[103] > 14) {
                    this.rmsOther[3] = 4;
                    break;
                }
                return 15;
            }
            case 4: {
                if (b && this.monInfoList[103] > 29) {
                    this.rmsOther[3] = 5;
                    break;
                }
                return 30;
            }
        }
        return -1;
    }
    
    public void loadInfoList() {
        this.info = Ms.i().rmsOptions(6, null, 1);
        if (this.info[0] == -1) {
            this.monInfoList = new byte[105];
            for (int i = 0; i < this.monInfoList.length; ++i) {
                this.monInfoList[i] = 0;
            }
        }
        else {
            this.monInfoList = this.info;
        }
        this.info = null;
    }
    
    public void loadItem() {
        this.info = Ms.i().rmsOptions(4, null, 1);
        this.len = new byte[] { 16, 19, 23, 12 };
        this.itemsLength = new byte[4];
        if (this.info[0] != -1) {
            for (int i = 0; i < 4; ++i) {
                this.itemsLength[i] = this.info[i];
            }
        }
        this.items = new byte[this.itemsLength.length][][];
        int j = 0;
        int n = 0;
        while (j < this.items.length) {
            this.items[j] = new byte[this.len[j]][2];
            for (byte b = 0; b < this.itemsLength[j]; ++b, ++n) {
                this.items[j][b][0] = this.info[n * 2 + 4];
                this.items[j][b][1] = this.info[n * 2 + 4 + 1];
            }
            ++j;
        }
        this.info = null;
        this.len = null;
    }
    
    public void loadMon(int n, final byte[][] array) {
        this.info = Ms.i().rmsOptions(n + 8, null, 1);
        final int n2 = 0;
        final int n3 = 0;
        Label_0085: {
            ByteArrayInputStream byteArrayInputStream2 = null;
            if (n != 0) {
                this.myMonsters = new Monster[5];
                if (this.info[0] == -1) {
                    this.myMon_length = 0;
                    return;
                }
                final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.info);
                this.myMon_length = (byte)byteArrayInputStream.read();
                n = n2;
                while (true) {
                    byteArrayInputStream2 = byteArrayInputStream;
                    if (n >= this.myMon_length) {
                        break Label_0085;
                    }
                    this.loadMon(byteArrayInputStream, this.myMonsters[n] = new Monster(), array);
                    ++n;
                }
            }
            while (true) {
                while (true) {
                    Label_0106: {
                        try {
                            this.cMonsters = new Monster[95];
                            if (this.info[0] == -1) {
                                this.cMon_count = 0;
                            }
                            else {
                                byteArrayInputStream2 = new ByteArrayInputStream(this.info);
                                this.cMon_count = (byte)byteArrayInputStream2.read();
                                n = n3;
                                if (n < this.cMon_count) {
                                    break Label_0106;
                                }
                                byteArrayInputStream2.close();
                                this.info = null;
                            }
                            return;
                        }
                        catch (final Exception ex) {
                            ex.printStackTrace();
                            return;
                        }
                        return;
                    }
                    this.loadMon(byteArrayInputStream2, this.cMonsters[n] = new Monster(), array);
                    ++n;
                    continue;
                }
            }
        }
    }
    
    public void loadMon(final ByteArrayInputStream byteArrayInputStream, final Monster monster, final byte[][] array) throws IOException {
        monster.monster = new byte[18];
        monster.monsterPro = new short[8];
        byteArrayInputStream.read(monster.monster);
        byteArrayInputStream.read(this.len = new byte[10]);
        for (int i = 0; i < 5; ++i) {
            monster.monsterPro[i] = (short)((this.len[i * 2 + 1] & 0xFF) << 8 | (this.len[i * 2 + 0] & 0xFF));
        }
        monster.setProAFD(array[monster.monster[0]]);
        this.len = null;
    }
    
    public void loadRmsNidus() {
        this.rmsNidus = Ms.i().rmsOptions(3, null, 1);
        if (this.rmsNidus[0] == -1) {
            this.rmsNidus = null;
            this.rmsNidus = new byte[] { -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10 };
        }
    }
    
    public void loadRmsOther() {
        this.info = Ms.i().rmsOptions(10, null, 1);
        if (this.info[0] == -1) {
            this.setMaxTakes(true);
            this.initRmsOther();
        }
        else {
            this.rmsOther = this.info;
            this.setMaxTakes(false);
        }
        this.info = null;
    }
    
    public void loadRmsSms() {
        this.rmsSms = Ms.i().rmsOptions(5, null, 1);
        if (this.rmsSms == null || this.rmsSms[0] == -1) {
            this.rmsSms = null;
            this.rmsSms = new byte[7];
        }
        if (this.rmsSms[0] == 10) {
            final byte[] rmsOther = this.rmsOther;
            rmsOther[2] |= 0x8;
        }
    }
    
    public void saveInfoList() {
        Ms.i().rmsOptions(6, this.monInfoList, 2);
    }
    
    public void saveItem() {
        int n = 0;
        for (int i = 0; i < 4; ++i) {
            n += this.itemsLength[i];
        }
        this.info = new byte[this.items.length + n * 2];
        int n2 = 0;
        for (int j = 0; j < 4; ++j) {
            this.info[j] = this.itemsLength[j];
        }
        for (int k = 0; k < this.items.length; ++k) {
            for (byte b = 0; b < this.itemsLength[k]; ++b, ++n2) {
                this.info[n2 * 2 + 4] = this.items[k][b][0];
                this.info[n2 * 2 + 4 + 1] = this.items[k][b][1];
            }
        }
        Ms.i().rmsOptions(4, this.info, 2);
        this.info = null;
    }
    
    public void saveMon(int i) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final int n = 0;
        final int n2 = 0;
        Label_0075: {
            if (i != 0) {
                break Label_0075;
            }
            Block_4_Outer:Label_0086_Outer:
            while (true) {
                while (true) {
                    try {
                        byteArrayOutputStream.write(this.cMon_count);
                        for (i = n2; i < this.cMon_count; ++i) {
                            this.saveMon(byteArrayOutputStream, this.cMonsters[i]);
                        }
                        Ms.i().rmsOptions(8, byteArrayOutputStream.toByteArray(), 2);
                        while (true) {
                            while (true) {
                                byteArrayOutputStream.close();
                                return;
                                Ms.i().rmsOptions(9, byteArrayOutputStream.toByteArray(), 2);
                                continue Block_4_Outer;
                            }
                            byteArrayOutputStream.write(this.myMon_length);
                            i = n;
                            iftrue(Label_0122:)(i < this.myMon_length);
                            continue Label_0086_Outer;
                        }
                    }
                    catch (final Exception ex) {
                        ex.printStackTrace();
                        return;
                    }
                    Label_0122: {
                        this.saveMon(byteArrayOutputStream, this.myMonsters[i]);
                    }
                    ++i;
                    continue;
                }
            }
        }
    }
    
    public void saveMon(final ByteArrayOutputStream byteArrayOutputStream, final Monster monster) throws IOException {
        byteArrayOutputStream.write(monster.monster);
        for (int i = 0; i < 5; ++i) {
            final short n = monster.monsterPro[i];
            byteArrayOutputStream.write(n & 0xFF);
            byteArrayOutputStream.write(n >> 8 & 0xFF);
        }
    }
    
    public void setAction_str(String[] action_str) {
        this.action_str = action_str;
        action_str = null;
    }
    
    public void setGogoWord() {
        this.introT = Constants_H.WIDTH;
        Ms.i();
        Ms.skip = 0;
        final StringBuffer[] stringArray = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
        Ms.i();
        this.gogoST = stringArray[Ms.getRandom(stringArray.length)].toString();
        final StringBuffer[] array = (StringBuffer[])null;
    }
    
    public void setMaxTakes(final boolean b) {
        if (b) {
            this.max_takes = 3;
            this.max_monsters = 10;
        }
        else if (this.rmsOther[3] == 2) {
            this.max_takes = 4;
            this.max_monsters = 20;
        }
        else if (this.rmsOther[3] == 3) {
            this.max_takes = 5;
            this.max_monsters = 40;
        }
        else if (this.rmsOther[3] == 4) {
            this.max_takes = 5;
            this.max_monsters = 80;
        }
        else if (this.rmsOther[3] == 5) {
            this.max_takes = 5;
            this.max_monsters = 95;
        }
    }
    
    public void setNidusExp(int n) {
        if (n / 10 < 1) {
            n = 1;
        }
        else {
            n /= 10;
        }
        for (int i = 0; i < 5; i = (byte)(i + 1)) {
            if (this.getRid(i) != -2) {
                Ms.i().putShort(this.getNexp(i, 1) + n, this.rmsNidus, i * 5 + 1);
                if (this.getNexp(i, 1) > this.getNexp(i, 3)) {
                    Ms.i().putShort(this.getNexp(i, 3), this.rmsNidus, i * 5 + 1);
                }
            }
        }
    }
    
    public void setPauseS(final int n) {
        if (n == 0) {
            this.setAction_str(new String[] { "\u4fdd\u5b58\u6e38\u620f", "\u67e5\u770b\u5ba0\u7269", "\u4eba\u7269\u80cc\u5305", "\u5ba0\u7269\u56fe\u9274", "\u67e5\u770b\u4efb\u52a1", "\u8fd4\u56de\u6e38\u620f" });
        }
        else {
            this.setAction_str(new String[] { "\u8bfb\u53d6\u8fdb\u5ea6", "\u58f0\u97f3", "\u6e38\u620f\u5e2e\u52a9", "\u56de\u4e3b\u83dc\u5355" });
        }
    }
    
    public void setStringB(final String s, final int n, final int n2) {
        if (n2 == 0) {
            this.about_a = Ms.i().groupString(s, n);
        }
        else if (n2 == 1) {
            this.about_b = Ms.i().groupString(s, n);
        }
        else if (n2 == 2) {
            this.about_c = Ms.i().groupString(s, n);
        }
        else if (n2 == 3) {
            this.about_d = Ms.i().groupString(s, n);
        }
    }
    
    public void showString(final String s, final int n, final int n2) {
        Ui.i().drawK0(n2 - 5, n, 640 + 10, ((byte)(s.length() / 11) + 1) * 25 + 8, 3);
        this.showStringM(s, 320 + n2, n + 3, 11, 0);
    }
    
    public void showString(final StringBuffer[] array, int i, final int n, final int n2) {
        final int width__ = Constants_H.WIDTH__;
        final int n3 = Constants_H.WIDTH__ / 2;
        final int n4 = i + 5;
        if (n2 != 0) {
            Ui.i().drawKuang(n - 5, n4, width__ + 10, array.length * 25 + 12);
            if (n2 == 2) {
                this.drawSnare5(n3 + n, array.length * 25 + n4 + 4);
            }
        }
        for (i = 0; i < array.length; i = (byte)(i + 1)) {
            Ui.i().drawStringColor(array[i].toString(), 25 + n, n4 + 4 + i * 25, -1, 1);
        }
    }
    
    public void showStringM(final String s, final int n, final int n2, final int n3, final int n4) {
        for (byte b = (byte)(s.length() / n3), b2 = 0; b2 <= b; ++b2) {
            if (b == 0) {
                Ui.i().drawString(s, n, n2, 0x1 | 0x10, n4, 1);
                Log.e("sk", "strNum == 0");
            }
            else {
                final Ui i = Ui.i();
                int length;
                if (b2 + 1 > b) {
                    length = s.length();
                }
                else {
                    length = (b2 + 1) * n3;
                }
                i.drawString(s.substring(b2 * n3, length), n, n2 + b2 * 25, 0x1 | 0x10, n4, 0);
                Log.e("sk", "else");
            }
        }
    }
    
    public void showStringM_(final String s, final int n, final int n2, final int n3, final int n4) {
        for (byte b = (byte)(s.length() / n3), b2 = 0; b2 <= b; ++b2) {
            if (b == 0) {
                Ui.i().drawString(s, n, n2, 0x1 | 0x10, n4, 1);
                Log.e("sk", "strNum == 0");
            }
            else {
                final Ui i = Ui.i();
                int length;
                if (b2 + 1 > b) {
                    length = s.length();
                }
                else {
                    length = (b2 + 1) * n3;
                }
                i.drawString(s.substring(b2 * n3, length), n, n2 + b2 * 25, 0x1 | 0x10, n4, 0);
            }
        }
    }
}
