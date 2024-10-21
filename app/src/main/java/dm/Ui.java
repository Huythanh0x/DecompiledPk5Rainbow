package dm.Ui;
import java.lang.Object;
import dm.Sprite;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import com.nokia.mid.ui.DirectGraphics;
import java.lang.String;
import android.util.Log;
import java.lang.StringBuilder;
import dm.Ms;
import java.lang.Integer;
import java.lang.StringBuffer;
import main.Constants_H;
import com.nokia.mid.ui.DirectUtils;

public class Ui	// class@0000e5 from classes.dex
{
    private int[] MIRROR;
    private byte[][] MIRROR2;
    private byte[] MIRROR3;
    public byte cTriangle;
    private byte rz;
    private Image ui_img;
    private short[][] ui_modules;
    public static DirectGraphics dg;
    public static Graphics g;
    private static final short[] transforms;
    private static Ui uiListener;

    static {
       short[] oshortArray = new short[8];
       oshortArray[1] = 5;
       oshortArray[2] = 3;
       oshortArray[3] = 6;
       oshortArray[4] = 2;
       oshortArray[5] = 4;
       oshortArray[6] = 1;
       oshortArray[7] = 7;
       Ui.transforms = oshortArray;
    }
    public void Ui(){
       super();
       byte[][] uobyteArray = new byte[][2];
       byte[] uobyteArray1 = new byte[8];
       uobyteArray1[1] = 1;
       uobyteArray1[2] = 2;
       uobyteArray1[3] = 3;
       uobyteArray1[4] = 4;
       uobyteArray1[5] = 5;
       uobyteArray1[6] = 6;
       uobyteArray1[7] = 7;
       uobyteArray[0] = uobyteArray1;
       uobyteArray1 = new byte[8];
       uobyteArray1[0] = 4;
       uobyteArray1[1] = 5;
       uobyteArray1[2] = 6;
       uobyteArray1[3] = 7;
       uobyteArray1[5] = 1;
       uobyteArray1[6] = 2;
       uobyteArray1[7] = 3;
       uobyteArray[1] = uobyteArray1;
       this.MIRROR2 = uobyteArray;
       this.MIRROR3 = new byte[2]{0x01,0xff};
       int[] ointArray = new int[]{4 | 0x10,8 | 0x10};
       this.MIRROR = ointArray;
       this.cTriangle = 0;
       Ui.uiListener = this;
    }
    public static Ui i(){
       if (Ui.uiListener == null) {
          Ui.uiListener = new Ui();
       }
       return Ui.uiListener;
    }
    public boolean drawActionOne(Sprite sp,int a_id,int x,int y,byte[] now_a,int dir,boolean mode){
       this.drawFrameOne(sp, sp.action(a_id, now_a[0], 0), x, y, dir);
       int b = (byte)(now_a[1] + 1);
       now_a[1] = b;
       if (b > sp.action(a_id, now_a[0], 1)) {
          now_a[1] = 0;
          b = (byte)(now_a[0] + 1);
          now_a[0] = b;
          if (b >= sp.aLength(a_id)) {
             if (!mode) {
                now_a[0] = (byte)(sp.aLength(a_id) - 1);
                b = 1;
             label_0039 :
                return b;
             }else {
                now_a[0] = 0;
             }
          }
       }
       b = 0;
       goto label_0039 ;
    }
    public void drawBDir(int x,int y,int w,int h){
       Ui.g.setColor(0x7ecef4);
       Ui.g.drawRect(x, y, (w * 3), (h << 1));
       Ui.g.drawRect((x + w), y, w, (h << 1));
       Ui.g.drawLine((float)x, (float)(y + h), (float)((w * 3) + x), (float)(y + h));
    }
    public void drawBarOne(int x,int y,int w,int cMin,int cMax,int mode){
       int i = 1;
       int c0 = 0xf60e1c;
       int c1 = 0xff9f01;
       int h = 5;
       if (mode == i) {
          c0 = 0xd8ff;
       }else if(mode == 2){
          c0 = 0xeb11;
       }
       this.fillRect(0x3e1141, (x + 1), y, (w - i), h);
       Ui.g.drawRect(x, (y + 1), w, (h - 3));
       h = h - 2;
       this.fillRect(c1, (x + 1), (y + 1), cMin, h);
       int i1 = x + 1;
       i = y + 1;
       int i2 = (cMin > cMax)? cMax: cMin;
       this.fillRect(c0, i1, i, i2, h);
       return;
    }
    public void drawFrameOne(Sprite sp,int f_id,int x,int y,int dir){
       short now_frame = 0;
       while (now_frame < sp.fLength(f_id)) {
          int i = sp.frame(f_id, now_frame, 1) * this.MIRROR3[dir];
          int i1 = x + i;
          int i2 = y + sp.frame(f_id, now_frame, 2);
          this.drawModuleOne(sp, sp.frame(f_id, now_frame, 0), i1, i2, dir, sp.frame(f_id, now_frame, 3));
          i = now_frame + 1;
          now_frame = (short)i;
       }
       return;
    }
    public void drawImage(Image image,int x,int y,int archor){
       Ui.g.drawImage(image, x, y, archor);
    }
    public void drawImage(Image image,int x,int y,int archor,int trans){
       if (!trans) {
          Ui.g.drawImage(image, x, y, archor);
       }else {
          Ui.dg.drawImage(image, x, y, archor, trans);
       }
       return;
    }
    public void drawK(int x,int y,int w,int h,int c){
       if (!c) {
          c = 0xeafcff;
       }else if(c == 1){
          c = 0xbc7afc;
       }else if(c == 2){
          c = 0xbbe2ff;
       }else if(c == 3){
          c = 0x4fc7ff;
       }else if(c == 4){
          c = 0x78ff;
       }else {
          c = 0xa9b4dc;
       }
       Ui.g.setColor(c);
       Ui.g.fillRect((x + 1), y, (w - 2), h);
       Ui.g.fillRect(x, (y + 1), w, (h - 2));
       return;
    }
    public void drawK0(int x,int y,int w,int h,int c){
       int i = 2;
       byte c0 = (byte)c;
       c = (c == i)? 0xeafcff: 0x1d1e35;
       Ui.g.setColor(c);
       Ui.g.drawRect((x + 1), y, (w - 3), (h - 1));
       Ui.g.drawRect(x, (y + 1), (w - 1), (h - 3));
       this.drawK((x + 1), (y + 1), (w - i), (h - i), c0);
       return;
    }
    public void drawK1(int x,int y,int w,int h,int c){
       Graphics g = Ui.g;
       int i = (!c)? 0x535453: 0x1d1e35;
       g.setColor(i);
       Ui.g.drawRect(x, (y + 2), w, (h - 3));
       Ui.g.drawLine((float)(x + 1), (float)(y + h), (float)((x + w) - 1), (float)(y + h));
       if (c && c != 1) {
          if (c == 2) {
             c = 0xd3fbff;
          }else if(c == 3){
             c = 0x75eaff;
          }else {
             c = 0xbc7afc;
          }
       }else {
          c = 0xeafcff;
       }
       Ui.g.setColor(c);
       Ui.g.fillRect((x + 1), y, (w - 2), h);
       Ui.g.fillRect(x, (y + 1), w, (h - 2));
       return;
    }
    public void drawK2(int x,int y,int w,int h,int arc){
       int i = 4;
       arc = (!arc)? 5: 20;
       Ui.g.setColor(0);
       Ui.g.fillRect(x, y, w, h);
       Ui.g.setColor(0x78ff);
       Ui.g.fillRect((x + 2), (y + 2), (w - i), (h - i));
       return;
    }
    public void drawK3(int x,int y,int w,int h){
       this.drawK0(x, y, (w - 1), (h - 1), 0);
       Ui.g.setColor(0x1d1e35);
       Ui.g.fillRect((x + 2), (y + 2), (w - 2), (h - 2));
    }
    public void drawK4(int x,int y,int w,int h){
       Ui.g.setColor(0xffe92d);
       Ui.g.drawLine((float)(x + 1), (float)y, (float)((x + w) - 2), (float)y);
       Ui.g.drawLine((float)(x + 1), (float)((y + h) - 1), (float)((x + w) - 2), (float)((y + h) - 1));
       Ui.g.drawLine((float)x, (float)(y + 1), (float)x, (float)((y + h) - 2));
       Ui.g.drawLine((float)((x + w) - 1), (float)(y + 1), (float)((x + w) - 1), (float)((y + h) - 2));
       Ui.g.drawLine((float)x, (float)(y + 1), (float)(x + 1), (float)(y + 1));
       Ui.g.drawLine((float)((x + w) - 2), (float)(y + 1), (float)((x + w) - 1), (float)(y + 1));
       Ui.g.drawLine((float)x, (float)((y + h) - 2), (float)(x + 1), (float)((y + h) - 2));
       Ui.g.drawLine((float)((x + w) - 2), (float)((y + h) - 2), (float)((x + w) - 2), (float)((y + h) - 2));
    }
    public void drawKuang(int x,int y,int w,int h){
       Ui.g.setColor(0x1d1e35);
       Ui.g.drawRect((x + 1), y, (w - 4), (h - 2));
       Ui.g.drawRect((x + 2), (y + 1), (w - 4), (h - 2));
       Ui.g.drawLine((float)x, (float)(y + 1), (float)x, (float)((y + h) - 3));
       Ui.g.drawLine((float)((x + w) - 1), (float)(y + 2), (float)((x + w) - 1), (float)((y + h) - 2));
       this.fillRect(0xeafcff, (x + 1), (y + 1), (w - 3), (h - 3));
    }
    public void drawKuangAdorn(int x,int y,int w,int h,int mode){
       int i = 22;
       if (!mode) {
          Ui.g.setColor(0x1c1d34);
          Ui.g.drawRect((x + 20), (y - i), (w - 21), 20);
          Ui.g.drawRect((x + 20), (y - i), (w - i), 21);
          this.fillRect(0xe6dc90, (x + 20), (y - i), (w - i), 20);
          this.drawUi(33, x, y, 36, 0);
          this.drawUi(31, ((x + w) - 4), y, 36, 0);
       }else if(mode == 1){
          this.drawUi(32, x, (y - 7), 0, 0);
          this.drawUi(32, ((x + w) + 5), (y - 7), (8 | 0x10), 0);
          this.fillRect(0xcec36d, (x + 15), (y - 5), (w - 25), 13);
          this.fillRect(0xf5ea9f, (x + 15), (y - 3), (w - 25), 10);
          this.fillRect(0xc78f36, (x + 15), (y + 10), (w - 25), 5);
          this.drawLine(0x1c1d34, (x + 15), (y - 7), ((x + w) - 11), (y - 7));
          this.drawLine(0xfaf3c3, (x + 15), (y - 6), ((x + w) - 11), (y - 6));
          this.drawLine(0x5e2103, (x + 15), (y + 12), ((x + w) - 11), (y + 12));
          Ui.g.setColor(0xcaa856);
          Ui.g.drawRect((x + 15), (y + 8), (w - 26), 1);
       }else if(mode == 2){
          this.drawUi(32, x, ((y + h) - 1), 36, 6);
          this.drawUi(32, ((x + w) + 5), ((y + h) - 1), 40, 6);
          this.fillRect(0xcec36d, (x + 15), ((y + h) - 16), (w - 25), 13);
          this.fillRect(0xf5ea9f, (x + 15), ((y + h) - 15), (w - 25), 10);
          this.fillRect(0xc78f36, (x + 15), ((y + h) - 23), (w - 25), 5);
          this.drawLine(0x1c1d34, (x + 15), ((y + h) - 2), ((x + w) - 11), ((y + h) - 2));
          this.drawLine(0xfaf3c3, (x + 15), ((y + h) - 3), ((x + w) - 11), ((y + h) - 3));
          this.drawLine(0x5e2103, (x + 15), ((y + h) - 21), ((x + w) - 11), ((y + h) - 21));
          Ui.g.setColor(0xcaa856);
          Ui.g.drawRect((x + 15), ((y + h) - 18), (w - 26), 1);
       }
       return;
    }
    public void drawKuangMap(int x,int y,int w,int h,boolean mode){
       int i = (mode)? 0x3a71: 0xffc500;
       this.fillRect(i, x, y, w, h);
       i = (mode)? 0x6699ff: 0xad7e34;
       this.fillRect(i, (x + 1), (y + 1), (w - 2), (h - 2));
       return;
    }
    public void drawKuangSelect(int x,int y,int w,int h,int mode){
       int i = 2;
       int i1 = 1;
       int color = 0xcaa856;
       if (mode == i1) {
          color = 0xad7e34;
       }else if(mode == i){
          color = 0x221300;
       }else if(mode == 3){
          color = 0xe6dc90;
       }else if(mode == 4){
          color = 0xffc500;
       }else if(mode == 5){
          color = 0x5e2103;
       }
       Ui.g.setColor(color);
       Ui.g.fillRect((x + 1), y, (w - i), h);
       Ui.g.drawRect(x, (y + 1), (w - i1), (h - 3));
       return;
    }
    public void drawLine(int c,int x0,int y0,int x1,int y1){
       Ui.g.setColor(c);
       Ui.g.drawLine((float)x0, (float)y0, (float)x1, (float)y1);
    }
    public void drawListKY(int length,int x,int y,int w,int kw,int kh,int dis,int sel,int c0,int c1){
       int i1;
       byte d = 0;
       while (d < length) {
          if (d != sel) {
             int i = x + kw;
             i1 = kh + dis;
             i1 = i1 * d;
             int i2 = y + i1;
             i1 = kw << 1;
             int i3 = w - i1;
             this.drawK0(i, i2, i3, kh, c1);
          }
          i1 = d + 1;
          d = (byte)i1;
       }
       if (sel != -1) {
          this.drawK1(x, (y + ((kh + dis) * sel)), w, kh, c0);
       }
       return;
    }
    public void drawListSY(Object[] menu,int x,int y,int w,int sh,int sel,int c0,int c1,int strT){
       byte d = 0;
       while (d < menu.length) {
          String str = menu[d].toString();
          int i = w >> 1;
          int i1 = x + i;
          i = y + 2;
          int i2 = d * sh;
          i2 = i2 + i;
          int i3 = (d == sel)? c0: c1;
          this.drawString(str, i1, i2, 17, i3, strT);
          i = d + 1;
          d = (byte)i;
       }
       Log.e("sk", "drawListSY");
       return;
    }
    public void drawListSYHasSound(Object[] menu,int x,int y,int w,int sh,int sel,int c0,int c1,int strT){
       byte d = 0;
       while (d < menu.length) {
          String str = menu[d].toString();
          int i = w >> 1;
          int i1 = x + i;
          i = y + 2;
          int i2 = d * sh;
          i2 = i2 + i;
          int i3 = (menu[d].toString().equals("\x58\x02\x97\x02"))? 20: 17;
          int i4 = (d == sel)? c0: c1;
          this.drawString(str, i1, i2, i3, i4, strT);
          i = d + 1;
          d = (byte)i;
       }
       return;
    }
    public void drawModuleOne(Sprite sp,int m_id,int x,int y,int dir,int manipulation){
       this.drawRegion(sp.img, sp.module(m_id, 0), sp.module(m_id, 1), sp.module(m_id, 2), sp.module(m_id, 3), x, y, this.MIRROR[dir], this.MIRROR2[dir][manipulation], Ui.g);
    }
    public void drawNum(String str,int x,int y,int anchor,int type){
       byte w;
       char cr;
       int ix1;
       int ix2;
       int ix3;
       if (str.length()) {
          int ix = (!anchor)? 0: str.length() - 1;
          byte i = (byte)ix;
          short sw = 0;
          do {
             if (!type) {
                w = 8;
             }else if(type == 1){
                w = 10;
             }else {
                w = 14;
             }
             byte bid = -1;
             if ((cr = str.charAt(i)) >= '0' && cr <= '9') {
                ix = cr - 48;
                bid = (byte)ix;
                if (!type) {
                   ix = bid + 10;
                   bid = (byte)ix;
                }else if(type == 1){
                   ix = bid + 35;
                   bid = (byte)ix;
                }else {
                   ix = bid + 57;
                   bid = (byte)ix;
                }
             }else if(cr == '/'){
                bid = 20;
             }else if(cr == '-'){
                ix = (type == 2)? 56: 46;
                bid = (byte)ix;
             }else if(cr == '+'){
                bid = 47;
             }else if(cr == '%'){
                bid = 45;
                w = 14;
             }else if(cr == 0x7ea7){
                bid = 29;
                w = 12;
             }
             if (bid != -1) {
                if (!anchor) {
                   ix1 = x + sw;
                   this.drawUi(bid, ix1, y, 36, 0);
                }else {
                   ix1 = x - sw;
                   this.drawUi(bid, ix1, y, 40, 0);
                }
                ix = sw + w;
                sw = (short)ix;
             }else if(!anchor){
                ix2 = x + sw;
                ix3 = y + 5;
                this.drawString("".append(cr).toString(), ix2, ix3, 36, 3, 0);
             }else {
                ix2 = x - sw;
                ix3 = y + 5;
                this.drawString("".append(cr).toString(), ix2, ix3, 40, 3, 0);
             }
             ix = sw + 25;
             sw = (short)ix;
             if (!anchor) {
                ix = i + 1;
                i = (byte)ix;
             }else {
                ix = i - 1;
                i = (byte)ix;
             }
             if (!anchor) {
             }else if(i <= -1){
             }
          } while (i >= str.length());
       }
       return;
    }
    public void drawRect(int c,int x0,int y0,int w,int h){
       Ui.g.setColor(c);
       Ui.g.drawRect(x0, y0, w, h);
    }
    public void drawRectZ(int color,int x,int y,int w,int h,int s){
       Ui.g.setColor(color);
       Ms.i();
       Ms.i();
       Ms.i();
       Ms.i();
       Ui.g.drawRect((x - Ms.abs(this.rz)), (y - Ms.abs(this.rz)), ((Ms.abs(this.rz) << 1) + w), ((Ms.abs(this.rz) << 1) + h));
       byte b = (byte)(this.rz + 1);
       this.rz = b;
       if (b > s) {
          this.rz = (byte)(- s);
       }
       return;
    }
    public void drawRegion(Image image,int mx,int my,int mw,int mh,int realX,int realY,int anchor,int manipulation,Graphics g){
       g.drawRegion(image, mx, my, mw, mh, Ui.transforms[manipulation], realX, realY, anchor);
    }
    public void drawString(String str_hit,int x,int y,int anchor,int color,int mode){
       int c0 = 0xcaa856;
       int c1 = 0x381808;
       y++;
       switch (color){
           case 0:
             c0 = 0;
             c1 = 0xffffff;
             break;
           case 1:
             c0 = 0x535453;
             c1 = 0x75eaff;
             break;
           case 2:
             c0 = 0x2951d8;
             c1 = 0xa808;
             break;
           case 3:
             c0 = 0x1d1e35;
             c1 = 0x5ee7;
             break;
           case 4:
             c0 = 0x140e03;
             c1 = 0x4fc7ff;
             break;
           case 5:
             c0 = 0x221503;
             c1 = 0xff6c00;
             break;
           case 6:
             c0 = 0x7b3939;
             c1 = 0xf70808;
             break;
           case 7:
             c0 = 0x442b01;
             c1 = 0xffb400;
             break;
           case 8:
             c0 = 0x9a7604;
             c1 = 0xc000ff;
             break;
           case 9:
             c0 = 0xb07038;
             c1 = 0x381808;
             break;
           case 10:
             c0 = 0x140225;
             c1 = 0x868686;
             break;
       }
       if (mode == 2) {
          Ui.g.setColor(c0);
          Ui.g.drawString(str_hit, (x - 1), y, anchor);
          Ui.g.drawString(str_hit, (x + 1), y, anchor);
          Ui.g.drawString(str_hit, x, (y - 1), anchor);
          Ui.g.drawString(str_hit, x, (y + 1), anchor);
          Ui.g.drawString(str_hit, (x + 1), (y + 1), anchor);
          Ui.g.drawString(str_hit, (x - 1), (y + 1), anchor);
          Ui.g.drawString(str_hit, (x - 1), (y - 1), anchor);
          Ui.g.drawString(str_hit, (x + 1), (y - 1), anchor);
       }
       Ui.g.setColor(c1);
       if (mode == 1) {
          Ui.g.drawString(str_hit, (x + 1), y, anchor);
       }
       Ui.g.drawString(str_hit, x, y, anchor);
       return;
    }
    public void drawStringColor(String str,int x,int y,int color,int mode){
       byte end;
       byte c = (byte)color;
       byte start = 0;
       short tw = 0;
       do {
          end = (byte)str.indexOf("#", start);
          if (end != -1) {
             String ssub = str.substring(start, end);
             int i = x + tw;
             this.drawString(ssub, i, y, 0, c, mode);
             int i1 = Ms.i().getStringWidth(ssub) + tw;
             tw = (short)i1;
             i1 = end + 1;
             ssub = end + 2;
             i1 = Integer.parseInt(str.substring(i1, ssub)) - 1;
             c = (byte)i1;
             i1 = end + 2;
             start = (byte)i1;
             if (c == -1) {
                c = (byte)color;
             }
          }else {
             int i2 = x + tw;
             this.drawString(str.substring(start, str.length()), i2, y, 0, c, mode);
          }
       } while (end == -1);
       return;
    }
    public void drawStringY(Object[] str,int x,int y,int start,int end,int sh,int c,int strT){
       byte i = (byte)start;
       while (i < end && i < str.length) {
          int ix = i - start;
          ix = ix * sh;
          int ix1 = y + ix;
          Ui.i().drawString(str[i].toString(), x, ix1, 0, c, strT);
          int ix2 = i + 1;
          i = (byte)ix2;
       }
       return;
    }
    public void drawStringY(StringBuffer[] showS,int x,int y,int fh,int color,int mode){
       byte d = 0;
       while (d < showS.length) {
          int i = y + 4;
          int i1 = d * fh;
          int i2 = i + i1;
          this.drawStringColor(showS[d].toString(), x, i2, color, mode);
          i = d + 1;
          d = (byte)i;
       }
       return;
    }
    public void drawTriangle(int x,int y,int w,boolean dir,boolean ct){
    }
    public void drawTriangle1(int x,int y,int w,boolean dir,boolean ct){
       Ms.i();
       this.drawUi(30, ((x - w) - Ms.abs(this.cTriangle)), y, (4 | 0x02), 4);
       Ms.i();
       this.drawUi(30, (Ms.abs(this.cTriangle) + (x + w)), y, (8 | 0x02), 0);
       if (ct) {
          byte b = (byte)(this.cTriangle + 1);
          this.cTriangle = b;
          if (b > 4) {
             this.cTriangle = -3;
          }
       }
       return;
    }
    public void drawUi(int action,int x,int y,int anchor,int manipulation){
       this.drawRegion(this.ui_img, this.ui_modules[action][0], this.ui_modules[action][1], this.ui_modules[action][2], this.ui_modules[action][3], x, y, anchor, manipulation, Ui.g);
    }
    public void drawVolume(int x,int y,int v,boolean bb){
       Graphics g = Ui.g;
       int i = (bb)? 0x7004b: 0xb07038;
       g.setColor(i);
       Ui.g.drawRect(((x - 1) + 3), (y + 5), 7, 10);
       Ui.g.drawRect((((x + 5) + 2) + 3), (y + 2), 7, 13);
       Ui.g.drawRect((((x + 11) + 4) + 3), (y - 1), 8, 16);
       g = Ui.g;
       i = (bb)? 0xf4e110: 0x381808;
       g.setColor(i);
       Ui.g.drawRect((x + 3), (y + 6), 6, 8);
       Ui.g.drawRect((((x + 6) + 2) + 3), (y + 3), 6, 11);
       Ui.g.drawRect((((x + 12) + 4) + 3), y, 6, 14);
       if (v > 0) {
          Ui.g.fillRect(((x + 1) + 3), (y + 7), 5, 7);
       }
       if (v > 30) {
          Ui.g.fillRect((((x + 7) + 2) + 3), (y + 4), 5, 10);
       }
       if (v > 60) {
          Ui.g.fillRect((((x + 13) + 4) + 3), (y + 1), 5, 13);
       }
       return;
    }
    public void drawYesNo(boolean a,boolean b){
       int WIDTH = 640;
       int HEIGHT = 360;
       if (a) {
          this.drawUi(27, 0, HEIGHT, 36, 0);
       }
       if (b) {
          this.drawUi(28, WIDTH, HEIGHT, 40, 0);
       }
       return;
    }
    public void drawYesNo_(boolean a,boolean b){
       if (a) {
          this.drawUi(27, 0, Constants_H.HEIGHT, 36, 0);
       }
       if (b) {
          this.drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0);
       }
       return;
    }
    public void drawYesNo__(boolean a,boolean b){
       int WIDTH = Constants_H.WIDTH__;
       int HEIGHT = Constants_H.HEIGHT__;
       if (a) {
          this.drawUi(27, 0, HEIGHT, 36, 0);
       }
       if (b) {
          this.drawUi(28, WIDTH, HEIGHT, 40, 0);
       }
       return;
    }
    public void fillArc(int c,int x,int y,int w,int h,int a0,int a1){
       Ui.g.setColor(c);
       Ui.g.fillArc(x, y, w, h, a0, a1);
    }
    public void fillRect(int c,int x,int y,int w,int h){
       Ui.g.setColor(c);
       Ui.g.fillRect(x, y, w, h);
    }
    public void fillRectB(){
       int WIDTH = 640;
       int HEIGHT = 360;
       this.fillRect(0x52bdef, 0, 0, WIDTH, HEIGHT);
    }
    public void initGraphics(Graphics _g){
       Ui.g = _g;
       Ui.dg = DirectUtils.getDirectGraphics(_g);
    }
    public void initUiModules(){
       this.ui_img = Ms.i().createImage("data/ui");
       Ms.i();
       Ms.skip = 0;
       this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
    }
    public void sliding(int x,int y,int h,int now,int all,boolean type){
       int i3;
       int i4;
       byte w = 10;
       if (!type) {
          this.drawK((x - 2), (y - 2), (w + 4), (h + 4), 0);
       }
       int i = (type)? 0: 3;
       this.drawK(x, y, w, h, i);
       byte i1 = 11;
       i = (type)? 3: 0;
       this.drawK(x, y, w, i1, i);
       int i2 = (y + h) - 11;
       i1 = 11;
       i = (type)? 3: 0;
       this.drawK(x, i2, w, i1, i);
       h = h - 22;
       if ((all--) < 1) {
          i3 = x + 1;
          i2 = y + 12;
          i4 = w - 2;
          i1 = h - 2;
          i = (type)? 3: 0;
          this.drawK(i3, i2, i4, i1, i);
       }else if((i1 = (byte)(h / (all + 1))) < 15){
          i1 = 15;
       }
       short k2 = (short)((((h - 2) - i1) * now) / all);
       i3 = x + 1;
       i2 = (y + 12) + k2;
       i4 = w - 2;
       i = (type)? 3: 0;
       this.drawK(i3, i2, i4, i1, i);
       return;
    }
}
