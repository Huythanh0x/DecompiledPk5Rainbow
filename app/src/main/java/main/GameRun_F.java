package main;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import dm.Monster;
import dm.Ms;
import dm.Sound;
import dm.Ui;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Player;

/* loaded from: classes.dex */
public class GameRun_F implements Key_H {
    static DirectGraphics dg;
    static Graphics g;
    public static MainCanvas mc;
    static Graphics offG;
    public static int run_state = 1;
    static Image scrT;
    public StringBuffer[] about_a;
    public StringBuffer[] about_b;
    public StringBuffer[] about_c;
    public StringBuffer[] about_d;
    public String[] action_str;
    public byte cMon_count;
    public Monster[] cMonsters;
    public byte cur_a;
    public byte cur_b;
    public byte cur_c;
    public Monster cur_emon;
    public Monster cur_mon;
    public byte[] info;
    public byte[][][] items;
    public byte[] itemsLength;
    public byte[] len;
    public Map map;
    public byte[] monInfoList;
    public short move_x;
    public short move_y;
    public byte myMon_length;
    public Monster[] myMonsters;
    public byte[][] nidusList;
    public byte[] nidusMap;
    public PointerKey pkey;
    public byte[] rmsNidus;
    public byte[] rmsOther;
    public byte[] rmsSms;
    public byte selectx;
    public byte selecty;
    public StringBuffer[] showS;
    public String str_cur;
    final byte[] anchor = {20, Constants_H.f79, 40, 24, 24, 40, Constants_H.f79, 20};
    final short[] transB = {0, 90, 180, 270, 8192, 8282, 8372, 8462};
    public int introX = Constants_H.WIDTH_H;
    public String gogoString = "";
    public int introT = Constants_H.WIDTH_;
    public String gogoST = "";
    private byte brow5 = 0;
    public byte page_max = 0;
    public byte help_page = 0;
    public byte[] src_c = new byte[4];
    public byte popMenu = -1;
    public byte[] select_it = new byte[4];
    public byte[] select_st = new byte[4];
    public byte[][] selectBag = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 2);
    public byte[][] select = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 2, 2);
    public byte max_takes = 3;
    public byte max_monsters = 10;

    public void initGraphics(Graphics _g) {
        g = _g;
        dg = DirectUtils.getDirectGraphics(_g);
    }

    public void initOffG() {
        scrT = Image.createImage(Constants_H.WIDTH + 20, Constants_H.HEIGHT + 20);
        offG = scrT.getGraphics();
    }

    public void setStringB(String str, int w, int mode) {
        if (mode != 0) {
            if (mode != 1) {
                if (mode != 2) {
                    if (mode == 3) {
                        this.about_d = Ms.i().groupString(str, w);
                        return;
                    }
                    return;
                }
                this.about_c = Ms.i().groupString(str, w);
                return;
            }
            this.about_b = Ms.i().groupString(str, w);
            return;
        }
        this.about_a = Ms.i().groupString(str, w);
    }

    public short getSIndexW(String str) {
        byte num = 0;
        byte start = 0;
        byte end = (byte) str.indexOf("#", 0);
        if (end == 0) {
            end = 1;
        }
        while (end != -1) {
            start = (byte) (start + end);
            end = (byte) str.indexOf("#", start);
            num = (byte) (num + 1);
        }
        return (short) (Ms.i().getStringWidth("#1") * num);
    }

    public void drawZero(int x, int y, int anchor, int color) {
        Ui.i().drawString(Constants_H.GAME_TXT_28, x, y, anchor, color, 0);
    }

    public void drawZero(String str, int y) {
        Ui.i().drawString("点击屏幕" + str, Constants_H.WIDTH_H, y, 1 | 32, 0, 0);
    }

    public void gogoWord(String string, int x, int y, int w, int color, int strT, int speed) {
        short sw = (short) (Ms.i().getStringWidth(string) - getSIndexW(string));
        if (sw > (Constants_H.WIDTH_ - x) - w) {
            this.introX -= speed;
            if (this.introX + sw < x) {
                this.introX = (Constants_H.WIDTH_ - w) - 75;
            }
        } else {
            this.introX = x;
        }
        g.clipRect(x, y, (Constants_H.WIDTH_ - w) - x, 30);
        Ui.i().drawStringColor(string, this.introX, y, color, strT);
        g.setClip(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
    }

    public void gogoWordM(String string, int y, int w, int color, int strT, int speed) {
        short sw = (short) Ms.i().getStringWidth(string);
        this.introT -= speed;
        if (this.introT + sw < (w << 1)) {
            this.introT = Constants_H.WIDTH_ + 1;
        }
        g.clipRect(w, y, Constants_H.WIDTH_ - (w << 1), 30);
        Ui.i().drawString(string, this.introT, y, 0, color, strT);
        g.setClip(0, 0, Constants_H.WIDTH_, Constants_H.HEIGHT_);
    }

    public void setGogoWord() {
        this.introT = Constants_H.WIDTH;
        Ms.i();
        Ms.skip = 0;
        StringBuffer[] sr = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
        Ms.i();
        this.gogoST = sr[Ms.getRandom(sr.length)].toString();
    }

    private void drawSnare5(int x, int y) {
        Ui.i().drawUi(8, x, y + (this.brow5 % 3 == 0 ? 1 : 0), 0, 0);
        byte b = this.brow5;
        this.brow5 = (byte) (b + 1);
        if (b > 100) {
            this.brow5 = (byte) 0;
        }
    }

    public void showString(StringBuffer[] showS, int y, int offx, int mode) {
        int WIDTH = Constants_H.WIDTH__;
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        int y2 = y + 5;
        if (mode != 0) {
            Ui.i().drawKuang(offx - 5, y2, WIDTH + 10, (showS.length * 25) + 12);
            if (mode == 2) {
                drawSnare5(WIDTH_H + offx, (showS.length * 25) + y2 + 4);
            }
        }
        for (byte d = 0; d < showS.length; d = (byte) (d + 1)) {
            Ui.i().drawStringColor(showS[d].toString(), 25 + offx, y2 + 4 + (d * 25), -1, 1);
        }
    }

    public void showString(String string, int y, int offx) {
        byte strNum = (byte) (string.length() / 11);
        Ui.i().drawK0(offx - 5, y, Constants_H.WIDTH_ + 10, ((strNum + 1) * 25) + 8, 3);
        showStringM(string, Constants_H.WIDTH_H_ + offx, y + 3, 11, 0);
    }

    public void showStringM(String str, int x, int y, int num, int c) {
        byte strNum = (byte) (str.length() / num);
        for (byte d = 0; d <= strNum; d = (byte) (d + 1)) {
            if (strNum == 0) {
                Ui.i().drawString(str, x, y, 1 | 16, c, 1);
                Log.e("sk", "strNum == 0");
            } else {
                Ui.i().drawString(str.substring(d * num, d + 1 > strNum ? str.length() : (d + 1) * num), x, y + (d * 25), 1 | 16, c, 0);
                Log.e("sk", "else");
            }
        }
    }

    public void showStringM_(String str, int x, int y, int num, int c) {
        byte strNum = (byte) (str.length() / num);
        for (byte d = 0; d <= strNum; d = (byte) (d + 1)) {
            if (strNum == 0) {
                Ui.i().drawString(str, x, y, 1 | 16, c, 1);
                Log.e("sk", "strNum == 0");
            } else {
                Ui.i().drawString(str.substring(d * num, d + 1 > strNum ? str.length() : (d + 1) * num), x, y + (d * 25), 1 | 16, c, 0);
            }
        }
    }

    public void drawHelpStr(Graphics g2, StringBuffer[] help_strbuff, int line_num, int x, int y, int anchor) {
        byte line_start = (byte) (this.help_page * line_num);
        for (byte i = line_start; i < line_start + line_num && i < help_strbuff.length; i = (byte) (i + 1)) {
            Ui.i().drawString(help_strbuff[i].toString(), x, y + ((i - line_start) * 27), anchor, 3, 0);
        }
        if (help_strbuff.length > line_num) {
            this.page_max = (byte) ((help_strbuff.length / line_num) + (help_strbuff.length % line_num != 0 ? 1 : 0));
            Ui.i().drawString(String.valueOf(this.help_page + 1) + "/" + ((int) this.page_max), Constants_H.WIDTH_H, Constants_H.HEIGHT - 2, 1 | 32, 3, 0);
            Ui.i().drawTriangle(Constants_H.WIDTH_H, Constants_H.HEIGHT - 12, 75, true, true);
            return;
        }
        this.page_max = (byte) 1;
    }

    public void drawSrcLine(Graphics g2, int y, int h, int piece, boolean dir, boolean mode) {
        byte i = 0;
        byte ph = (byte) (h / piece);
        g2.setColor(0);
        if (!dir) {
            short speed = (short) (2 << this.src_c[0]);
            byte i2 = (byte) (piece - 1);
            while (i2 > -1) {
                if (ph - speed > 0) {
                    g2.fillRect(0, (i2 * ph) + y + (speed < 2 ? (short) 0 : speed), Constants_H.WIDTH_, ph - (speed < 2 ? (short) 0 : speed));
                }
                i2 = (byte) (i2 - 1);
                speed = (short) (speed / 2);
            }
            if (!mode || this.src_c[0] >= 12) {
                if (mode || this.src_c[0] <= 0) {
                    return;
                }
                byte[] bArr = this.src_c;
                bArr[0] = (byte) (bArr[0] - 1);
                return;
            }
            byte[] bArr2 = this.src_c;
            bArr2[0] = (byte) (bArr2[0] + 1);
            return;
        }
        short speed2 = (short) (2 << this.src_c[1]);
        while (dir && i < piece) {
            if (ph - speed2 > 0) {
                g2.fillRect(0, (i * ph) + y, Constants_H.WIDTH_, ph - (speed2 < 2 ? (short) 0 : speed2));
            }
            i = (byte) (i + 1);
            speed2 = (short) (speed2 / 2);
        }
        if (!mode || this.src_c[1] >= 12) {
            if (mode || this.src_c[1] <= 0) {
                return;
            }
            byte[] bArr3 = this.src_c;
            bArr3[1] = (byte) (bArr3[1] - 1);
            return;
        }
        byte[] bArr4 = this.src_c;
        bArr4[1] = (byte) (bArr4[1] + 1);
    }

    public String createString(String name) {
        Ms.i();
        Ms.skip = 0;
        StringBuffer[] str = Ms.i().createStringArray(Ms.i().getStream(name, -1));
        return str[0].toString();
    }

    public byte[] createData(int no) {
        return Ms.i().getStream("4", no);
    }

    public void setAction_str(String[] temp_str) {
        this.action_str = temp_str;
    }

    public void drawMenu(StringBuffer[] menu, int x, int y, int w) {
        byte color;
        if (w > 0) {
            Ui.i().drawKuang(x, y, w, (menu.length * 27) + 12);
        } else {
            Ms.i();
            w = Ms.abs(w);
        }
        byte d = 0;
        while (d < menu.length) {
            if (d == 0) {
                color = 9;
            } else {
                color = d == this.cur_a ? (byte) 8 : (byte) 0;
            }
            Ui.i().drawString(menu[d].toString(), (w >> 1) + x, y + 4 + (d * 27), 1 | 16, color, 0);
            d = (byte) (d + 1);
        }
    }

    public void drawSelectMenu(Object[] menu, int x, int y, int w, int dis, int cn, int s_f) {
        byte d = 0;
        while (d < menu.length) {
            Ui.i().drawK0(x, y + ((dis + 33) * d), w, 33, d == s_f ? 1 : cn);
            Ui.i().drawString(menu[d].toString(), (w >> 1) + x, y + 2 + ((dis + 33) * d), 1 | 16, d == s_f ? 0 : 3, 1);
            Log.e("sk", "drawSelectMenu");
            if (this.pkey.isSelect(x, ((dis + 33) * d) + y, w, 33)) {
                if (this.map.my.state == 12) {
                    if (d == s_f) {
                        this.map.my.state = (byte) 13;
                    } else {
                        this.cur_a = d;
                    }
                } else if (run_state == 35 || run_state == 25 || this.map.my.state == 16 || run_state == 65 || run_state == 66 || run_state == 61) {
                    if (d == s_f) {
                        this.pkey.setKey5();
                    } else {
                        this.popMenu = d;
                    }
                }
            }
            d = (byte) (d + 1);
        }
    }

    public void drawSelectMenu_(Object[] menu, int x, int y, int w, int dis, int cn, int s_f) {
        byte d = 0;
        while (d < menu.length) {
            int i = 25 + 8;
            Ui.i().drawK0(x, y + ((dis + 33) * d), w, 25 + 8, d == s_f ? 1 : cn);
            int i2 = 25 + 8;
            Ui.i().drawString(menu[d].toString(), (w >> 1) + x, y + 2 + ((dis + 33) * d), 1 | 16, d == s_f ? 0 : 3, 1);
            g.setColor(16711680);
            int i3 = 25 + 8;
            int i4 = 25 + 8;
            if (this.pkey.isSelect((Constants_H.WIDTH * x) / Constants_H.WIDTH__, ((((dis + 33) * d) + y) * Constants_H.WIDTH) / Constants_H.WIDTH__, (Constants_H.WIDTH * w) / Constants_H.WIDTH__, (Constants_H.WIDTH * 33) / Constants_H.WIDTH__)) {
                if (this.map.my.state == 12) {
                    if (d == s_f) {
                        this.map.my.state = (byte) 13;
                    } else {
                        this.cur_a = d;
                    }
                } else if (run_state == 35 || run_state == 25 || this.map.my.state == 16 || run_state == 65 || run_state == 66) {
                    if (d == s_f) {
                        this.pkey.setKey5();
                    } else {
                        this.popMenu = d;
                    }
                }
            }
            d = (byte) (d + 1);
        }
    }

    public void setPauseS(int mode) {
        if (mode == 0) {
            setAction_str(new String[]{Constants_H.PAUSE_TXT_0, Constants_H.PAUSE_TXT_1, Constants_H.PAUSE_TXT_2, Constants_H.PAUSE_TXT_3, Constants_H.PAUSE_TXT_24, Constants_H.PAUSE_TXT_4});
        } else {
            setAction_str(new String[]{Constants_H.PAUSE_TXT_5, Constants_H.PAUSE_TXT_6, Constants_H.PAUSE_TXT_7, Constants_H.PAUSE_TXT_8});
        }
    }

    public void drawPauseMenu(int x, int y, int w, int h) {
        Ui.i().drawK2(x, y, w, h, 1);
        Ui.i().drawK1(x + 9, y + 25 + 11, w - 18, (h - 25) - 19, 0);
        Ui.i().drawListKY(6, x + 8, y + 25 + 13, w - 16, 1, 33, -1, this.selecty, 4, 2);
        this.pkey.selectListSY(this.action_str.length, x + 8, y + 25 + 13, w - 16, 1, 33, -1, this.selecty);
        byte t = this.pkey.selectMenuX(2, x, y + 3, w >> 1, 38);
        if (t != -1) {
            this.selectx = t;
            this.selecty = (byte) 0;
            setPauseS(this.selectx);
        }
        if (this.selectx == 1) {
            Ui.i().drawVolume(((((w >> 1) + x) + 25) - 8) - 60, y + 25 + 16 + 33, Sound.i().getVolume(), this.selecty == 1);
            Ui.i().drawListSYHasSound(this.action_str, x + 8, y + 25 + 13, w - 16, 32, this.selecty, 0, 3, 0);
        } else {
            Ui.i().drawListSY(this.action_str, x + 8, y + 25 + 13, w - 16, 32, this.selecty, 0, 3, 0);
        }
        Ui.i().drawK1((w >> 1) + x + (this.selectx == 0 ? -60 : 2), y + 4, 56, 29, 4);
        Ui.i().drawString(Constants_H.PAUSE_TXT_16, (((w >> 1) + x) - 25) - 3, y + 3, 1 | 16, this.selectx == 0 ? 0 : 1, 0);
        Ui.i().drawString(Constants_H.PAUSE_TXT_17, (w >> 1) + x + 25 + 3, y + 3, 1 | 16, this.selectx == 0 ? 1 : 0, 0);
        Ui.i().drawTriangle((w >> 1) + x, y + 12, 80, true, true);
    }

    public void saveMon(ByteArrayOutputStream byteArray, Monster mon) throws IOException {
        byteArray.write(mon.monster);
        for (int i = 0; i < 5; i++) {
            short s = mon.monsterPro[i];
            byteArray.write((byte) (s & 255));
            byteArray.write((byte) ((s >> 8) & 255));
        }
    }

    public void loadMon(ByteArrayInputStream byteArray, Monster mon, byte[][] data) throws IOException {
        mon.monster = new byte[18];
        mon.monsterPro = new short[8];
        byteArray.read(mon.monster);
        this.len = new byte[10];
        byteArray.read(this.len);
        for (int i = 0; i < 5; i++) {
            mon.monsterPro[i] = (short) (((this.len[(i * 2) + 1] & 255) << 8) | (this.len[(i * 2) + 0] & 255));
        }
        mon.setProAFD(data[mon.monster[0]]);
        this.len = null;
    }

    public void saveMon(int flag) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        int i = 0;
        try {
            if (flag == 0) {
                byteArray.write(this.cMon_count);
                while (i < this.cMon_count) {
                    saveMon(byteArray, this.cMonsters[i]);
                    i++;
                }
                Ms.i().rmsOptions(8, byteArray.toByteArray(), 2);
            } else {
                byteArray.write(this.myMon_length);
                while (i < this.myMon_length) {
                    saveMon(byteArray, this.myMonsters[i]);
                    i++;
                }
                Ms.i().rmsOptions(9, byteArray.toByteArray(), 2);
            }
            byteArray.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadMon(int flag, byte[][] data) {
        ByteArrayInputStream byteArray;
        this.info = Ms.i().rmsOptions(flag + 8, null, 1);
        int i = 0;
        try {
            if (flag == 0) {
                this.cMonsters = new Monster[95];
                if (this.info[0] == -1) {
                    this.cMon_count = (byte) 0;
                    return;
                }
                byteArray = new ByteArrayInputStream(this.info);
                this.cMon_count = (byte) byteArray.read();
                while (i < this.cMon_count) {
                    this.cMonsters[i] = new Monster();
                    loadMon(byteArray, this.cMonsters[i], data);
                    i++;
                }
            } else {
                this.myMonsters = new Monster[5];
                if (this.info[0] == -1) {
                    this.myMon_length = (byte) 0;
                    return;
                }
                byteArray = new ByteArrayInputStream(this.info);
                this.myMon_length = (byte) byteArray.read();
                while (i < this.myMon_length) {
                    this.myMonsters[i] = new Monster();
                    loadMon(byteArray, this.myMonsters[i], data);
                    i++;
                }
            }
            byteArray.close();
            this.info = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void saveInfoList() {
        Ms.i().rmsOptions(6, this.monInfoList, 2);
    }

    public void loadInfoList() {
        this.info = Ms.i().rmsOptions(6, null, 1);
        if (this.info[0] == -1) {
            this.monInfoList = new byte[105];
            for (int i = 0; i < this.monInfoList.length; i++) {
                this.monInfoList[i] = 0;
            }
        } else {
            this.monInfoList = this.info;
        }
        this.info = null;
    }

    public void loadRmsOther() {
        this.info = Ms.i().rmsOptions(10, null, 1);
        if (this.info[0] == -1) {
            setMaxTakes(true);
            initRmsOther();
        } else {
            this.rmsOther = this.info;
            setMaxTakes(false);
        }
        this.info = null;
    }

    public void setMaxTakes(boolean bb) {
        if (bb) {
            this.max_takes = (byte) 3;
            this.max_monsters = (byte) 10;
            return;
        }
        if (this.rmsOther[3] == 2) {
            this.max_takes = (byte) 4;
            this.max_monsters = (byte) 20;
            return;
        }
        if (this.rmsOther[3] == 3) {
            this.max_takes = (byte) 5;
            this.max_monsters = (byte) 40;
        } else if (this.rmsOther[3] == 4) {
            this.max_takes = (byte) 5;
            this.max_monsters = (byte) 80;
        } else if (this.rmsOther[3] == 5) {
            this.max_takes = (byte) 5;
            this.max_monsters = Constants_H.MAX_MONSTERS;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public byte isMyLevel(boolean bb) {
        switch (this.rmsOther[3]) {
            case 1:
                if (!bb || this.monInfoList[103] <= 4) {
                    return (byte) 5;
                }
                this.rmsOther[3] = 2;
                return (byte) -1;
            case 2:
                if (bb && this.monInfoList[103] > 9) {
                    this.rmsOther[3] = 3;
                    return (byte) -1;
                }
                return (byte) 10;
            case 3:
                if (bb && this.monInfoList[103] > 14) {
                    this.rmsOther[3] = 4;
                    return (byte) -1;
                }
                return (byte) 15;
            case 4:
                if (bb && this.monInfoList[103] > 29) {
                    this.rmsOther[3] = 5;
                    return (byte) -1;
                }
                return (byte) 30;
            default:
                return (byte) -1;
        }
    }

    public void saveItem() {
        int len = 0;
        for (int i = 0; i < 4; i++) {
            len += this.itemsLength[i];
        }
        this.info = new byte[this.items.length + (len * 2)];
        int len2 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            this.info[i2] = this.itemsLength[i2];
        }
        for (int i3 = 0; i3 < this.items.length; i3++) {
            int j = 0;
            while (j < this.itemsLength[i3]) {
                this.info[(len2 * 2) + 4] = this.items[i3][j][0];
                this.info[(len2 * 2) + 4 + 1] = this.items[i3][j][1];
                j++;
                len2++;
            }
        }
        Ms.i().rmsOptions(4, this.info, 2);
        this.info = null;
    }

    public void loadItem() {
        this.info = Ms.i().rmsOptions(4, null, 1);
        this.len = new byte[]{16, 19, 23, 12};
        this.itemsLength = new byte[4];
        if (this.info[0] != -1) {
            for (int i = 0; i < 4; i++) {
                this.itemsLength[i] = this.info[i];
            }
        }
        this.items = new byte[this.itemsLength.length][];
        int k = 0;
        for (int i2 = 0; i2 < this.items.length; i2++) {
            this.items[i2] = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.len[i2], 2);
            int j = 0;
            while (j < this.itemsLength[i2]) {
                this.items[i2][j][0] = this.info[(k * 2) + 4];
                this.items[i2][j][1] = this.info[(k * 2) + 4 + 1];
                j++;
                k++;
            }
        }
        this.info = null;
        this.len = null;
    }

    public void initRmsOther() {
        this.rmsOther = null;
        byte[] bArr = new byte[12];
        bArr[0] = -1;
        bArr[3] = 1;
        this.rmsOther = bArr;
    }

    public void loadRmsSms() {
        this.rmsSms = Ms.i().rmsOptions(5, null, 1);
        if (this.rmsSms == null || this.rmsSms[0] == -1) {
            this.rmsSms = null;
            this.rmsSms = new byte[7];
        }
        if (this.rmsSms[0] == 10) {
            byte[] bArr = this.rmsOther;
            bArr[2] = (byte) (bArr[2] | 8);
        }
    }

    public void loadRmsNidus() {
        this.rmsNidus = Ms.i().rmsOptions(3, null, 1);
        if (this.rmsNidus[0] == -1) {
            this.rmsNidus = null;
            this.rmsNidus = new byte[]{-2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10};
        }
    }

    public byte getRid(int i) {
        return this.rmsNidus[i * 5];
    }

    public byte getNid(int i) {
        return this.nidusList[0][getRid(i)];
    }

    public byte getNLevel(int i) {
        return this.nidusList[1][getRid(i)];
    }

    public short getNexp(int i, int n) {
        return Ms.i().getShort(this.rmsNidus, (i * 5) + n);
    }

    public boolean addNidus(int id) {
        for (byte i = 0; i < this.rmsNidus.length; i = (byte) (i + 5)) {
            if (this.rmsNidus[i] == -2) {
                this.rmsNidus[i] = (byte) id;
                Ms.i().putShort(0, this.rmsNidus, i + 1);
                Ms.i().putShort(Player.REALIZED, this.rmsNidus, i + 3);
                return true;
            }
        }
        return false;
    }

    public void delNidus(int i) {
        this.rmsNidus[i * 5] = -2;
    }

    public void setNidusExp(int exp) {
        int exp2 = exp / 10 < 1 ? 1 : exp / 10;
        for (byte i = 0; i < 5; i = (byte) (i + 1)) {
            if (getRid(i) != -2) {
                Ms.i().putShort(getNexp(i, 1) + exp2, this.rmsNidus, (i * 5) + 1);
                if (getNexp(i, 1) > getNexp(i, 3)) {
                    Ms.i().putShort(getNexp(i, 3), this.rmsNidus, (i * 5) + 1);
                }
            }
        }
    }
}
