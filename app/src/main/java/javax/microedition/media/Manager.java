package javax.microedition.media;

import java.io.IOException;

/* loaded from: classes.dex */
/**
 * The Manager class provides methods to create and manage media players.
 * It supports various audio content types and protocols.
 */
public class Manager {
    private static boolean islocator = false;
    private static final String[] supportedContentTypes = {"audio/x-wav", "audio/basic", "audio/mpeg", "audio/midi", "audio/x-tone-seq", "audio/amr"};
    private static final String[] supportedProtocols = {"http://", "rtsp://"};

    /**
     * Creates a Player instance for the given sound and type.
     *
     * @param sound the sound source
     * @param type the type of the sound
     * @return a Player instance
     * @throws IOException if an I/O error occurs
     * @throws MediaException if a media error occurs
     */
    public static Player createPlayer(String sound, String type) throws IOException, MediaException {
        islocator = false;
        String typeName = "";
        if (type.indexOf("mid") != -1) {
            typeName = ".mid";
        } else if (type.indexOf("midi") != -1) {
            typeName = ".midi";
        } else if (type.indexOf("mpeg") != -1) {
            typeName = ".mp3";
        } else if (type.indexOf("amr") != -1) {
            typeName = ".amr";
        }
        Player player = new Player();
        if (sound.indexOf(47) == 0) {
            player.setDatasource(sound.substring(1, sound.length()));
        } else {
            player.setDatasource(sound);
        }
        player.setType(typeName);
        return player;
    }

    /**
     * Creates a Player instance for the given locator.
     *
     * @param locator the locator of the media
     * @return a Player instance
     * @throws IOException if an I/O error occurs
     * @throws MediaException if a media error occurs
     */
    public static Player createPlayer(String locator) throws IOException, MediaException {
        islocator = true;
        String typeName = "";
        if (locator.endsWith(".mid") || locator.endsWith(".midi")) {
            typeName = "audio/midi";
        } else if (locator.endsWith(".wav")) {
            typeName = "audio/x-wav";
        } else if (locator.endsWith(".mpeg") || locator.endsWith(".mp3")) {
            typeName = "audio/mpeg";
        } else if (locator.endsWith(".amr")) {
            typeName = "audio/amr";
        }
        Player player = new Player();
        player.setDatasource(locator);
        player.setType(typeName);
        return player;
    }

    /**
     * Returns the supported content types for the given protocol.
     *
     * @param protocol the protocol to check
     * @return an array of supported content types
     */
    public static String[] getSupportedContentTypes(String protocol) {
        return supportedContentTypes;
    }

    /**
     * Returns the supported protocols for the given content type.
     *
     * @param content_type the content type to check
     * @return an array of supported protocols
     */
    public static String[] getSupportedProtocols(String content_type) {
        return supportedProtocols;
    }

    /**
     * Returns whether the current player was created with a locator.
     *
     * @return true if the player was created with a locator, false otherwise
     */
    public static boolean getIsLocator() {
        return islocator;
    }
}
