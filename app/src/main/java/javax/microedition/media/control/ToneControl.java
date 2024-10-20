package javax.microedition.media.control;

import javax.microedition.media.Control;

public class ToneControl implements Control
{
    public static byte BLOCK_END;
    public static byte BLOCK_START;
    public static byte C4;
    public static byte PLAY_BLOCK;
    public static byte REPEAT;
    public static byte RESOLUTION;
    public static byte SET_VOLUME;
    public static byte SILENCE;
    public static byte TEMPO;
    public static byte VERSION;
    
    static {
        ToneControl.BLOCK_END = -6;
        ToneControl.BLOCK_START = -5;
        ToneControl.C4 = 60;
        ToneControl.PLAY_BLOCK = -7;
        ToneControl.REPEAT = -9;
        ToneControl.RESOLUTION = -4;
        ToneControl.SET_VOLUME = -8;
        ToneControl.SILENCE = -1;
        ToneControl.TEMPO = -3;
        ToneControl.VERSION = -2;
    }
    
    public ToneControl() {
        super();
    }
}
