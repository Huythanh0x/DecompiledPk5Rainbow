package dm.Ms;
import main.Key_H;
import java.util.Random;
import javax.microedition.lcdui.Font;
import java.lang.Object;
import java.lang.Runtime;
import java.lang.String;
import java.lang.Class;
import java.lang.System;
import javax.microedition.lcdui.Image;
import java.lang.StringBuilder;
import dm.Sprite;
import java.lang.StringBuffer;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import com.android.Util.AndroidUtil;
import java.lang.Exception;
import java.util.Vector;
import java.io.ByteArrayInputStream;
import javax.microedition.rms.RecordStore;
import android.util.Log;

public class Ms implements Key_H	// class@0000e1 from classes.dex
{
    final int RMSSIZE;
    private int sleep_time;
    private final byte[] transA;
    public static Font font;
    public static int key;
    public static boolean keyRepeat;
    public static byte key_delay;
    public static byte key_time;
    private static Ms msListener;
    private static Random random;
    private static RecordStore rms;
    public static int skip;
    public static int skip2;

    static {
       Ms.random = new Random();
       Ms.font = Font.getFont(0, 0, 26);
       Ms.key_delay = 0;
       Ms.key_time = 10;
    }
    public void Ms(){
       super();
       this.RMSSIZE = 0x3c00;
       byte[] uobyteArray = new byte[8];
       uobyteArray[1] = 6;
       uobyteArray[2] = 3;
       uobyteArray[3] = 5;
       uobyteArray[4] = 2;
       uobyteArray[5] = 7;
       uobyteArray[6] = 1;
       uobyteArray[7] = 4;
       this.transA = uobyteArray;
       Ms.msListener = this;
    }
    public static int abs(int a){
       int i = (a > 0)? a: - a;
       return i;
    }
    private boolean checkIsSimulate(){
       boolean b;
       if ((Runtime.getRuntime().totalMemory() - 0x7a1200) >= 0) {
          b = true;
       }else {
          try{
             Class.forName("emulator.Emulator");
             Class.forName("com.sprintpcs.util.System");
             b = true;
          }catch(java.lang.Exception e1){
             String platForm = System.getProperty("microedition.platform");
             b = (platForm.toLowerCase().indexOf("wtk") == -1 && (platForm.toLowerCase().indexOf("javasdk") == -1 && platForm.toLowerCase().indexOf("j2me") == -1))? false: true;
          }
       }
       return b;
    }
    public static int compare_min(int c0,int c1){
       int i = (c0 <= c1)? c0: c1;
       return i;
    }
    public static long getNum(byte[] b){
       int ix;
       int ix1;
       int rtn = 0;
       int len = b.length;
       int i = 0;
       while (i < len) {
          switch (len){
              case 1:
                ix = b[i] & 0x00ff;
                ix1 = i * 8;
                ix = ix << ix1;
                rtn = rtn + (byte)ix;
                break;
              case 2:
                ix = b[i] & 0x00ff;
                ix1 = i * 8;
                ix = ix << ix1;
                rtn = rtn + (short)ix;
                break;
              case 3:
              case 5:
              case 6:
              case 7:
                break;
              case 4:
                ix = b[i] & 0x00ff;
                ix1 = i * 8;
                ix = ix << ix1;
                rtn = rtn + ix;
                break;
              case 8:
                int ix2 = b[i] & 0x00ff;
                int ix3 = i * 8;
                ix2 = ix2 << ix3;
                long l = (long)rtn + (long)ix2;
                rtn = (int)l;
                break;
          }
          i++;
       }
       return (long)rtn;
    }
    public static int getRandom(int ss){
       return ((Ms.random.nextInt() & Integer.MAX_VALUE) % ss);
    }
    private short getStreamL(byte[] data,int mode){
       short skip;
       int skip1;
       if (!mode) {
          skip = Ms.skip;
          Ms.skip = skip + 1;
          skip = data[skip];
       }else if(mode == 1){
          skip = Ms.skip;
          Ms.skip = skip + 1;
          skip = (short)(data[skip] + 100);
       }else if(mode == 2){
          skip = Ms.skip;
          Ms.skip = skip + 1;
          skip1 = Ms.skip;
          Ms.skip = skip1 + 1;
          skip = (short)(((data[skip] & 0x00ff) << 8) | (data[skip1] & 0x00ff));
       }else {
          skip = Ms.skip;
          Ms.skip = skip + 1;
          skip1 = Ms.skip;
          Ms.skip = skip1 + 1;
          skip = (short)((data[skip] & 0x00ff) | ((data[skip1] & 0x00ff) << 8));
       }
       return skip;
    }
    public static Ms i(){
       if (Ms.msListener == null) {
          Ms.msListener = new Ms();
       }
       return Ms.msListener;
    }
    public short[] byteArrayToShortArray(byte[] bytebuf){
       Ms.skip = 0;
       int len = bytebuf.length >> 1;
       short[] shortbuf = new short[len];
       for (int i = 0; i < len; i++) {
          shortbuf[i] = this.getStreamL(bytebuf, 2);
       }
       return shortbuf;
    }
    public void correctSelect(byte[] select,int max,int showLine){
       if (select[0] < max) {
          select[1] = (byte)((select[0] - showLine) + 1);
       }else {
          select[0] = (byte)(max - 1);
          select[1] = (byte)(max - showLine);
       }
       if (select[0] < 0) {
          select[0] = 0;
       }
       if (select[1] < 0) {
          select[1] = 0;
       }
       return;
    }
    public byte[][] create2Array(byte[] data){
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       byte[][] array = new byte[][this.getLen_byte(data[skip])];
       for (int i = 0; i < array.length; i++) {
          array[i] = this.createArray(data);
       }
       return array;
    }
    public byte[][][] create3Array(byte[] data){
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       byte[][][] array = new byte[][][this.getLen_byte(data[skip])];
       for (int i = 0; i < array.length; i++) {
          array[i] = this.create2Array(data);
       }
       return array;
    }
    public byte[][][][] create4Array(byte[] data){
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       byte[][][][] array = new byte[][][][this.getLen_byte(data[skip])];
       for (int i = 0; i < array.length; i++) {
          array[i] = this.create3Array(data);
       }
       return array;
    }
    public byte[] createArray(byte[] data){
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       byte[] array = new byte[this.getLen_byte(data[skip])];
       for (int j = 0; j < array.length; j++) {
          skip = Ms.skip;
          int i = skip + 1;
          Ms.skip = i;
          array[j] = data[skip];
       }
       return array;
    }
    Image createCellImage(Image image,int cell_index,int cell_width,int cell_height,int trans){
       int temp_cell_x = (cell_index % (image.getWidth() / cell_width)) * cell_width;
       int temp_cell_y = (cell_index % (image.getHeight() / cell_height)) * cell_height;
       return this.createImage(image, temp_cell_x, temp_cell_y, cell_width, cell_height, trans);
    }
    public Image createImage(String imageName){
       Image image;
       try{
          image = Image.createImage("/"+imageName+".png");
       }catch(java.lang.Exception e1){
          Exception ex = e1;
          image = null;
       }
       return image;
    }
    public Image createImage(String name,int no){
       byte[] data = this.getStream(name, no);
       return Image.createImage(data, 0, data.length);
    }
    Image createImage(Image image,int x,int y,int width,int height,int trans){
       if (((x + width)) > image.getWidth()) {
          width = image.getWidth() - x;
       }
       if (((y + height)) > image.getHeight()) {
          height = image.getHeight() - y;
       }
       return Image.createImage(image, x, y, width, height, this.transA[trans]);
    }
    public Image[] createImageArray(int len,String name){
       Image[] img = new Image[len];
       short i = 0;
       while (i < img.length) {
          img[i] = this.createImage(String.valueOf(name).append(i).toString());
          int ix = i + 1;
          i = (short)ix;
       }
       return img;
    }
    public Image[] createImageArray_(int len,String name,int a){
       Image[] img = new Image[len];
       short i = 0;
       while (i < img.length) {
          img[i] = this.createImage_(String.valueOf(name).append(i).toString(), a);
          int ix = i + 1;
          i = (short)ix;
       }
       return img;
    }
    public Image createImage_(String imageName,int a){
       Image image;
       try{
          image = Image.createImage("/"+imageName+".png", a);
       }catch(java.lang.Exception e1){
          Exception ex = e1;
          image = null;
       }
       return image;
    }
    public int[] createIntArray(byte[] data){
       int[] array = new int[this.getStreamL(data, 0)];
       for (int i = 0; i < array.length; i++) {
          int skip = Ms.skip;
          int ix = skip + 1;
          Ms.skip = ix;
          skip = data[skip] & 0x00ff;
          ix = Ms.skip;
          int ix1 = ix + 1;
          Ms.skip = ix1;
          ix = data[ix] & 0x00ff;
          ix = ix << 8;
          skip = skip | ix;
          ix = Ms.skip;
          ix1 = ix + 1;
          Ms.skip = ix1;
          ix = data[ix] & 0x00ff;
          ix = ix << 16;
          skip = skip | ix;
          ix = Ms.skip;
          ix1 = ix + 1;
          Ms.skip = ix1;
          ix = data[ix] & 0x00ff;
          ix = ix << 24;
          skip = skip | ix;
          array[i] = skip;
       }
       return array;
    }
    public short[][] createShort2Array(byte[] data,int mode){
       short[][] array = new short[][this.getStreamL(data, mode)];
       for (int i = 0; i < array.length; i++) {
          array[i] = this.createShortArray(data, mode);
       }
       return array;
    }
    public short[][][] createShort3Array(byte[] data,int mode){
       short[][][] array = new short[][][this.getStreamL(data, mode)];
       for (int i = 0; i < array.length; i++) {
          array[i] = this.createShort2Array(data, mode);
       }
       return array;
    }
    public short[] createShortArray(byte[] data,int mode){
       short[] array = new short[this.getStreamL(data, mode)];
       for (int j = 0; j < array.length; j++) {
          int i = (mode == 2)? 2: -1;
          array[j] = this.getStreamL(data, i);
       }
       return array;
    }
    public Sprite createSprite(String name,boolean mode){
       int i = 2;
       byte[] date = this.getStream(String.valueOf(name)+".data", -1);
       Ms.skip = 0;
       Sprite sprite = (mode)? Sprite.Create(this.createImage(name), this.create2Array(date), this.create3Array(date), this.create3Array(date)): Sprite.Create(this.createImage(name), this.createShort2Array(date, i), this.createShort3Array(date, i), this.createShort3Array(date, i));
       return sprite;
    }
    public StringBuffer[][] createString2Array(byte[] dataa){
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       byte len = dataa[skip];
       StringBuffer[][] string = new StringBuffer[][len];
       byte i = 0;
       while (i < string.length) {
          string[i] = this.createStringArray(dataa);
          skip = i + 1;
          i = (byte)skip;
       }
       return string;
    }
    public StringBuffer[] createStringArray(byte[] data){
       short l_c;
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       StringBuffer[] string = new StringBuffer[this.getLen_byte(data[skip])];
       byte i = 0;
       while (i < string.length) {
          if ((l_c = data[Ms.skip]) < 0) {
             skip = l_c + 256;
             l_c = (short)skip;
          }
          int ix = Ms.skip + 1;
          string[i] = this.getDialogs(data, ix, l_c);
          ix = l_c * 2;
          ix = ix + 1;
          skip = Ms.skip + ix;
          Ms.skip = skip;
          skip = i + 1;
          i = (byte)skip;
       }
       return string;
    }
    public StringBuffer createStringArrayOne(byte[] data){
       return this.getDialogs(data, 2, this.getLen_byte(data[1]));
    }
    public boolean equals(StringBuffer sbuff,String str){
       return sbuff.equals(str);
    }
    public String getDialogs(byte[] data,int start,int len){
       StringBuffer dialog = "";
       for (int i = 0; i < len; i++) {
          int ix = i << 1;
          ix = ix + start;
          ix = data[ix] << 8;
          int ix1 = i << 1;
          ix1 = ix1 + start;
          ix1 = ix1 + 1;
          ix1 = data[ix1] & 0x00ff;
          ix = ix | ix1;
          dialog = dialog.append((char)ix);
       }
       return dialog;
    }
    public byte[] getEventNowData(short[][] event_now){
       ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
       byteArray.write(event_now.length);
       int i = 0;
       while (i < event_now.length) {
          if (event_now[i] == null) {
             byteArray.write(0);
          }else {
             byteArray.write(event_now[i].length);
             for (int j = 0; j < event_now[i].length; j++) {
                int ix = event_now[i][j] & 0x00ff;
                byteArray.write(ix);
                ix = event_now[i][j] >> 8;
                ix = ix & 0x00ff;
                byteArray.write(ix);
             }
          }
          i++;
       }
       return byteArray.toByteArray();
    }
    public int getInt(byte[] buf,int i){
       return (((((buf[i] & 0x00ff) << 24) | ((buf[(i + 1)] & 0x00ff) << 16)) | ((buf[(i + 2)] & 0x00ff) << 8)) | (buf[(i + 3)] & 0x00ff));
    }
    public int getLen_byte(byte value){
       int i = (value < 0)? value + 256: value;
       return i;
    }
    public int getLen_short(short value){
       int i = (value < 0)? 0x10000 + value: value;
       return i;
    }
    public byte getMin(byte i0,byte i1){
       byte b = (i0 > i1)? i1: i0;
       return b;
    }
    public String getPrecision(int t){
       return String.valueOf((t / 10))+"."+(t % 10);
    }
    public short getShort(byte[] buf,int i){
       return (short)(((buf[i] & 0x00ff) << 8) | (buf[(i + 1)] & 0x00ff));
    }
    public int getSleep(){
       return this.sleep_time;
    }
    public byte[] getStream(String i,int num){
       try{
          DataInputStream dataInput = new DataInputStream(AndroidUtil.getResourceAsStream("/"+i));
          if (num > -1) {
             dataInput.readByte();
             byte n = 0;
             while (n < num) {
                dataInput.skip((long)this.getLen_short(dataInput.readShort()));
                int ix = n + 1;
                n = (byte)ix;
             }
          }
          byte[] data = new byte[this.getLen_short(dataInput.readShort())];
          dataInput.read(data);
          dataInput.close();
          dataInput = null;
       }catch(java.lang.Exception e4){
          Exception ex = e4;
          ex.printStackTrace();
       }
       return 0;
    }
    public int getStringWidth(String str){
       return Ms.font.stringWidth(str);
    }
    public StringBuffer[] groupString(String info,int width){
       int ix;
       StringBuffer[] tempResult = new StringBuffer[30];
       StringBuffer temp = "";
       StringBuffer orig = info;
       short infoLength = (short)info.length();
       byte tc = 0;
       byte tw = (byte)this.getStringWidth("#0");
       byte rows = -1;
       boolean isNewRow = false;
       String tcolor = "";
       int i = 0;
       while (i < infoLength) {
          if (orig.charAt(0) == '#') {
             if (orig.charAt(1) == 'n') {
                isNewRow = true;
             }else {
                tcolor = "#".append(orig.charAt(1)).toString();
                temp = temp.append(tcolor);
                ix = tc + 1;
                tc = (byte)ix;
             }
             orig.deleteCharAt(0);
             orig.deleteCharAt(0);
             i++;
          }else {
             temp = temp.append(orig.charAt(0));
             if (width) {
                int ix1 = tw * tc;
                ix1 = ix1 + width;
                if (this.getStringWidth(temp.toString()) <= ix1) {
                   orig.deleteCharAt(0);
                }else if(width){
                   i--;
                   ix = temp.length() - 1;
                   temp.deleteCharAt(ix);
                   isNewRow = true;
                }else {
                   orig.deleteCharAt(0);
                }
             }else {
             }
             ix = infoLength - 1;
             if (i == ix && !isNewRow) {
                isNewRow = true;
             }
          }
          if (isNewRow) {
             ix = rows + 1;
             rows = (byte)ix;
             ix = (!tcolor.length())? 0: 1;
             tc = (byte)ix;
             isNewRow = false;
             tempResult[rows] = temp;
             temp = null;
             temp = "";
             temp = temp.append(tcolor);
          }
          i++;
       }
       StringBuffer[] result = new StringBuffer[(rows + 1)];
       System.arraycopy(tempResult, 0, result, 0, (rows + 1));
       tempResult = null;
       orig = null;
       temp = orig;
       tcolor = null;
       return result;
    }
    public boolean isRect(int a0,int a1,int aw,int ah,int b0,int b1,int bw,int bh){
       boolean b = (a0 < (b0 + bw) && (((a0 + aw)) > b0 && (a1 < (b1 + bh) && ((a1 + ah)) > b1)))? true: false;
       return b;
    }
    public void keyRelease(){
       Ms.keyRepeat = false;
       Ms.key_delay = false;
       Ms.key_time = 10;
    }
    public boolean key_Down(){
       boolean b = (Ms.key == -2)? true: false;
       return b;
    }
    public boolean key_Left(){
       boolean b = (Ms.key == -3)? true: false;
       return b;
    }
    public boolean key_Left_Right(){
       boolean b = (Ms.key != -3 && Ms.key != -4)? false: true;
       return b;
    }
    public boolean key_Num0(){
       boolean b = (Ms.key == 48)? true: false;
       return b;
    }
    public boolean key_Num1(){
       boolean b = (Ms.key == 49)? true: false;
       return b;
    }
    public boolean key_Num3(){
       boolean b = (Ms.key == 51)? true: false;
       return b;
    }
    public boolean key_Num9(){
       boolean b = (Ms.key == 57)? true: false;
       return b;
    }
    public boolean key_Right(){
       boolean b = (Ms.key == -4)? true: false;
       return b;
    }
    public boolean key_S1(){
       boolean b = (Ms.key == -6)? true: false;
       return b;
    }
    public boolean key_S1_Num5(){
       boolean b = (Ms.key != -6 && (Ms.key != 53 && Ms.key != -5))? false: true;
       return b;
    }
    public boolean key_S2(){
       boolean b = (Ms.key == -7)? true: false;
       return b;
    }
    public boolean key_Up(){
       boolean b = (Ms.key == -1)? true: false;
       return b;
    }
    public boolean key_Up_Down(){
       boolean b = (Ms.key != -1 && Ms.key != -2)? false: true;
       return b;
    }
    public boolean key_delay(){
       boolean b;
       if (!Ms.key_delay) {
          Ms.key_delay = Ms.key_time;
          if (Ms.key_time > 1) {
             Ms.key_time = (byte)(Ms.key_time - 1);
          }
          b = false;
       }else {
          b = 1;
       }
       return b;
    }
    public String[] loadText(byte[] word_uni){
       String[] stringArray;
       int k;
       int l;
       try{
          StringBuffer stringbuffer = "";
          int j = 2;
          j = j;
          while (j < word_uni.length) {
             j = j + 1;
             if ((k = word_uni[j]) < 0) {
                k = k + 256;
             }
             j = j + 1;
             if ((l = word_uni[j]) < 0) {
                l = l + 256;
             }
             int i = l << 8;
             i = i + k;
             char c = (char)i;
             stringbuffer = stringbuffer.append(c);
          }
          String strReturn = stringbuffer;
          stringbuffer = null;
          Vector vecString = new Vector();
          k = 0;
          l = 0;
          for (j = 0; j < strReturn.length(); j++) {
             if (strReturn.charAt(j) == 10 || j == strReturn.length()) {
                String temp = strReturn.substring(k, l);
                vecString.addElement(temp);
                k = l + 1;
             }
             l++;
          }
          strReturn = null;
          String[] reStr = new String[vecString.size()];
          for (j = 0; j < vecString.size(); j++) {
             reStr[j] = vecString.elementAt(j);
          }
          vecString = null;
          stringArray = reStr;
       }catch(java.lang.Exception e12){
          Exception e = e12;
          e.printStackTrace();
          stringArray = null;
       }
       return stringArray;
    }
    public short mathPercent(int m0,int m1,int per){
       if (per < 1) {
          per = 1;
       }
       return (short)((m0 * m1) / per);
    }
    public short mathSpeedDown(int volue,int num,boolean bb){
       if ((volue / num)) {
          volue = volue - (volue / num);
       }else if(bb && volue > 0){
          volue--;
       }else if(bb && volue < 0){
          volue++;
       }else {
          volue = 0;
       }
       return (short)volue;
    }
    public short mathSpeedN(int volue,int maxv,int speed,boolean bb){
       if (volue > maxv && ((volue - speed)) > maxv) {
          volue = volue - speed;
       }else if(volue < maxv && ((volue + speed)) < maxv){
          volue = volue + speed;
       }else if(bb && volue > maxv){
          volue--;
       }else if(bb && volue < maxv){
          volue++;
       }else {
          volue = maxv;
       }
       return (short)volue;
    }
    public short mathSpeedUp(int volue,int max,int speed){
       int i = ((volue = volue - ((max - volue) / speed)) < 0)? 0: volue;
       return (short)i;
    }
    public void putInt(int value,byte[] buf,int i){
       buf[i] = (byte)((value >> 24) & 0x00ff);
       buf[(i + 1)] = (byte)((value >> 16) & 0x00ff);
       buf[(i + 2)] = (byte)((value >> 8) & 0x00ff);
       buf[(i + 3)] = (byte)(value & 0x00ff);
    }
    public void putShort(int value,byte[] buf,int i){
       buf[i] = (byte)((value >> 8) & 0x00ff);
       buf[(i + 1)] = (byte)(value & 0x00ff);
    }
    public void putShort(byte[] buf,int value){
       int skip = Ms.skip;
       Ms.skip = skip + 1;
       buf[skip] = (byte)((value >> 8) & 0x00ff);
       skip = Ms.skip;
       Ms.skip = skip + 1;
       buf[skip] = (byte)((value >> 0) & 0x00ff);
    }
    public short[][] readEventNowData(){
       int nn;
       short[][] event_now = null;
       ByteArrayInputStream byteArray = new ByteArrayInputStream(this.rmsOptions(12, null, 1));
       event_now = new short[][byteArray.read()];
       int i = 0;
       while (i < event_now.length) {
          if (nn = byteArray.read()) {
             short[] oshortArray = new short[nn];
             event_now[i] = oshortArray;
             for (int j = 0; j < event_now[i].length; j++) {
                int ix = byteArray.read() << 8;
                int ix1 = byteArray.read() | ix;
                event_now[i][j] = (short)ix1;
             }
          }
          i++;
       }
       return event_now;
    }
    public byte[] rmsOptions(int recordId,byte[] info,int flag){
       byte[] uobyteArray;
       int i = 1;
       try{
          if (Ms.rms == null) {
             Ms.rms = RecordStore.openRecordStore("pk5_caihong", true);
          label_000f :
             if (!Ms.rms.getNumRecords()) {
                this.setRmsInit(true);
             }
             if (flag) {
                if (flag == i) {
                   info = Ms.rms.getRecord(recordId);
                   uobyteArray = info;
                label_0026 :
                   return uobyteArray;
                }else if(flag == 2){
                   Ms.rms.setRecord(recordId, info, 0, info.length);
                }else if(flag == 3){
                   this.setRmsInit(false);
                }else if(flag == 4){
                   if (Ms.rms != null) {
                      Ms.rms.closeRecordStore();
                      Ms.rms = null;
                   }
                }else if(flag == 5){
                   Log.e("rms.getSizeAvailable\(\) = ", Ms.rms.getSizeAvailable());
                   uobyteArray = null;
                   goto label_0026 ;
                }
             }
          }else {
             goto label_000f ;
          }
       }catch(java.lang.Exception e1){
          Exception e = e1;
          e.printStackTrace();
       }
       uobyteArray = null;
       goto label_0026 ;
    }
    public void runDelay(){
       if (Ms.key_delay > 0) {
          Ms.key_delay = (byte)(Ms.key_delay - 1);
       }
       return;
    }
    public byte select(int select,int min,int max){
       byte b;
       if (!max) {
          b = (byte)select;
       }else if(((Ms.abs(Ms.key) % 2)) == 1 && (select--) < min){
          select = max;
       }else if(!((Ms.abs(Ms.key) % 2)) && (select++) > max){
          select = min;
       }
       b = (byte)select;
       return b;
    }
    public void selectS(byte[] select,int min,int max,int showLine){
       if (max) {
          select[0] = this.select(select[0], min, (max - 1));
          if (((select[1] - 1)) == select[0]) {
             select[1] = (byte)(select[1] - 1);
          }else if(((select[1] + showLine)) == select[0]){
             select[1] = (byte)(select[1] + 1);
          }else if(select[0] == (max - 1)){
             int i = (((max - min)) < showLine)? min: max - showLine;
             select[1] = (byte)i;
          }else if(select[0] == min){
             select[1] = (byte)min;
          }
       }
       return;
    }
    public void setRmsInit(boolean mode){
       int ix;
       byte[] info = new byte[140];
       info[0] = -1;
       byte[] aaa = new byte[280];
       int i = 0;
       while (i < 83) {
          if (mode || i != 4) {
             if (i != 12) {
                if (mode) {
                   Ms.rms.addRecord(info, 0, info.length);
                }else {
                   ix = i + 1;
                   Ms.rms.setRecord(ix, info, 0, info.length);
                }
             }else if(mode){
                Ms.rms.addRecord(aaa, 0, aaa.length);
             }else {
                ix = i + 1;
                Ms.rms.setRecord(ix, aaa, 0, aaa.length);
             }
          }
          i++;
       }
       info = null;
       return;
    }
    public void setSprite(Sprite sp,String name,boolean mode){
       int i = 2;
       byte[] date = this.getStream(String.valueOf(name)+".data", -1);
       Ms.skip = 0;
       sp.nullIMFA();
       if (mode) {
          sp.Set(this.createImage(name), this.create2Array(date), this.create3Array(date), this.create3Array(date));
       }else {
          sp.Set(this.createImage(name), this.createShort2Array(date, i), this.createShort3Array(date, i), this.createShort3Array(date, i));
       }
       date = null;
       return;
    }
    public byte[] shortArrayToByteArray(short[] shortbuf){
       Ms.skip = 0;
       int len = shortbuf.length;
       byte[] bytebuf = new byte[(len << 1)];
       for (int i = 0; i < len; i++) {
          this.putShort(bytebuf, shortbuf[i]);
       }
       return bytebuf;
    }
    public void sleep(int time){
       this.sleep_time = time;
    }
    public int sqrt(int x){
       int y;
       int i;
       if (x > 0) {
          x = x * 10000;
          int b = 0x2710;
          do {
             y = b;
             i = x / b;
             i = i + b;
          } while ((b = i >> 1) >= y);
          y = y / 100;
          i = y;
       }else {
          i = 0;
       }
       return i;
    }
}
