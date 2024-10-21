/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Player
 */
package javax.microedition.media;

import javax.microedition.media.Player;

public interface PlayerListener {
    public static final String CLOSED = "closed";
    public static final String DEVICE_AVAILABLE = "deviceAvailable";
    public static final String DEVICE_UNAVAILABLE = "deviceUnavailable";
    public static final String DURATION_UPDATED = "durationUpdated";
    public static final String END_OF_MEDIA = "endOfMedia";
    public static final String ERROR = "error";
    public static final String STARTED = "started";
    public static final String STOPPED = "stopped";
    public static final String VOLUME_CHANGED = "volumeChanged";

    public void playerUpdate(Player var1, String var2, Object var3);
}
