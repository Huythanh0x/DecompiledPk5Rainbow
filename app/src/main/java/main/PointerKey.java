package main.PointerKey;
import main.Key_H;
import main.MainCanvas;
import java.lang.Object;
import main.Constants_H;
import main.GameRun;
import main.Map;
import dm.Npc;
import dm.Ms;
import java.lang.StringBuilder;
import java.lang.String;
import android.util.Log;

public class PointerKey implements Key_H	// class@000167 from classes.dex
{
    public int[][][] button_pos;
    boolean dir;
    int gox;
    int goy;
    GameRun gr;
    int i0;
    int i1;
    boolean isGo;
    int m0;
    int m1;
    Map map;
    MainCanvas mc;
    int tempx;
    int tempy;

    public void PointerKey(MainCanvas mc_){
       super();
       int[][][] ointArray = new int[][][11];
       int[][] ointArray1 = new int[][2];
       int[] ointArray2 = new int[5];
       ointArray2[1] = Constants_H.HEIGHT - 50;
       ointArray2[2] = 50;
       ointArray2[3] = 50;
       ointArray2[4] = -6;
       ointArray1[0] = ointArray2;
       int[] ointArray3 = new int[]{Constants_H.WIDTH - 50,Constants_H.HEIGHT - 50,50,50,-7};
       ointArray1[1] = ointArray3;
       ointArray[0] = ointArray1;
       int[][] ointArray4 = new int[][1]{ointArray3};
       ointArray3 = new int[5];
       ointArray3[2] = Constants_H.WIDTH;
       ointArray3[3] = Constants_H.HEIGHT;
       ointArray3[4] = 48;
       ointArray[1] = ointArray4;
       ointArray4 = new int[][1]{ointArray3};
       ointArray3 = new int[5];
       ointArray3[2] = Constants_H.WIDTH;
       ointArray3[3] = Constants_H.HEIGHT;
       ointArray3[4] = 53;
       ointArray[2] = ointArray4;
       ointArray4 = new int[][3]{new int[5]{170,275,'j','a',-3},new int[5]{363,285,'l','S',-4},new int[5]{281,290,'L','X','5'}};
       ointArray[3] = ointArray4;
       ointArray1 = new int[][2];
       ointArray2 = new int[5];
       ointArray2[2] = 320;
       ointArray2[3] = 360;
       ointArray2[4] = -3;
       ointArray1[0] = ointArray2;
       ointArray3 = new int[5];
       ointArray3[0] = 320;
       ointArray3[2] = 320;
       ointArray3[3] = 360;
       ointArray3[4] = -4;
       ointArray1[1] = ointArray3;
       ointArray[4] = ointArray1;
       ointArray4 = new int[][5]{new int[5]{462,'*','S','H',9999},new int[5]{548,'t','S','G',9999},new int[5]{466,182,'U','K',9999},new int[5]{524,266,'[','D',9999},new int[5]{'0',277,'W','P',9999}};
       ointArray[5] = ointArray4;
       ointArray1 = new int[][7];
       ointArray2 = new int[]{Constants_H.WIDTH__ - 60,Constants_H.HEIGHT__ - 60,60,60,9999};
       ointArray1[0] = ointArray2;
       ointArray3 = new int[5];
       ointArray3[1] = Constants_H.HEIGHT__ - 60;
       ointArray3[2] = 60;
       ointArray3[3] = 60;
       ointArray3[4] = 9999;
       ointArray1[1] = ointArray3;
       ointArray3 = new int[]{Constants_H.WIDTH__ - 60,((Constants_H.HEIGHT__ - 60) - 120) - 40,60,60,9999};
       ointArray1[2] = ointArray3;
       ointArray3 = new int[]{Constants_H.WIDTH__ - 60,((Constants_H.HEIGHT__ - 60) - 60) - 20,60,60,9999};
       ointArray1[3] = ointArray3;
       ointArray3 = new int[]{((Constants_H.WIDTH__ - 60) - 120) - 40,Constants_H.HEIGHT__ - 60,60,60,9999};
       ointArray1[4] = ointArray3;
       ointArray3 = new int[]{((Constants_H.WIDTH__ - 60) - 60) - 20,Constants_H.HEIGHT__ - 60,60,60,9999};
       ointArray1[5] = ointArray3;
       ointArray2 = new int[]{Constants_H.WIDTH__ - 60,((Constants_H.HEIGHT__ - 60) - 180) - 60,60,60,9999};
       ointArray1[6] = ointArray2;
       ointArray[6] = ointArray1;
       ointArray1 = new int[][1]{ointArray2};
       ointArray2 = new int[]{Constants_H.WIDTH - 50,Constants_H.HEIGHT - 50,50,50,-7};
       ointArray[7] = ointArray1;
       ointArray1 = new int[][2]{ointArray2,new int[5]{590,310,'2','2',-7}};
       ointArray2 = new int[5];
       ointArray2[1] = 310;
       ointArray2[2] = 50;
       ointArray2[3] = 50;
       ointArray2[4] = -6;
       ointArray[8] = ointArray1;
       ointArray1 = new int[][1]{ointArray2};
       ointArray2 = new int[5];
       ointArray2[2] = 640;
       ointArray2[3] = 360;
       ointArray2[4] = 48;
       ointArray[9] = ointArray1;
       ointArray1 = new int[][7];
       ointArray2 = new int[]{Constants_H.WIDTH - 30,Constants_H.HEIGHT - 30,30,30,9999};
       ointArray1[0] = ointArray2;
       ointArray3 = new int[5];
       ointArray3[1] = Constants_H.HEIGHT - 30;
       ointArray3[2] = 30;
       ointArray3[3] = 30;
       ointArray3[4] = 9999;
       ointArray1[1] = ointArray3;
       ointArray3 = new int[]{Constants_H.WIDTH - 30,((Constants_H.HEIGHT - 30) - 90) - 25,30,30,9999};
       ointArray1[2] = ointArray3;
       ointArray3 = new int[]{Constants_H.WIDTH - 30,((Constants_H.HEIGHT - 30) - 45) - 15,30,30,9999};
       ointArray1[3] = ointArray3;
       ointArray3 = new int[]{((Constants_H.WIDTH - 30) - 90) - 40,Constants_H.HEIGHT - 30,30,30,9999};
       ointArray1[4] = ointArray3;
       ointArray3 = new int[]{((Constants_H.WIDTH - 30) - 45) - 20,Constants_H.HEIGHT - 30,30,30,9999};
       ointArray1[5] = ointArray3;
       ointArray2 = new int[]{Constants_H.WIDTH - 30,((Constants_H.HEIGHT - 30) - 135) - 35,30,30,9999};
       ointArray1[6] = ointArray2;
       ointArray[10] = ointArray1;
       this.button_pos = ointArray;
       this.i0 = -1;
       this.i1 = -1;
       this.mc = mc_;
       this.gr = this.mc.gr;
       this.map = this.gr.map;
    }
    private boolean isMove(int x,int y){
       int npcX;
       int npcY;
       boolean b;
       if (this.map.my.dir == 3) {
          npcX = this.map.my.x - 20;
          npcY = this.map.my.y - 60;
       }else if(this.map.my.dir == 4){
          npcX = this.map.my.x + 20;
          npcY = this.map.my.y - 60;
       }else if(this.map.my.dir == 1){
          npcX = this.map.my.x;
          npcY = this.map.my.y - 80;
       }else {
          npcX = this.map.my.x;
          npcY = this.map.my.y - 40;
       }
       if (Ms.i().isRect(x, y, 1, 1, npcX, npcY, 20, 80) || Ms.i().isRect(this.i0, this.i1, 1, 1, (Constants_H.WIDTH_H - 30), (Constants_H.HEIGHT - 60), 60, 60)) {
          npcX = this.map;
          if (this.map.checkSoftKey(this.map.my.x, this.map.my.y, (this.map.dir_select[this.map.my.dir][0] * this.map.my.speed), (this.map.dir_select[npcX.my.dir][1] * this.map.my.speed)) != -1) {
             b = false;
          label_00bd :
             return b;
          }
       }
       b = true;
       goto label_00bd ;
    }
    public int checkButton(int check_no){
       return this.checkButton(check_no, this.i0, this.i1);
    }
    public int checkButton(int check_no,int x,int y){
       int ix;
       int i = 0;
       while (true) {
          if (i >= this.button_pos[check_no].length) {
             ix = -1;
             break ;
          }else {
             int ix1 = x - 1;
             int ix2 = y - 1;
             if (Ms.i().isRect(ix1, ix2, 2, 2, this.button_pos[check_no][i][0], this.button_pos[check_no][i][1], this.button_pos[check_no][i][2], this.button_pos[check_no][i][3])) {
                Ms.key = this.button_pos[check_no][i][4];
                if (check_no == 3 && Ms.key == 53) {
                   Log.e("touch", "\x63\x02\x4e\x02\x78\x02\x5b\x02\x95\x02\x30\x02\x30\x02\x30\x02menu_state: "+this.mc.menu_state);
                }
                Ms.keyRepeat = true;
                this.initPointer();
                ix = i;
                break ;
             }else {
                i++;
             }
          }
       }
       return ix;
    }
    public void initPointer(){
       this.i1 = -1;
       this.i0 = -1;
       this.m1 = -1;
       this.m0 = -1;
    }
    public boolean isSelect(int x,int y,int w,int h){
       int i;
       if (Ms.i().isRect(this.i0, this.i1, 1, 1, x, y, w, h)) {
          this.initPointer();
          i = 1;
       }else {
          i = false;
       }
       return i;
    }
    public void process(int x,int y){
       if (this.map.my.state != 20 || this.checkButton(7, x, y) == -1) {
          if (GameRun.run_state != -10 || (this.map.my.state != null || this.map.my.state == 20)) {
             if (GameRun.run_state == -10) {
                if (this.map.my.state == 18 || (this.map.my.state == 17 && (this.checkButton(8, x, y) != -1 || (this.map.my.state != 18 || (this.map.my.state == 17 || this.checkButton(0, x, y) == -1))))) {
                label_001a :
                   return;
                }
             }else if(GameRun.run_state != -10 && this.checkButton(8, x, y) != -1){
                goto label_001a ;
             }
          }
          switch (this.mc.game_state){
              case 30:
                this.runKeySate(x, y);
                goto label_001a ;
                break;
              case 40:
                switch (this.mc.menu_state){
                    case 0:
                      if (this.mc.load_c == 1) {
                         this.i0 = x;
                         this.i1 = y;
                         this.checkButton(3, x, y);
                         goto label_001a ;
                      }else {
                         this.checkButton(9, x, y);
                         goto label_001a ;
                      }
                      break;
                    default:
                      goto label_001a ;
                }
                break;
              case 'b':
                this.checkButton(9, x, y);
                Log.d("soars", "checkButton");
                goto label_001a ;
                break;
              default:
                goto label_001a ;
          }
       }
    }
    public void runKeySate(int x,int y){
       switch (GameRun.run_state){
           case 0xffffffe1:
             if (this.gr.battle_state == 2) {
                if ((this.gr.cur_a = (byte)this.checkButton(5, x, y)) != -1) {
                   this.setKey5();
                }
             }else {
                this.i0 = x;
                this.i1 = y;
             }
             break;
           case 0xffffffec:
           case 18:
           case 25:
           case 35:
           case 61:
           case 'A':
           case 'B':
           case 'D':
           case 'a':
             this.i0 = x;
             this.i1 = y;
             break;
           case 0xfffffff6:
             this.i0 = x;
             this.i1 = y;
             if (this.map.my.state == 22) {
                if (this.gr.say_c < null) {
                   this.checkButton(2, x, y);
                }else {
                   this.checkButton(1, x, y);
                }
             }else if(this.map.my.state != 1 && this.map.my.state != 10){
                if (this.map.my.state == null) {
                   if (this.gr.say_c == -1) {
                      this.checkButton(2, x, y);
                   }else if(this.gr.say_s == null && (this.gr.say_c == null && this.isMove(((- this.map.map_x) + x), ((- this.map.map_y) + y)))){
                      this.setMove(x, y);
                   }
                   this.i0 = x;
                   this.i1 = y;
                }else if(this.map.my.state != 12 && (this.map.my.state != 18 && (this.map.my.state != 17 && (this.map.my.state != 16 && (this.map.my.state != 20 && this.map.my.state != 2))))){
                   this.i0 = x;
                   this.i1 = y;
                }
             }else {
                this.checkButton(2, x, y);
             }
             break;
           case 60:
           case 'b':
             this.checkButton(1, x, y);
             break;
           case 'E':
             this.i0 = x;
             this.i1 = y;
             break;
       }
       return;
    }
    public void runMove(){
       boolean bb;
       int i;
       if (GameRun.run_state == -10 && (this.map.my.state == null && this.m0 != -1)) {
          int x = this.m0 - this.map.my.x;
          int y = this.m1 - this.map.my.y;
          if (Ms.abs(x) < this.map.my.speed && Ms.abs(y) < this.map.my.speed) {
             this.stopMove();
          }else if(this.dir != null){
             bb = (Ms.abs(y) < this.map.my.speed)? true: 0;
          }else if(Ms.abs(x) >= this.map.my.speed){
             bb = 1;
          }else {
             bb = 0;
          }
          if (bb) {
             i = (x < 0)? -3: -4;
             Ms.key = i;
          }else if(y < 0){
             i = -1;
          }else {
             i = -2;
          }
          Ms.key = i;
          this.map.map_key = (byte)(- Ms.key);
          this.map.doKey();
       }
       return;
    }
    public void selectListSY(int len,int x,int y,int w,int kw,int kh,int dis,int sel){
       int i = 0;
       while (i < len) {
          int ix = kh + dis;
          ix = ix * i;
          int ix1 = y + ix;
          if (Ms.i().isRect(this.i0, this.i1, 1, 1, x, ix1, w, kh)) {
             this.gr.selecty = (byte)i;
             if (i == sel) {
                this.setKey5();
             }
             this.initPointer();
          }
          i++;
       }
       return;
    }
    public byte selectMenuX(int len,int x,int y,int w,int h){
       byte b;
       int i = 0;
       while (true) {
          if (i >= len) {
             b = -1;
             break ;
          }else {
             int ix = i * w;
             int ix1 = x + ix;
             if (Ms.i().isRect(this.i0, this.i1, 1, 1, ix1, y, w, h)) {
                this.initPointer();
                b = (byte)i;
                break ;
             }else {
                i++;
             }
          }
       }
       return b;
    }
    public void setKey5(){
       Ms.key = 53;
       Ms.keyRepeat = true;
    }
    public void setKeySoftkey1(){
       Ms.key = -6;
       Ms.keyRepeat = true;
    }
    public void setMove(int x,int y){
       this.m0 = (((- this.map.map_x) + x) / 20) * 20;
       this.m1 = (((- this.map.map_y) + y) / 20) * 20;
       boolean b = (Ms.abs((this.m0 - this.map.my.x)) < Ms.abs((this.m1 - this.map.my.y)))? true: false;
       this.dir = b;
       this.isGo = true;
       this.tempx = x;
       this.tempy = y;
       this.gox = (- this.map.map_x) + this.tempx;
       this.goy = (- this.map.map_y) + this.tempy;
       return;
    }
    public void stopMove(){
       Ms.i().keyRelease();
       this.initPointer();
       this.isGo = false;
    }
}
