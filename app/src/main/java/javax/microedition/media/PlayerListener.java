package javax.microedition.media;

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
  
  void playerUpdate(Player paramPlayer, String paramString, Object paramObject);
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/javax/microedition/media/PlayerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */