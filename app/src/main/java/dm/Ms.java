package dm;

import android.annotation.SuppressLint;
import android.util.Log;
import com.android.Util.AndroidUtil;
import com.uc.paymentsdk.util.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.rms.RecordStore;
import main.Constants_H;
import main.Key_H;

/* loaded from: classes.dex */
public class Ms implements Key_H {
    //todo thanh0x fix here [][]
    public static int key;
    public static boolean keyRepeat;
    private static Ms msListener;
    private static RecordStore rms;
    public static int skip;
    public static int skip2;
    private int sleep_time;
    private static Random random = new Random();
    public static Font font = Font.getFont(0, 0, 26);
    public static byte key_delay = 0;
    public static byte key_time = 10;
    final int RMSSIZE = 15360;
    private final byte[] transA = {0, 6, 3, 5, 2, 7, 1, 4};

    public Ms() {
        msListener = this;
    }

    public static Ms i() {
        if (msListener == null) {
            msListener = new Ms();
        }
        return msListener;
    }

    public void sleep(int time) {
        this.sleep_time = time;
    }

    public int getSleep() {
        return this.sleep_time;
    }

    @SuppressLint("LongLogTag")
    public byte[] rmsOptions(int recordId, byte[] info, int flag) {
        try {
            if (rms == null) {
                rms = RecordStore.openRecordStore(Constants_H.RMS_NAME, true);
            }
            if (rms.getNumRecords() == 0) {
                setRmsInit(true);
            }
            if (flag != 0) {
                if (flag == 1) {
                    return rms.getRecord(recordId);
                }
                if (flag == 2) {
                    rms.setRecord(recordId, info, 0, info.length);
                } else if (flag == 3) {
                    setRmsInit(false);
                } else if (flag == 4) {
                    if (rms != null) {
                        rms.closeRecordStore();
                        rms = null;
                    }
                } else if (flag == 5) {
                    Log.e("rms.getSizeAvailable() = ", new StringBuilder().append(rms.getSizeAvailable()).toString());
                    return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setRmsInit(boolean mode) throws Exception {
        byte[] info = new byte[140];
        info[0] = -1;
        byte[] aaa = new byte[280];
        for (int i = 0; i < 83; i++) {
            if (mode || i != 4) {
                if (i != 12) {
                    if (mode) {
                        rms.addRecord(info, 0, info.length);
                    } else {
                        rms.setRecord(i + 1, info, 0, info.length);
                    }
                } else if (mode) {
                    rms.addRecord(aaa, 0, aaa.length);
                } else {
                    rms.setRecord(i + 1, aaa, 0, aaa.length);
                }
            }
        }
    }

    public byte[] getEventNowData(short[][] event_now) {
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        byteArray.write(event_now.length);
        for (int i = 0; i < event_now.length; i++) {
            if (event_now[i] == null) {
                byteArray.write(0);
            } else {
                byteArray.write(event_now[i].length);
                for (int j = 0; j < event_now[i].length; j++) {
                    byteArray.write(event_now[i][j] & 255);
                    byteArray.write((event_now[i][j] >> 8) & 255);
                }
            }
        }
        return byteArray.toByteArray();
    }

    public short[][] readEventNowData() {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(rmsOptions(12, null, 1));
        short[][] event_now = new short[byteArray.read()];
        for (int i = 0; i < event_now.length; i++) {
            int nn = byteArray.read();
            if (nn != 0) {
                event_now[i] = new short[nn];
                for (int j = 0; j < event_now[i].length; j++) {
                    event_now[i][j] = (short) (byteArray.read() | (byteArray.read() << 8));
                }
            }
        }
        return event_now;
    }

    public static long getNum(byte[] b) {
        int rtn = 0;
        int len = b.length;
        for (int i = 0; i < len; i++) {
            switch (len) {
                case 1:
                    rtn += (byte) ((b[i] & 255) << (i * 8));
                    break;
                case 2:
                    rtn += (short) ((b[i] & 255) << (i * 8));
                    break;
                case 4:
                    rtn += (b[i] & 255) << (i * 8);
                    break;
                case 8:
                    rtn = (int) (rtn + ((b[i] & 255) << (i * 8)));
                    break;
            }
        }
        return rtn;
    }

    public int getLen_byte(byte value) {
        return value < 0 ? value + 256 : value;
    }

    public int getLen_short(short value) {
        return value < 0 ? 65536 + value : value;
    }

    public int getInt(byte[] buf, int i) {
        return ((buf[i] & 255) << 24) | ((buf[i + 1] & 255) << 16) | ((buf[i + 2] & 255) << 8) | (buf[i + 3] & 255);
    }

    public void putInt(int value, byte[] buf, int i) {
        buf[i] = (byte) ((value >> 24) & 255);
        buf[i + 1] = (byte) ((value >> 16) & 255);
        buf[i + 2] = (byte) ((value >> 8) & 255);
        buf[i + 3] = (byte) (value & 255);
    }

    public short getShort(byte[] buf, int i) {
        return (short) (((buf[i] & 255) << 8) | (buf[i + 1] & 255));
    }

    public void putShort(int value, byte[] buf, int i) {
        buf[i] = (byte) ((value >> 8) & 255);
        buf[i + 1] = (byte) (value & 255);
    }

    public void putShort(byte[] buf, int value) {
        int i = skip;
        skip = i + 1;
        buf[i] = (byte) ((value >> 8) & 255);
        int i2 = skip;
        skip = i2 + 1;
        buf[i2] = (byte) ((value >> 0) & 255);
    }

    public short[] byteArrayToShortArray(byte[] bytebuf) {
        skip = 0;
        int len = bytebuf.length >> 1;
        short[] shortbuf = new short[len];
        for (int i = 0; i < len; i++) {
            shortbuf[i] = getStreamL(bytebuf, 2);
        }
        return shortbuf;
    }

    public byte[] shortArrayToByteArray(short[] shortbuf) {
        skip = 0;
        int len = shortbuf.length;
        byte[] bytebuf = new byte[len << 1];
        for (short s : shortbuf) {
            putShort(bytebuf, s);
        }
        return bytebuf;
    }

    private short getStreamL(byte[] data, int mode) {
        if (mode == 0) {
            int i = skip;
            skip = i + 1;
            return data[i];
        }
        if (mode == 1) {
            int i2 = skip;
            skip = i2 + 1;
            return (short) (data[i2] + 100);
        }
        if (mode == 2) {
            int i3 = skip;
            skip = i3 + 1;
            int i4 = (data[i3] & 255) << 8;
            int i5 = skip;
            skip = i5 + 1;
            return (short) (i4 | (data[i5] & 255));
        }
        int i6 = skip;
        skip = i6 + 1;
        int i7 = data[i6] & 255;
        int i8 = skip;
        skip = i8 + 1;
        return (short) (i7 | ((data[i8] & 255) << 8));
    }

    public byte[] getStream(String i, int num) {
        byte[] data = (byte[]) null;
        try {
            DataInputStream dataInput = new DataInputStream(AndroidUtil.getResourceAsStream("/" + i));
            if (num > -1) {
                dataInput.readByte();
                for (byte n = 0; n < num; n = (byte) (n + 1)) {
                    dataInput.skip(getLen_short(dataInput.readShort()));
                }
            }
            data = new byte[getLen_short(dataInput.readShort())];
            dataInput.read(data);
            dataInput.close();
            return data;
        } catch (Exception ex) {
            ex.printStackTrace();
            return data;
        }
    }

    public int[] createIntArray(byte[] data) {
        int[] array = new int[getStreamL(data, 0)];
        for (int i = 0; i < array.length; i++) {
            int i2 = skip;
            skip = i2 + 1;
            int i3 = data[i2] & 255;
            int i4 = skip;
            skip = i4 + 1;
            int i5 = i3 | ((data[i4] & 255) << 8);
            int i6 = skip;
            skip = i6 + 1;
            int i7 = i5 | ((data[i6] & 255) << 16);
            int i8 = skip;
            skip = i8 + 1;
            array[i] = i7 | ((data[i8] & 255) << 24);
        }
        return array;
    }

    public short[] createShortArray(byte[] data, int mode) {
        short[] array = new short[getStreamL(data, mode)];
        for (int j = 0; j < array.length; j++) {
            array[j] = getStreamL(data, mode == 2 ? 2 : -1);
        }
        return array;
    }

    public short[][] createShort2Array(byte[] data, int mode) {
        short[][] array = new short[getStreamL(data, mode)];
        for (int i = 0; i < array.length; i++) {
            array[i] = createShortArray(data, mode);
        }
        return array;
    }

    public short[][][] createShort3Array(byte[] data, int mode) {
        short[][][] array = new short[getStreamL(data, mode)][];
        for (int i = 0; i < array.length; i++) {
            array[i] = createShort2Array(data, mode);
        }
        return array;
    }

    public byte[] createArray(byte[] data) {
        int i = skip;
        skip = i + 1;
        byte[] array = new byte[getLen_byte(data[i])];
        for (int j = 0; j < array.length; j++) {
            int i2 = skip;
            skip = i2 + 1;
            array[j] = data[i2];
        }
        return array;
    }

    public byte[][] create2Array(byte[] data) {
        int i = skip;
        skip = i + 1;
        byte[][] array = new byte[getLen_byte(data[i])];
        for (int i2 = 0; i2 < array.length; i2++) {
            array[i2] = createArray(data);
        }
        return array;
    }

    public byte[][][] create3Array(byte[] data) {
        int i = skip;
        skip = i + 1;
        byte[][][] array = new byte[getLen_byte(data[i])][];
        for (int i2 = 0; i2 < array.length; i2++) {
            array[i2] = create2Array(data);
        }
        return array;
    }

    public byte[][][][] create4Array(byte[] data) {
        int i = skip;
        skip = i + 1;
        byte[][][][] array = new byte[getLen_byte(data[i])][][];
        for (int i2 = 0; i2 < array.length; i2++) {
            array[i2] = create3Array(data);
        }
        return array;
    }

    public StringBuffer[] createStringArray(byte[] bArr) {
        int i = skip;
        skip = i + 1;
        StringBuffer[] string = new StringBuffer[getLen_byte(bArr[i])];
        for (byte i2 = 0; i2 < string.length; i2 = (byte) (i2 + 1)) {
            short s = bArr[skip];
            if (s < 0) {
                s = (short) (s + 256);
            }
            string[i2] = new StringBuffer(getDialogs(bArr, skip + 1, s));
            skip += (s * 2) + 1;
        }
        return string;
    }

    public StringBuffer createStringArrayOne(byte[] data) {
        return new StringBuffer(getDialogs(data, 2, getLen_byte(data[1])));
    }

    public StringBuffer[][] createString2Array(byte[] bArr) {
        int i = skip;
        skip = i + 1;
        StringBuffer[][] string = new StringBuffer[bArr[i]];
        for (byte i2 = 0; i2 < string.length; i2 = (byte) (i2 + 1)) {
            string[i2] = createStringArray(bArr);
        }
        return string;
    }

    public String getDialogs(byte[] data, int start, int len) {
        StringBuffer dialog = new StringBuffer();
        for (int i = 0; i < len; i++) {
            dialog.append((char) ((data[(i << 1) + start] << 8) | (data[(i << 1) + start + 1] & 255)));
        }
        return dialog.toString();
    }

    public StringBuffer[] groupString(String info, int width) {
        StringBuffer[] tempResult = new StringBuffer[30];
        StringBuffer temp = new StringBuffer();
        StringBuffer orig = new StringBuffer(info);
        short infoLength = (short) info.length();
        byte tc = 0;
        byte tw = (byte) getStringWidth("#0");
        byte rows = -1;
        boolean isNewRow = false;
        String tcolor = "";
        int i = 0;
        while (i < infoLength) {
            if (orig.charAt(0) == '#') {
                if (orig.charAt(1) == 'n') {
                    isNewRow = true;
                } else {
                    tcolor = "#" + orig.charAt(1);
                    temp.append(tcolor);
                    tc = (byte) (tc + 1);
                }
                orig.deleteCharAt(0);
                orig.deleteCharAt(0);
                i++;
            } else {
                temp.append(orig.charAt(0));
                if (width != 0 && getStringWidth(temp.toString()) <= (tw * tc) + width) {
                    orig.deleteCharAt(0);
                } else if (width != 0) {
                    i--;
                    temp.deleteCharAt(temp.length() - 1);
                    isNewRow = true;
                } else {
                    orig.deleteCharAt(0);
                }
                if (i == infoLength - 1 && !isNewRow) {
                    isNewRow = true;
                }
            }
            if (isNewRow) {
                rows = (byte) (rows + 1);
                tc = (byte) (tcolor.length() == 0 ? 0 : 1);
                isNewRow = false;
                tempResult[rows] = temp;
                temp = new StringBuffer();
                temp.append(tcolor);
            }
            i++;
        }
        StringBuffer[] result = new StringBuffer[rows + 1];
        System.arraycopy(tempResult, 0, result, 0, rows + 1);
        return result;
    }

    public String[] loadText(byte[] bArr) {
        try {
            StringBuffer stringbuffer = new StringBuffer("");
            int j = 2;
            while (j < bArr.length) {
                int j2 = j + 1;
                int i = bArr[j];
                if (i < 0) {
                    i += GameCanvas.FIRE_PRESSED;
                }
                j = j2 + 1;
                int i2 = bArr[j2];
                if (i2 < 0) {
                    i2 += GameCanvas.FIRE_PRESSED;
                }
                char c = (char) ((i2 << 8) + i);
                stringbuffer.append(c);
            }
            String strReturn = stringbuffer.toString();
            Vector vecString = new Vector();
            int k = 0;
            int l = 0;
            for (int j3 = 0; j3 < strReturn.length(); j3++) {
                if (strReturn.charAt(j3) == '\n' || j3 == strReturn.length()) {
                    String temp = strReturn.substring(k, l);
                    vecString.addElement(temp);
                    k = l + 1;
                }
                l++;
            }
            String[] reStr = new String[vecString.size()];
            for (int j4 = 0; j4 < vecString.size(); j4++) {
                String s = (String) vecString.elementAt(j4);
                reStr[j4] = s;
            }
            return reStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    Image createImage(Image image, int x, int y, int width, int height, int trans) {
        if (x + width > image.getWidth()) {
            width = image.getWidth() - x;
        }
        if (y + height > image.getHeight()) {
            height = image.getHeight() - y;
        }
        return Image.createImage(image, x, y, width, height, this.transA[trans]);
    }

    Image createCellImage(Image image, int cell_index, int cell_width, int cell_height, int trans) {
        int temp_cell_x = (cell_index % (image.getWidth() / cell_width)) * cell_width;
        int temp_cell_y = (cell_index % (image.getHeight() / cell_height)) * cell_height;
        return createImage(image, temp_cell_x, temp_cell_y, cell_width, cell_height, trans);
    }

    public Image[] createImageArray(int len, String name) {
        Image[] img = new Image[len];
        for (short i = 0; i < img.length; i = (short) (i + 1)) {
            img[i] = createImage(String.valueOf(name) + ((int) i));
        }
        return img;
    }

    public Image[] createImageArray_(int len, String name, int a) {
        Image[] img = new Image[len];
        for (short i = 0; i < img.length; i = (short) (i + 1)) {
            img[i] = createImage_(String.valueOf(name) + ((int) i), a);
        }
        return img;
    }

    public Image createImage(String name, int no) {
        byte[] data = getStream(name, no);
        return Image.createImage(data, 0, data.length);
    }

    public Image createImage(String imageName) {
        try {
            return Image.createImage("/" + imageName + ".png");
        } catch (Exception e) {
            return null;
        }
    }

    public Image createImage_(String imageName, int a) {
        try {
            return Image.createImage("/" + imageName + ".png", a);
        } catch (Exception e) {
            return null;
        }
    }

    public Sprite createSprite(String name, boolean mode) {
        byte[] date = getStream(String.valueOf(name) + ".data", -1);
        skip = 0;
        if (mode) {
            return Sprite.Create(createImage(name), create2Array(date), create3Array(date), create3Array(date));
        }
        return Sprite.Create(createImage(name), createShort2Array(date, 2), createShort3Array(date, 2), createShort3Array(date, 2));
    }

    public void setSprite(Sprite sp, String name, boolean mode) {
        byte[] date = getStream(String.valueOf(name) + ".data", -1);
        skip = 0;
        sp.nullIMFA();
        if (mode) {
            sp.Set(createImage(name), create2Array(date), create3Array(date), create3Array(date));
        } else {
            sp.Set(createImage(name), createShort2Array(date, 2), createShort3Array(date, 2), createShort3Array(date, 2));
        }
    }

    public boolean equals(StringBuffer sbuff, String str) {
        return sbuff.toString().equals(str);
    }

    public boolean isRect(int a0, int a1, int aw, int ah, int b0, int b1, int bw, int bh) {
        return a0 < b0 + bw && a0 + aw > b0 && a1 < b1 + bh && a1 + ah > b1;
    }

    public String getPrecision(int t) {
        return String.valueOf(t / 10) + "." + (t % 10);
    }

    public int sqrt(int x) {
        int y;
        if (x <= 0) {
            return 0;
        }
        int x2 = x * Constants.PAYMENT_JIFENGQUAN_MAX;
        int b = Constants.PAYMENT_JIFENGQUAN_MAX;
        do {
            y = b;
            b = ((x2 / b) + b) >> 1;
        } while (b < y);
        return y / 100;
    }

    public static int getRandom(int ss) {
        return (random.nextInt() & Integer.MAX_VALUE) % ss;
    }

    public static int abs(int a) {
        return a > 0 ? a : -a;
    }

    public static int compare_min(int c0, int c1) {
        return c0 <= c1 ? c0 : c1;
    }

    public short mathPercent(int m0, int m1, int per) {
        if (per < 1) {
            per = 1;
        }
        return (short) ((m0 * m1) / per);
    }

    public int getStringWidth(String str) {
        return font.stringWidth(str);
    }

    public byte getMin(byte i0, byte i1) {
        return i0 > i1 ? i1 : i0;
    }

    public short mathSpeedDown(int volue, int num, boolean bb) {
        int volue2;
        if (volue / num != 0) {
            volue2 = volue - (volue / num);
        } else if (!bb || volue <= 0) {
            volue2 = (!bb || volue >= 0) ? 0 : volue + 1;
        } else {
            volue2 = volue - 1;
        }
        return (short) volue2;
    }

    public short mathSpeedUp(int volue, int max, int speed) {
        int volue2 = volue - ((max - volue) / speed);
        return (short) (volue2 < 0 ? 0 : volue2);
    }

    public short mathSpeedN(int volue, int maxv, int speed, boolean bb) {
        int volue2;
        if (volue > maxv && volue - speed > maxv) {
            volue2 = volue - speed;
        } else if (volue < maxv && volue + speed < maxv) {
            volue2 = volue + speed;
        } else if (!bb || volue <= maxv) {
            volue2 = (!bb || volue >= maxv) ? maxv : volue + 1;
        } else {
            volue2 = volue - 1;
        }
        return (short) volue2;
    }

    public byte select(int select, int min, int max) {
        if (max == 0) {
            return (byte) select;
        }
        if (abs(key) % 2 == 1 && select - 1 < min) {
            select = max;
        } else if (abs(key) % 2 == 0 && (select = select + 1) > max) {
            select = min;
        }
        return (byte) select;
    }

    public void selectS(byte[] select, int min, int max, int showLine) {
        if (max != 0) {
            select[0] = select(select[0], min, max - 1);
            if (select[1] - 1 == select[0]) {
                select[1] = (byte) (select[1] - 1);
                return;
            }
            if (select[1] + showLine == select[0]) {
                select[1] = (byte) (select[1] + 1);
            } else {
                if (select[0] != max - 1) {
                    if (select[0] == min) {
                        select[1] = (byte) min;
                        return;
                    }
                    return;
                }
                select[1] = (byte) (max - min < showLine ? min : max - showLine);
            }
        }
    }

    public void correctSelect(byte[] select, int max, int showLine) {
        if (select[0] < max) {
            select[1] = (byte) ((select[0] - showLine) + 1);
        } else {
            select[0] = (byte) (max - 1);
            select[1] = (byte) (max - showLine);
        }
        if (select[0] < 0) {
            select[0] = 0;
        }
        if (select[1] < 0) {
            select[1] = 0;
        }
    }

    private boolean checkIsSimulate() {
        if (Runtime.getRuntime().totalMemory() >= 8000000) {
            return true;
        }
        try {
            Class.forName("emulator.Emulator");
            Class.forName("com.sprintpcs.util.System");
            return true;
        } catch (Exception e) {
            String platForm = System.getProperty("microedition.platform");
            return (platForm.toLowerCase().indexOf("wtk") == -1 && platForm.toLowerCase().indexOf("javasdk") == -1 && platForm.toLowerCase().indexOf("j2me") == -1) ? false : true;
        }
    }

    public void runDelay() {
        if (key_delay > 0) {
            key_delay = (byte) (key_delay - 1);
        }
    }

    public boolean key_delay() {
        if (key_delay != 0) {
            return true;
        }
        key_delay = key_time;
        if (key_time > 1) {
            key_time = (byte) (key_time - 1);
        }
        return false;
    }

    public void keyRelease() {
        keyRepeat = false;
        key_delay = (byte) 0;
        key_time = (byte) 10;
    }

    public boolean key_Up_Down() {
        return key == -1 || key == -2;
    }

    public boolean key_Up() {
        return key == -1;
    }

    public boolean key_Down() {
        return key == -2;
    }

    public boolean key_Left_Right() {
        return key == -3 || key == -4;
    }

    public boolean key_Left() {
        return key == -3;
    }

    public boolean key_Right() {
        return key == -4;
    }

    public boolean key_S1_Num5() {
        return key == -6 || key == 53 || key == -5;
    }

    public boolean key_S1() {
        return key == -6;
    }

    public boolean key_S2() {
        return key == -7;
    }

    public boolean key_Num0() {
        return key == 48;
    }

    public boolean key_Num1() {
        return key == 49;
    }

    public boolean key_Num3() {
        return key == 51;
    }

    public boolean key_Num9() {
        return key == 57;
    }
}
