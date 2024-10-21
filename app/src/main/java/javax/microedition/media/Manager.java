/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.MediaException
 *  javax.microedition.media.Player
 */
package javax.microedition.media;

import java.io.IOException;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

public class Manager {
    private static boolean islocator = false;
    private static final String[] supportedContentTypes = new String[]{"audio/x-wav", "audio/basic", "audio/mpeg", "audio/midi", "audio/x-tone-seq", "audio/amr"};
    private static final String[] supportedProtocols = new String[]{"http://", "rtsp://"};

    /*
     * Unable to fully structure code
     */
    public static Player createPlayer(String var0) throws IOException, MediaException {
        block3: {
            block2: {
                Manager.islocator = true;
                var1_1 = "";
                if (var0.endsWith(".mid") || var0.endsWith(".midi")) {
                    var1_1 = "audio/midi";
lbl5:
                    // 5 sources

                    while (true) {
                        var2_2 = new Player();
                        var2_2.setDatasource(var0);
                        var2_2.setType(var1_1);
                        return var2_2;
                    }
                }
                if (!var0.endsWith(".wav")) break block2;
                var1_1 = "audio/x-wav";
                ** GOTO lbl5
            }
            if (!var0.endsWith(".mpeg") && !var0.endsWith(".mp3")) break block3;
            var1_1 = "audio/mpeg";
            ** GOTO lbl5
        }
        if (!var0.endsWith(".amr")) ** GOTO lbl5
        var1_1 = "audio/amr";
        ** while (true)
    }

    /*
     * Unable to fully structure code
     */
    public static Player createPlayer(String var0, String var1_1) throws IOException, MediaException {
        block4: {
            block6: {
                block5: {
                    Manager.islocator = false;
                    var2_2 = "";
                    if (var1_1.indexOf("mid") != -1) {
                        var2_2 = ".mid";
lbl5:
                        // 5 sources

                        while (true) {
                            var1_1 = new Player();
                            if (var0.indexOf(47) == 0) {
                                var1_1.setDatasource(var0.substring(1, var0.length()));
lbl9:
                                // 2 sources

                                while (true) {
                                    var1_1.setType(var2_2);
                                    return var1_1;
                                }
                            }
                            break block4;
                            break;
                        }
                    }
                    if (var1_1.indexOf("midi") == -1) break block5;
                    var2_2 = ".midi";
                    ** GOTO lbl5
                }
                if (var1_1.indexOf("mpeg") == -1) break block6;
                var2_2 = ".mp3";
                ** GOTO lbl5
            }
            if (var1_1.indexOf("amr") == -1) ** GOTO lbl5
            var2_2 = ".amr";
            ** while (true)
        }
        var1_1.setDatasource(var0);
        ** while (true)
    }

    public static boolean getIsLocator() {
        return islocator;
    }

    public static String[] getSupportedContentTypes(String string) {
        return supportedContentTypes;
    }

    public static String[] getSupportedProtocols(String string) {
        return supportedProtocols;
    }
}
