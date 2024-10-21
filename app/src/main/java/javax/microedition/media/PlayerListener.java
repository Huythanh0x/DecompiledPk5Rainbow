package javax.microedition.media;

public interface PlayerListener {
   String CLOSED = "closed";
   String DEVICE_AVAILABLE = "deviceAvailable";
   String DEVICE_UNAVAILABLE = "deviceUnavailable";
   String DURATION_UPDATED = "durationUpdated";
   String END_OF_MEDIA = "endOfMedia";
   String ERROR = "error";
   String STARTED = "started";
   String STOPPED = "stopped";
   String VOLUME_CHANGED = "volumeChanged";

   void playerUpdate(Player var1, String var2, Object var3);
}
