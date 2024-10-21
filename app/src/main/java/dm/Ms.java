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
   public static Font font = Font.getFont(0, 0, 26);
   public static int key;
   public static boolean keyRepeat;
   public static byte key_delay = 0;
   public static byte key_time = 10;
   private static Ms msListener;
   private static Random random = new Random();
   private static RecordStore rms;
   public static int skip;
   public static int skip2;
   final int RMSSIZE = 15360;
   private int sleep_time;
   private final byte[] transA;

   public Ms() {
      super();
      byte[] var1 = new byte[]{0, 6, 3, 5, 2, 7, 1, 4};
      this.transA = var1;
      msListener = this;
   }

   public static int abs(int var0) {
      if (var0 <= 0) {
         var0 = -var0;
      }

      return var0;
   }

   private boolean checkIsSimulate() {
      boolean var1;
      if (Runtime.getRuntime().totalMemory() >= 8000000L) {
         var1 = true;
      } else {
         try {
            Class.forName("emulator.Emulator");
            Class.forName("com.sprintpcs.util.System");
         } catch (Exception var3) {
            String var2 = System.getProperty("microedition.platform");
            if (var2.toLowerCase().indexOf("wtk") == -1 && var2.toLowerCase().indexOf("javasdk") == -1 && var2.toLowerCase().indexOf("j2me") == -1) {
               var1 = false;
            } else {
               var1 = true;
            }

            return var1;
         }

         var1 = true;
      }

      return var1;
   }

   public static int compare_min(int var0, int var1) {
      if (var0 > var1) {
         var0 = var1;
      }

      return var0;
   }

   public static long getNum(byte[] var0) {
      int var3 = 0;
      int var4 = var0.length;

      int var1;
      for(int var2 = 0; var2 < var4; var3 = var1) {
         var1 = var3;
         switch (var4) {
            case 1:
               var1 = var3 + (byte)((var0[var2] & 255) << var2 * 8);
               break;
            case 2:
               var1 = var3 + (short)((var0[var2] & 255) << var2 * 8);
            case 3:
            case 5:
            case 6:
            case 7:
               break;
            case 4:
               var1 = var3 + ((var0[var2] & 255) << var2 * 8);
               break;
            case 8:
               var1 = (int)((long)var3 + (long)((var0[var2] & 255) << var2 * 8));
               break;
            default:
               var1 = var3;
         }

         ++var2;
      }

      return (long)var3;
   }

   public static int getRandom(int var0) {
      return (random.nextInt() & Integer.MAX_VALUE) % var0;
   }

   private short getStreamL(byte[] var1, int var2) {
      short var3;
      if (var2 == 0) {
         var2 = skip++;
         var3 = var1[var2];
      } else if (var2 == 1) {
         var2 = skip++;
         var3 = (short)(var1[var2] + 100);
      } else {
         int var4;
         if (var2 == 2) {
            var2 = skip++;
            var4 = var1[var2];
            var2 = skip++;
            var3 = (short)((var4 & 255) << 8 | var1[var2] & 255);
         } else {
            var2 = skip++;
            byte var5 = var1[var2];
            var4 = skip++;
            var3 = (short)(var5 & 255 | (var1[var4] & 255) << 8);
         }
      }

      return var3;
   }

   public static Ms i() {
      if (msListener == null) {
         msListener = new Ms();
      }

      return msListener;
   }

   public short[] byteArrayToShortArray(byte[] var1) {
      skip = 0;
      int var3 = var1.length >> 1;
      short[] var4 = new short[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         var4[var2] = this.getStreamL(var1, 2);
      }

      return var4;
   }

   public void correctSelect(byte[] var1, int var2, int var3) {
      if (var1[0] < var2) {
         var1[1] = (byte)(var1[0] - var3 + 1);
      } else {
         var1[0] = (byte)(var2 - 1);
         var1[1] = (byte)(var2 - var3);
      }

      if (var1[0] < 0) {
         var1[0] = 0;
      }

      if (var1[1] < 0) {
         var1[1] = 0;
      }

   }

   public byte[][] create2Array(byte[] var1) {
      int var2 = skip++;
      byte[][] var3 = new byte[this.getLen_byte(var1[var2])][];

      for(var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = this.createArray(var1);
      }

      return var3;
   }

   public byte[][][] create3Array(byte[] var1) {
      int var2 = skip++;
      byte[][][] var3 = new byte[this.getLen_byte(var1[var2])][][];

      for(var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = this.create2Array(var1);
      }

      return var3;
   }

   public byte[][][][] create4Array(byte[] var1) {
      int var2 = skip++;
      byte[][][][] var3 = new byte[this.getLen_byte(var1[var2])][][][];

      for(var2 = 0; var2 < var3.length; ++var2) {
         var3[var2] = this.create3Array(var1);
      }

      return var3;
   }

   public byte[] createArray(byte[] var1) {
      int var2 = skip++;
      byte[] var4 = new byte[this.getLen_byte(var1[var2])];

      for(var2 = 0; var2 < var4.length; ++var2) {
         int var3 = skip++;
         var4[var2] = var1[var3];
      }

      return var4;
   }

   Image createCellImage(Image var1, int var2, int var3, int var4, int var5) {
      return this.createImage(var1, var2 % (var1.getWidth() / var3) * var3, var2 % (var1.getHeight() / var4) * var4, var3, var4, var5);
   }

   public Image createImage(String var1) {
      Image var4;
      try {
         StringBuilder var2 = new StringBuilder("/");
         var4 = Image.createImage(var2.append(var1).append(".png").toString());
      } catch (Exception var3) {
         var4 = null;
      }

      return var4;
   }

   public Image createImage(String var1, int var2) {
      byte[] var3 = this.getStream(var1, var2);
      return Image.createImage(var3, 0, var3.length);
   }

   Image createImage(Image var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = var4;
      if (var2 + var4 > var1.getWidth()) {
         var7 = var1.getWidth() - var2;
      }

      var4 = var5;
      if (var3 + var5 > var1.getHeight()) {
         var4 = var1.getHeight() - var3;
      }

      return Image.createImage(var1, var2, var3, var7, var4, this.transA[var6]);
   }

   public Image[] createImageArray(int var1, String var2) {
      Image[] var3 = new Image[var1];

      for(short var4 = 0; var4 < var3.length; ++var4) {
         var3[var4] = this.createImage(var2 + var4);
      }

      return var3;
   }

   public Image[] createImageArray_(int var1, String var2, int var3) {
      Image[] var4 = new Image[var1];

      for(short var5 = 0; var5 < var4.length; ++var5) {
         var4[var5] = this.createImage_(var2 + var5, var3);
      }

      return var4;
   }

   public Image createImage_(String var1, int var2) {
      Image var5;
      try {
         StringBuilder var3 = new StringBuilder("/");
         var5 = Image.createImage(var3.append(var1).append(".png").toString(), var2);
      } catch (Exception var4) {
         var5 = null;
      }

      return var5;
   }

   public int[] createIntArray(byte[] var1) {
      int[] var7 = new int[this.getStreamL(var1, 0)];

      for(int var2 = 0; var2 < var7.length; ++var2) {
         int var3 = skip++;
         byte var8 = var1[var3];
         int var4 = skip++;
         byte var9 = var1[var4];
         int var5 = skip++;
         byte var6 = var1[var5];
         var5 = skip++;
         var7[var2] = var8 & 255 | (var9 & 255) << 8 | (var6 & 255) << 16 | (var1[var5] & 255) << 24;
      }

      return var7;
   }

   public short[][] createShort2Array(byte[] var1, int var2) {
      short[][] var4 = new short[this.getStreamL(var1, var2)][];

      for(int var3 = 0; var3 < var4.length; ++var3) {
         var4[var3] = this.createShortArray(var1, var2);
      }

      return var4;
   }

   public short[][][] createShort3Array(byte[] var1, int var2) {
      short[][][] var4 = new short[this.getStreamL(var1, var2)][][];

      for(int var3 = 0; var3 < var4.length; ++var3) {
         var4[var3] = this.createShort2Array(var1, var2);
      }

      return var4;
   }

   public short[] createShortArray(byte[] var1, int var2) {
      short[] var5 = new short[this.getStreamL(var1, var2)];

      for(int var3 = 0; var3 < var5.length; ++var3) {
         byte var4;
         if (var2 == 2) {
            var4 = 2;
         } else {
            var4 = -1;
         }

         var5[var3] = this.getStreamL(var1, var4);
      }

      return var5;
   }

   public Sprite createSprite(String var1, boolean var2) {
      byte[] var3 = this.getStream(var1 + ".data", -1);
      skip = 0;
      Sprite var4;
      if (var2) {
         var4 = Sprite.Create(this.createImage(var1), this.create2Array(var3), this.create3Array(var3), this.create3Array(var3));
      } else {
         var4 = Sprite.Create(this.createImage(var1), this.createShort2Array(var3, 2), this.createShort3Array(var3, 2), this.createShort3Array(var3, 2));
      }

      return var4;
   }

   public StringBuffer[][] createString2Array(byte[] var1) {
      int var2 = skip++;
      StringBuffer[][] var3 = new StringBuffer[var1[var2]][];

      for(byte var4 = 0; var4 < var3.length; ++var4) {
         var3[var4] = this.createStringArray(var1);
      }

      return var3;
   }

   public StringBuffer[] createStringArray(byte[] var1) {
      int var2 = skip++;
      StringBuffer[] var5 = new StringBuffer[this.getLen_byte(var1[var2])];

      for(byte var6 = 0; var6 < var5.length; ++var6) {
         byte var4 = var1[skip];
         short var3 = var4;
         if (var4 < 0) {
            var3 = (short)(var4 + 256);
         }

         var5[var6] = new StringBuffer(this.getDialogs(var1, skip + 1, var3));
         skip += var3 * 2 + 1;
      }

      return var5;
   }

   public StringBuffer createStringArrayOne(byte[] var1) {
      return new StringBuffer(this.getDialogs(var1, 2, this.getLen_byte(var1[1])));
   }

   public boolean equals(StringBuffer var1, String var2) {
      return var1.toString().equals(var2);
   }

   public String getDialogs(byte[] var1, int var2, int var3) {
      StringBuffer var5 = new StringBuffer();

      for(int var4 = 0; var4 < var3; ++var4) {
         var5.append((char)(var1[(var4 << 1) + var2] << 8 | var1[(var4 << 1) + var2 + 1] & 255));
      }

      return var5.toString();
   }

   public byte[] getEventNowData(short[][] var1) {
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      var4.write(var1.length);

      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] == null) {
            var4.write(0);
         } else {
            var4.write(var1[var2].length);

            for(int var3 = 0; var3 < var1[var2].length; ++var3) {
               var4.write(var1[var2][var3] & 255);
               var4.write(var1[var2][var3] >> 8 & 255);
            }
         }
      }

      return var4.toByteArray();
   }

   public int getInt(byte[] var1, int var2) {
      return (var1[var2] & 255) << 24 | (var1[var2 + 1] & 255) << 16 | (var1[var2 + 2] & 255) << 8 | var1[var2 + 3] & 255;
   }

   public int getLen_byte(byte var1) {
      if (var1 < 0) {
         var1 += 256;
      }

      return var1;
   }

   public int getLen_short(short var1) {
      if (var1 < 0) {
         var1 += 65536;
      }

      return var1;
   }

   public byte getMin(byte var1, byte var2) {
      if (var1 > var2) {
         var1 = var2;
      }

      return var1;
   }

   public String getPrecision(int var1) {
      return var1 / 10 + "." + var1 % 10;
   }

   public short getShort(byte[] var1, int var2) {
      return (short)((var1[var2] & 255) << 8 | var1[var2 + 1] & 255);
   }

   public int getSleep() {
      return this.sleep_time;
   }

   public byte[] getStream(String var1, int var2) {
      byte[] var5 = (byte[])null;
      byte[] var4 = var5;

      Exception var10000;
      byte[] var17;
      label92: {
         DataInputStream var6;
         boolean var10001;
         try {
            var6 = new DataInputStream;
         } catch (Exception var16) {
            var10000 = var16;
            var10001 = false;
            break label92;
         }

         var4 = var5;

         StringBuilder var7;
         try {
            var7 = new StringBuilder;
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label92;
         }

         var4 = var5;

         try {
            var7.<init>("/");
         } catch (Exception var14) {
            var10000 = var14;
            var10001 = false;
            break label92;
         }

         var4 = var5;

         try {
            var6.<init>(AndroidUtil.getResourceAsStream(var7.append(var1).toString()));
         } catch (Exception var13) {
            var10000 = var13;
            var10001 = false;
            break label92;
         }

         if (var2 > -1) {
            var4 = var5;

            try {
               var6.readByte();
            } catch (Exception var12) {
               var10000 = var12;
               var10001 = false;
               break label92;
            }

            for(byte var3 = 0; var3 < var2; ++var3) {
               var4 = var5;

               try {
                  var6.skip((long)this.getLen_short(var6.readShort()));
               } catch (Exception var11) {
                  var10000 = var11;
                  var10001 = false;
                  break label92;
               }
            }
         }

         var4 = var5;

         try {
            var17 = new byte[this.getLen_short(var6.readShort())];
         } catch (Exception var10) {
            var10000 = var10;
            var10001 = false;
            break label92;
         }

         var4 = var17;

         try {
            var6.read(var17);
         } catch (Exception var9) {
            var10000 = var9;
            var10001 = false;
            break label92;
         }

         var4 = var17;

         try {
            var6.close();
            return var17;
         } catch (Exception var8) {
            var10000 = var8;
            var10001 = false;
         }
      }

      Exception var18 = var10000;
      var18.printStackTrace();
      var17 = var4;
      return var17;
   }

   public int getStringWidth(String var1) {
      return font.stringWidth(var1);
   }

   public StringBuffer[] groupString(String var1, int var2) {
      StringBuffer[] var15 = new StringBuffer[30];
      StringBuffer var12 = new StringBuffer();
      StringBuffer var16 = new StringBuffer(var1);
      short var10 = (short)var1.length();
      byte var3 = 0;
      byte var11 = (byte)this.getStringWidth("#0");
      byte var8 = -1;
      boolean var4 = false;
      var1 = "";

      StringBuffer var14;
      for(int var5 = 0; var5 < var10; var12 = var14) {
         int var9;
         String var13;
         byte var18;
         if (var16.charAt(0) == '#') {
            if (var16.charAt(1) == 'n') {
               var4 = true;
            } else {
               var1 = "#" + var16.charAt(1);
               var12.append(var1);
               ++var3;
            }

            var16.deleteCharAt(0);
            var16.deleteCharAt(0);
            var9 = var5 + 1;
            var13 = var1;
            var18 = var3;
         } else {
            var12.append(var16.charAt(0));
            int var6;
            boolean var7;
            if (var2 != 0 && this.getStringWidth(var12.toString()) <= var11 * var3 + var2) {
               var16.deleteCharAt(0);
               var7 = var4;
               var6 = var5;
            } else if (var2 != 0) {
               var6 = var5 - 1;
               var12.deleteCharAt(var12.length() - 1);
               var7 = true;
            } else {
               var16.deleteCharAt(0);
               var6 = var5;
               var7 = var4;
            }

            var9 = var6;
            var4 = var7;
            var18 = var3;
            var13 = var1;
            if (var6 == var10 - 1) {
               var9 = var6;
               var4 = var7;
               var18 = var3;
               var13 = var1;
               if (!var7) {
                  var4 = true;
                  var9 = var6;
                  var18 = var3;
                  var13 = var1;
               }
            }
         }

         boolean var19 = var4;
         byte var20 = var8;
         var3 = var18;
         var14 = var12;
         if (var4) {
            var20 = (byte)(var8 + 1);
            if (var13.length() == 0) {
               var3 = 0;
            } else {
               var3 = 1;
            }

            var3 = (byte)var3;
            var19 = false;
            var15[var20] = var12;
            var14 = new StringBuffer();
            var14.append(var13);
         }

         var5 = var9 + 1;
         var4 = var19;
         var8 = var20;
         var1 = var13;
      }

      StringBuffer[] var17 = new StringBuffer[var8 + 1];
      System.arraycopy(var15, 0, var17, 0, var8 + 1);
      StringBuffer[] var21 = (StringBuffer[])null;
      return var17;
   }

   public boolean isRect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      boolean var9;
      if (var1 < var5 + var7 && var1 + var3 > var5 && var2 < var6 + var8 && var2 + var4 > var6) {
         var9 = true;
      } else {
         var9 = false;
      }

      return var9;
   }

   public void keyRelease() {
      keyRepeat = false;
      key_delay = 0;
      key_time = 10;
   }

   public boolean key_Down() {
      boolean var1;
      if (key == -2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Left() {
      boolean var1;
      if (key == -3) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Left_Right() {
      boolean var1;
      if (key != -3 && key != -4) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean key_Num0() {
      boolean var1;
      if (key == 48) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Num1() {
      boolean var1;
      if (key == 49) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Num3() {
      boolean var1;
      if (key == 51) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Num9() {
      boolean var1;
      if (key == 57) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Right() {
      boolean var1;
      if (key == -4) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_S1() {
      boolean var1;
      if (key == -6) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_S1_Num5() {
      boolean var1;
      if (key != -6 && key != 53 && key != -5) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean key_S2() {
      boolean var1;
      if (key == -7) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Up() {
      boolean var1;
      if (key == -1) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean key_Up_Down() {
      boolean var1;
      if (key != -1 && key != -2) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean key_delay() {
      boolean var1;
      if (key_delay == 0) {
         key_delay = key_time;
         if (key_time > 1) {
            --key_time;
         }

         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public String[] loadText(byte[] var1) {
      Exception var10000;
      String[] var17;
      label98: {
         StringBuffer var6;
         boolean var10001;
         try {
            var6 = new StringBuffer("");
         } catch (Exception var15) {
            var10000 = var15;
            var10001 = false;
            break label98;
         }

         int var2 = 2;

         int var3;
         int var4;
         int var5;
         String var16;
         Vector var20;
         while(true) {
            try {
               if (var2 >= var1.length) {
                  var16 = var6.toString();
                  var20 = new Vector();
                  break;
               }
            } catch (Exception var14) {
               var10000 = var14;
               var10001 = false;
               break label98;
            }

            var5 = var2 + 1;
            var3 = var1[var2];
            var2 = var3;
            if (var3 < 0) {
               var2 = var3 + 256;
            }

            var4 = var5 + 1;
            byte var19 = var1[var5];
            var3 = var19;
            if (var19 < 0) {
               var3 = var19 + 256;
            }

            try {
               var6.append((char)((var3 << 8) + var2));
            } catch (Exception var13) {
               var10000 = var13;
               var10001 = false;
               break label98;
            }

            var2 = var4;
         }

         var3 = 0;
         var2 = 0;
         var5 = 0;

         while(true) {
            try {
               if (var5 >= var16.length()) {
                  var17 = new String[var20.size()];
                  break;
               }
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label98;
            }

            label101: {
               label102: {
                  try {
                     if (var16.charAt(var5) == '\n') {
                        break label102;
                     }
                  } catch (Exception var12) {
                     var10000 = var12;
                     var10001 = false;
                     break label98;
                  }

                  var4 = var3;

                  try {
                     if (var5 != var16.length()) {
                        break label101;
                     }
                  } catch (Exception var11) {
                     var10000 = var11;
                     var10001 = false;
                     break label98;
                  }
               }

               try {
                  var20.addElement(var16.substring(var3, var2));
               } catch (Exception var9) {
                  var10000 = var9;
                  var10001 = false;
                  break label98;
               }

               var4 = var2 + 1;
            }

            ++var2;
            ++var5;
            var3 = var4;
         }

         var2 = 0;

         while(true) {
            try {
               if (var2 >= var20.size()) {
                  return var17;
               }
            } catch (Exception var8) {
               var10000 = var8;
               var10001 = false;
               break;
            }

            try {
               var17[var2] = (String)var20.elementAt(var2);
            } catch (Exception var7) {
               var10000 = var7;
               var10001 = false;
               break;
            }

            ++var2;
         }
      }

      Exception var18 = var10000;
      var18.printStackTrace();
      var17 = null;
      return var17;
   }

   public short mathPercent(int var1, int var2, int var3) {
      int var4 = var3;
      if (var3 < 1) {
         var4 = 1;
      }

      return (short)(var1 * var2 / var4);
   }

   public short mathSpeedDown(int var1, int var2, boolean var3) {
      if (var1 / var2 != 0) {
         var1 -= var1 / var2;
      } else if (var3 && var1 > 0) {
         --var1;
      } else if (var3 && var1 < 0) {
         ++var1;
      } else {
         var1 = 0;
      }

      return (short)var1;
   }

   public short mathSpeedN(int var1, int var2, int var3, boolean var4) {
      if (var1 > var2 && var1 - var3 > var2) {
         var1 -= var3;
      } else if (var1 < var2 && var1 + var3 < var2) {
         var1 += var3;
      } else if (var4 && var1 > var2) {
         --var1;
      } else if (var4 && var1 < var2) {
         ++var1;
      } else {
         var1 = var2;
      }

      return (short)var1;
   }

   public short mathSpeedUp(int var1, int var2, int var3) {
      var1 -= (var2 - var1) / var3;
      if (var1 < 0) {
         var1 = 0;
      }

      return (short)var1;
   }

   public void putInt(int var1, byte[] var2, int var3) {
      var2[var3] = (byte)(var1 >> 24 & 255);
      var2[var3 + 1] = (byte)(var1 >> 16 & 255);
      var2[var3 + 2] = (byte)(var1 >> 8 & 255);
      var2[var3 + 3] = (byte)(var1 & 255);
   }

   public void putShort(int var1, byte[] var2, int var3) {
      var2[var3] = (byte)(var1 >> 8 & 255);
      var2[var3 + 1] = (byte)(var1 & 255);
   }

   public void putShort(byte[] var1, int var2) {
      int var3 = skip++;
      var1[var3] = (byte)(var2 >> 8 & 255);
      var3 = skip++;
      var1[var3] = (byte)(var2 >> 0 & 255);
   }

   public short[][] readEventNowData() {
      short[][] var3 = (short[][])null;
      ByteArrayInputStream var5 = new ByteArrayInputStream(this.rmsOptions(12, (byte[])null, 1));
      short[][] var4 = new short[var5.read()][];

      for(int var1 = 0; var1 < var4.length; ++var1) {
         int var2 = var5.read();
         if (var2 != 0) {
            var4[var1] = new short[var2];

            for(var2 = 0; var2 < var4[var1].length; ++var2) {
               var4[var1][var2] = (short)(var5.read() | var5.read() << 8);
            }
         }
      }

      return var4;
   }

   public byte[] rmsOptions(int var1, byte[] var2, int var3) {
      label73: {
         Exception var10000;
         label76: {
            boolean var10001;
            try {
               if (rms == null) {
                  rms = RecordStore.openRecordStore("pk5_caihong", true);
               }
            } catch (Exception var10) {
               var10000 = var10;
               var10001 = false;
               break label76;
            }

            try {
               if (rms.getNumRecords() == 0) {
                  this.setRmsInit(true);
               }
            } catch (Exception var9) {
               var10000 = var9;
               var10001 = false;
               break label76;
            }

            if (var3 == 0) {
               break label73;
            }

            if (var3 == 1) {
               try {
                  var2 = rms.getRecord(var1);
                  return var2;
               } catch (Exception var4) {
                  var10000 = var4;
                  var10001 = false;
               }
            } else if (var3 == 2) {
               try {
                  rms.setRecord(var1, var2, 0, var2.length);
                  break label73;
               } catch (Exception var8) {
                  var10000 = var8;
                  var10001 = false;
               }
            } else if (var3 == 3) {
               try {
                  this.setRmsInit(false);
                  break label73;
               } catch (Exception var6) {
                  var10000 = var6;
                  var10001 = false;
               }
            } else if (var3 == 4) {
               try {
                  if (rms != null) {
                     rms.closeRecordStore();
                     rms = null;
                  }
                  break label73;
               } catch (Exception var7) {
                  var10000 = var7;
                  var10001 = false;
               }
            } else {
               label85: {
                  if (var3 != 5) {
                     break label73;
                  }

                  try {
                     StringBuilder var12 = new StringBuilder();
                     Log.e("rms.getSizeAvailable() = ", var12.append(rms.getSizeAvailable()).toString());
                  } catch (Exception var5) {
                     var10000 = var5;
                     var10001 = false;
                     break label85;
                  }

                  var2 = null;
                  return var2;
               }
            }
         }

         Exception var11 = var10000;
         var11.printStackTrace();
      }

      var2 = null;
      return var2;
   }

   public void runDelay() {
      if (key_delay > 0) {
         --key_delay;
      }

   }

   public byte select(int var1, int var2, int var3) {
      byte var4;
      if (var3 == 0) {
         var4 = (byte)var1;
      } else {
         label19: {
            int var5 = var1;
            if (abs(key) % 2 == 1) {
               --var1;
               var5 = var1;
               if (var1 < var2) {
                  var1 = var3;
                  break label19;
               }
            }

            var1 = var5;
            if (abs(key) % 2 == 0) {
               ++var5;
               var1 = var5;
               if (var5 > var3) {
                  var1 = var2;
               }
            }
         }

         var4 = (byte)var1;
      }

      return var4;
   }

   public void selectS(byte[] var1, int var2, int var3, int var4) {
      if (var3 != 0) {
         var1[0] = this.select(var1[0], var2, var3 - 1);
         if (var1[1] - 1 == var1[0]) {
            --var1[1];
         } else if (var1[1] + var4 == var1[0]) {
            ++var1[1];
         } else if (var1[0] == var3 - 1) {
            if (var3 - var2 >= var4) {
               var2 = var3 - var4;
            }

            var1[1] = (byte)var2;
         } else if (var1[0] == var2) {
            var1[1] = (byte)var2;
         }
      }

   }

   public void setRmsInit(boolean var1) throws Exception {
      byte[] var4 = new byte[140];
      var4[0] = -1;
      byte[] var3 = new byte[280];

      for(int var2 = 0; var2 < 83; ++var2) {
         if (var1 || var2 != 4) {
            if (var2 != 12) {
               if (var1) {
                  rms.addRecord(var4, 0, var4.length);
               } else {
                  rms.setRecord(var2 + 1, var4, 0, var4.length);
               }
            } else if (var1) {
               rms.addRecord(var3, 0, var3.length);
            } else {
               rms.setRecord(var2 + 1, var3, 0, var3.length);
            }
         }
      }

      var3 = (byte[])null;
   }

   public void setSprite(Sprite var1, String var2, boolean var3) {
      byte[] var4 = this.getStream(var2 + ".data", -1);
      skip = 0;
      var1.nullIMFA();
      if (var3) {
         var1.Set(this.createImage(var2), this.create2Array(var4), this.create3Array(var4), this.create3Array(var4));
      } else {
         var1.Set(this.createImage(var2), this.createShort2Array(var4, 2), this.createShort3Array(var4, 2), this.createShort3Array(var4, 2));
      }

      byte[] var5 = (byte[])null;
   }

   public byte[] shortArrayToByteArray(short[] var1) {
      skip = 0;
      int var3 = var1.length;
      byte[] var4 = new byte[var3 << 1];

      for(int var2 = 0; var2 < var3; ++var2) {
         this.putShort(var4, var1[var2]);
      }

      return var4;
   }

   public void sleep(int var1) {
      this.sleep_time = var1;
   }

   public int sqrt(int var1) {
      if (var1 > 0) {
         int var2 = 10000;

         int var3;
         int var4;
         do {
            var4 = var2;
            var3 = var1 * 10000 / var2 + var2 >> 1;
            var2 = var3;
         } while(var3 < var4);

         var1 = var4 / 100;
      } else {
         var1 = 0;
      }

      return var1;
   }
}
