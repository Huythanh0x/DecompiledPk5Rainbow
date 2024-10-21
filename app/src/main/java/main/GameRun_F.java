package main.GameRun_F;
import main.Key_H;
import java.lang.Object;
import main.Constants_H;
import java.lang.Byte;
import java.lang.Class;
import java.lang.reflect.Array;
import dm.Ui;
import dm.Ms;
import java.lang.String;
import java.lang.StringBuffer;
import javax.microedition.lcdui.Graphics;
import java.lang.StringBuilder;
import main.PointerKey;
import dm.Sound;
import android.util.Log;
import main.Map;
import dm.Npc;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Image;
import dm.Monster;
import java.io.ByteArrayInputStream;
import java.lang.Exception;
import java.io.ByteArrayOutputStream;

public class GameRun_F implements Key_H	// class@000162 from classes.dex
{
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
    static DirectGraphics dg;
    static Graphics g;
    public static MainCanvas mc;
    static Graphics offG;
    public static int run_state;
    static Image scrT;

    static {
       GameRun_F.run_state = 1;
    }
    public void GameRun_F(){
       super();
       this.anchor = new byte[8]{0x14,'$','(',0x18,0x18,'(','$',0x14};
       short[] oshortArray = new short[8];
       oshortArray[1] = 90;
       oshortArray[2] = 180;
       oshortArray[3] = 270;
       oshortArray[4] = 8192;
       oshortArray[5] = 8282;
       oshortArray[6] = 8372;
       oshortArray[7] = 8462;
       this.transB = oshortArray;
       this.introX = Constants_H.WIDTH_H;
       this.gogoString = "";
       this.introT = 640;
       this.gogoST = "";
       this.brow5 = 0;
       this.page_max = 0;
       this.help_page = 0;
       byte[] uobyteArray = new byte[4];
       this.src_c = uobyteArray;
       this.popMenu = -1;
       uobyteArray = new byte[4];
       this.select_it = uobyteArray;
       uobyteArray = new byte[4];
       this.select_st = uobyteArray;
       int[] ointArray = new int[]{4,2};
       this.selectBag = Array.newInstance(Byte.TYPE, ointArray);
       ointArray = new int[]{2,2};
       this.select = Array.newInstance(Byte.TYPE, ointArray);
       this.max_takes = 3;
       this.max_monsters = 10;
    }
    private void drawSnare5(int x,int y){
       Ui ui = Ui.i();
       int i = 8;
       int i1 = (!((this.brow5 % 3)))? 1: 0;
       ui.drawUi(i, x, (y + i1), 0, 0);
       GameRun_F tbrow5 = this.brow5;
       this.brow5 = (byte)(tbrow5 + 1);
       if (tbrow5 > 100) {
          this.brow5 = 0;
       }
       return;
    }
    public boolean addNidus(int id){
       int b;
       int ix = 0;
       byte i = 0;
       while (true) {
          if (i >= this.rmsNidus.length) {
             b = ix;
             break ;
          }else if(this.rmsNidus[i] != -2){
             b = i + 5;
             i = (byte)b;
          }else {
             this.rmsNidus[i] = (byte)id;
             Ms.i().putShort(ix, this.rmsNidus, (i + 1));
             Ms.i().putShort(200, this.rmsNidus, (i + 3));
             b = true;
             break ;
          }
       }
       return b;
    }
    public byte[] createData(int no){
       return Ms.i().getStream("4", no);
    }
    public String createString(String name){
       Ms.i();
       Ms.skip = 0;
       StringBuffer[] str = Ms.i().createStringArray(Ms.i().getStream(name, -1));
       return str[0];
    }
    public void delNidus(int i){
       this.rmsNidus[(i * 5)] = -2;
    }
    public void drawHelpStr(Graphics g,StringBuffer[] help_strbuff,int line_num,int x,int y,int anchor){
       byte line_start = (byte)(this.help_page * line_num);
       byte i = line_start;
       while (true) {
          int ix = line_start + line_num;
          if (i < ix && i < help_strbuff.length) {
             int ix2 = i - line_start;
             ix2 = ix2 * 27;
             int ix3 = y + ix2;
             Ui.i().drawString(help_strbuff[i].toString(), x, ix3, anchor, 3, 0);
             ix = i + 1;
             i = (byte)ix;
          }else if(help_strbuff.length > line_num){
             ix = help_strbuff.length / line_num;
             int ix1 = ((help_strbuff.length % line_num))? 1: 0;
             this.page_max = (byte)(ix + ix1);
             Ui.i().drawString(String.valueOf((this.help_page + 1))+"/"+this.page_max, Constants_H.WIDTH_H, (Constants_H.HEIGHT - 2), (1 | 0x20), 3, 0);
             Ui.i().drawTriangle(Constants_H.WIDTH_H, (Constants_H.HEIGHT - 12), 75, true, true);
          }else {
             this.page_max = 1;
          }
          return;
       }
    }
    public void drawMenu(StringBuffer[] menu,int x,int y,int w){
       byte color = 10;
       if (w > 0) {
          Ui.i().drawKuang(x, y, w, ((menu.length * 27) + 12));
       }else {
          Ms.i();
          w = Ms.abs(w);
       }
       byte d = 0;
       while (d < menu.length) {
          if (!d) {
             color = 9;
          }else if(d == this.cur_a){
             color = 8;
          }else {
             color = 0;
          }
          int i = w >> 1;
          i = i + x;
          int i1 = y + 4;
          int i2 = d * 27;
          i1 = i1 + i2;
          i2 = 1 | 0x10;
          Ui.i().drawString(menu[d].toString(), i, i1, i2, color, 0);
          int i3 = d + 1;
          d = (byte)i3;
       }
       return;
    }
    public void drawPauseMenu(int x,int y,int w,int h){
       byte t;
       Ui ui;
       int i;
       int i1;
       int volume;
       int b;
       Ui.i().drawK2(x, y, w, h, 1);
       Ui.i().drawK1((x + 9), ((y + 25) + 11), (w - 18), ((h - 25) - 19), 0);
       Ui.i().drawListKY(6, (x + 8), ((y + 25) + 13), (w - 16), 1, 33, -1, this.selecty, 4, 2);
       this.pkey.selectListSY(this.action_str.length, (x + 8), ((y + 25) + 13), (w - 16), 1, 33, -1, this.selecty);
       if ((t = this.pkey.selectMenuX(2, x, (y + 3), (w >> 1), 38)) != -1) {
          this.selectx = t;
          this.selecty = 0;
          this.setPauseS(this.selectx);
       }
       if (this.selectx == 1) {
          ui = Ui.i();
          i = ((((w >> 1) + x) + 25) - 8) - 60;
          i1 = ((y + 25) + 16) + 33;
          volume = Sound.i().getVolume();
          b = (this.selecty == 1)? true: false;
          ui.drawVolume(i, i1, volume, b);
          Ui.i().drawListSYHasSound(this.action_str, (x + 8), ((y + 25) + 13), (w - 16), 32, this.selecty, 0, 3, 0);
       }else {
          Ui.i().drawListSY(this.action_str, (x + 8), ((y + 25) + 13), (w - 16), 32, this.selecty, 0, 3, 0);
       }
       ui = Ui.i();
       i = (w >> 1) + x;
       i1 = (this.selectx == null)? -60: 2;
       ui.drawK1((i + i1), (y + 4), 56, 29, 4);
       ui = Ui.i();
       String str = "\x83\x02\x53\x02";
       i1 = (((w >> 1) + x) - 25) - 3;
       volume = y + 3;
       b = 1 | 0x10;
       int i2 = (this.selectx == null)? 0: 1;
       ui.drawString(str, i1, volume, b, i2, 0);
       ui = Ui.i();
       str = "\x7c\x02\x7e\x02";
       i1 = (((w >> 1) + x) + 25) + 3;
       volume = y + 3;
       b = 1 | 0x10;
       i2 = (this.selectx == null)? 1: 0;
       ui.drawString(str, i1, volume, b, i2, 0);
       Ui.i().drawTriangle(((w >> 1) + x), (y + 12), 80, true, true);
       return;
    }
    public void drawSelectMenu(Object[] menu,int x,int y,int w,int dis,int cn,int s_f){
       byte d = 0;
       while (d < menu.length) {
          Ui ui = Ui.i();
          int i = dis + 33;
          i = i * d;
          int i1 = y + i;
          int i2 = 33;
          int i3 = (d == s_f)? 1: cn;
          ui.drawK0(x, i1, w, i2, i3);
          ui = Ui.i();
          String str = menu[d].toString();
          i1 = w >> 1;
          i1 = i1 + x;
          int i4 = y + 2;
          i2 = dis + 33;
          i2 = i2 * d;
          i4 = i4 + i2;
          i2 = 1 | 0x10;
          i3 = (d == s_f)? 0: 3;
          ui.drawString(str, i1, i4, i2, i3, 1);
          Log.e("sk", "drawSelectMenu");
          i = dis + 33;
          i = i * d;
          i = i + y;
          if (this.pkey.isSelect(x, i, w, 33)) {
             if (this.map.my.state == 12) {
                if (d == s_f) {
                   this.map.my.state = 13;
                }else {
                   this.cur_a = d;
                }
             }else if(GameRun_F.run_state != 35 && (GameRun_F.run_state != 25 && (this.map.my.state != 16 && (GameRun_F.run_state != 65 && (GameRun_F.run_state != 66 && GameRun_F.run_state != 61))))){
                if (d == s_f) {
                   this.pkey.setKey5();
                }else {
                   this.popMenu = d;
                }
             }
          }
          int i5 = d + 1;
          d = (byte)i5;
       }
       return;
    }
    public void drawSelectMenu_(Object[] menu,int x,int y,int w,int dis,int cn,int s_f){
       int FONT_H = 25;
       byte d = 0;
       while (d < menu.length) {
          Ui ui = Ui.i();
          int i = FONT_H + 8;
          i = dis + 33;
          i = i * d;
          int i1 = y + i;
          int i2 = FONT_H + 8;
          int i3 = (d == s_f)? 1: cn;
          ui.drawK0(x, i1, w, i2, i3);
          ui = Ui.i();
          String str = menu[d].toString();
          i1 = w >> 1;
          i1 = i1 + x;
          int i4 = y + 2;
          i2 = FONT_H + 8;
          i2 = dis + 33;
          i2 = i2 * d;
          i4 = i4 + i2;
          i2 = 1 | 0x10;
          i3 = (d == s_f)? 0: 3;
          ui.drawString(str, i1, i4, i2, i3, 1);
          GameRun_F.g.setColor(0xff0000);
          i = Constants_H.WIDTH * x;
          i = i / Constants_H.WIDTH__;
          i1 = FONT_H + 8;
          i1 = dis + 33;
          i1 = i1 * d;
          i1 = i1 + y;
          i1 = i1 * Constants_H.WIDTH;
          i1 = i1 / Constants_H.WIDTH__;
          i4 = Constants_H.WIDTH * w;
          i4 = i4 / Constants_H.WIDTH__;
          i2 = FONT_H + 8;
          i2 = Constants_H.WIDTH * 33;
          i2 = i2 / Constants_H.WIDTH__;
          if (this.pkey.isSelect(i, i1, i4, i2)) {
             if (this.map.my.state == 12) {
                if (d == s_f) {
                   this.map.my.state = 13;
                }else {
                   this.cur_a = d;
                }
             }else if(GameRun_F.run_state != 35 && (GameRun_F.run_state != 25 && (this.map.my.state != 16 && (GameRun_F.run_state != 65 && GameRun_F.run_state != 66)))){
                if (d == s_f) {
                   this.pkey.setKey5();
                }else {
                   this.popMenu = d;
                }
             }
          }
          int i5 = d + 1;
          d = (byte)i5;
       }
       return;
    }
    public void drawSrcLine(Graphics g,int y,int h,int piece,boolean dir,boolean mode){
       short speed;
       GameRun_F tsrc_c;
       int ix;
       int ix1;
       short ix2;
       int WIDTH = 640;
       byte i = 0;
       byte ph = (byte)(h / piece);
       g.setColor(0);
       if (!dir) {
          speed = (short)(2 << this.src_c[0]);
          i = (byte)(piece - 1);
          while (i > -1) {
             if ((ix = ph - speed) > 0) {
                ix = 0;
                ix1 = i * ph;
                ix1 = ix1 + y;
                ix2 = (speed < 2)? 0: speed;
                ix1 = ix1 + ix2;
                ix2 = (speed < 2)? 0: speed;
                ix2 = ph - ix2;
                g.fillRect(ix, ix1, WIDTH, ix2);
             }
             ix = i - 1;
             i = (byte)ix;
             ix = speed / 2;
             speed = (short)ix;
          }
          if (mode && this.src_c[0] < 12) {
             tsrc_c = this.src_c;
             tsrc_c[0] = (byte)(tsrc_c[0] + 1);
          }else if(!mode && this.src_c[0] > 0){
             tsrc_c = this.src_c;
             tsrc_c[0] = (byte)(tsrc_c[0] - 1);
          }
       }else {
          speed = (short)(2 << this.src_c[1]);
          while (dir && i < piece) {
             if ((ix = ph - speed) > 0) {
                ix = 0;
                ix1 = i * ph;
                ix1 = ix1 + y;
                ix2 = (speed < 2)? 0: speed;
                ix2 = ph - ix2;
                g.fillRect(ix, ix1, WIDTH, ix2);
             }
             ix = i + 1;
             i = (byte)ix;
             ix = speed / 2;
             speed = (short)ix;
          }
          if (mode && this.src_c[1] < 12) {
             tsrc_c = this.src_c;
             tsrc_c[1] = (byte)(tsrc_c[1] + 1);
          }else if(!mode && this.src_c[1] > 0){
             tsrc_c = this.src_c;
             tsrc_c[1] = (byte)(tsrc_c[1] - 1);
          }
       }
       return;
    }
    public void drawZero(int x,int y,int anchor,int color){
       Ui.i().drawString("\x70\x02\x51\x02\x5c\x02\x5e\x02\x7e\x02\x7e\x02", x, y, anchor, color, 0);
    }
    public void drawZero(String str,int y){
       Ui.i().drawString("\x70\x02\x51\x02\x5c\x02\x5e\x02"+str, Constants_H.WIDTH_H, y, (1 | 0x20), 0, 0);
    }
    public byte getNLevel(int i){
       return this.nidusList[1][this.getRid(i)];
    }
    public short getNexp(int i,int n){
       return Ms.i().getShort(this.rmsNidus, ((i * 5) + n));
    }
    public byte getNid(int i){
       return this.nidusList[0][this.getRid(i)];
    }
    public byte getRid(int i){
       return this.rmsNidus[(i * 5)];
    }
    public short getSIndexW(String str){
       byte end;
       byte num = 0;
       byte start = 0;
       if (!(end = (byte)str.indexOf("#", start))) {
          end = 1;
       }
       while (end != -1) {
          int i = start + end;
          start = (byte)i;
          end = (byte)str.indexOf("#", start);
          i = num + 1;
          num = (byte)i;
       }
       return (short)(Ms.i().getStringWidth("#1") * num);
    }
    public void gogoWord(String string,int x,int y,int w,int color,int strT,int speed){
       short sw;
       int WIDTH = 640;
       int HEIGHT = 360;
       if ((sw = (short)(Ms.i().getStringWidth(string) - this.getSIndexW(string))) > ((WIDTH - x) - w)) {
          this.introX = this.introX - speed;
          if (((this.introX + sw)) < x) {
             this.introX = (WIDTH - w) - 75;
          }
       }else {
          this.introX = x;
       }
       GameRun_F.g.clipRect(x, y, ((WIDTH - w) - x), 30);
       Ui.i().drawStringColor(string, this.introX, y, color, strT);
       GameRun_F.g.setClip(0, 0, WIDTH, HEIGHT);
       return;
    }
    public void gogoWordM(String string,int y,int w,int color,int strT,int speed){
       int WIDTH = 640;
       int HEIGHT = 360;
       short sw = (short)Ms.i().getStringWidth(string);
       this.introT = this.introT - speed;
       if (((this.introT + sw)) < (w << 1)) {
          this.introT = WIDTH + 1;
       }
       GameRun_F.g.clipRect(w, y, (WIDTH - (w << 1)), 30);
       Ui.i().drawString(string, this.introT, y, 0, color, strT);
       GameRun_F.g.setClip(0, 0, WIDTH, HEIGHT);
       return;
    }
    public void initGraphics(Graphics _g){
       GameRun_F.g = _g;
       GameRun_F.dg = DirectUtils.getDirectGraphics(_g);
    }
    public void initOffG(){
       GameRun_F.scrT = Image.createImage((Constants_H.WIDTH + 20), (Constants_H.HEIGHT + 20));
       GameRun_F.offG = GameRun_F.scrT.getGraphics();
    }
    public void initRmsOther(){
       this.rmsOther = null;
       byte[] uobyteArray = new byte[12];
       uobyteArray[0] = -1;
       uobyteArray[3] = 1;
       this.rmsOther = uobyteArray;
    }
    public byte isMyLevel(boolean bb){
       byte b;
       int i = 103;
       switch (this.rmsOther[3]){
           case 1:
             if (bb && this.monInfoList[i] > 4) {
                this.rmsOther[3] = 2;
             }else {
                b = 5;
             }
             break;
           case 2:
             if (bb && this.monInfoList[i] > 9) {
                this.rmsOther[3] = 3;
             }else {
                b = 10;
             }
             break;
           case 3:
             if (bb && this.monInfoList[i] > 14) {
                this.rmsOther[3] = 4;
             }else {
                b = 15;
             }
             break;
           case 4:
             if (bb && this.monInfoList[i] > 29) {
                this.rmsOther[3] = 5;
             }else {
                b = 30;
             }
             break;
           default:
             b = -1;
       }
       return b;
    }
    public void loadInfoList(){
       this.info = Ms.i().rmsOptions(6, null, 1);
       if (this.info[0] == -1) {
          byte[] uobyteArray = new byte[105];
          this.monInfoList = uobyteArray;
          for (int i = 0; i < this.monInfoList.length; i++) {
             this.monInfoList[i] = 0;
          }
       }else {
          this.monInfoList = this.info;
       }
       this.info = null;
       return;
    }
    public void loadItem(){
       int ix = 4;
       this.info = Ms.i().rmsOptions(ix, null, 1);
       this.len = new byte[ix]{0x10,0x13,0x17,0x0c};
       byte[] uobyteArray = new byte[ix];
       this.itemsLength = uobyteArray;
       int i = 0;
       int j = 0;
       int k = 0;
       if (this.info[0] != -1) {
          for (i = 0; i < ix; i++) {
             this.itemsLength[i] = this.info[i];
          }
       }
       byte[][][] uobyteArray1 = new byte[][][this.itemsLength.length];
       this.items = uobyteArray1;
       i = 0;
       k = 0;
       while (i < this.items.length) {
          int[] ointArray = new int[]{this.len[i],2};
          this.items[i] = Array.newInstance(Byte.TYPE, ointArray);
          j = 0;
          while (j < this.itemsLength[i]) {
             ix = k * 2;
             ix = ix + 4;
             this.items[i][j][0] = this.info[ix];
             ix = k * 2;
             ix = ix + 4;
             ix = ix + 1;
             this.items[i][j][1] = this.info[ix];
             j++;
             k++;
          }
          i++;
       }
       this.info = null;
       this.len = null;
       return;
    }
    public void loadMon(int flag,byte[][] data){
       Monster[] monsterArray;
       ByteArrayInputStream byteArray;
       try{
          this.info = Ms.i().rmsOptions((flag + 8), null, 1);
          int i = 0;
          if (!flag) {
             int ix = 95;
             monsterArray = new Monster[ix];
             this.cMonsters = monsterArray;
             if (this.info[0] == -1) {
                this.cMon_count = 0;
             }else {
                byteArray = new ByteArrayInputStream(this.info);
                this.cMon_count = (byte)byteArray.read();
                for (; i < this.cMon_count; i++) {
                   this.cMonsters[i] = new Monster();
                   this.loadMon(byteArray, this.cMonsters[i], data);
                }
                byteArray.close();
                byteArray = null;
                this.info = null;
             }
          }else {
             monsterArray = new Monster[5];
             this.myMonsters = monsterArray;
             if (this.info[0] == -1) {
                this.myMon_length = 0;
             }else {
                byteArray = new ByteArrayInputStream(this.info);
                this.myMon_length = (byte)byteArray.read();
                for (; i < this.myMon_length; i++) {
                   this.myMonsters[i] = new Monster();
                   this.loadMon(byteArray, this.myMonsters[i], data);
                }
             }
          }
       }catch(java.lang.Exception e3){
          Exception ex = e3;
          ex.printStackTrace();
       }
       return;
    }
    public void loadMon(ByteArrayInputStream byteArray,Monster mon,byte[][] data){
       byte[] uobyteArray = new byte[18];
       mon.monster = uobyteArray;
       short[] oshortArray = new short[8];
       mon.monsterPro = oshortArray;
       byteArray.read(mon.monster);
       uobyteArray = new byte[10];
       this.len = uobyteArray;
       byteArray.read(this.len);
       for (int i = 0; i < 5; i++) {
          int ix = i * 2;
          ix = ix + 1;
          int ix1 = this.len[ix] & 0x00ff;
          ix1 = ix1 << 8;
          int ix2 = i * 2;
          ix2 = ix2 + 0;
          ix = this.len[ix2] & 0x00ff;
          ix1 = ix1 | ix;
          mon.monsterPro[i] = (short)ix1;
       }
       mon.setProAFD(data[mon.monster[0]]);
       this.len = null;
       return;
    }
    public void loadRmsNidus(){
       this.rmsNidus = Ms.i().rmsOptions(3, null, 1);
       if (this.rmsNidus[0] == -1) {
          this.rmsNidus = null;
          byte[] uobyteArray = new byte[25];
          uobyteArray[0] = -2;
          uobyteArray[3] = 10;
          uobyteArray[4] = 10;
          uobyteArray[5] = -2;
          uobyteArray[8] = 10;
          uobyteArray[9] = 10;
          uobyteArray[10] = -2;
          uobyteArray[13] = 10;
          uobyteArray[14] = 10;
          uobyteArray[15] = -2;
          uobyteArray[18] = 10;
          uobyteArray[19] = 10;
          uobyteArray[20] = -2;
          uobyteArray[23] = 10;
          uobyteArray[24] = 10;
          this.rmsNidus = uobyteArray;
       }
       return;
    }
    public void loadRmsOther(){
       this.info = Ms.i().rmsOptions(10, null, 1);
       if (this.info[0] == -1) {
          this.setMaxTakes(1);
          this.initRmsOther();
       }else {
          this.rmsOther = this.info;
          this.setMaxTakes(0);
       }
       this.info = null;
       return;
    }
    public void loadRmsSms(){
       this.rmsSms = Ms.i().rmsOptions(5, null, 1);
       if (this.rmsSms == null || this.rmsSms[0] == -1) {
          this.rmsSms = null;
          byte[] uobyteArray = new byte[7];
          this.rmsSms = uobyteArray;
       }
       if (this.rmsSms[0] == 10) {
          GameRun_F trmsOther = this.rmsOther;
          trmsOther[2] = (byte)(trmsOther[2] | 0x08);
       }
       return;
    }
    public void saveInfoList(){
       Ms.i().rmsOptions(6, this.monInfoList, 2);
    }
    public void saveItem(){
       int len = 0;
       for (int i = 0; i < 4; i++) {
          len = len + this.itemsLength[i];
       }
       byte[] uobyteArray = new byte[(this.items.length + (len * 2))];
       this.info = uobyteArray;
       len = 0;
       for (i = 0; i < 4; i++) {
          this.info[i] = this.itemsLength[i];
       }
       i = 0;
       while (i < this.items.length) {
          int j = 0;
          while (j < this.itemsLength[i]) {
             int ix = len * 2;
             ix = ix + 4;
             this.info[ix] = this.items[i][j][0];
             ix = len * 2;
             ix = ix + 4;
             ix = ix + 1;
             this.info[ix] = this.items[i][j][1];
             j++;
             len++;
          }
          i++;
       }
       Ms.i().rmsOptions(4, this.info, 2);
       this.info = null;
       return;
    }
    public void saveMon(int flag){
       try{
          ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
          int i = 0;
          if (!flag) {
             byteArray.write(this.cMon_count);
             for (; i < this.cMon_count; i++) {
                this.saveMon(byteArray, this.cMonsters[i]);
             }
             Ms.i().rmsOptions(8, byteArray.toByteArray(), 2);
          }else {
             byteArray.write(this.myMon_length);
             for (; i < this.myMon_length; i++) {
                this.saveMon(byteArray, this.myMonsters[i]);
             }
             Ms.i().rmsOptions(9, byteArray.toByteArray(), 2);
          }
          byteArray.close();
          byteArray = null;
       }catch(java.lang.Exception e3){
          Exception ex = e3;
          ex.printStackTrace();
       }
       return;
    }
    public void saveMon(ByteArrayOutputStream byteArray,Monster mon){
       byteArray.write(mon.monster);
       int xxx = 0;
       for (int i = 0; i < 5; i++) {
          xxx = mon.monsterPro[i];
          int ix = xxx & 0x00ff;
          byteArray.write((byte)ix);
          ix = xxx >> 8;
          ix = ix & 0x00ff;
          byteArray.write((byte)ix);
       }
       return;
    }
    public void setAction_str(String[] temp_str){
       this.action_str = temp_str;
       temp_str = null;
    }
    public void setGogoWord(){
       this.introT = Constants_H.WIDTH;
       Ms.i();
       Ms.skip = 0;
       StringBuffer[] sr = Ms.i().createStringArray(Ms.i().getStream("data/other/hint.t", -1));
       Ms.i();
       this.gogoST = sr[Ms.getRandom(sr.length)];
       sr = null;
    }
    public void setMaxTakes(boolean bb){
       if (bb) {
          this.max_takes = 3;
          this.max_monsters = 10;
       }else if(this.rmsOther[3] == 2){
          this.max_takes = 4;
          this.max_monsters = 20;
       }else if(this.rmsOther[3] == 3){
          this.max_takes = 5;
          this.max_monsters = 40;
       }else if(this.rmsOther[3] == 4){
          this.max_takes = 5;
          this.max_monsters = 80;
       }else if(this.rmsOther[3] == 5){
          this.max_takes = 5;
          this.max_monsters = 95;
       }
       return;
    }
    public void setNidusExp(int exp){
       exp = (((exp / 10)) < 1)? 1: exp / 10;
       byte i = 0;
       while (i < 5) {
          if (this.getRid(i) != -2) {
             int ix1 = this.getNexp(i, 1) + exp;
             int ix2 = i * 5;
             ix2 = ix2 + 1;
             Ms.i().putShort(ix1, this.rmsNidus, ix2);
             if (this.getNexp(i, 1) > this.getNexp(i, 3)) {
                ix2 = i * 5;
                ix2 = ix2 + 1;
                Ms.i().putShort(this.getNexp(i, 3), this.rmsNidus, ix2);
             }
          }
          int ix = i + 1;
          i = (byte)ix;
       }
       return;
    }
    public void setPauseS(int mode){
       String[] stringArray;
       int i = 0;
       if (!mode) {
          stringArray = new String[]{"\x4f\x02\x5b\x02\x6e\x02\x62\x02","\x67\x02\x77\x02\x5b\x02\x72\x02","\x4e\x02\x72\x02\x80\x02\x53\x02","\x5b\x02\x72\x02\x56\x02\x92\x02","\x67\x02\x77\x02\x4e\x02\x52\x02","\x8f\x02\x56\x02\x6e\x02\x62\x02"};
          this.setAction_str(stringArray);
       }else {
          stringArray = new String[]{"\x8b\x02\x53\x02\x8f\x02\x5e\x02","\x58\x02\x97\x02","\x6e\x02\x62\x02\x5e\x02\x52\x02","\x56\x02\x4e\x02\x83\x02\x53\x02"};
          this.setAction_str(stringArray);
       }
       return;
    }
    public void setStringB(String str,int w,int mode){
       if (!mode) {
          this.about_a = Ms.i().groupString(str, w);
       }else if(mode == 1){
          this.about_b = Ms.i().groupString(str, w);
       }else if(mode == 2){
          this.about_c = Ms.i().groupString(str, w);
       }else if(mode == 3){
          this.about_d = Ms.i().groupString(str, w);
       }
       return;
    }
    public void showString(String string,int y,int offx){
       int WIDTH = 640;
       int HEIGHT = 360;
       int WIDTH_H = 320;
       int HEIGHT_H = 180;
       byte strNum = (byte)(string.length() / 11);
       Ui.i().drawK0((offx - 5), y, (WIDTH + 10), (((strNum + 1) * 25) + 8), 3);
       this.showStringM(string, (WIDTH_H + offx), (y + 3), 11, 0);
    }
    public void showString(StringBuffer[] showS,int y,int offx,int mode){
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = 360;
       int WIDTH_H = Constants_H.WIDTH__ / 2;
       int HEIGHT_H = 180;
       int FONT_W = 25;
       int FONT_H = 25;
       y = y + 5;
       if (mode) {
          Ui.i().drawKuang((offx - 5), y, (WIDTH + 10), ((showS.length * FONT_H) + 12));
          if (mode == 2) {
             this.drawSnare5((WIDTH_H + offx), (((showS.length * FONT_H) + y) + 4));
          }
       }
       byte d = 0;
       while (d < showS.length) {
          int i = FONT_W + offx;
          int i1 = y + 4;
          int i2 = d * FONT_H;
          i1 = i1 + i2;
          Ui.i().drawStringColor(showS[d].toString(), i, i1, -1, 1);
          int i3 = d + 1;
          d = (byte)i3;
       }
       return;
    }
    public void showStringM(String str,int x,int y,int num,int c){
       int i;
       int i3;
       byte strNum = (byte)(str.length() / num);
       byte d = 0;
       while (d <= strNum) {
          if (!strNum) {
             i = 1 | 0x10;
             Ui.i().drawString(str, x, y, i, c, 1);
             Log.e("sk", "strNum == 0");
          }else {
             Ui ui = Ui.i();
             int i2 = d * num;
             if ((i3 = d + 1) > strNum) {
                i3 = str.length();
             }else {
                i3 = d + 1;
                i3 = i3 * num;
             }
             i3 = d * 25;
             int i4 = y + i3;
             i = 1 | 0x10;
             ui.drawString(str.substring(i2, i3), x, i4, i, c, 0);
             Log.e("sk", "else");
          }
          int i1 = d + 1;
          d = (byte)i1;
       }
       return;
    }
    public void showStringM_(String str,int x,int y,int num,int c){
       int i;
       int i3;
       int FONT_H = 25;
       byte strNum = (byte)(str.length() / num);
       byte d = 0;
       while (d <= strNum) {
          if (!strNum) {
             i = 1 | 0x10;
             Ui.i().drawString(str, x, y, i, c, 1);
             Log.e("sk", "strNum == 0");
          }else {
             Ui ui = Ui.i();
             int i2 = d * num;
             if ((i3 = d + 1) > strNum) {
                i3 = str.length();
             }else {
                i3 = d + 1;
                i3 = i3 * num;
             }
             i3 = d * FONT_H;
             int i4 = y + i3;
             i = 1 | 0x10;
             ui.drawString(str.substring(i2, i3), x, i4, i, c, 0);
          }
          int i1 = d + 1;
          d = (byte)i1;
       }
       return;
    }
}
