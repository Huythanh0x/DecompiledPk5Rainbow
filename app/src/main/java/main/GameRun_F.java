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
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class GameRun_F implements Key_H {
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
    static DirectGraphics dg;
    static Graphics g;
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
    public static MainCanvas mc;
    public byte[] monInfoList;
    public short move_x;
    public short move_y;
    public byte myMon_length;
    public Monster[] myMonsters;
    public byte[][] nidusList;
    public byte[] nidusMap;
    static Graphics offG;
    public byte page_max;
    public PointerKey pkey;
    public byte popMenu;
    public byte[] rmsNidus;
    public byte[] rmsOther;
    public byte[] rmsSms;
    public static int run_state;
    static Image scrT;
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
        this.anchor = new byte[]{20, 36, 40, 24, 24, 40, 36, 20};
        this.transB = new short[]{0, 90, 180, 270, 0x2000, 0x205A, 0x20B4, 0x210E};
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

    public boolean addNidus(int id) {
        int i;
        for(i = 0; true; i = (byte)(i + 5)) {
            if(i >= this.rmsNidus.length) {
                return false;
            }
            if(this.rmsNidus[i] == -2) {
                break;
            }
        }
        this.rmsNidus[i] = (byte)id;
        Ms.i().putShort(0, this.rmsNidus, i + 1);
        Ms.i().putShort(200, this.rmsNidus, i + 3);
        return true;
    }

    public byte[] createData(int no) {
        return Ms.i().getStream("4", no);
    }

    public String createString(String name) {
        Ms.i();
        Ms.skip = 0;
        return Ms.i().createStringArray(Ms.i().getStream(name, -1))[0].toString();
    }

    public void delNidus(int i) {
        this.rmsNidus[i * 5] = -2;
    }

    public void drawHelpStr(Graphics g, StringBuffer[] help_strbuff, int line_num, int x, int y, int anchor) {
        int line_start = (byte)(this.help_page * line_num);
        for(int i = line_start; i < line_start + line_num && i < help_strbuff.length; i = (byte)(i + 1)) {
            Ui.i().drawString(help_strbuff[i].toString(), x, y + (i - line_start) * 27, anchor, 3, 0);
        }
        if(help_strbuff.length > line_num) {
            this.page_max = (byte)(help_strbuff.length / line_num + (help_strbuff.length % line_num == 0 ? 0 : 1));
            Ui.i().drawString(this.help_page + 1 + "/" + ((int)this.page_max), Constants_H.WIDTH_H, Constants_H.HEIGHT - 2, 33, 3, 0);
            Ui.i();
            return;
        }
        this.page_max = 1;
    }

    public void drawMenu(StringBuffer[] menu, int x, int y, int w) {
        int color;
        if(w > 0) {
            Ui.i().drawKuang(x, y, w, menu.length * 27 + 12);
        }
        else {
            Ms.i();
            w = Ms.abs(w);
        }
        for(int d = 0; d < menu.length; d = (byte)(d + 1)) {
            if(d == 0) {
                color = 9;
            }
            else {
                color = d == this.cur_a ? 8 : 0;
            }
            Ui.i().drawString(menu[d].toString(), (w >> 1) + x, y + 4 + d * 27, 17, color, 0);
        }
    }

    public void drawPauseMenu(int x, int y, int w, int h) {
        Ui.i().drawK2(x, y, w, h, 1);
        Ui.i().drawK1(x + 9, y + 36, w - 18, h - 44, 0);
        Ui.i().drawListKY(6, x + 8, y + 38, w - 16, 1, 33, -1, ((int)this.selecty), 4, 2);
        this.pkey.selectListSY(this.action_str.length, x + 8, y + 38, w - 16, 1, 33, -1, ((int)this.selecty));
        byte b = this.pkey.selectMenuX(2, x, y + 3, w >> 1, 38);
        if(b != -1) {
            this.selectx = b;
            this.selecty = 0;
            this.setPauseS(((int)this.selectx));
        }
        if(this.selectx == 1) {
            Ui.i().drawVolume((w >> 1) + x - 43, y + 74, Sound.i().getVolume(), this.selecty == 1);
            Ui.i().drawListSYHasSound(this.action_str, x + 8, y + 38, w - 16, 0x20, ((int)this.selecty), 0, 3, 0);
        }
        else {
            Ui.i().drawListSY(this.action_str, x + 8, y + 38, w - 16, 0x20, ((int)this.selecty), 0, 3, 0);
        }
        Ui.i().drawK1((w >> 1) + x + (this.selectx == 0 ? -60 : 2), y + 4, 56, 29, 4);
        Ui.i().drawString("菜单", (w >> 1) + x - 28, y + 3, 17, (this.selectx == 0 ? 0 : 1), 0);
        Ui.i().drawString("系统", (w >> 1) + x + 28, y + 3, 17, (this.selectx == 0 ? 1 : 0), 0);
        Ui.i();
    }

    public void drawSelectMenu(Object[] menu, int x, int y, int w, int dis, int cn, int s_f) {
        for(byte d = 0; d < menu.length; d = (byte)(d + 1)) {
            Ui.i().drawK0(x, y + (dis + 33) * d, w, 33, (d == s_f ? 1 : cn));
            Ui.i().drawString(menu[d].toString(), (w >> 1) + x, y + 2 + (dis + 33) * d, 17, (d == s_f ? 0 : 3), 1);
            Log.e("sk", "drawSelectMenu");
            if(this.pkey.isSelect(x, (dis + 33) * d + y, w, 33)) {
                if(this.map.my.state == 12) {
                    if(d == s_f) {
                        this.map.my.state = 13;
                    }
                    else {
                        this.cur_a = d;
                    }
                }
                else if(GameRun_F.run_state == 25 || GameRun_F.run_state == 35 || this.map.my.state == 16 || (GameRun_F.run_state == 61 || GameRun_F.run_state == 65 || GameRun_F.run_state == 66)) {
                    if(d == s_f) {
                        this.pkey.setKey5();
                    }
                    else {
                        this.popMenu = d;
                    }
                }
            }
        }
    }

    public void drawSelectMenu_(Object[] menu, int x, int y, int w, int dis, int cn, int s_f) {
        for(byte d = 0; d < menu.length; d = (byte)(d + 1)) {
            Ui.i().drawK0(x, y + (dis + 33) * d, w, 33, (d == s_f ? 1 : cn));
            Ui.i().drawString(menu[d].toString(), (w >> 1) + x, y + 2 + (dis + 33) * d, 17, (d == s_f ? 0 : 3), 1);
            GameRun_F.g.setColor(0xFF0000);
            if(this.pkey.isSelect(Constants_H.WIDTH * x / Constants_H.WIDTH__, ((dis + 33) * d + y) * Constants_H.WIDTH / Constants_H.WIDTH__, Constants_H.WIDTH * w / Constants_H.WIDTH__, Constants_H.WIDTH * 33 / Constants_H.WIDTH__)) {
                if(this.map.my.state == 12) {
                    if(d == s_f) {
                        this.map.my.state = 13;
                    }
                    else {
                        this.cur_a = d;
                    }
                }
                else if(GameRun_F.run_state == 25 || GameRun_F.run_state == 35 || this.map.my.state == 16 || GameRun_F.run_state == 65 || GameRun_F.run_state == 66) {
                    if(d == s_f) {
                        this.pkey.setKey5();
                    }
                    else {
                        this.popMenu = d;
                    }
                }
            }
        }
    }

    private void drawSnare5(int x, int y) {
        Ui.i().drawUi(8, x, y + (this.brow5 % 3 == 0 ? 1 : 0), 0, 0);
        int v2 = this.brow5;
        this.brow5 = (byte)(v2 + 1);
        if(v2 > 100) {
            this.brow5 = 0;
        }
    }

    public void drawSrcLine(Graphics g, int y, int h, int piece, boolean dir, boolean mode) {
        int i = 0;
        int ph = (byte)(h / piece);
        g.setColor(0);
        if(dir) {
            for(int speed = (short)(2 << this.src_c[1]); dir && i < piece; speed = (short)(speed / 2)) {
                if(ph - speed > 0) {
                    g.fillRect(0, i * ph + y, 640, ph - (speed >= 2 ? speed : 0));
                }
                i = (byte)(i + 1);
            }
            if(mode && this.src_c[1] < 12) {
                this.src_c[1] = (byte)(this.src_c[1] + 1);
                return;
            }
            if(!mode && this.src_c[1] > 0) {
                this.src_c[1] = (byte)(this.src_c[1] - 1);
            }
        }
        else {
            int speed = (short)(2 << this.src_c[0]);
            int i = (byte)(piece - 1);
            while(i > -1) {
                if(ph - speed > 0) {
                    g.fillRect(0, i * ph + y + (speed >= 2 ? speed : 0), 640, ph - (speed >= 2 ? speed : 0));
                }
                i = (byte)(i - 1);
                speed = (short)(speed / 2);
            }
            if(mode && this.src_c[0] < 12) {
                this.src_c[0] = (byte)(this.src_c[0] + 1);
                return;
            }
            if(!mode && this.src_c[0] > 0) {
                this.src_c[0] = (byte)(this.src_c[0] - 1);
            }
        }
    }

    public void drawZero(int x, int y, int anchor, int color) {
        Ui.i().drawString("点击屏幕继续", x, y, anchor, color, 0);
    }

    public void drawZero(String str, int y) {
        Ui.i().drawString("点击屏幕" + str, Constants_H.WIDTH_H, y, 33, 0, 0);
    }

    public byte getNLevel(int i) {
        return this.nidusList[1][this.getRid(i)];
    }

    public short getNexp(int i, int n) {
        return Ms.i().getShort(this.rmsNidus, i * 5 + n);
    }

    public byte getNid(int i) {
        return this.nidusList[0][this.getRid(i)];
    }

    public byte getRid(int i) {
        return this.rmsNidus[i * 5];
    }

    public short getSIndexW(String str) {
        int num = 0;
        int start = 0;
        int end = (byte)str.indexOf("#", 0);
        if(end == 0) {
            end = 1;
        }
        while(end != -1) {
            start = (byte)(start + end);
            end = (byte)str.indexOf("#", start);
            num = (byte)(num + 1);
        }
        return (short)(Ms.i().getStringWidth("#1") * num);
    }

    public void gogoWord(String string, int x, int y, int w, int color, int strT, int speed) {
        int sw = (short)(Ms.i().getStringWidth(string) - this.getSIndexW(string));
        if(sw > 640 - x - w) {
            this.introX -= speed;
            if(this.introX + sw < x) {
                this.introX = 565 - w;
            }
        }
        else {
            this.introX = x;
        }
        GameRun_F.g.clipRect(x, y, 640 - w - x, 30);
        Ui.i().drawStringColor(string, this.introX, y, color, strT);
        GameRun_F.g.setClip(0, 0, 640, 360);
    }

    public void gogoWordM(String string, int y, int w, int color, int strT, int speed) {
        int sw = (short)Ms.i().getStringWidth(string);
        this.introT -= speed;
        if(this.introT + sw < w << 1) {
            this.introT = 641;
        }
        GameRun_F.g.clipRect(w, y, 640 - (w << 1), 30);
        Ui.i().drawString(string, this.introT, y, 0, color, strT);
        GameRun_F.g.setClip(0, 0, 640, 360);
    }

    public void initGraphics(Graphics _g) {
        GameRun_F.g = _g;
        GameRun_F.dg = DirectUtils.getDirectGraphics(_g);
    }

    public void initOffG() {
        GameRun_F.scrT = Image.createImage(Constants_H.WIDTH + 20, Constants_H.HEIGHT + 20);
        GameRun_F.offG = GameRun_F.scrT.getGraphics();
    }

    public void initRmsOther() {
        this.rmsOther = null;
        byte[] arr_b = new byte[12];
        arr_b[0] = -1;
        arr_b[3] = 1;
        this.rmsOther = arr_b;
    }

    public byte isMyLevel(boolean bb) {
        switch(this.rmsOther[3]) {
            case 1: {
                if(bb && this.monInfoList[103] > 4) {
                    this.rmsOther[3] = 2;
                    return -1;
                }
                return 5;
            }
            case 2: {
                if(bb && this.monInfoList[103] > 9) {
                    this.rmsOther[3] = 3;
                    return -1;
                }
                return 10;
            }
            case 3: {
                if(bb && this.monInfoList[103] > 14) {
                    this.rmsOther[3] = 4;
                    return -1;
                }
                return 15;
            }
            case 4: {
                if(bb && this.monInfoList[103] > 29) {
                    this.rmsOther[3] = 5;
                    return -1;
                }
                return 30;
            }
            default: {
                return -1;
            }
        }
    }

    public void loadInfoList() {
        this.info = Ms.i().rmsOptions(6, null, 1);
        if(this.info[0] == -1) {
            this.monInfoList = new byte[105];
            for(int i = 0; i < this.monInfoList.length; ++i) {
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
        this.len = new byte[]{16, 19, 23, 12};
        this.itemsLength = new byte[4];
        if(this.info[0] != -1) {
            for(int i = 0; i < 4; ++i) {
                this.itemsLength[i] = this.info[i];
            }
        }
        this.items = new byte[this.itemsLength.length][][];
        for(int i = 0; i < this.items.length; ++i) {
            byte[][][] arr3_b = this.items;
            arr3_b[i] = new byte[this.len[i]][2];
            int j = 0;
            for(int k = 0; j < this.itemsLength[i]; ++k) {
                this.items[i][j][0] = this.info[k * 2 + 4];
                this.items[i][j][1] = this.info[k * 2 + 5];
                ++j;
            }
        }
        this.info = null;
        this.len = null;
    }

    public void loadMon(int flag, byte[][] data) {
        ByteArrayInputStream byteArray;
        this.info = Ms.i().rmsOptions(flag + 8, null, 1);
        int i = 0;
        try {
            if(flag == 0) {
                this.cMonsters = new Monster[0x5F];
                if(this.info[0] == -1) {
                    this.cMon_count = 0;
                    return;
                }
                byteArray = new ByteArrayInputStream(this.info);
                this.cMon_count = (byte)byteArray.read();
                while(i < this.cMon_count) {
                    Monster[] arr_monster1 = this.cMonsters;
                    arr_monster1[i] = new Monster();
                    this.loadMon(byteArray, this.cMonsters[i], data);
                    ++i;
                }
            }
            else {
                this.myMonsters = new Monster[5];
                if(this.info[0] == -1) {
                    this.myMon_length = 0;
                    return;
                }
                byteArray = new ByteArrayInputStream(this.info);
                this.myMon_length = (byte)byteArray.read();
                while(i < this.myMon_length) {
                    Monster[] arr_monster = this.myMonsters;
                    arr_monster[i] = new Monster();
                    this.loadMon(byteArray, this.myMonsters[i], data);
                    ++i;
                }
            }
            byteArray.close();
            this.info = null;
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public void loadMon(ByteArrayInputStream byteArray, Monster mon, byte[][] data) throws IOException {
        mon.monster = new byte[18];
        mon.monsterPro = new short[8];
        byteArray.read(mon.monster);
        this.len = new byte[10];
        byteArray.read(this.len);
        for(int i = 0; i < 5; ++i) {
            mon.monsterPro[i] = (short)((this.len[i * 2 + 1] & 0xFF) << 8 | this.len[i * 2] & 0xFF);
        }
        mon.setProAFD(data[mon.monster[0]]);
        this.len = null;
    }

    public void loadRmsNidus() {
        this.rmsNidus = Ms.i().rmsOptions(3, null, 1);
        if(this.rmsNidus[0] == -1) {
            this.rmsNidus = null;
            this.rmsNidus = new byte[]{-2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10, -2, 0, 0, 10, 10};
        }
    }

    public void loadRmsOther() {
        this.info = Ms.i().rmsOptions(10, null, 1);
        if(this.info[0] == -1) {
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
        if(this.rmsSms == null || this.rmsSms[0] == -1) {
            this.rmsSms = null;
            this.rmsSms = new byte[7];
        }
        if(this.rmsSms[0] == 10) {
            this.rmsOther[2] = (byte)(this.rmsOther[2] | 8);
        }
    }

    public void saveInfoList() {
        Ms.i().rmsOptions(6, this.monInfoList, 2);
    }

    public void saveItem() {
        int len = 0;
        for(int i = 0; i < 4; ++i) {
            len += this.itemsLength[i];
        }
        this.info = new byte[this.items.length + len * 2];
        for(int i = 0; i < 4; ++i) {
            this.info[i] = this.itemsLength[i];
        }
        for(int i = 0; i < this.items.length; ++i) {
            int j = 0;
            for(int len = 0; j < this.itemsLength[i]; ++len) {
                this.info[len * 2 + 4] = this.items[i][j][0];
                this.info[len * 2 + 5] = this.items[i][j][1];
                ++j;
            }
        }
        Ms.i().rmsOptions(4, this.info, 2);
        this.info = null;
    }

    public void saveMon(int flag) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        int i = 0;
        try {
            if(flag == 0) {
                byteArray.write(((int)this.cMon_count));
                while(true) {
                    if(i >= this.cMon_count) {
                        Ms.i().rmsOptions(8, byteArray.toByteArray(), 2);
                        byteArray.close();
                        return;
                    }
                    this.saveMon(byteArray, this.cMonsters[i]);
                    ++i;
                }
            }
            byteArray.write(((int)this.myMon_length));
            while(true) {
                if(i >= this.myMon_length) {
                    Ms.i().rmsOptions(9, byteArray.toByteArray(), 2);
                    byteArray.close();
                    return;
                }
                this.saveMon(byteArray, this.myMonsters[i]);
                ++i;
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
    }

    public void saveMon(ByteArrayOutputStream byteArray, Monster mon) throws IOException {
        byteArray.write(mon.monster);
        for(int i = 0; i < 5; ++i) {
            int xxx = mon.monsterPro[i];
            byteArray.write(((int)(((byte)(xxx & 0xFF)))));
            byteArray.write(((int)(((byte)(xxx >> 8 & 0xFF)))));
        }
    }

    public void setAction_str(String[] temp_str) {
        this.action_str = temp_str;
    }

    public void setGogoWord() {
        this.introT = Constants_H.WIDTH;
        Ms.i();
        Ms.skip = 0;
        StringBuffer[] arr_stringBuffer = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
        Ms.i();
        this.gogoST = arr_stringBuffer[Ms.getRandom(arr_stringBuffer.length)].toString();
    }

    public void setMaxTakes(boolean bb) {
        if(bb) {
            this.max_takes = 3;
            this.max_monsters = 10;
            return;
        }
        if(this.rmsOther[3] == 2) {
            this.max_takes = 4;
            this.max_monsters = 20;
            return;
        }
        switch(this.rmsOther[3]) {
            case 3: {
                this.max_takes = 5;
                this.max_monsters = 40;
                return;
            }
            case 4: {
                this.max_takes = 5;
                this.max_monsters = 80;
                return;
            }
            case 5: {
                this.max_takes = 5;
                this.max_monsters = 0x5F;
            }
        }
    }

    public void setNidusExp(int exp) {
        for(int i = 0; i < 5; i = (byte)(i + 1)) {
            if(this.getRid(i) != -2) {
                Ms.i().putShort(this.getNexp(i, 1) + (exp / 10 >= 1 ? exp / 10 : 1), this.rmsNidus, i * 5 + 1);
                if(this.getNexp(i, 1) > this.getNexp(i, 3)) {
                    Ms.i().putShort(this.getNexp(i, 3), this.rmsNidus, i * 5 + 1);
                }
            }
        }
    }

    public void setPauseS(int mode) {
        if(mode == 0) {
            this.setAction_str(new String[]{"保存游戏", "查看宠物", "人物背包", "宠物图鉴", "查看任务", "返回游戏"});
            return;
        }
        this.setAction_str(new String[]{"读取进度", "声音", "游戏帮助", "回主菜单"});
    }

    public void setStringB(String str, int w, int mode) {
        if(mode == 0) {
            this.about_a = Ms.i().groupString(str, w);
            return;
        }
        switch(mode) {
            case 1: {
                this.about_b = Ms.i().groupString(str, w);
                return;
            }
            case 2: {
                this.about_c = Ms.i().groupString(str, w);
                return;
            }
            case 3: {
                this.about_d = Ms.i().groupString(str, w);
            }
        }
    }

    public void showString(String string, int y, int offx) {
        Ui.i().drawK0(offx - 5, y, 650, (((byte)(string.length() / 11)) + 1) * 25 + 8, 3);
        this.showStringM(string, 320 + offx, y + 3, 11, 0);
    }

    public void showString(StringBuffer[] showS, int y, int offx, int mode) {
        int WIDTH = Constants_H.WIDTH__;
        int WIDTH_H = Constants_H.WIDTH__ / 2;
        if(mode != 0) {
            Ui.i().drawKuang(offx - 5, y + 5, WIDTH + 10, showS.length * 25 + 12);
            if(mode == 2) {
                this.drawSnare5(WIDTH_H + offx, showS.length * 25 + (y + 5) + 4);
            }
        }
        for(int d = 0; d < showS.length; d = (byte)(d + 1)) {
            Ui.i().drawStringColor(showS[d].toString(), 25 + offx, y + 9 + d * 25, -1, 1);
        }
    }

    public void showStringM(String str, int x, int y, int num, int c) {
        int strNum = (byte)(str.length() / num);
        for(int d = 0; d <= strNum; d = (byte)(d + 1)) {
            if(strNum == 0) {
                Ui.i().drawString(str, x, y, 17, c, 1);
                Log.e("sk", "strNum == 0");
            }
            else {
                Ui.i().drawString(str.substring(d * num, (d + 1 <= strNum ? (d + 1) * num : str.length())), x, y + d * 25, 17, c, 0);
                Log.e("sk", "else");
            }
        }
    }

    public void showStringM_(String str, int x, int y, int num, int c) {
        int strNum = (byte)(str.length() / num);
        for(int d = 0; d <= strNum; d = (byte)(d + 1)) {
            if(strNum == 0) {
                Ui.i().drawString(str, x, y, 17, c, 1);
                Log.e("sk", "strNum == 0");
            }
            else {
                Ui.i().drawString(str.substring(d * num, (d + 1 <= strNum ? (d + 1) * num : str.length())), x, y + d * 25, 17, c, 0);
            }
        }
    }
}

