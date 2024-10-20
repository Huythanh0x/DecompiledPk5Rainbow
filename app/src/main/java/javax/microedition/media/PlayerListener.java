package javax.microedition.media.PlayerListener;
import javax.microedition.media.Player;
import java.lang.String;
import java.lang.Object;

public interface abstract PlayerListener	// class@00014d from classes.dex
{
    public static final String CLOSED = "closed";
    public static final String DEVICE_AVAILABLE = "deviceAvailable";
    public static final String DEVICE_UNAVAILABLE = "deviceUnavailable";
    public static final String DURATION_UPDATED = "durationUpdated";
    public static final String END_OF_MEDIA = "endOfMedia";
    public static final String ERROR = "error";
    public static final String STARTED = "started";
    public static final String STOPPED = "stopped";
    public static final String VOLUME_CHANGED = "volumeChanged";

    void playerUpdate(Player p0,String p1,Object p2);
}
