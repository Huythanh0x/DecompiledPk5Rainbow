package javax.microedition.media;

import java.io.IOException;

public class Manager {
  private static boolean islocator = false;
  
  private static final String[] supportedContentTypes = new String[] { "audio/x-wav", "audio/basic", "audio/mpeg", "audio/midi", "audio/x-tone-seq", "audio/amr" };
  
  private static final String[] supportedProtocols = new String[] { "http://", "rtsp://" };
  
  public static Player createPlayer(String paramString) throws IOException, MediaException {
    islocator = true;
    String str = "";
    if (paramString.endsWith(".mid") || paramString.endsWith(".midi")) {
      str = "audio/midi";
      Player player1 = new Player();
      player1.setDatasource(paramString);
      player1.setType(str);
      return player1;
    } 
    if (paramString.endsWith(".wav")) {
      str = "audio/x-wav";
      Player player1 = new Player();
      player1.setDatasource(paramString);
      player1.setType(str);
      return player1;
    } 
    if (paramString.endsWith(".mpeg") || paramString.endsWith(".mp3")) {
      str = "audio/mpeg";
      Player player1 = new Player();
      player1.setDatasource(paramString);
      player1.setType(str);
      return player1;
    } 
    if (paramString.endsWith(".amr"))
      str = "audio/amr"; 
    Player player = new Player();
    player.setDatasource(paramString);
    player.setType(str);
    return player;
  }
  
  public static Player createPlayer(String paramString1, String paramString2) throws IOException, MediaException {
    islocator = false;
    String str = "";
    if (paramString2.indexOf("mid") != -1) {
      str = ".mid";
    } else if (paramString2.indexOf("midi") != -1) {
      str = ".midi";
    } else if (paramString2.indexOf("mpeg") != -1) {
      str = ".mp3";
    } else if (paramString2.indexOf("amr") != -1) {
      str = ".amr";
    } 
    Player player = new Player();
    if (paramString1.indexOf('/') == 0) {
      player.setDatasource(paramString1.substring(1, paramString1.length()));
      player.setType(str);
      return player;
    } 
    player.setDatasource(paramString1);
    player.setType(str);
    return player;
  }
  
  public static boolean getIsLocator() {
    return islocator;
  }
  
  public static String[] getSupportedContentTypes(String paramString) {
    return supportedContentTypes;
  }
  
  public static String[] getSupportedProtocols(String paramString) {
    return supportedProtocols;
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/media/Manager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */