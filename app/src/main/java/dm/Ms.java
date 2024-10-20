package dm;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.Vector;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.RecordStore;
import main.Key_H;

public class Ms implements Key_H {
  public static Font font;
  
  public static int key;
  
  public static boolean keyRepeat;
  
  public static byte key_delay;
  
  public static byte key_time;
  
  private static Ms msListener;
  
  private static Random random = new Random();
  
  private static RecordStore rms;
  
  public static int skip;
  
  public static int skip2;
  
  final int RMSSIZE = 15360;
  
  private int sleep_time;
  
  private final byte[] transA;
  
  static {
    font = Font.getFont(0, 0, 26);
    key_delay = 0;
    key_time = 10;
  }
  
  public Ms() {
    byte[] arrayOfByte = new byte[8];
    arrayOfByte[1] = 6;
    arrayOfByte[2] = 3;
    arrayOfByte[3] = 5;
    arrayOfByte[4] = 2;
    arrayOfByte[5] = 7;
    arrayOfByte[6] = 1;
    arrayOfByte[7] = 4;
    this.transA = arrayOfByte;
    msListener = this;
  }
  
  public static int abs(int paramInt) {
    if (paramInt <= 0)
      paramInt = -paramInt; 
    return paramInt;
  }
  
  private boolean checkIsSimulate() {
    boolean bool;
    if (Runtime.getRuntime().totalMemory() >= 8000000L)
      return true; 
    try {
      Class.forName("emulator.Emulator");
      Class.forName("com.sprintpcs.util.System");
      bool = true;
    } catch (Exception exception) {
      String str = System.getProperty("microedition.platform");
    } 
    return bool;
  }
  
  public static int compare_min(int paramInt1, int paramInt2) {
    if (paramInt1 > paramInt2)
      paramInt1 = paramInt2; 
    return paramInt1;
  }
  
  public static long getNum(byte[] paramArrayOfbyte) {
    int i = 0;
    int j = paramArrayOfbyte.length;
    byte b = 0;
    while (true) {
      if (b >= j)
        return i; 
      int k = i;
      switch (j) {
        case 3:
        case 5:
        case 6:
        case 7:
          b++;
          i = k;
          break;
        case 1:
          k = i + (byte)((paramArrayOfbyte[b] & 0xFF) << b * 8);
        case 2:
          k = i + (short)((paramArrayOfbyte[b] & 0xFF) << b * 8);
        case 4:
          k = i + ((paramArrayOfbyte[b] & 0xFF) << b * 8);
        case 8:
          k = (int)(i + ((paramArrayOfbyte[b] & 0xFF) << b * 8));
      } 
    } 
  }
  
  public static int getRandom(int paramInt) {
    return (random.nextInt() & Integer.MAX_VALUE) % paramInt;
  }
  
  private short getStreamL(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt == 0) {
      paramInt = skip;
      skip = paramInt + 1;
      return paramArrayOfbyte[paramInt];
    } 
    if (paramInt == 1) {
      paramInt = skip;
      skip = paramInt + 1;
      return (short)(paramArrayOfbyte[paramInt] + 100);
    } 
    if (paramInt == 2) {
      paramInt = skip;
      skip = paramInt + 1;
      paramInt = paramArrayOfbyte[paramInt];
      int i = skip;
      skip = i + 1;
      return (short)((paramInt & 0xFF) << 8 | paramArrayOfbyte[i] & 0xFF);
    } 
    paramInt = skip;
    skip = paramInt + 1;
    byte b = paramArrayOfbyte[paramInt];
    paramInt = skip;
    skip = paramInt + 1;
    return (short)(b & 0xFF | (paramArrayOfbyte[paramInt] & 0xFF) << 8);
  }
  
  public static Ms i() {
    if (msListener == null)
      msListener = new Ms(); 
    return msListener;
  }
  
  public short[] byteArrayToShortArray(byte[] paramArrayOfbyte) {
    skip = 0;
    int i = paramArrayOfbyte.length >> 1;
    short[] arrayOfShort = new short[i];
    for (byte b = 0;; b++) {
      if (b >= i)
        return arrayOfShort; 
      arrayOfShort[b] = getStreamL(paramArrayOfbyte, 2);
    } 
  }
  
  public void correctSelect(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    if (paramArrayOfbyte[0] < paramInt1) {
      paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[0] - paramInt2 + 1);
    } else {
      paramArrayOfbyte[0] = (byte)(paramInt1 - 1);
      paramArrayOfbyte[1] = (byte)(paramInt1 - paramInt2);
    } 
    if (paramArrayOfbyte[0] < 0)
      paramArrayOfbyte[0] = 0; 
    if (paramArrayOfbyte[1] < 0)
      paramArrayOfbyte[1] = 0; 
  }
  
  public byte[][] create2Array(byte[] paramArrayOfbyte) {
    int i = skip;
    skip = i + 1;
    byte[][] arrayOfByte = new byte[getLen_byte(paramArrayOfbyte[i])][];
    for (i = 0;; i++) {
      if (i >= arrayOfByte.length)
        return arrayOfByte; 
      arrayOfByte[i] = createArray(paramArrayOfbyte);
    } 
  }
  
  public byte[][][] create3Array(byte[] paramArrayOfbyte) {
    int i = skip;
    skip = i + 1;
    byte[][][] arrayOfByte = new byte[getLen_byte(paramArrayOfbyte[i])][][];
    for (i = 0;; i++) {
      if (i >= arrayOfByte.length)
        return arrayOfByte; 
      arrayOfByte[i] = create2Array(paramArrayOfbyte);
    } 
  }
  
  public byte[][][][] create4Array(byte[] paramArrayOfbyte) {
    int i = skip;
    skip = i + 1;
    byte[][][][] arrayOfByte = new byte[getLen_byte(paramArrayOfbyte[i])][][][];
    for (i = 0;; i++) {
      if (i >= arrayOfByte.length)
        return arrayOfByte; 
      arrayOfByte[i] = create3Array(paramArrayOfbyte);
    } 
  }
  
  public byte[] createArray(byte[] paramArrayOfbyte) {
    int i = skip;
    skip = i + 1;
    byte[] arrayOfByte = new byte[getLen_byte(paramArrayOfbyte[i])];
    for (i = 0;; i++) {
      if (i >= arrayOfByte.length)
        return arrayOfByte; 
      int j = skip;
      skip = j + 1;
      arrayOfByte[i] = paramArrayOfbyte[j];
    } 
  }
  
  Image createCellImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    return createImage(paramImage, paramInt1 % paramImage.getWidth() / paramInt2 * paramInt2, paramInt1 % paramImage.getHeight() / paramInt3 * paramInt3, paramInt2, paramInt3, paramInt4);
  }
  
  public Image createImage(String paramString) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("/");
      Image image = Image.createImage(stringBuilder.append(paramString).append(".png").toString());
    } catch (Exception exception) {
      exception = null;
    } 
    return (Image)exception;
  }
  
  public Image createImage(String paramString, int paramInt) {
    byte[] arrayOfByte = getStream(paramString, paramInt);
    return Image.createImage(arrayOfByte, 0, arrayOfByte.length);
  }
  
  Image createImage(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int i = paramInt3;
    if (paramInt1 + paramInt3 > paramImage.getWidth())
      i = paramImage.getWidth() - paramInt1; 
    paramInt3 = paramInt4;
    if (paramInt2 + paramInt4 > paramImage.getHeight())
      paramInt3 = paramImage.getHeight() - paramInt2; 
    return Image.createImage(paramImage, paramInt1, paramInt2, i, paramInt3, this.transA[paramInt5]);
  }
  
  public Image[] createImageArray(int paramInt, String paramString) {
    Image[] arrayOfImage = new Image[paramInt];
    for (paramInt = 0;; paramInt = (short)(paramInt + 1)) {
      if (paramInt >= arrayOfImage.length)
        return arrayOfImage; 
      arrayOfImage[paramInt] = createImage(String.valueOf(paramString) + paramInt);
    } 
  }
  
  public Image[] createImageArray_(int paramInt1, String paramString, int paramInt2) {
    Image[] arrayOfImage = new Image[paramInt1];
    for (paramInt1 = 0;; paramInt1 = (short)(paramInt1 + 1)) {
      if (paramInt1 >= arrayOfImage.length)
        return arrayOfImage; 
      arrayOfImage[paramInt1] = createImage_(String.valueOf(paramString) + paramInt1, paramInt2);
    } 
  }
  
  public Image createImage_(String paramString, int paramInt) {
    try {
      StringBuilder stringBuilder = new StringBuilder();
      this("/");
      Image image = Image.createImage(stringBuilder.append(paramString).append(".png").toString(), paramInt);
    } catch (Exception exception) {
      exception = null;
    } 
    return (Image)exception;
  }
  
  public int[] createIntArray(byte[] paramArrayOfbyte) {
    int[] arrayOfInt = new int[getStreamL(paramArrayOfbyte, 0)];
    for (byte b = 0;; b++) {
      if (b >= arrayOfInt.length)
        return arrayOfInt; 
      int i = skip;
      skip = i + 1;
      i = paramArrayOfbyte[i];
      int j = skip;
      skip = j + 1;
      j = paramArrayOfbyte[j];
      int k = skip;
      skip = k + 1;
      k = paramArrayOfbyte[k];
      int m = skip;
      skip = m + 1;
      arrayOfInt[b] = i & 0xFF | (j & 0xFF) << 8 | (k & 0xFF) << 16 | (paramArrayOfbyte[m] & 0xFF) << 24;
    } 
  }
  
  public short[][] createShort2Array(byte[] paramArrayOfbyte, int paramInt) {
    short[][] arrayOfShort = new short[getStreamL(paramArrayOfbyte, paramInt)][];
    for (byte b = 0;; b++) {
      if (b >= arrayOfShort.length)
        return arrayOfShort; 
      arrayOfShort[b] = createShortArray(paramArrayOfbyte, paramInt);
    } 
  }
  
  public short[][][] createShort3Array(byte[] paramArrayOfbyte, int paramInt) {
    short[][][] arrayOfShort = new short[getStreamL(paramArrayOfbyte, paramInt)][][];
    for (byte b = 0;; b++) {
      if (b >= arrayOfShort.length)
        return arrayOfShort; 
      arrayOfShort[b] = createShort2Array(paramArrayOfbyte, paramInt);
    } 
  }
  
  public short[] createShortArray(byte[] paramArrayOfbyte, int paramInt) {
    short[] arrayOfShort = new short[getStreamL(paramArrayOfbyte, paramInt)];
    for (byte b = 0;; b++) {
      byte b1;
      if (b >= arrayOfShort.length)
        return arrayOfShort; 
      if (paramInt == 2) {
        b1 = 2;
      } else {
        b1 = -1;
      } 
      arrayOfShort[b] = getStreamL(paramArrayOfbyte, b1);
    } 
  }
  
  public Sprite createSprite(String paramString, boolean paramBoolean) {
    byte[] arrayOfByte = getStream(String.valueOf(paramString) + ".data", -1);
    skip = 0;
    return paramBoolean ? Sprite.Create(createImage(paramString), create2Array(arrayOfByte), create3Array(arrayOfByte), create3Array(arrayOfByte)) : Sprite.Create(createImage(paramString), createShort2Array(arrayOfByte, 2), createShort3Array(arrayOfByte, 2), createShort3Array(arrayOfByte, 2));
  }
  
  public StringBuffer[][] createString2Array(byte[] paramArrayOfbyte) {
    int i = skip;
    skip = i + 1;
    StringBuffer[][] arrayOfStringBuffer = new StringBuffer[paramArrayOfbyte[i]][];
    for (i = 0;; i = (byte)(i + 1)) {
      if (i >= arrayOfStringBuffer.length)
        return arrayOfStringBuffer; 
      arrayOfStringBuffer[i] = createStringArray(paramArrayOfbyte);
    } 
  }
  
  public StringBuffer[] createStringArray(byte[] paramArrayOfbyte) {
    int i = skip;
    skip = i + 1;
    StringBuffer[] arrayOfStringBuffer = new StringBuffer[getLen_byte(paramArrayOfbyte[i])];
    for (i = 0;; i = (byte)(i + 1)) {
      if (i >= arrayOfStringBuffer.length)
        return arrayOfStringBuffer; 
      int k = paramArrayOfbyte[skip];
      int j = k;
      if (k < 0)
        j = (short)(k + 256); 
      arrayOfStringBuffer[i] = new StringBuffer(getDialogs(paramArrayOfbyte, skip + 1, j));
      skip += j * 2 + 1;
    } 
  }
  
  public StringBuffer createStringArrayOne(byte[] paramArrayOfbyte) {
    return new StringBuffer(getDialogs(paramArrayOfbyte, 2, getLen_byte(paramArrayOfbyte[1])));
  }
  
  public boolean equals(StringBuffer paramStringBuffer, String paramString) {
    return paramStringBuffer.toString().equals(paramString);
  }
  
  public String getDialogs(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0;; b++) {
      if (b >= paramInt2)
        return stringBuffer.toString(); 
      stringBuffer.append((char)(paramArrayOfbyte[(b << 1) + paramInt1] << 8 | paramArrayOfbyte[(b << 1) + paramInt1 + 1] & 0xFF));
    } 
  }
  
  public byte[] getEventNowData(short[][] paramArrayOfshort) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byteArrayOutputStream.write(paramArrayOfshort.length);
    byte b = 0;
    label14: while (true) {
      if (b >= paramArrayOfshort.length)
        return byteArrayOutputStream.toByteArray(); 
      if (paramArrayOfshort[b] == null) {
        byteArrayOutputStream.write(0);
        continue;
      } 
      byteArrayOutputStream.write((paramArrayOfshort[b]).length);
      byte b1 = 0;
      while (true) {
        if (b1 < (paramArrayOfshort[b]).length) {
          byteArrayOutputStream.write(paramArrayOfshort[b][b1] & 0xFF);
          byteArrayOutputStream.write(paramArrayOfshort[b][b1] >> 8 & 0xFF);
          b1++;
          continue;
        } 
        b++;
        continue label14;
      } 
      break;
    } 
  }
  
  public int getInt(byte[] paramArrayOfbyte, int paramInt) {
    return (paramArrayOfbyte[paramInt] & 0xFF) << 24 | (paramArrayOfbyte[paramInt + 1] & 0xFF) << 16 | (paramArrayOfbyte[paramInt + 2] & 0xFF) << 8 | paramArrayOfbyte[paramInt + 3] & 0xFF;
  }
  
  public int getLen_byte(byte paramByte) {
    if (paramByte < 0)
      paramByte += 256; 
    return paramByte;
  }
  
  public int getLen_short(short paramShort) {
    int i;
    if (paramShort < 0)
      i = 65536 + paramShort; 
    return i;
  }
  
  public byte getMin(byte paramByte1, byte paramByte2) {
    if (paramByte1 > paramByte2)
      paramByte1 = paramByte2; 
    return paramByte1;
  }
  
  public String getPrecision(int paramInt) {
    return String.valueOf(paramInt / 10) + "." + (paramInt % 10);
  }
  
  public short getShort(byte[] paramArrayOfbyte, int paramInt) {
    return (short)((paramArrayOfbyte[paramInt] & 0xFF) << 8 | paramArrayOfbyte[paramInt + 1] & 0xFF);
  }
  
  public int getSleep() {
    return this.sleep_time;
  }
  
  public byte[] getStream(String paramString, int paramInt) {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast [B
    //   4: astore #5
    //   6: aload #5
    //   8: astore #4
    //   10: new java/io/DataInputStream
    //   13: astore #6
    //   15: aload #5
    //   17: astore #4
    //   19: new java/lang/StringBuilder
    //   22: astore #7
    //   24: aload #5
    //   26: astore #4
    //   28: aload #7
    //   30: ldc '/'
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: aload #5
    //   37: astore #4
    //   39: aload #6
    //   41: aload #7
    //   43: aload_1
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual toString : ()Ljava/lang/String;
    //   50: invokestatic getResourceAsStream : (Ljava/lang/String;)Ljava/io/InputStream;
    //   53: invokespecial <init> : (Ljava/io/InputStream;)V
    //   56: iload_2
    //   57: iconst_m1
    //   58: if_icmple -> 78
    //   61: aload #5
    //   63: astore #4
    //   65: aload #6
    //   67: invokevirtual readByte : ()B
    //   70: pop
    //   71: iconst_0
    //   72: istore_3
    //   73: iload_3
    //   74: iload_2
    //   75: if_icmplt -> 114
    //   78: aload #5
    //   80: astore #4
    //   82: aload_0
    //   83: aload #6
    //   85: invokevirtual readShort : ()S
    //   88: invokevirtual getLen_short : (S)I
    //   91: newarray byte
    //   93: astore_1
    //   94: aload_1
    //   95: astore #4
    //   97: aload #6
    //   99: aload_1
    //   100: invokevirtual read : ([B)I
    //   103: pop
    //   104: aload_1
    //   105: astore #4
    //   107: aload #6
    //   109: invokevirtual close : ()V
    //   112: aload_1
    //   113: areturn
    //   114: aload #5
    //   116: astore #4
    //   118: aload #6
    //   120: aload_0
    //   121: aload #6
    //   123: invokevirtual readShort : ()S
    //   126: invokevirtual getLen_short : (S)I
    //   129: i2l
    //   130: invokevirtual skip : (J)J
    //   133: pop2
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: i2b
    //   138: istore_3
    //   139: goto -> 73
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual printStackTrace : ()V
    //   147: aload #4
    //   149: astore_1
    //   150: goto -> 112
    // Exception table:
    //   from	to	target	type
    //   10	15	142	java/lang/Exception
    //   19	24	142	java/lang/Exception
    //   28	35	142	java/lang/Exception
    //   39	56	142	java/lang/Exception
    //   65	71	142	java/lang/Exception
    //   82	94	142	java/lang/Exception
    //   97	104	142	java/lang/Exception
    //   107	112	142	java/lang/Exception
    //   118	134	142	java/lang/Exception
  }
  
  public int getStringWidth(String paramString) {
    return font.stringWidth(paramString);
  }
  
  public StringBuffer[] groupString(String paramString, int paramInt) {
    StringBuffer[] arrayOfStringBuffer = new StringBuffer[30];
    StringBuffer stringBuffer1 = new StringBuffer();
    StringBuffer stringBuffer2 = new StringBuffer(paramString);
    short s = (short)paramString.length();
    int i = 0;
    byte b1 = (byte)getStringWidth("#0");
    byte b = -1;
    boolean bool = false;
    paramString = "";
    int j = 0;
    while (true) {
      int k;
      StringBuffer[] arrayOfStringBuffer1;
      String str;
      StringBuffer stringBuffer4;
      if (j >= s) {
        StringBuffer[] arrayOfStringBuffer3 = new StringBuffer[b + 1];
        System.arraycopy(arrayOfStringBuffer, 0, arrayOfStringBuffer3, 0, b + 1);
        arrayOfStringBuffer1 = (StringBuffer[])null;
        return arrayOfStringBuffer3;
      } 
      if (stringBuffer2.charAt(0) == '#') {
        if (stringBuffer2.charAt(1) == 'n') {
          bool = true;
        } else {
          paramString = "#" + stringBuffer2.charAt(1);
          arrayOfStringBuffer1.append(paramString);
          i = (byte)(i + 1);
        } 
        stringBuffer2.deleteCharAt(0);
        stringBuffer2.deleteCharAt(0);
        k = j + 1;
        str = paramString;
        j = i;
      } else {
        int m;
        boolean bool2;
        arrayOfStringBuffer1.append(stringBuffer2.charAt(0));
        if (paramInt != 0 && getStringWidth(arrayOfStringBuffer1.toString()) <= b1 * i + paramInt) {
          stringBuffer2.deleteCharAt(0);
          bool2 = bool;
          m = j;
        } else if (paramInt != 0) {
          m = j - 1;
          arrayOfStringBuffer1.deleteCharAt(arrayOfStringBuffer1.length() - 1);
          bool2 = true;
        } else {
          stringBuffer2.deleteCharAt(0);
          m = j;
          bool2 = bool;
        } 
        k = m;
        bool = bool2;
        j = i;
        str = paramString;
        if (m == s - 1) {
          k = m;
          bool = bool2;
          j = i;
          str = paramString;
          if (!bool2) {
            bool = true;
            k = m;
            j = i;
            str = paramString;
          } 
        } 
      } 
      boolean bool1 = bool;
      byte b2 = b;
      i = j;
      StringBuffer[] arrayOfStringBuffer2 = arrayOfStringBuffer1;
      if (bool) {
        b2 = (byte)(b + 1);
        if (str.length() == 0) {
          i = 0;
        } else {
          i = 1;
        } 
        i = (byte)i;
        bool1 = false;
        arrayOfStringBuffer[b2] = (StringBuffer)arrayOfStringBuffer1;
        stringBuffer4 = new StringBuffer();
        stringBuffer4.append(str);
      } 
      j = k + 1;
      bool = bool1;
      b = b2;
      paramString = str;
      StringBuffer stringBuffer3 = stringBuffer4;
    } 
  }
  
  public boolean isRect(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
    return (paramInt1 < paramInt5 + paramInt7 && paramInt1 + paramInt3 > paramInt5 && paramInt2 < paramInt6 + paramInt8 && paramInt2 + paramInt4 > paramInt6);
  }
  
  public void keyRelease() {
    keyRepeat = false;
    key_delay = 0;
    key_time = 10;
  }
  
  public boolean key_Down() {
    return (key == -2);
  }
  
  public boolean key_Left() {
    return (key == -3);
  }
  
  public boolean key_Left_Right() {
    return !(key != -3 && key != -4);
  }
  
  public boolean key_Num0() {
    return (key == 48);
  }
  
  public boolean key_Num1() {
    return (key == 49);
  }
  
  public boolean key_Num3() {
    return (key == 51);
  }
  
  public boolean key_Num9() {
    return (key == 57);
  }
  
  public boolean key_Right() {
    return (key == -4);
  }
  
  public boolean key_S1() {
    return (key == -6);
  }
  
  public boolean key_S1_Num5() {
    return !(key != -6 && key != 53 && key != -5);
  }
  
  public boolean key_S2() {
    return (key == -7);
  }
  
  public boolean key_Up() {
    return (key == -1);
  }
  
  public boolean key_Up_Down() {
    return !(key != -1 && key != -2);
  }
  
  public boolean key_delay() {
    if (key_delay == 0) {
      key_delay = key_time;
      if (key_time > 1)
        key_time = (byte)(key_time - 1); 
      return false;
    } 
    return true;
  }
  
  public String[] loadText(byte[] paramArrayOfbyte) {
    try {
      Object object;
      StringBuffer stringBuffer = new StringBuffer();
      this("");
      byte b = 2;
      while (true) {
        String str1;
        byte b1;
        if (object >= paramArrayOfbyte.length) {
          str1 = stringBuffer.toString();
          Vector vector = new Vector();
          this();
          boolean bool = false;
          b1 = 0;
          byte b2 = 0;
          while (true) {
            b1++;
            b2++;
            object1 = SYNTHETIC_LOCAL_VARIABLE_4;
          } 
          break;
        } 
        int j = b1 + 1;
        String str3 = str1[b1];
        String str2 = str3;
        if (str3 < null)
          int k = str3 + 256; 
        int i = j + 1;
        String str4 = str1[j];
        str3 = str4;
        if (str4 < null)
          int k = str4 + 256; 
        continue;
        stringBuffer.append((char)((SYNTHETIC_LOCAL_VARIABLE_3 << 8) + b));
        object = SYNTHETIC_LOCAL_VARIABLE_4;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (String[])exception;
  }
  
  public short mathPercent(int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt3;
    if (paramInt3 < 1)
      i = 1; 
    return (short)(paramInt1 * paramInt2 / i);
  }
  
  public short mathSpeedDown(int paramInt1, int paramInt2, boolean paramBoolean) {
    if (paramInt1 / paramInt2 != 0) {
      paramInt1 -= paramInt1 / paramInt2;
      return (short)paramInt1;
    } 
    if (paramBoolean && paramInt1 > 0)
      return (short)--paramInt1; 
    if (paramBoolean && paramInt1 < 0)
      return (short)++paramInt1; 
    paramInt1 = 0;
    return (short)paramInt1;
  }
  
  public short mathSpeedN(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
    if (paramInt1 > paramInt2 && paramInt1 - paramInt3 > paramInt2) {
      paramInt1 -= paramInt3;
      return (short)paramInt1;
    } 
    if (paramInt1 < paramInt2 && paramInt1 + paramInt3 < paramInt2) {
      paramInt1 += paramInt3;
      return (short)paramInt1;
    } 
    if (paramBoolean && paramInt1 > paramInt2)
      return (short)--paramInt1; 
    if (paramBoolean && paramInt1 < paramInt2)
      return (short)++paramInt1; 
    paramInt1 = paramInt2;
    return (short)paramInt1;
  }
  
  public short mathSpeedUp(int paramInt1, int paramInt2, int paramInt3) {
    paramInt1 -= (paramInt2 - paramInt1) / paramInt3;
    if (paramInt1 < 0)
      paramInt1 = 0; 
    return (short)paramInt1;
  }
  
  public void putInt(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
    paramArrayOfbyte[paramInt2] = (byte)(paramInt1 >> 24 & 0xFF);
    paramArrayOfbyte[paramInt2 + 1] = (byte)(paramInt1 >> 16 & 0xFF);
    paramArrayOfbyte[paramInt2 + 2] = (byte)(paramInt1 >> 8 & 0xFF);
    paramArrayOfbyte[paramInt2 + 3] = (byte)(paramInt1 & 0xFF);
  }
  
  public void putShort(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
    paramArrayOfbyte[paramInt2] = (byte)(paramInt1 >> 8 & 0xFF);
    paramArrayOfbyte[paramInt2 + 1] = (byte)(paramInt1 & 0xFF);
  }
  
  public void putShort(byte[] paramArrayOfbyte, int paramInt) {
    int i = skip;
    skip = i + 1;
    paramArrayOfbyte[i] = (byte)(paramInt >> 8 & 0xFF);
    i = skip;
    skip = i + 1;
    paramArrayOfbyte[i] = (byte)(paramInt >> 0 & 0xFF);
  }
  
  public short[][] readEventNowData() {
    short[][] arrayOfShort = (short[][])null;
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(rmsOptions(12, null, 1));
    arrayOfShort = new short[byteArrayInputStream.read()][];
    byte b = 0;
    label14: while (true) {
      if (b >= arrayOfShort.length)
        return arrayOfShort; 
      int i = byteArrayInputStream.read();
      if (i == 0)
        continue; 
      arrayOfShort[b] = new short[i];
      i = 0;
      while (true) {
        if (i < (arrayOfShort[b]).length) {
          arrayOfShort[b][i] = (short)(byteArrayInputStream.read() | byteArrayInputStream.read() << 8);
          i++;
          continue;
        } 
        b++;
        continue label14;
      } 
      break;
    } 
  }
  
  public byte[] rmsOptions(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
    try {
      if (rms == null)
        rms = RecordStore.openRecordStore("pk5_caihong", true); 
      if (rms.getNumRecords() == 0)
        setRmsInit(true); 
      if (paramInt2 != 0) {
        if (paramInt2 == 1)
          return rms.getRecord(paramInt1); 
        if (paramInt2 == 2) {
          rms.setRecord(paramInt1, paramArrayOfbyte, 0, paramArrayOfbyte.length);
        } else if (paramInt2 == 3) {
          setRmsInit(false);
        } else if (paramInt2 == 4) {
          if (rms != null) {
            rms.closeRecordStore();
            rms = null;
          } 
        } else if (paramInt2 == 5) {
          null = new StringBuilder();
          this();
          Log.e("rms.getSizeAvailable() = ", null.append(rms.getSizeAvailable()).toString());
          return null;
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return null;
  }
  
  public void runDelay() {
    if (key_delay > 0)
      key_delay = (byte)(key_delay - 1); 
  }
  
  public byte select(int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: iload_3
    //   1: ifne -> 11
    //   4: iload_1
    //   5: i2b
    //   6: istore #4
    //   8: iload #4
    //   10: ireturn
    //   11: iload_1
    //   12: istore #5
    //   14: getstatic dm/Ms.key : I
    //   17: invokestatic abs : (I)I
    //   20: iconst_2
    //   21: irem
    //   22: iconst_1
    //   23: if_icmpne -> 46
    //   26: iinc #1, -1
    //   29: iload_1
    //   30: istore #5
    //   32: iload_1
    //   33: iload_2
    //   34: if_icmpge -> 46
    //   37: iload_3
    //   38: istore_1
    //   39: iload_1
    //   40: i2b
    //   41: istore #4
    //   43: goto -> 8
    //   46: iload #5
    //   48: istore_1
    //   49: getstatic dm/Ms.key : I
    //   52: invokestatic abs : (I)I
    //   55: iconst_2
    //   56: irem
    //   57: ifne -> 39
    //   60: iinc #5, 1
    //   63: iload #5
    //   65: istore_1
    //   66: iload #5
    //   68: iload_3
    //   69: if_icmple -> 39
    //   72: iload_2
    //   73: istore_1
    //   74: goto -> 39
  }
  
  public void selectS(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 != 0) {
      paramArrayOfbyte[0] = select(paramArrayOfbyte[0], paramInt1, paramInt2 - 1);
      if (paramArrayOfbyte[1] - 1 == paramArrayOfbyte[0]) {
        paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] - 1);
        return;
      } 
      if (paramArrayOfbyte[1] + paramInt3 == paramArrayOfbyte[0]) {
        paramArrayOfbyte[1] = (byte)(paramArrayOfbyte[1] + 1);
        return;
      } 
      if (paramArrayOfbyte[0] == paramInt2 - 1) {
        if (paramInt2 - paramInt1 >= paramInt3)
          paramInt1 = paramInt2 - paramInt3; 
        paramArrayOfbyte[1] = (byte)paramInt1;
        return;
      } 
      if (paramArrayOfbyte[0] == paramInt1)
        paramArrayOfbyte[1] = (byte)paramInt1; 
    } 
  }
  
  public void setRmsInit(boolean paramBoolean) throws Exception {
    byte[] arrayOfByte1 = new byte[140];
    arrayOfByte1[0] = -1;
    byte[] arrayOfByte2 = new byte[280];
    for (byte b = 0;; b++) {
      if (b >= 83) {
        arrayOfByte1 = (byte[])null;
        return;
      } 
      if (paramBoolean || b != 4)
        if (b != 12) {
          if (paramBoolean) {
            rms.addRecord(arrayOfByte1, 0, arrayOfByte1.length);
          } else {
            rms.setRecord(b + 1, arrayOfByte1, 0, arrayOfByte1.length);
          } 
        } else if (paramBoolean) {
          rms.addRecord(arrayOfByte2, 0, arrayOfByte2.length);
        } else {
          rms.setRecord(b + 1, arrayOfByte2, 0, arrayOfByte2.length);
        }  
    } 
  }
  
  public void setSprite(Sprite paramSprite, String paramString, boolean paramBoolean) {
    byte[] arrayOfByte2 = getStream(String.valueOf(paramString) + ".data", -1);
    skip = 0;
    paramSprite.nullIMFA();
    if (paramBoolean) {
      paramSprite.Set(createImage(paramString), create2Array(arrayOfByte2), create3Array(arrayOfByte2), create3Array(arrayOfByte2));
    } else {
      paramSprite.Set(createImage(paramString), createShort2Array(arrayOfByte2, 2), createShort3Array(arrayOfByte2, 2), createShort3Array(arrayOfByte2, 2));
    } 
    byte[] arrayOfByte1 = (byte[])null;
  }
  
  public byte[] shortArrayToByteArray(short[] paramArrayOfshort) {
    skip = 0;
    int i = paramArrayOfshort.length;
    byte[] arrayOfByte = new byte[i << 1];
    for (byte b = 0;; b++) {
      if (b >= i)
        return arrayOfByte; 
      putShort(arrayOfByte, paramArrayOfshort[b]);
    } 
  }
  
  public void sleep(int paramInt) {
    this.sleep_time = paramInt;
  }
  
  public int sqrt(int paramInt) {
    if (paramInt > 0) {
      int i = 10000;
      while (true) {
        int j = i;
        int k = paramInt * 10000 / j + j >> 1;
        i = k;
        if (k >= j)
          return j / 100; 
      } 
    } 
    return 0;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Ms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */