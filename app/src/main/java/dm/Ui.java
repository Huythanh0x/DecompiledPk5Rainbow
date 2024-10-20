package dm;

import android.util.Log;
import com.nokia.mid.ui.DirectGraphics;
import com.nokia.mid.ui.DirectUtils;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import main.Constants_H;

public class Ui {
   public static DirectGraphics dg;
   public static Graphics g;
   private static final short[] transforms;
   private static Ui uiListener;
   private int[] MIRROR;
   private byte[][] MIRROR2;
   private byte[] MIRROR3;
   public byte cTriangle;
   private byte rz;
   private Image ui_img;
   private short[][] ui_modules;

   static {
      short[] var0 = new short[]{0, 5, 3, 6, 2, 4, 1, 7};
      transforms = var0;
   }

   public Ui() {
      super();
      byte[] var1 = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
      byte[] var2 = new byte[]{4, 5, 6, 7, 0, 1, 2, 3};
      this.MIRROR2 = new byte[][]{var1, var2};
      this.MIRROR3 = new byte[]{1, -1};
      this.MIRROR = new int[]{4 | 16, 8 | 16};
      this.cTriangle = 0;
      uiListener = this;
   }

   public static Ui i() {
      if (uiListener == null) {
         uiListener = new Ui();
      }

      return uiListener;
   }

   public boolean drawActionOne(Sprite var1, int var2, int var3, int var4, byte[] var5, int var6, boolean var7) {
      this.drawFrameOne(var1, var1.action(var2, var5[0], 0), var3, var4, var6);
      byte var8 = (byte)(var5[1] + 1);
      var5[1] = var8;
      if (var8 > var1.action(var2, var5[0], 1)) {
         var5[1] = 0;
         var8 = (byte)(var5[0] + 1);
         var5[0] = var8;
         if (var8 >= var1.aLength(var2)) {
            if (!var7) {
               var5[0] = (byte)(var1.aLength(var2) - 1);
               var7 = true;
               return var7;
            }

            var5[0] = 0;
         }
      }

      var7 = false;
      return var7;
   }

   public void drawBDir(int var1, int var2, int var3, int var4) {
      g.setColor(8310516);
      g.drawRect(var1, var2, var3 * 3, var4 << 1);
      g.drawRect(var1 + var3, var2, var3, var4 << 1);
      g.drawLine((float)var1, (float)(var2 + var4), (float)(var3 * 3 + var1), (float)(var2 + var4));
   }

   public void drawBarOne(int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 16125468;
      if (var6 == 1) {
         var7 = 55551;
      } else if (var6 == 2) {
         var7 = 60177;
      }

      this.fillRect(4067649, var1 + 1, var2, var3 - 1, 5);
      g.drawRect(var1, var2 + 1, var3, 5 - 3);
      var3 = 5 - 2;
      this.fillRect(16752385, var1 + 1, var2 + 1, var4, var3);
      if (var4 <= var5) {
         var5 = var4;
      }

      this.fillRect(var7, var1 + 1, var2 + 1, var5, var3);
   }

   public void drawFrameOne(Sprite var1, int var2, int var3, int var4, int var5) {
      for(short var6 = 0; var6 < var1.fLength(var2); ++var6) {
         this.drawModuleOne(var1, var1.frame(var2, var6, 0), var3 + var1.frame(var2, var6, 1) * this.MIRROR3[var5], var4 + var1.frame(var2, var6, 2), var5, var1.frame(var2, var6, 3));
      }

   }

   public void drawImage(Image var1, int var2, int var3, int var4) {
      g.drawImage(var1, var2, var3, var4);
   }

   public void drawImage(Image var1, int var2, int var3, int var4, int var5) {
      if (var5 == 0) {
         g.drawImage(var1, var2, var3, var4);
      } else {
         dg.drawImage(var1, var2, var3, var4, var5);
      }

   }

   public void drawK(int var1, int var2, int var3, int var4, int var5) {
      if (var5 == 0) {
         var5 = 15400191;
      } else if (var5 == 1) {
         var5 = 12352252;
      } else if (var5 == 2) {
         var5 = 12313343;
      } else if (var5 == 3) {
         var5 = 5228543;
      } else if (var5 == 4) {
         var5 = 30975;
      } else {
         var5 = 11121884;
      }

      g.setColor(var5);
      g.fillRect(var1 + 1, var2, var3 - 2, var4);
      g.fillRect(var1, var2 + 1, var3, var4 - 2);
   }

   public void drawK0(int var1, int var2, int var3, int var4, int var5) {
      byte var6 = (byte)var5;
      if (var5 == 2) {
         var5 = 15400191;
      } else {
         var5 = 1908277;
      }

      g.setColor(var5);
      g.drawRect(var1 + 1, var2, var3 - 3, var4 - 1);
      g.drawRect(var1, var2 + 1, var3 - 1, var4 - 3);
      this.drawK(var1 + 1, var2 + 1, var3 - 2, var4 - 2, var6);
   }

   public void drawK1(int var1, int var2, int var3, int var4, int var5) {
      Graphics var7 = g;
      int var6;
      if (var5 == 0) {
         var6 = 5461075;
      } else {
         var6 = 1908277;
      }

      var7.setColor(var6);
      g.drawRect(var1, var2 + 2, var3, var4 - 3);
      g.drawLine((float)(var1 + 1), (float)(var2 + var4), (float)(var1 + var3 - 1), (float)(var2 + var4));
      if (var5 != 0 && var5 != 1) {
         if (var5 == 2) {
            var5 = 13892607;
         } else if (var5 == 3) {
            var5 = 7727871;
         } else {
            var5 = 12352252;
         }
      } else {
         var5 = 15400191;
      }

      g.setColor(var5);
      g.fillRect(var1 + 1, var2, var3 - 2, var4);
      g.fillRect(var1, var2 + 1, var3, var4 - 2);
   }

   public void drawK2(int var1, int var2, int var3, int var4, int var5) {
      if (var5 == 0) {
      }

      g.setColor(0);
      g.fillRect(var1, var2, var3, var4);
      g.setColor(30975);
      g.fillRect(var1 + 2, var2 + 2, var3 - 4, var4 - 4);
   }

   public void drawK3(int var1, int var2, int var3, int var4) {
      this.drawK0(var1, var2, var3 - 1, var4 - 1, 0);
      g.setColor(1908277);
      g.fillRect(var1 + 2, var2 + 2, var3 - 2, var4 - 2);
   }

   public void drawK4(int var1, int var2, int var3, int var4) {
      g.setColor(16771373);
      g.drawLine((float)(var1 + 1), (float)var2, (float)(var1 + var3 - 2), (float)var2);
      g.drawLine((float)(var1 + 1), (float)(var2 + var4 - 1), (float)(var1 + var3 - 2), (float)(var2 + var4 - 1));
      g.drawLine((float)var1, (float)(var2 + 1), (float)var1, (float)(var2 + var4 - 2));
      g.drawLine((float)(var1 + var3 - 1), (float)(var2 + 1), (float)(var1 + var3 - 1), (float)(var2 + var4 - 2));
      g.drawLine((float)var1, (float)(var2 + 1), (float)(var1 + 1), (float)(var2 + 1));
      g.drawLine((float)(var1 + var3 - 2), (float)(var2 + 1), (float)(var1 + var3 - 1), (float)(var2 + 1));
      g.drawLine((float)var1, (float)(var2 + var4 - 2), (float)(var1 + 1), (float)(var2 + var4 - 2));
      g.drawLine((float)(var1 + var3 - 2), (float)(var2 + var4 - 2), (float)(var1 + var3 - 2), (float)(var2 + var4 - 2));
   }

   public void drawKuang(int var1, int var2, int var3, int var4) {
      g.setColor(1908277);
      g.drawRect(var1 + 1, var2, var3 - 4, var4 - 2);
      g.drawRect(var1 + 2, var2 + 1, var3 - 4, var4 - 2);
      g.drawLine((float)var1, (float)(var2 + 1), (float)var1, (float)(var2 + var4 - 3));
      g.drawLine((float)(var1 + var3 - 1), (float)(var2 + 2), (float)(var1 + var3 - 1), (float)(var2 + var4 - 2));
      this.fillRect(15400191, var1 + 1, var2 + 1, var3 - 3, var4 - 3);
   }

   public void drawKuangAdorn(int var1, int var2, int var3, int var4, int var5) {
      if (var5 == 0) {
         g.setColor(1842484);
         g.drawRect(var1 + 20, var2 - 22, var3 - 21, 20);
         g.drawRect(var1 + 20, var2 - 22, var3 - 22, 21);
         this.fillRect(15129744, var1 + 20, var2 - 22, var3 - 22, 20);
         this.drawUi(33, var1, var2, 36, 0);
         this.drawUi(31, var1 + var3 - 4, var2, 36, 0);
      } else if (var5 == 1) {
         this.drawUi(32, var1, var2 - 7, 0, 0);
         this.drawUi(32, var1 + var3 + 5, var2 - 7, 8 | 16, 0);
         this.fillRect(13550445, var1 + 15, var2 - 5, var3 - 25, 13);
         this.fillRect(16116383, var1 + 15, var2 - 3, var3 - 25, 10);
         this.fillRect(13078326, var1 + 15, var2 + 10, var3 - 25, 5);
         this.drawLine(1842484, var1 + 15, var2 - 7, var1 + var3 - 11, var2 - 7);
         this.drawLine(16446403, var1 + 15, var2 - 6, var1 + var3 - 11, var2 - 6);
         this.drawLine(6168835, var1 + 15, var2 + 12, var1 + var3 - 11, var2 + 12);
         g.setColor(13281366);
         g.drawRect(var1 + 15, var2 + 8, var3 - 26, 1);
      } else if (var5 == 2) {
         this.drawUi(32, var1, var2 + var4 - 1, 36, 6);
         this.drawUi(32, var1 + var3 + 5, var2 + var4 - 1, 40, 6);
         this.fillRect(13550445, var1 + 15, var2 + var4 - 16, var3 - 25, 13);
         this.fillRect(16116383, var1 + 15, var2 + var4 - 15, var3 - 25, 10);
         this.fillRect(13078326, var1 + 15, var2 + var4 - 23, var3 - 25, 5);
         this.drawLine(1842484, var1 + 15, var2 + var4 - 2, var1 + var3 - 11, var2 + var4 - 2);
         this.drawLine(16446403, var1 + 15, var2 + var4 - 3, var1 + var3 - 11, var2 + var4 - 3);
         this.drawLine(6168835, var1 + 15, var2 + var4 - 21, var1 + var3 - 11, var2 + var4 - 21);
         g.setColor(13281366);
         g.drawRect(var1 + 15, var2 + var4 - 18, var3 - 26, 1);
      }

   }

   public void drawKuangMap(int var1, int var2, int var3, int var4, boolean var5) {
      int var6;
      if (var5) {
         var6 = 14961;
      } else {
         var6 = 16762112;
      }

      this.fillRect(var6, var1, var2, var3, var4);
      if (var5) {
         var6 = 6724095;
      } else {
         var6 = 11370036;
      }

      this.fillRect(var6, var1 + 1, var2 + 1, var3 - 2, var4 - 2);
   }

   public void drawKuangSelect(int var1, int var2, int var3, int var4, int var5) {
      int var6 = 13281366;
      if (var5 == 1) {
         var6 = 11370036;
      } else if (var5 == 2) {
         var6 = 2233088;
      } else if (var5 == 3) {
         var6 = 15129744;
      } else if (var5 == 4) {
         var6 = 16762112;
      } else if (var5 == 5) {
         var6 = 6168835;
      }

      g.setColor(var6);
      g.fillRect(var1 + 1, var2, var3 - 2, var4);
      g.drawRect(var1, var2 + 1, var3 - 1, var4 - 3);
   }

   public void drawLine(int var1, int var2, int var3, int var4, int var5) {
      g.setColor(var1);
      g.drawLine((float)var2, (float)var3, (float)var4, (float)var5);
   }

   public void drawListKY(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      for(byte var11 = 0; var11 < var1; ++var11) {
         if (var11 != var8) {
            this.drawK0(var2 + var5, var3 + (var6 + var7) * var11, var4 - (var5 << 1), var6, var10);
         }
      }

      if (var8 != -1) {
         this.drawK1(var2, var3 + (var6 + var7) * var8, var4, var6, var9);
      }

   }

   public void drawListSY(Object[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      for(byte var10 = 0; var10 < var1.length; ++var10) {
         String var12 = var1[var10].toString();
         int var11;
         if (var10 == var6) {
            var11 = var7;
         } else {
            var11 = var8;
         }

         this.drawString(var12, var2 + (var4 >> 1), var10 * var5 + var3 + 2, 17, var11, var9);
      }

      Log.e("sk", "drawListSY");
   }

   public void drawListSYHasSound(Object[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      for(byte var10 = 0; var10 < var1.length; ++var10) {
         String var13 = var1[var10].toString();
         byte var11;
         if (var1[var10].toString().equals("\u58f0\u97f3")) {
            var11 = 20;
         } else {
            var11 = 17;
         }

         int var12;
         if (var10 == var6) {
            var12 = var7;
         } else {
            var12 = var8;
         }

         this.drawString(var13, var2 + (var4 >> 1), var10 * var5 + var3 + 2, var11, var12, var9);
      }

   }

   public void drawModuleOne(Sprite var1, int var2, int var3, int var4, int var5, int var6) {
      this.drawRegion(var1.img, var1.module(var2, 0), var1.module(var2, 1), var1.module(var2, 2), var1.module(var2, 3), var3, var4, this.MIRROR[var5], this.MIRROR2[var5][var6], g);
   }

   public void drawNum(String var1, int var2, int var3, int var4, int var5) {
      if (var1.length() != 0) {
         int var7;
         if (var4 == 0) {
            var7 = 0;
         } else {
            var7 = var1.length() - 1;
         }

         byte var9 = (byte)var7;
         short var10 = 0;

         while(true) {
            byte var8;
            if (var5 == 0) {
               var8 = 8;
            } else if (var5 == 1) {
               var8 = 10;
            } else {
               var8 = 14;
            }

            short var11 = -1;
            char var6 = var1.charAt(var9);
            if (var6 >= '0' && var6 <= '9') {
               byte var13 = (byte)(var6 - 48);
               if (var5 == 0) {
                  var11 = (byte)(var13 + 10);
               } else if (var5 == 1) {
                  var11 = (byte)(var13 + 35);
               } else {
                  var11 = (byte)(var13 + 57);
               }
            } else if (var6 == '/') {
               var11 = 20;
            } else if (var6 == '-') {
               if (var5 == 2) {
                  var11 = 56;
               } else {
                  var11 = 46;
               }

               var11 = (byte)var11;
            } else if (var6 == '+') {
               var11 = 47;
            } else if (var6 == '%') {
               var11 = 45;
               var8 = 14;
            } else if (var6 == 32423) {
               var11 = 29;
               var8 = 12;
            }

            if (var11 != -1) {
               if (var4 == 0) {
                  this.drawUi(var11, var2 + var10, var3, 36, 0);
               } else {
                  this.drawUi(var11, var2 - var10, var3, 40, 0);
               }

               var11 = (short)(var10 + var8);
            } else {
               if (var4 == 0) {
                  this.drawString("" + var6, var2 + var10, var3 + 5, 36, 3, 0);
               } else {
                  this.drawString("" + var6, var2 - var10, var3 + 5, 40, 3, 0);
               }

               var11 = (short)(var10 + 25);
            }

            byte var12;
            if (var4 == 0) {
               var12 = (byte)(var9 + 1);
            } else {
               var12 = (byte)(var9 - 1);
            }

            if (var4 == 0) {
               var9 = var12;
               var10 = var11;
               if (var12 >= var1.length()) {
                  break;
               }
            } else {
               var9 = var12;
               var10 = var11;
               if (var12 <= -1) {
                  break;
               }
            }
         }
      }

   }

   public void drawRect(int var1, int var2, int var3, int var4, int var5) {
      g.setColor(var1);
      g.drawRect(var2, var3, var4, var5);
   }

   public void drawRectZ(int var1, int var2, int var3, int var4, int var5, int var6) {
      g.setColor(var1);
      Graphics var10 = g;
      Ms.i();
      int var9 = Ms.abs(this.rz);
      Ms.i();
      var1 = Ms.abs(this.rz);
      Ms.i();
      int var8 = Ms.abs(this.rz);
      Ms.i();
      var10.drawRect(var2 - var9, var3 - var1, (var8 << 1) + var4, (Ms.abs(this.rz) << 1) + var5);
      byte var7 = (byte)(this.rz + 1);
      this.rz = var7;
      if (var7 > var6) {
         this.rz = (byte)(-var6);
      }

   }

   public void drawRegion(Image var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, Graphics var10) {
      var10.drawRegion(var1, var2, var3, var4, var5, transforms[var9], var6, var7, var8);
   }

   public void drawString(String var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 13281366;
      int var8 = 3676168;
      int var9 = var3 + 1;
      switch (var5) {
         case 0:
            var3 = 0;
            var5 = 16777215;
            break;
         case 1:
            var3 = 5461075;
            var5 = 7727871;
            break;
         case 2:
            var3 = 2707928;
            var5 = 43016;
            break;
         case 3:
            var3 = 1908277;
            var5 = 24295;
            break;
         case 4:
            var3 = 1314307;
            var5 = 5228543;
            break;
         case 5:
            var3 = 2233603;
            var5 = 16739328;
            break;
         case 6:
            var3 = 8075577;
            var5 = 16189448;
            break;
         case 7:
            var3 = 4467457;
            var5 = 16757760;
            break;
         case 8:
            var3 = 10122756;
            var5 = 12583167;
            break;
         case 9:
            var3 = 11563064;
            var5 = 3676168;
            break;
         case 10:
            var3 = 1311269;
            var5 = 8816262;
            break;
         default:
            var5 = var8;
            var3 = var7;
      }

      if (var6 == 2) {
         g.setColor(var3);
         g.drawString(var1, var2 - 1, var9, var4);
         g.drawString(var1, var2 + 1, var9, var4);
         g.drawString(var1, var2, var9 - 1, var4);
         g.drawString(var1, var2, var9 + 1, var4);
         g.drawString(var1, var2 + 1, var9 + 1, var4);
         g.drawString(var1, var2 - 1, var9 + 1, var4);
         g.drawString(var1, var2 - 1, var9 - 1, var4);
         g.drawString(var1, var2 + 1, var9 - 1, var4);
      }

      g.setColor(var5);
      if (var6 == 1) {
         g.drawString(var1, var2 + 1, var9, var4);
      }

      g.drawString(var1, var2, var9, var4);
   }

   public void drawStringColor(String var1, int var2, int var3, int var4, int var5) {
      byte var6 = (byte)var4;
      byte var7 = 0;
      short var8 = 0;

      byte var12;
      do {
         var12 = (byte)var1.indexOf("#", var7);
         if (var12 != -1) {
            String var13 = var1.substring(var7, var12);
            this.drawString(var13, var2 + var8, var3, 0, var6, var5);
            short var9 = (short)(Ms.i().getStringWidth(var13) + var8);
            byte var11 = (byte)(Integer.parseInt(var1.substring(var12 + 1, var12 + 2)) - 1);
            byte var10 = (byte)(var12 + 2);
            var6 = var11;
            var7 = var10;
            var8 = var9;
            if (var11 == -1) {
               var6 = (byte)var4;
               var8 = var9;
               var7 = var10;
            }
         } else {
            this.drawString(var1.substring(var7, var1.length()), var2 + var8, var3, 0, var6, var5);
         }
      } while(var12 != -1);

   }

   public void drawStringY(Object[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      for(byte var9 = (byte)var4; var9 < var5 && var9 < var1.length; ++var9) {
         i().drawString(var1[var9].toString(), var2, var3 + (var9 - var4) * var6, 0, var7, var8);
      }

   }

   public void drawStringY(StringBuffer[] var1, int var2, int var3, int var4, int var5, int var6) {
      for(byte var7 = 0; var7 < var1.length; ++var7) {
         this.drawStringColor(var1[var7].toString(), var2, var3 + 4 + var7 * var4, var5, var6);
      }

   }

   public void drawTriangle(int var1, int var2, int var3, boolean var4, boolean var5) {
   }

   public void drawTriangle1(int var1, int var2, int var3, boolean var4, boolean var5) {
      Ms.i();
      this.drawUi(30, var1 - var3 - Ms.abs(this.cTriangle), var2, 4 | 2, 4);
      Ms.i();
      this.drawUi(30, Ms.abs(this.cTriangle) + var1 + var3, var2, 8 | 2, 0);
      if (var5) {
         byte var6 = (byte)(this.cTriangle + 1);
         this.cTriangle = var6;
         if (var6 > 4) {
            this.cTriangle = -3;
         }
      }

   }

   public void drawUi(int var1, int var2, int var3, int var4, int var5) {
      this.drawRegion(this.ui_img, this.ui_modules[var1][0], this.ui_modules[var1][1], this.ui_modules[var1][2], this.ui_modules[var1][3], var2, var3, var4, var5, g);
   }

   public void drawVolume(int var1, int var2, int var3, boolean var4) {
      Graphics var6 = g;
      int var5;
      if (var4) {
         var5 = 458827;
      } else {
         var5 = 11563064;
      }

      var6.setColor(var5);
      g.drawRect(var1 - 1 + 3, var2 + 5, 7, 10);
      g.drawRect(var1 + 5 + 2 + 3, var2 + 2, 7, 13);
      g.drawRect(var1 + 11 + 4 + 3, var2 - 1, 8, 16);
      var6 = g;
      if (var4) {
         var5 = 16048400;
      } else {
         var5 = 3676168;
      }

      var6.setColor(var5);
      g.drawRect(var1 + 3, var2 + 6, 6, 8);
      g.drawRect(var1 + 6 + 2 + 3, var2 + 3, 6, 11);
      g.drawRect(var1 + 12 + 4 + 3, var2, 6, 14);
      if (var3 > 0) {
         g.fillRect(var1 + 1 + 3, var2 + 7, 5, 7);
      }

      if (var3 > 30) {
         g.fillRect(var1 + 7 + 2 + 3, var2 + 4, 5, 10);
      }

      if (var3 > 60) {
         g.fillRect(var1 + 13 + 4 + 3, var2 + 1, 5, 13);
      }

   }

   public void drawYesNo(boolean var1, boolean var2) {
      if (var1) {
         this.drawUi(27, 0, 360, 36, 0);
      }

      if (var2) {
         this.drawUi(28, 640, 360, 40, 0);
      }

   }

   public void drawYesNo_(boolean var1, boolean var2) {
      if (var1) {
         this.drawUi(27, 0, Constants_H.HEIGHT, 36, 0);
      }

      if (var2) {
         this.drawUi(28, Constants_H.WIDTH, Constants_H.HEIGHT, 40, 0);
      }

   }

   public void drawYesNo__(boolean var1, boolean var2) {
      int var4 = Constants_H.WIDTH__;
      int var3 = Constants_H.HEIGHT__;
      if (var1) {
         this.drawUi(27, 0, var3, 36, 0);
      }

      if (var2) {
         this.drawUi(28, var4, var3, 40, 0);
      }

   }

   public void fillArc(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      g.setColor(var1);
      g.fillArc(var2, var3, var4, var5, var6, var7);
   }

   public void fillRect(int var1, int var2, int var3, int var4, int var5) {
      g.setColor(var1);
      g.fillRect(var2, var3, var4, var5);
   }

   public void fillRectB() {
      this.fillRect(5422575, 0, 0, 640, 360);
   }

   public void initGraphics(Graphics var1) {
      g = var1;
      dg = DirectUtils.getDirectGraphics(var1);
   }

   public void initUiModules() {
      this.ui_img = Ms.i().createImage("data/ui");
      Ms.i();
      Ms.skip = 0;
      this.ui_modules = Ms.i().createShort2Array(Ms.i().getStream("data/ui_m.d", -1), 0);
   }

   public void sliding(int var1, int var2, int var3, int var4, int var5, boolean var6) {
      if (!var6) {
         this.drawK(var1 - 2, var2 - 2, 10 + 4, var3 + 4, 0);
      }

      int var7;
      if (var6) {
         var7 = 0;
      } else {
         var7 = 3;
      }

      this.drawK(var1, var2, 10, var3, var7);
      if (var6) {
         var7 = 3;
      } else {
         var7 = 0;
      }

      this.drawK(var1, var2, 10, 11, var7);
      if (var6) {
         var7 = 3;
      } else {
         var7 = 0;
      }

      this.drawK(var1, var2 + var3 - 11, 10, 11, var7);
      var7 = var3 - 22;
      int var8 = var5 - 1;
      if (var8 < 1) {
         byte var9;
         if (var6) {
            var9 = 3;
         } else {
            var9 = 0;
         }

         this.drawK(var1 + 1, var2 + 12, 10 - 2, var7 - 2, var9);
      } else {
         short var12 = (byte)(var7 / (var8 + 1));
         byte var10 = (byte)var12;
         if (var12 < 15) {
            var10 = 15;
         }

         var12 = (short)((var7 - 2 - var10) * var4 / var8);
         byte var11;
         if (var6) {
            var11 = 3;
         } else {
            var11 = 0;
         }

         this.drawK(var1 + 1, var2 + 12 + var12, 10 - 2, var10, var11);
      }

   }
}
