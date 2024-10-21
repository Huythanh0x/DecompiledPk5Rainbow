package javax.microedition.media;

import java.io.IOException;

public class Manager {
   private static boolean islocator = false;
   private static final String[] supportedContentTypes = new String[]{"audio/x-wav", "audio/basic", "audio/mpeg", "audio/midi", "audio/x-tone-seq", "audio/amr"};
   private static final String[] supportedProtocols = new String[]{"http://", "rtsp://"};

   public Manager() {
      super();
   }

   public static Player createPlayer(String var0) throws IOException, MediaException {
      islocator = true;
      String var1 = "";
      if (!var0.endsWith(".mid") && !var0.endsWith(".midi")) {
         if (var0.endsWith(".wav")) {
            var1 = "audio/x-wav";
         } else if (!var0.endsWith(".mpeg") && !var0.endsWith(".mp3")) {
            if (var0.endsWith(".amr")) {
               var1 = "audio/amr";
            }
         } else {
            var1 = "audio/mpeg";
         }
      } else {
         var1 = "audio/midi";
      }

      Player var2 = new Player();
      var2.setDatasource(var0);
      var2.setType(var1);
      return var2;
   }

   public static Player createPlayer(String var0, String var1) throws IOException, MediaException {
      islocator = false;
      String var2 = "";
      if (var1.indexOf("mid") != -1) {
         var2 = ".mid";
      } else if (var1.indexOf("midi") != -1) {
         var2 = ".midi";
      } else if (var1.indexOf("mpeg") != -1) {
         var2 = ".mp3";
      } else if (var1.indexOf("amr") != -1) {
         var2 = ".amr";
      }

      Player var3 = new Player();
      if (var0.indexOf(47) == 0) {
         var3.setDatasource(var0.substring(1, var0.length()));
      } else {
         var3.setDatasource(var0);
      }

      var3.setType(var2);
      return var3;
   }

   public static boolean getIsLocator() {
      return islocator;
   }

   public static String[] getSupportedContentTypes(String var0) {
      return supportedContentTypes;
   }

   public static String[] getSupportedProtocols(String var0) {
      return supportedProtocols;
   }
}
