package javax.microedition.media;

import java.io.IOException;

public class Manager
{
    private static boolean islocator;
    private static final String[] supportedContentTypes;
    private static final String[] supportedProtocols;
    
    static {
        Manager.islocator = false;
        supportedContentTypes = new String[] { "audio/x-wav", "audio/basic", "audio/mpeg", "audio/midi", "audio/x-tone-seq", "audio/amr" };
        supportedProtocols = new String[] { "http://", "rtsp://" };
    }
    
    public Manager() {
        super();
    }
    
    public static Player createPlayer(final String datasource) throws IOException, MediaException {
        Manager.islocator = true;
        String type = "";
        if (datasource.endsWith(".mid") || datasource.endsWith(".midi")) {
            type = "audio/midi";
        }
        else if (datasource.endsWith(".wav")) {
            type = "audio/x-wav";
        }
        else if (datasource.endsWith(".mpeg") || datasource.endsWith(".mp3")) {
            type = "audio/mpeg";
        }
        else if (datasource.endsWith(".amr")) {
            type = "audio/amr";
        }
        final Player player = new Player();
        player.setDatasource(datasource);
        player.setType(type);
        return player;
    }
    
    public static Player createPlayer(final String datasource, final String s) throws IOException, MediaException {
        Manager.islocator = false;
        String type = "";
        if (s.indexOf("mid") != -1) {
            type = ".mid";
        }
        else if (s.indexOf("midi") != -1) {
            type = ".midi";
        }
        else if (s.indexOf("mpeg") != -1) {
            type = ".mp3";
        }
        else if (s.indexOf("amr") != -1) {
            type = ".amr";
        }
        final Player player = new Player();
        if (datasource.indexOf(47) == 0) {
            player.setDatasource(datasource.substring(1, datasource.length()));
        }
        else {
            player.setDatasource(datasource);
        }
        player.setType(type);
        return player;
    }
    
    public static boolean getIsLocator() {
        return Manager.islocator;
    }
    
    public static String[] getSupportedContentTypes(final String s) {
        return Manager.supportedContentTypes;
    }
    
    public static String[] getSupportedProtocols(final String s) {
        return Manager.supportedProtocols;
    }
}
