package dm;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.util.Vector;
import java.io.DataInputStream;
import com.android.Util.AndroidUtil;
import java.io.ByteArrayOutputStream;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import java.util.Random;
import javax.microedition.lcdui.Font;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreNotOpenException;

import main.Key_H;

public class Ms implements Key_H
{
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
    final int RMSSIZE;
    private int sleep_time;
    private final byte[] transA;

    static {
        Ms.random = new Random();
        Ms.font = Font.getFont(0, 0, 26);
        Ms.key_delay = 0;
        Ms.key_time = 10;
    }

    public Ms() {
        super();
        this.RMSSIZE = 15360;
        this.transA = new byte[] { 0, 6, 3, 5, 2, 7, 1, 4 };
        Ms.msListener = this;
    }

    public static int abs(int n) {
        if (n <= 0) {
            n = -n;
        }
        return n;
    }

    private boolean checkIsSimulate() {
        boolean b;
        if (Runtime.getRuntime().totalMemory() >= 8000000L) {
            b = true;
        }
        else {
            try {
                Class.forName("emulator.Emulator");
                Class.forName("com.sprintpcs.util.System");
                b = true;
            }
            catch (final Exception ex) {
                final String property = System.getProperty("microedition.platform");
                b = (property.toLowerCase().indexOf("wtk") != -1 || property.toLowerCase().indexOf("javasdk") != -1 || property.toLowerCase().indexOf("j2me") != -1);
            }
        }
        return b;
    }

    public static int compare_min(final int n, int n2) {
        if (n <= n2) {
            n2 = n;
        }
        return n2;
    }

    public static long getNum(final byte[] array) {
        byte b = 0;
        final int length = array.length;
        int i = 0;
        while (i < length) {
            int n = b;
            Label_0070: {
                switch (length) {
                    default: {
                        n = b;
                        break Label_0070;
                    }
                    case 8: {
                        n = (int)(b + (long)((array[i] & 0xFF) << i * 8));
                        break Label_0070;
                    }
                    case 4: {
                        n = b + ((array[i] & 0xFF) << i * 8);
                        break Label_0070;
                    }
                    case 2: {
                        n = b + (short)((array[i] & 0xFF) << i * 8);
                        break Label_0070;
                    }
                    case 1: {
                        n = b + (byte)((array[i] & 0xFF) << i * 8);
                    }
                    case 3:
                    case 5:
                    case 6:
                    case 7: {
                        ++i;
                        b = (byte)n;
                        continue;
                    }
                }
            }
        }
        return b;
    }

    public static int getRandom(final int n) {
        return (Ms.random.nextInt() & Integer.MAX_VALUE) % n;
    }

    private short getStreamL(final byte[] array, int n) {
        short n2;
        if (n == 0) {
            n = Ms.skip;
            Ms.skip = n + 1;
            n2 = array[n];
        }
        else if (n == 1) {
            n = Ms.skip;
            Ms.skip = n + 1;
            n2 = (short)(array[n] + 100);
        }
        else if (n == 2) {
            n = Ms.skip;
            Ms.skip = n + 1;
            final byte b = array[n];
            n = Ms.skip;
            Ms.skip = n + 1;
            n2 = (short)((b & 0xFF) << 8 | (array[n] & 0xFF));
        }
        else {
            n = Ms.skip;
            Ms.skip = n + 1;
            final byte b2 = array[n];
            n = Ms.skip;
            Ms.skip = n + 1;
            n2 = (short)((b2 & 0xFF) | (array[n] & 0xFF) << 8);
        }
        return n2;
    }

    public static Ms i() {
        if (Ms.msListener == null) {
            Ms.msListener = new Ms();
        }
        return Ms.msListener;
    }

    public short[] byteArrayToShortArray(final byte[] array) {
        Ms.skip = 0;
        final int n = array.length >> 1;
        final short[] array2 = new short[n];
        for (int i = 0; i < n; ++i) {
            array2[i] = this.getStreamL(array, 2);
        }
        return array2;
    }

    public void correctSelect(final byte[] array, final int n, final int n2) {
        if (array[0] < n) {
            array[1] = (byte)(array[0] - n2 + 1);
        }
        else {
            array[0] = (byte)(n - 1);
            array[1] = (byte)(n - n2);
        }
        if (array[0] < 0) {
            array[0] = 0;
        }
        if (array[1] < 0) {
            array[1] = 0;
        }
    }

    public byte[][] create2Array(final byte[] array) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        final byte[][] array2 = new byte[this.getLen_byte(array[skip])][];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = this.createArray(array);
        }
        return array2;
    }

    public byte[][][] create3Array(final byte[] array) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        final byte[][][] array2 = new byte[this.getLen_byte(array[skip])][][];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = this.create2Array(array);
        }
        return array2;
    }

    public byte[][][][] create4Array(final byte[] array) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        final byte[][][][] array2 = new byte[this.getLen_byte(array[skip])][][][];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = this.create3Array(array);
        }
        return array2;
    }

    public byte[] createArray(final byte[] array) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        final byte[] array2 = new byte[this.getLen_byte(array[skip])];
        for (int i = 0; i < array2.length; ++i) {
            final int skip2 = Ms.skip;
            Ms.skip = skip2 + 1;
            array2[i] = array[skip2];
        }
        return array2;
    }

    Image createCellImage(final Image image, final int n, final int n2, final int n3, final int n4) {
        return this.createImage(image, n % (image.getWidth() / n2) * n2, n % (image.getHeight() / n3) * n3, n2, n3, n4);
    }

    public Image createImage(final String str) {
        try {
            return Image.createImage("/" + str + ".png");
        }
        catch (final Exception ex) {
            return null;
        }
    }

    public Image createImage(final String s, final int n) {
        final byte[] stream = this.getStream(s, n);
        return Image.createImage(stream, 0, stream.length);
    }

    Image createImage(final Image image, final int n, final int n2, int n3, final int n4, final int n5) {
        int n6 = n3;
        if (n + n3 > image.getWidth()) {
            n6 = image.getWidth() - n;
        }
        n3 = n4;
        if (n2 + n4 > image.getHeight()) {
            n3 = image.getHeight() - n2;
        }
        return Image.createImage(image, n, n2, n6, n3, (int)this.transA[n5]);
    }

    public Image[] createImageArray(int i, final String obj) {
        Image[] array;
        for (array = new Image[i], i = 0; i < array.length; i = (short)(i + 1)) {
            array[i] = this.createImage(String.valueOf(obj) + i);
        }
        return array;
    }

    public Image[] createImageArray_(int i, final String obj, final int n) {
        Image[] array;
        for (array = new Image[i], i = 0; i < array.length; i = (short)(i + 1)) {
            array[i] = this.createImage_(String.valueOf(obj) + i, n);
        }
        return array;
    }

    public Image createImage_(final String str, final int n) {
        try {
            return Image.createImage("/" + str + ".png", n);
        }
        catch (final Exception ex) {
            return null;
        }
    }

    public int[] createIntArray(final byte[] array) {
        final int[] array2 = new int[this.getStreamL(array, 0)];
        for (int i = 0; i < array2.length; ++i) {
            final int skip = Ms.skip;
            Ms.skip = skip + 1;
            final byte b = array[skip];
            final int skip2 = Ms.skip;
            Ms.skip = skip2 + 1;
            final byte b2 = array[skip2];
            final int skip3 = Ms.skip;
            Ms.skip = skip3 + 1;
            final byte b3 = array[skip3];
            final int skip4 = Ms.skip;
            Ms.skip = skip4 + 1;
            array2[i] = ((b & 0xFF) | (b2 & 0xFF) << 8 | (b3 & 0xFF) << 16 | (array[skip4] & 0xFF) << 24);
        }
        return array2;
    }

    public short[][] createShort2Array(final byte[] array, final int n) {
        final short[][] array2 = new short[this.getStreamL(array, n)][];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = this.createShortArray(array, n);
        }
        return array2;
    }

    public short[][][] createShort3Array(final byte[] array, final int n) {
        final short[][][] array2 = new short[this.getStreamL(array, n)][][];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = this.createShort2Array(array, n);
        }
        return array2;
    }

    public short[] createShortArray(final byte[] array, final int n) {
        final short[] array2 = new short[this.getStreamL(array, n)];
        for (int i = 0; i < array2.length; ++i) {
            int n2;
            if (n == 2) {
                n2 = 2;
            }
            else {
                n2 = -1;
            }
            array2[i] = this.getStreamL(array, n2);
        }
        return array2;
    }

    public Sprite createSprite(final String obj, final boolean b) {
        final byte[] stream = this.getStream(String.valueOf(obj) + ".data", -1);
        Ms.skip = 0;
        Sprite sprite;
        if (b) {
            sprite = Sprite.Create(this.createImage(obj), this.create2Array(stream), this.create3Array(stream), this.create3Array(stream));
        }
        else {
            sprite = Sprite.Create(this.createImage(obj), this.createShort2Array(stream, 2), this.createShort3Array(stream, 2), this.createShort3Array(stream, 2));
        }
        return sprite;
    }

    public StringBuffer[][] createString2Array(final byte[] array) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        final StringBuffer[][] array2 = new StringBuffer[array[skip]][];
        for (int i = 0; i < array2.length; i = (byte)(i + 1)) {
            array2[i] = this.createStringArray(array);
        }
        return array2;
    }

    public StringBuffer[] createStringArray(final byte[] array) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        final StringBuffer[] array2 = new StringBuffer[this.getLen_byte(array[skip])];
        for (int i = 0; i < array2.length; i = (byte)(i + 1)) {
            final byte b = array[Ms.skip];
            short n;
            if ((n = b) < 0) {
                n = (short)(b + 256);
            }
            array2[i] = new StringBuffer(this.getDialogs(array, Ms.skip + 1, n));
            Ms.skip += n * 2 + 1;
        }
        return array2;
    }

    public StringBuffer createStringArrayOne(final byte[] array) {
        return new StringBuffer(this.getDialogs(array, 2, this.getLen_byte(array[1])));
    }

    public boolean equals(final StringBuffer sb, final String anObject) {
        return sb.toString().equals(anObject);
    }

    public String getDialogs(final byte[] array, final int n, final int n2) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n2; ++i) {
            sb.append((char)(array[(i << 1) + n] << 8 | (array[(i << 1) + n + 1] & 0xFF)));
        }
        return sb.toString();
    }

    public byte[] getEventNowData(final short[][] array) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(array.length);
        for (int i = 0; i < array.length; ++i) {
            if (array[i] == null) {
                byteArrayOutputStream.write(0);
            }
            else {
                byteArrayOutputStream.write(array[i].length);
                for (int j = 0; j < array[i].length; ++j) {
                    byteArrayOutputStream.write(array[i][j] & 0xFF);
                    byteArrayOutputStream.write(array[i][j] >> 8 & 0xFF);
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getInt(final byte[] array, final int n) {
        return (array[n] & 0xFF) << 24 | (array[n + 1] & 0xFF) << 16 | (array[n + 2] & 0xFF) << 8 | (array[n + 3] & 0xFF);
    }

    public int getLen_byte(byte b) {
        if (b < 0) {
            b += 256;
        }
        return b;
    }

    public int getLen_short(short n) {
        if (n < 0) {
            n += 65536;
        }
        return n;
    }

    public byte getMin(byte b, final byte b2) {
        if (b > b2) {
            b = b2;
        }
        return b;
    }

    public String getPrecision(final int n) {
        return String.valueOf(n / 10) + "." + n % 10;
    }

    public short getShort(final byte[] array, final int n) {
        return (short)((array[n] & 0xFF) << 8 | (array[n + 1] & 0xFF));
    }

    public int getSleep() {
        return this.sleep_time;
    }

    public byte[] getStream(final String str, final int n) {
        byte[] array2;
        final byte[] array = array2 = null;
        try {
            array2 = array;
            array2 = array;
            final StringBuilder sb = new StringBuilder("/");
            array2 = array;
            final DataInputStream dataInputStream = new DataInputStream(AndroidUtil.getResourceAsStream(sb.append(str).toString()));
            if (n > -1) {
                array2 = array;
                dataInputStream.readByte();
                for (int i = 0; i < n; i = (byte)(i + 1)) {
                    array2 = array;
                    dataInputStream.skip(this.getLen_short(dataInputStream.readShort()));
                }
            }
            array2 = array;
            final byte[] b = array2 = new byte[this.getLen_short(dataInputStream.readShort())];
            dataInputStream.read(b);
            array2 = b;
            dataInputStream.close();
            return b;
        }
        catch (final Exception ex) {
            ex.printStackTrace();
            return array2;
        }
    }

    public int getStringWidth(final String s) {
        return Ms.font.stringWidth(s);
    }

    public StringBuffer[] groupString(String string, final int n) {
        final StringBuffer[] array = new StringBuffer[30];
        StringBuffer sb = new StringBuffer();
        final StringBuffer sb2 = new StringBuffer(string);
        final short n2 = (short)string.length();
        byte b = 0;
        final byte b2 = (byte)this.getStringWidth("#0");
        int n3 = -1;
        int n4 = 0;
        string = "";
        int n5;
        String str;
        int n8;
        int n9;
        StringBuffer sb3;
        for (int i = 0; i < n2; i = n5 + 1, n4 = n8, n3 = n9, string = str, sb = sb3) {
            byte b3;
            if (sb2.charAt(0) == '#') {
                if (sb2.charAt(1) == 'n') {
                    n4 = 1;
                }
                else {
                    string = "#" + sb2.charAt(1);
                    sb.append(string);
                    ++b;
                }
                sb2.deleteCharAt(0);
                sb2.deleteCharAt(0);
                n5 = i + 1;
                str = string;
                b3 = b;
            }
            else {
                sb.append(sb2.charAt(0));
                int n6;
                int n7;
                if (n != 0 && this.getStringWidth(sb.toString()) <= b2 * b + n) {
                    sb2.deleteCharAt(0);
                    n6 = n4;
                    n7 = i;
                }
                else if (n != 0) {
                    n7 = i - 1;
                    sb.deleteCharAt(sb.length() - 1);
                    n6 = 1;
                }
                else {
                    sb2.deleteCharAt(0);
                    n7 = i;
                    n6 = n4;
                }
                n5 = n7;
                n4 = n6;
                b3 = b;
                str = string;
                if (n7 == n2 - 1) {
                    n5 = n7;
                    n4 = n6;
                    b3 = b;
                    str = string;
                    if (n6 == 0) {
                        n4 = 1;
                        n5 = n7;
                        b3 = b;
                        str = string;
                    }
                }
            }
            n8 = n4;
            n9 = n3;
            b = b3;
            sb3 = sb;
            if (n4 != 0) {
                n9 = (byte)(n3 + 1);
                int n10;
                if (str.length() == 0) {
                    n10 = 0;
                }
                else {
                    n10 = 1;
                }
                b = (byte)n10;
                n8 = 0;
                array[n9] = sb;
                sb3 = new StringBuffer();
                sb3.append(str);
            }
        }
        final StringBuffer[] array2 = new StringBuffer[n3 + 1];
        System.arraycopy(array, 0, array2, 0, n3 + 1);
        final StringBuffer[] array3 = (StringBuffer[])null;
        return array2;
    }

    public boolean isRect(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        return n < n5 + n7 && n + n3 > n5 && n2 < n6 + n8 && n2 + n4 > n6;
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
        return Ms.key == -3 || Ms.key == -4;
    }

    public boolean key_Num0() {
        return Ms.key == 48;
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
        return Ms.key == -6 || Ms.key == 53 || Ms.key == -5;
    }

    public boolean key_S2() {
        return Ms.key == -7;
    }

    public boolean key_Up() {
        return Ms.key == -1;
    }

    public boolean key_Up_Down() {
        return Ms.key == -1 || Ms.key == -2;
    }

    public boolean key_delay() {
        boolean b;
        if (Ms.key_delay == 0) {
            Ms.key_delay = Ms.key_time;
            if (Ms.key_time > 1) {
                --Ms.key_time;
            }
            b = false;
        }
        else {
            b = true;
        }
        return b;
    }

    public String[] loadText(final byte[] array) {
        Label_0063_Outer:
        while (true) {
            while (true) {
                Vector vector = null;
                String[] array2 = null;
                int index2 = 0;
                Label_0203:
                while (true) {
                    String string;
                    int beginIndex;
                    int endIndex;
                    int index;
                    try {
                        final StringBuffer sb = new StringBuffer("");
                        int n3;
                        for (int i = 2; i < array.length; i = n3) {
                            final int n = i + 1;
                            final byte b = array[i];
                            int n2;
                            if ((n2 = b) < 0) {
                                n2 = b + 256;
                            }
                            n3 = n + 1;
                            final byte b2 = array[n];
                            int n4;
                            if ((n4 = b2) < 0) {
                                n4 = b2 + 256;
                            }
                            sb.append((char)((n4 << 8) + n2));
                        }
                        string = sb.toString();
                        vector = new Vector();
                        beginIndex = 0;
                        endIndex = 0;
                        index = 0;
                        if (index >= string.length()) {
                            array2 = new String[vector.size()];
                            index2 = 0;
                            if (index2 >= vector.size()) {
                                return array2;
                            }
                            break Label_0203;
                        }
                    }
                    catch (final Exception ex) {
                        ex.printStackTrace();
                        array2 = null;
                        return array2;
                    }
                    int n5 = 0;
                    Label_0190: {
                        if (string.charAt(index) != '\n') {
                            n5 = beginIndex;
                            if (index != string.length()) {
                                break Label_0190;
                            }
                        }
                        vector.addElement(string.substring(beginIndex, endIndex));
                        n5 = endIndex + 1;
                    }
                    ++endIndex;
                    ++index;
                    beginIndex = n5;
                    continue Label_0063_Outer;
                }
                array2[index2] = (String)vector.elementAt(index2);
                ++index2;
                continue;
            }
        }
    }

    public short mathPercent(final int n, final int n2, final int n3) {
        int n4 = n3;
        if (n3 < 1) {
            n4 = 1;
        }
        return (short)(n * n2 / n4);
    }

    public short mathSpeedDown(int n, final int n2, final boolean b) {
        if (n / n2 != 0) {
            n -= n / n2;
        }
        else if (b && n > 0) {
            --n;
        }
        else if (b && n < 0) {
            ++n;
        }
        else {
            n = 0;
        }
        return (short)n;
    }

    public short mathSpeedN(int n, final int n2, final int n3, final boolean b) {
        if (n > n2 && n - n3 > n2) {
            n -= n3;
        }
        else if (n < n2 && n + n3 < n2) {
            n += n3;
        }
        else if (b && n > n2) {
            --n;
        }
        else if (b && n < n2) {
            ++n;
        }
        else {
            n = n2;
        }
        return (short)n;
    }

    public short mathSpeedUp(int n, final int n2, final int n3) {
        n -= (n2 - n) / n3;
        if (n < 0) {
            n = 0;
        }
        return (short)n;
    }

    public void putInt(final int n, final byte[] array, final int n2) {
        array[n2] = (byte)(n >> 24 & 0xFF);
        array[n2 + 1] = (byte)(n >> 16 & 0xFF);
        array[n2 + 2] = (byte)(n >> 8 & 0xFF);
        array[n2 + 3] = (byte)(n & 0xFF);
    }

    public void putShort(final int n, final byte[] array, final int n2) {
        array[n2] = (byte)(n >> 8 & 0xFF);
        array[n2 + 1] = (byte)(n & 0xFF);
    }

    public void putShort(final byte[] array, final int n) {
        final int skip = Ms.skip;
        Ms.skip = skip + 1;
        array[skip] = (byte)(n >> 8 & 0xFF);
        final int skip2 = Ms.skip;
        Ms.skip = skip2 + 1;
        array[skip2] = (byte)(n >> 0 & 0xFF);
    }

    public short[][] readEventNowData() {
        final short[][] array = (short[][])null;
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rmsOptions(12, null, 1));
        final short[][] array2 = new short[byteArrayInputStream.read()][];
        for (int i = 0; i < array2.length; ++i) {
            final int read = byteArrayInputStream.read();
            if (read != 0) {
                array2[i] = new short[read];
                for (int j = 0; j < array2[i].length; ++j) {
                    array2[i][j] = (short)(byteArrayInputStream.read() | byteArrayInputStream.read() << 8);
                }
            }
        }
        return array2;
    }


    public byte[] rmsOptions(int i, byte[] bArr, int i2) {
        try {
            if (rms == null) {
                rms = RecordStore.openRecordStore("pk5_caihong", true);
            }
            if (rms.getNumRecords() == 0) {
                setRmsInit(true);
            }
            if (i2 != 0) {
                if (i2 == 1) {
                    return rms.getRecord(i);
                }
                if (i2 == 2) {
                    rms.setRecord(i, bArr, 0, bArr.length);
                    return null;
                } else if (i2 == 3) {
                    setRmsInit(false);
                    return null;
                } else if (i2 != 4) {
                    if (i2 == 5) {
                        Log.e("rms.getSizeAvailable()", new StringBuilder().append(rms.getSizeAvailable()).toString());
                        return null;
                    }
                    return null;
                } else if (rms != null) {
                    rms.closeRecordStore();
                    rms = null;
                    return null;
                } else {
                    return null;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void runDelay() {
        if (Ms.key_delay > 0) {
            --Ms.key_delay;
        }
    }

    public byte select(int n, final int n2, final int n3) {
        byte b;
        if (n3 == 0) {
            b = (byte)n;
        }
        else {
            int n4 = n;
            Label_0046: {
                if (abs(Ms.key) % 2 != 1) {
                    break Label_0046;
                }
                n4 = --n;
                if (n >= n2) {
                    break Label_0046;
                }
                n = n3;
                b = (byte)n;
                return b;
            }
            n = n4;
            if (abs(Ms.key) % 2 != 0) {
                return (byte)n;
            }
            n = ++n4;
            if (n4 > n3) {
                n = n2;
                return (byte)n;
            }
            return (byte)n;
        }
        return b;
    }

    public void selectS(final byte[] array, int n, final int n2, final int n3) {
        if (n2 != 0) {
            array[0] = this.select(array[0], n, n2 - 1);
            if (array[1] - 1 == array[0]) {
                --array[1];
            }
            else if (array[1] + n3 == array[0]) {
                ++array[1];
            }
            else if (array[0] == n2 - 1) {
                if (n2 - n >= n3) {
                    n = n2 - n3;
                }
                array[1] = (byte)n;
            }
            else if (array[0] == n) {
                array[1] = (byte)n;
            }
        }
    }

    public void setRmsInit(final boolean b) throws Exception {
        final byte[] array = new byte[140];
        array[0] = -1;
        final byte[] array2 = new byte[280];
        for (int i = 0; i < 83; ++i) {
            if (b || i != 4) {
                if (i != 12) {
                    if (b) {
                        Ms.rms.addRecord(array, 0, array.length);
                    }
                    else {
                        Ms.rms.setRecord(i + 1, array, 0, array.length);
                    }
                }
                else if (b) {
                    Ms.rms.addRecord(array2, 0, array2.length);
                }
                else {
                    Ms.rms.setRecord(i + 1, array2, 0, array2.length);
                }
            }
        }
        final byte[] array3 = (byte[])null;
    }

    public void setSprite(final Sprite sprite, final String obj, final boolean b) {
        final byte[] stream = this.getStream(String.valueOf(obj) + ".data", -1);
        Ms.skip = 0;
        sprite.nullIMFA();
        if (b) {
            sprite.Set(this.createImage(obj), this.create2Array(stream), this.create3Array(stream), this.create3Array(stream));
        }
        else {
            sprite.Set(this.createImage(obj), this.createShort2Array(stream, 2), this.createShort3Array(stream, 2), this.createShort3Array(stream, 2));
        }
        final byte[] array = (byte[])null;
    }

    public byte[] shortArrayToByteArray(final short[] array) {
        Ms.skip = 0;
        final int length = array.length;
        final byte[] array2 = new byte[length << 1];
        for (int i = 0; i < length; ++i) {
            this.putShort(array2, array[i]);
        }
        return array2;
    }

    public void sleep(final int sleep_time) {
        this.sleep_time = sleep_time;
    }

    public int sqrt(int n) {
        if (n > 0) {
            int n2 = 10000;
            int n3;
            do {
                n3 = n2;
            } while ((n2 = n * 10000 / n3 + n3 >> 1) < n3);
            n = n3 / 100;
        }
        else {
            n = 0;
        }
        return n;
    }
}
