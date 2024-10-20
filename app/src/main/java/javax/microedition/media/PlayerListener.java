package javax.microedition.media;

/* loaded from: classes.dex */
/**
 * The PlayerListener interface provides a mechanism to receive notifications 
 * about various events related to a media player. Implementations of this 
 * interface can be registered with a Player to handle these events.
 * 
 * <p>Event types include:</p>
 * <ul>
 *   <li>{@link #CLOSED} - Indicates that the player has been closed.</li>
 *   <li>{@link #DEVICE_AVAILABLE} - Indicates that a device has become available.</li>
 *   <li>{@link #DEVICE_UNAVAILABLE} - Indicates that a device has become unavailable.</li>
 *   <li>{@link #DURATION_UPDATED} - Indicates that the duration of the media has been updated.</li>
 *   <li>{@link #END_OF_MEDIA} - Indicates that the media has reached its end.</li>
 *   <li>{@link #ERROR} - Indicates that an error has occurred.</li>
 *   <li>{@link #STARTED} - Indicates that the player has started.</li>
 *   <li>{@link #STOPPED} - Indicates that the player has stopped.</li>
 *   <li>{@link #VOLUME_CHANGED} - Indicates that the volume has changed.</li>
 * </ul>
 * 
 * <p>Implementations of this interface must provide the {@link #playerUpdate(Player, String, Object)} 
 * method to handle these events.</p>
 */
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

    void playerUpdate(Player player, String str, Object obj);
}
