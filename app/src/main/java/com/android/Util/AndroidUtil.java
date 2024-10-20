package com.android.Util;

import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.ConditionVariable;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import javax.microedition.lcdui.CwaActivity;

public class AndroidUtil {
   private static final String LOG = "PIC_ERROR";
   public static int SCREEN_HEIGHT;
   public static int SCREEN_WIDTH;
   private static AudioManager aManager;
   public static AssetManager am = CwaActivity.getInstance().getAssets();
   public static ConditionVariable cv = new ConditionVariable(true);

   public AndroidUtil() {
      super();
   }

   public static int getCurrentMusic() {
      int var0;
      if (CwaActivity.getContextInstance() != null) {
         aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
         var0 = aManager.getStreamVolume(3);
      } else {
         var0 = -1;
      }

      return var0;
   }

   public static InputStream getResourceAsStream(String var0) {
      InputStream var1 = null;
      InputStream var2 = var1;

      label75: {
         IOException var10000;
         label66: {
            boolean var10001;
            label67: {
               label68: {
                  try {
                     if (var0.indexOf(47) != 0) {
                        break label68;
                     }
                  } catch (IOException var9) {
                     var10000 = var9;
                     var10001 = false;
                     break label66;
                  }

                  var2 = var1;

                  try {
                     var1 = am.open(var0.substring(1, var0.length()));
                     break label67;
                  } catch (IOException var8) {
                     var10000 = var8;
                     var10001 = false;
                     break label66;
                  }
               }

               var2 = var1;

               try {
                  var1 = am.open(var0);
               } catch (IOException var7) {
                  var10000 = var7;
                  var10001 = false;
                  break label66;
               }
            }

            var2 = var1;
            if (var1 != null) {
               return var2;
            }

            var2 = var1;

            StringBuilder var3;
            try {
               var3 = new StringBuilder;
            } catch (IOException var6) {
               var10000 = var6;
               var10001 = false;
               break label66;
            }

            var2 = var1;

            try {
               var3.<init>(String.valueOf(var0));
            } catch (IOException var5) {
               var10000 = var5;
               var10001 = false;
               break label66;
            }

            var2 = var1;

            try {
               Log.e("PIC_ERROR", var3.append(" is not exist").toString());
               break label75;
            } catch (IOException var4) {
               var10000 = var4;
               var10001 = false;
            }
         }

         IOException var10 = var10000;
         Log.e("PIC_ERROR", var0 + " is not exist");
         var10.printStackTrace();
         return var2;
      }

      var2 = var1;
      return var2;
   }

   public static void setMusic(int var0) {
      if (CwaActivity.getContextInstance() != null) {
         aManager = (AudioManager)CwaActivity.getContextInstance().getSystemService("audio");
         aManager.setStreamVolume(3, var0, 16);
      }

   }
}
