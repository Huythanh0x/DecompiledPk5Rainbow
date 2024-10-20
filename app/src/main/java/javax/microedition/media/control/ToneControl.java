package javax.microedition.media.control;

import javax.microedition.media.Control;

/* loaded from: classes.dex */
/**
 * The {@code ToneControl} class provides constants for controlling tone generation.
 * It implements the {@code Control} interface.
 * <p>
 * This class defines various byte constants that can be used to control the playback
 * of tones, such as starting and ending blocks, setting volume, and specifying tempo.
 * </p>
 */
public class ToneControl implements Control {

    /**
     * Indicates the end of a block.
     */
    public static byte BLOCK_END = -6;

    /**
     * Indicates the start of a block.
     */
    public static byte BLOCK_START = -5;

    /**
     * Represents the MIDI note number for middle C (C4).
     */
    public static byte C4 = 60;

    /**
     * Indicates the playback of a block.
     */
    public static byte PLAY_BLOCK = -7;

    /**
     * Indicates a repeat command.
     */
    public static byte REPEAT = -9;

    /**
     * Represents the resolution of the tone sequence.
     */
    public static byte RESOLUTION = -4;

    /**
     * Indicates a command to set the volume.
     */
    public static byte SET_VOLUME = -8;

    /**
     * Represents a silence or rest in the tone sequence.
     */
    public static byte SILENCE = -1;

    /**
     * Indicates a command to set the tempo.
     */
    public static byte TEMPO = -3;

    /**
     * Represents the version of the tone sequence format.
     */
    public static byte VERSION = -2;
}
