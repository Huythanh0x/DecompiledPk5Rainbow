package com.uc.paymentsdk.network;

import android.util.Log;

class AndroidHttpClient$LoggingConfiguration {
   private final int level;
   private final String tag;

   private AndroidHttpClient$LoggingConfiguration(String var1, int var2) {
      super();
      this.tag = var1;
      this.level = var2;
   }

   // $FF: synthetic method
   AndroidHttpClient$LoggingConfiguration(String var1, int var2, AndroidHttpClient$LoggingConfiguration var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static boolean access$0(AndroidHttpClient$LoggingConfiguration var0) {
      return var0.isLoggable();
   }

   // $FF: synthetic method
   static void access$1(AndroidHttpClient$LoggingConfiguration var0, String var1) {
      var0.println(var1);
   }

   private boolean isLoggable() {
      return Log.isLoggable(this.tag, this.level);
   }

   private void println(String var1) {
      Log.println(this.level, this.tag, var1);
   }
}
