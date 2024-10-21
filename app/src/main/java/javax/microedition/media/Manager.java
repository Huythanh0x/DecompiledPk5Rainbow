package javax.microedition.media.Manager;
import java.lang.String;
import java.lang.Object;
import javax.microedition.media.Player;

public class Manager	// class@00014a from classes.dex
{
    private static boolean islocator;
    private static final String[] supportedContentTypes;
    private static final String[] supportedProtocols;

    static {
       Manager.islocator = false;
       String[] stringArray = new String[]{"audio/x-wav","audio/basic","audio/mpeg","audio/midi","audio/x-tone-seq","audio/amr"};
       Manager.supportedContentTypes = stringArray;
       stringArray = new String[]{"http://","rtsp://"};
       Manager.supportedProtocols = stringArray;
    }
    public void Manager(){
       super();
    }
    public static Player createPlayer(String locator){
       Manager.islocator = true;
       String typeName = "";
       if (!locator.endsWith(".mid") && !locator.endsWith(".midi")) {
          if (locator.endsWith(".wav")) {
             typeName = "audio/x-wav";
          }else if(!locator.endsWith(".mpeg") && !locator.endsWith(".mp3")){
             if (locator.endsWith(".amr")) {
                typeName = "audio/amr";
             }
          }else {
             typeName = "audio/mpeg";
          }
       }else {
          typeName = "audio/midi";
       }
       Player player = new Player();
       player.setDatasource(locator);
       player.setType(typeName);
       return player;
    }
    public static Player createPlayer(String sound,String type){
       int i = -1;
       Manager.islocator = false;
       String typeName = "";
       if (type.indexOf("mid") != i) {
          typeName = ".mid";
       }else if(type.indexOf("midi") != i){
          typeName = ".midi";
       }else if(type.indexOf("mpeg") != i){
          typeName = ".mp3";
       }else if(type.indexOf("amr") != i){
          typeName = ".amr";
       }
       Player player = new Player();
       if (!sound.indexOf(47)) {
          player.setDatasource(sound.substring(1, sound.length()));
       }else {
          player.setDatasource(sound);
       }
       player.setType(typeName);
       return player;
    }
    public static boolean getIsLocator(){
       return Manager.islocator;
    }
    public static String[] getSupportedContentTypes(String protocol){
       return Manager.supportedContentTypes;
    }
    public static String[] getSupportedProtocols(String content_type){
       return Manager.supportedProtocols;
    }
}
