package dm;

import android.util.Log;
import com.android.Util.AndroidUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import main.Key_H;

public class Ms implements Key_H {
    final int RMSSIZE;
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
    private int sleep_time;
    private final byte[] transA;

    static {
        Ms.random = new Random();
        Ms.font = Font.getFont(0, 0, 26);
        Ms.key_delay = 0;
        Ms.key_time = 10;
    }

    public Ms() {
        this.RMSSIZE = 0x3C00;
        this.transA = new byte[]{0, 6, 3, 5, 2, 7, 1, 4};
        Ms.msListener = this;
    }

    public static int abs(int a) {
        return a <= 0 ? -a : a;
    }

    public short[] byteArrayToShortArray(byte[] bytebuf) {
        Ms.skip = 0;
        int len = bytebuf.length >> 1;
        short[] shortbuf = new short[len];
        for(int i = 0; i < len; ++i) {
            shortbuf[i] = this.getStreamL(bytebuf, 2);
        }
        return shortbuf;
    }

    private boolean checkIsSimulate() {
        if(Runtime.getRuntime().totalMemory() >= 8000000L) {
            return true;
        }
        try {
            Class.forName("emulator.Emulator");
            Class.forName("com.sprintpcs.util.System");
            return true;
        }
        catch(Exception unused_ex) {
            String s = System.getProperty("microedition.platform");
            return s.toLowerCase().indexOf("wtk") != -1 || s.toLowerCase().indexOf("javasdk") != -1 || s.toLowerCase().indexOf("j2me") != -1;
        }
    }

    public static int compare_min(int c0, int c1) {
        return c0 > c1 ? c1 : c0;
    }

    public void correctSelect(byte[] select, int max, int showLine) {
        if(select[0] < max) {
            select[1] = (byte)(select[0] - showLine + 1);
        }
        else {
            select[0] = (byte)(max - 1);
            select[1] = (byte)(max - showLine);
        }
        if(select[0] < 0) {
            select[0] = 0;
        }
        if(select[1] < 0) {
            select[1] = 0;
        }
    }

    public byte[][] create2Array(byte[] data) {
        int v = Ms.skip;
        Ms.skip = v + 1;
        byte[][] array = new byte[this.getLen_byte(data[v])][];
        for(int i = 0; i < array.length; ++i) {
            array[i] = this.createArray(data);
        }
        return array;
    }

    public byte[][][] create3Array(byte[] data) {
        int v = Ms.skip;
        Ms.skip = v + 1;
        byte[][][] array = new byte[this.getLen_byte(data[v])][][];
        for(int i = 0; i < array.length; ++i) {
            array[i] = this.create2Array(data);
        }
        return array;
    }

    public byte[][][][] create4Array(byte[] data) {
        int v = Ms.skip;
        Ms.skip = v + 1;
        byte[][][][] array = new byte[this.getLen_byte(data[v])][][][];
        for(int i = 0; i < array.length; ++i) {
            array[i] = this.create3Array(data);
        }
        return array;
    }

    public byte[] createArray(byte[] data) {
        int v = Ms.skip;
        Ms.skip = v + 1;
        byte[] array = new byte[this.getLen_byte(data[v])];
        for(int j = 0; j < array.length; ++j) {
            int v2 = Ms.skip;
            Ms.skip = v2 + 1;
            array[j] = data[v2];
        }
        return array;
    }

    Image createCellImage(Image image, int cell_index, int cell_width, int cell_height, int trans) {
        return this.createImage(image, cell_index % (image.getWidth() / cell_width) * cell_width, cell_index % (image.getHeight() / cell_height) * cell_height, cell_width, cell_height, trans);
    }

    public Image createImage(String imageName) {
        try {
            return Image.createImage(("/" + imageName + ".png"));
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    public Image createImage(String name, int no) {
        byte[] arr_b = this.getStream(name, no);
        return Image.createImage(arr_b, 0, arr_b.length);
    }

    Image createImage(Image image, int x, int y, int width, int height, int trans) {
        if(x + width > image.getWidth()) {
            width = image.getWidth() - x;
        }
        if(y + height > image.getHeight()) {
            height = image.getHeight() - y;
        }
        return Image.createImage(image, x, y, width, height, ((int)this.transA[trans]));
    }

    public Image[] createImageArray(int len, String name) {
        Image[] img = new Image[len];
        for(int i = 0; i < img.length; i = (short)(i + 1)) {
            img[i] = this.createImage(String.valueOf(name) + i);
        }
        return img;
    }

    public Image[] createImageArray_(int len, String name, int a) {
        Image[] img = new Image[len];
        for(int i = 0; i < img.length; i = (short)(i + 1)) {
            img[i] = this.createImage_(String.valueOf(name) + i, a);
        }
        return img;
    }

    public Image createImage_(String imageName, int a) {
        try {
            return Image.createImage(("/" + imageName + ".png"), a);
        }
        catch(Exception unused_ex) {
            return null;
        }
    }

    public int[] createIntArray(byte[] data) {
        int[] array = new int[this.getStreamL(data, 0)];
        for(int i = 0; i < array.length; ++i) {
            int v1 = Ms.skip;
            Ms.skip = v1 + 1;
            int v2 = Ms.skip;
            Ms.skip = v2 + 1;
            int v3 = Ms.skip;
            Ms.skip = v3 + 1;
            int v4 = Ms.skip;
            Ms.skip = v4 + 1;
            array[i] = data[v1] & 0xFF | (data[v2] & 0xFF) << 8 | (data[v3] & 0xFF) << 16 | (data[v4] & 0xFF) << 24;
        }
        return array;
    }

    public short[][] createShort2Array(byte[] data, int mode) {
        short[][] array = new short[this.getStreamL(data, mode)][];
        for(int i = 0; i < array.length; ++i) {
            array[i] = this.createShortArray(data, mode);
        }
        return array;
    }

    public short[][][] createShort3Array(byte[] data, int mode) {
        short[][][] array = new short[this.getStreamL(data, mode)][][];
        for(int i = 0; i < array.length; ++i) {
            array[i] = this.createShort2Array(data, mode);
        }
        return array;
    }

    public short[] createShortArray(byte[] data, int mode) {
        short[] array = new short[this.getStreamL(data, mode)];
        for(int j = 0; j < array.length; ++j) {
            array[j] = this.getStreamL(data, (mode == 2 ? 2 : -1));
        }
        return array;
    }

    public Sprite createSprite(String name, boolean mode) {
        byte[] arr_b = this.getStream(name + ".data", -1);
        Ms.skip = 0;
        return mode ? Sprite.Create(this.createImage(name), this.create2Array(arr_b), this.create3Array(arr_b), this.create3Array(arr_b)) : Sprite.Create(this.createImage(name), this.createShort2Array(arr_b, 2), this.createShort3Array(arr_b, 2), this.createShort3Array(arr_b, 2));
    }

    public StringBuffer[][] createString2Array(byte[] dataa) {
        int v = Ms.skip;
        Ms.skip = v + 1;
        StringBuffer[][] string = new StringBuffer[dataa[v]][];
        for(int i = 0; i < string.length; i = (byte)(i + 1)) {
            string[i] = this.createStringArray(dataa);
        }
        return string;
    }

    public StringBuffer[] createStringArray(byte[] data) {
        int v = Ms.skip;
        Ms.skip = v + 1;
        StringBuffer[] string = new StringBuffer[this.getLen_byte(data[v])];
        for(int i = 0; i < string.length; i = (byte)(i + 1)) {
            int l_c = data[Ms.skip];
            if(l_c < 0) {
                l_c = (short)(l_c + 0x100);
            }
            string[i] = new StringBuffer(this.getDialogs(data, Ms.skip + 1, l_c));
            Ms.skip += l_c * 2 + 1;
        }
        return string;
    }

    public StringBuffer createStringArrayOne(byte[] data) {
        return new StringBuffer(this.getDialogs(data, 2, this.getLen_byte(data[1])));
    }

    public boolean equals(StringBuffer sbuff, String str) {
        return sbuff.toString().equals(str);
    }

    public String getDialogs(byte[] data, int start, int len) {
        StringBuffer dialog = new StringBuffer();
        for(int i = 0; i < len; ++i) {
            dialog.append(((char)(data[(i << 1) + start] << 8 | data[(i << 1) + start + 1] & 0xFF)));
        }
        return dialog.toString();
    }

    public byte[] getEventNowData(short[][] event_now) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        byteArray.write(event_now.length);
        for(int i = 0; i < event_now.length; ++i) {
            if(event_now[i] == null) {
                byteArray.write(0);
            }
            else {
                byteArray.write(event_now[i].length);
                for(int j = 0; j < event_now[i].length; ++j) {
                    byteArray.write(event_now[i][j] & 0xFF);
                    byteArray.write(event_now[i][j] >> 8 & 0xFF);
                }
            }
        }
        return byteArray.toByteArray();
    }

    public int getInt(byte[] buf, int i) {
        return (buf[i] & 0xFF) << 24 | (buf[i + 1] & 0xFF) << 16 | (buf[i + 2] & 0xFF) << 8 | buf[i + 3] & 0xFF;
    }

    public int getLen_byte(byte value) {
        return value < 0 ? value + 0x100 : value;
    }

    public int getLen_short(short value) {
        return value < 0 ? 0x10000 + value : value;
    }

    public byte getMin(byte i0, byte i1) {
        return i0 <= i1 ? i0 : i1;
    }

    public static long getNum(byte[] b) {
        int rtn = 0;
        for(int i = 0; i < b.length; ++i) {
            switch(b.length) {
                case 1: {
                    rtn += (byte)((b[i] & 0xFF) << i * 8);
                    break;
                }
                case 2: {
                    rtn += (short)((b[i] & 0xFF) << i * 8);
                    break;
                }
                case 4: {
                    rtn += (b[i] & 0xFF) << i * 8;
                    break;
                }
                case 8: {
                    rtn = (int)(((long)rtn) + ((long)((b[i] & 0xFF) << i * 8)));
                }
            }
        }
        return (long)rtn;
    }

    public String getPrecision(int t) {
        return t / 10 + "." + t % 10;
    }

    public static int getRandom(int ss) {
        return (Ms.random.nextInt() & 0x7FFFFFFF) % ss;
    }

    public short getShort(byte[] buf, int i) {
        return (short)((buf[i] & 0xFF) << 8 | buf[i + 1] & 0xFF);
    }

    public int getSleep() {
        return this.sleep_time;
    }

    public byte[] getStream(String i, int num) {
        byte[] data = null;
        try {
            DataInputStream dataInput = new DataInputStream(AndroidUtil.getResourceAsStream(("/" + i)));
            if(num > -1) {
                dataInput.readByte();
                for(int n = 0; n < num; n = (byte)(n + 1)) {
                    dataInput.skip(((long)this.getLen_short(dataInput.readShort())));
                }
            }
            data = new byte[this.getLen_short(dataInput.readShort())];
            dataInput.read(data);
            dataInput.close();
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        return data;
    }

    private short getStreamL(byte[] data, int mode) {
        if(mode == 0) {
            int v1 = Ms.skip;
            Ms.skip = v1 + 1;
            return data[v1];
        }
        switch(mode) {
            case 1: {
                int v4 = Ms.skip;
                Ms.skip = v4 + 1;
                return (short)(data[v4] + 100);
            }
            case 2: {
                int v5 = Ms.skip;
                Ms.skip = v5 + 1;
                int v6 = Ms.skip;
                Ms.skip = v6 + 1;
                return (short)((data[v5] & 0xFF) << 8 | data[v6] & 0xFF);
            }
            default: {
                int v2 = Ms.skip;
                Ms.skip = v2 + 1;
                int v3 = Ms.skip;
                Ms.skip = v3 + 1;
                return (short)(data[v2] & 0xFF | (data[v3] & 0xFF) << 8);
            }
        }
    }

    public int getStringWidth(String str) {
        return Ms.font.stringWidth(str);
    }

    public StringBuffer[] groupString(String info, int width) {
        StringBuffer[] tempResult = new StringBuffer[30];
        StringBuffer temp = new StringBuffer();
        StringBuffer orig = new StringBuffer(info);
        int infoLength = (short)info.length();
        int tc = 0;
        int tw = (byte)this.getStringWidth("#0");
        int rows = -1;
        boolean isNewRow = false;
        String tcolor = "";
        for(int i = 0; i < infoLength; ++i) {
            if(orig.charAt(0) == 35) {
                if(orig.charAt(1) == 110) {
                    isNewRow = true;
                }
                else {
                    tcolor = "#" + orig.charAt(1);
                    temp.append(tcolor);
                    tc = (byte)(tc + 1);
                }
                orig.deleteCharAt(0);
                orig.deleteCharAt(0);
                ++i;
            }
            else {
                temp.append(orig.charAt(0));
                if(width != 0 && this.getStringWidth(temp.toString()) <= tw * tc + width) {
                    orig.deleteCharAt(0);
                }
                else if(width == 0) {
                    orig.deleteCharAt(0);
                }
                else {
                    --i;
                    temp.deleteCharAt(temp.length() - 1);
                    isNewRow = true;
                }
                if(i == infoLength - 1 && !isNewRow) {
                    isNewRow = true;
                }
            }
            if(isNewRow) {
                rows = (byte)(rows + 1);
                tc = (byte)(tcolor.length() == 0 ? 0 : 1);
                isNewRow = false;
                tempResult[rows] = temp;
                temp = new StringBuffer();
                temp.append(tcolor);
            }
        }
        StringBuffer[] result = new StringBuffer[rows + 1];
        System.arraycopy(tempResult, 0, result, 0, rows + 1);
        return result;
    }

    public static Ms i() {
        if(Ms.msListener == null) {
            Ms.msListener = new Ms();
        }
        return Ms.msListener;
    }

    public boolean isRect(int a0, int a1, int aw, int ah, int b0, int b1, int bw, int bh) {
        return a0 < b0 + bw && a0 + aw > b0 && a1 < b1 + bh && a1 + ah > b1;
    }

    public void keyRelease() {
        Ms.keyRepeat = false;
        Ms.key_delay = 0;
        Ms.key_time = 10;
    }

    public boolean key_Down() {
        return Ms.key == -2;
    }

    public boolean key_Left() {
        return Ms.key == -3;
    }

    public boolean key_Left_Right() {
        return Ms.key == -4 || Ms.key == -3;
    }

    public boolean key_Num0() {
        return Ms.key == 0x30;
    }

    public boolean key_Num1() {
        return Ms.key == 49;
    }

    public boolean key_Num3() {
        return Ms.key == 51;
    }

    public boolean key_Num9() {
        return Ms.key == 57;
    }

    public boolean key_Right() {
        return Ms.key == -4;
    }

    public boolean key_S1() {
        return Ms.key == -6;
    }

    public boolean key_S1_Num5() {
        return Ms.key == -6 || Ms.key == -5 || Ms.key == 53;
    }

    public boolean key_S2() {
        return Ms.key == -7;
    }

    public boolean key_Up() {
        return Ms.key == -1;
    }

    public boolean key_Up_Down() {
        return Ms.key == -2 || Ms.key == -1;
    }

    public boolean key_delay() {
        if(Ms.key_delay == 0) {
            Ms.key_delay = Ms.key_time;
            if(Ms.key_time > 1) {
                Ms.key_time = (byte)(Ms.key_time - 1);
            }
            return false;
        }
        return true;
    }

    public String[] loadText(byte[] word_uni) {
        try {
            StringBuffer stringbuffer = new StringBuffer("");
            int j = 2;
            while(true) {
                if(j >= word_uni.length) {
                    String s = stringbuffer.toString();
                    Vector vecString = new Vector();
                    int k = 0;
                    int l = 0;
                    for(int j = 0; true; ++j) {
                        if(j >= s.length()) {
                            String[] reStr = new String[vecString.size()];
                            for(int j = 0; true; ++j) {
                                if(j >= vecString.size()) {
                                    return reStr;
                                }
                                reStr[j] = (String)vecString.elementAt(j);
                            }
                        }
                        if(s.charAt(j) == 10 || j == s.length()) {
                            vecString.addElement(s.substring(k, l));
                            k = l + 1;
                        }
                        ++l;
                    }
                }
                int j = j + 1;
                int k = word_uni[j];
                if(k < 0) {
                    k += 0x100;
                }
                j = j + 1;
                int l = word_uni[j];
                if(l < 0) {
                    l += 0x100;
                }
                stringbuffer.append(((char)((l << 8) + k)));
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            return null;
        }
    }

    public short mathPercent(int m0, int m1, int per) {
        if(per < 1) {
            per = 1;
        }
        return (short)(m0 * m1 / per);
    }

    public short mathSpeedDown(int volue, int num, boolean bb) {
        if(volue / num != 0) {
            return (short)(volue - volue / num);
        }
        if(bb && volue > 0) {
            return (short)(volue - 1);
        }
        return !bb || volue >= 0 ? 0 : ((short)(volue + 1));
    }

    public short mathSpeedN(int volue, int maxv, int speed, boolean bb) {
        if(volue > maxv && volue - speed > maxv) {
            return (short)(volue - speed);
        }
        if(volue < maxv && volue + speed < maxv) {
            return (short)(volue + speed);
        }
        if(bb && volue > maxv) {
            return (short)(volue - 1);
        }
        return !bb || volue >= maxv ? ((short)maxv) : ((short)(volue + 1));
    }

    public short mathSpeedUp(int volue, int max, int speed) {
        int v3 = volue - (max - volue) / speed;
        return v3 >= 0 ? ((short)v3) : 0;
    }

    public void putInt(int value, byte[] buf, int i) {
        buf[i] = (byte)(value >> 24 & 0xFF);
        buf[i + 1] = (byte)(value >> 16 & 0xFF);
        buf[i + 2] = (byte)(value >> 8 & 0xFF);
        buf[i + 3] = (byte)(value & 0xFF);
    }

    public void putShort(int value, byte[] buf, int i) {
        buf[i] = (byte)(value >> 8 & 0xFF);
        buf[i + 1] = (byte)(value & 0xFF);
    }

    public void putShort(byte[] buf, int value) {
        int v1 = Ms.skip;
        Ms.skip = v1 + 1;
        buf[v1] = (byte)(value >> 8 & 0xFF);
        int v2 = Ms.skip;
        Ms.skip = v2 + 1;
        buf[v2] = (byte)(value & 0xFF);
    }

    public short[][] readEventNowData() {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(this.rmsOptions(12, null, 1));
        short[][] event_now = new short[byteArray.read()][];
        for(int i = 0; i < event_now.length; ++i) {
            int v1 = byteArray.read();
            if(v1 != 0) {
                event_now[i] = new short[v1];
                for(int j = 0; j < event_now[i].length; ++j) {
                    short[] arr_v = event_now[i];
                    arr_v[j] = (short)(byteArray.read() | byteArray.read() << 8);
                }
            }
        }
        return event_now;
    }

    public byte[] rmsOptions(int recordId, byte[] info, int flag) {
        try {
            if(Ms.rms == null) {
                Ms.rms = RecordStore.openRecordStore("pk5_caihong", true);
            }
            if(Ms.rms.getNumRecords() == 0) {
                this.setRmsInit(true);
            }
            switch(flag) {
                case 1: {
                    return Ms.rms.getRecord(recordId);
                }
                case 2: {
                    Ms.rms.setRecord(recordId, info, 0, info.length);
                    break;
                }
                case 3: {
                    this.setRmsInit(false);
                    return null;
                }
                case 4: {
                    if(Ms.rms != null) {
                        Ms.rms.closeRecordStore();
                        Ms.rms = null;
                        return null;
                    }
                    break;
                }
                case 5: {
                    Log.e("rms.getSizeAvailable() = ", Ms.rms.getSizeAvailable());
                    return null;
                }
                default: {
                    return null;
                }
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        return null;
    }

    public void runDelay() {
        if(Ms.key_delay > 0) {
            Ms.key_delay = (byte)(Ms.key_delay - 1);
        }
    }

    public byte select(int select, int min, int max) {
        if(max == 0) {
            return (byte)select;
        }
        return select + 1 <= max ? ((byte)(select + 1)) : ((byte)min);
    }

    public void selectS(byte[] select, int min, int max, int showLine) {
        if(max != 0) {
            select[0] = this.select(((int)select[0]), min, max - 1);
            if(select[1] - 1 == select[0]) {
                select[1] = (byte)(select[1] - 1);
                return;
            }
            if(select[1] + showLine == select[0]) {
                select[1] = (byte)(select[1] + 1);
                return;
            }
            if(select[0] == max - 1) {
                select[1] = (byte)(max - min >= showLine ? max - showLine : min);
                return;
            }
            if(select[0] == min) {
                select[1] = (byte)min;
            }
        }
    }

    public void setRmsInit(boolean mode) throws Exception {
        byte[] info = new byte[140];
        info[0] = -1;
        byte[] aaa = new byte[280];
        for(int i = 0; i < 83; ++i) {
            if(mode || i != 4) {
                if(i == 12) {
                    if(mode) {
                        Ms.rms.addRecord(aaa, 0, 280);
                    }
                    else {
                        Ms.rms.setRecord(13, aaa, 0, 280);
                    }
                }
                else if(mode) {
                    Ms.rms.addRecord(info, 0, 140);
                }
                else {
                    Ms.rms.setRecord(i + 1, info, 0, 140);
                }
            }
        }
    }

    public void setSprite(Sprite sp, String name, boolean mode) {
        byte[] arr_b = this.getStream(name + ".data", -1);
        Ms.skip = 0;
        sp.nullIMFA();
        if(mode) {
            sp.Set(this.createImage(name), this.create2Array(arr_b), this.create3Array(arr_b), this.create3Array(arr_b));
            return;
        }
        sp.Set(this.createImage(name), this.createShort2Array(arr_b, 2), this.createShort3Array(arr_b, 2), this.createShort3Array(arr_b, 2));
    }

    public byte[] shortArrayToByteArray(short[] shortbuf) {
        Ms.skip = 0;
        byte[] bytebuf = new byte[shortbuf.length << 1];
        for(int i = 0; i < shortbuf.length; ++i) {
            this.putShort(bytebuf, ((int)shortbuf[i]));
        }
        return bytebuf;
    }

    public void sleep(int time) {
        this.sleep_time = time;
    }

    public int sqrt(int x) {
        int y;
        if(x > 0) {
            int b = 10000;
            do {
                y = b;
                b = x * 10000 / b + b >> 1;
            }
            while(b < y);
            return y / 100;
        }
        return 0;
    }
}

