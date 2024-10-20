package dm;

import javax.microedition.lcdui.Image;

/* loaded from: classes.dex */
/**
 * The Sprite class represents a graphical sprite with associated image and animation data.
 * It supports two types of data storage: byte arrays and short arrays.
 */
public class Sprite {

    /**
     * The image associated with the sprite.
     */
    public Image img;

    /**
     * Indicates the type of data storage used.
     * True for byte arrays, false for short arrays.
     */
    private boolean type;

    /**
     * Byte array representation of module data.
     */
    private byte[][] module_byte;

    /**
     * Byte array representation of frame data.
     */
    private byte[][][] frame_byte;

    /**
     * Byte array representation of action data.
     */
    private byte[][][] action_byte;

    /**
     * Short array representation of module data.
     */
    private short[][] module_short;

    /**
     * Short array representation of frame data.
     */
    private short[][][] frame_short;

    /**
     * Short array representation of action data.
     */
    private short[][][] action_short;

    /**
     * Constructor for the Sprite class.
     * Initializes all data to null.
     */
    public Sprite() {
        nullIMFA();
    }

    /**
     * Sets all image and animation data to null.
     */
    public void nullIMFA() {
        this.img = null;
        this.module_byte = null;
        this.frame_byte = null;
        this.action_byte = null;
        this.module_short = null;
        this.frame_short = null;
        this.action_short = null;
    }

    /**
     * Creates a new Sprite instance with byte array data.
     *
     * @param _img The image associated with the sprite.
     * @param _module The module data in byte array format.
     * @param _frame The frame data in byte array format.
     * @param _action The action data in byte array format.
     * @return A new Sprite instance.
     */
    public static Sprite Create(Image _img, byte[][] _module, byte[][][] _frame, byte[][][] _action) {
        Sprite sp = new Sprite();
        sp.type = true;
        sp.img = _img;
        sp.module_byte = _module;
        sp.frame_byte = _frame;
        sp.action_byte = _action;
        return sp;
    }

    /**
     * Sets the sprite's data using byte arrays.
     *
     * @param _img The image associated with the sprite.
     * @param _module The module data in byte array format.
     * @param _frame The frame data in byte array format.
     * @param _action The action data in byte array format.
     */
    public void Set(Image _img, byte[][] _module, byte[][][] _frame, byte[][][] _action) {
        nullIMFA();
        this.type = true;
        this.img = _img;
        this.module_byte = _module;
        this.frame_byte = _frame;
        this.action_byte = _action;
    }

    /**
     * Creates a new Sprite instance with short array data.
     *
     * @param _img The image associated with the sprite.
     * @param _module The module data in short array format.
     * @param _frame The frame data in short array format.
     * @param _action The action data in short array format.
     * @return A new Sprite instance.
     */
    public static Sprite Create(Image _img, short[][] _module, short[][][] _frame, short[][][] _action) {
        Sprite sp = new Sprite();
        sp.type = false;
        sp.img = _img;
        sp.module_short = _module;
        sp.frame_short = _frame;
        sp.action_short = _action;
        return sp;
    }

    /**
     * Sets the sprite's data using short arrays.
     *
     * @param _img The image associated with the sprite.
     * @param _module The module data in short array format.
     * @param _frame The frame data in short array format.
     * @param _action The action data in short array format.
     */
    public void Set(Image _img, short[][] _module, short[][][] _frame, short[][][] _action) {
        nullIMFA();
        this.type = false;
        this.img = _img;
        this.module_short = _module;
        this.frame_short = _frame;
        this.action_short = _action;
    }

    /**
     * Retrieves the module data at the specified indices.
     *
     * @param i The first index.
     * @param j The second index.
     * @return The module data at the specified indices.
     */
    public int module(int i, int j) {
        return this.type ? this.module_byte[i][j] : this.module_short[i][j];
    }

    /**
     * Retrieves the frame data at the specified indices.
     *
     * @param i The first index.
     * @param j The second index.
     * @param k The third index.
     * @return The frame data at the specified indices.
     */
    public int frame(int i, int j, int k) {
        return this.type ? this.frame_byte[i][j][k] : this.frame_short[i][j][k];
    }

    /**
     * Retrieves the action data at the specified indices.
     *
     * @param i The first index.
     * @param j The second index.
     * @param k The third index.
     * @return The action data at the specified indices.
     */
    public int action(int i, int j, int k) {
        return this.type ? this.action_byte[i][j][k] : this.action_short[i][j][k];
    }

    /**
     * Retrieves the length of the action data at the specified index.
     *
     * @param i The index.
     * @return The length of the action data at the specified index.
     */
    public int aLength(int i) {
        return this.type ? this.action_byte[i].length : this.action_short[i].length;
    }

    /**
     * Retrieves the total length of the action data.
     *
     * @return The total length of the action data.
     */
    public int aLength() {
        return this.type ? this.action_byte.length : this.action_short.length;
    }

    /**
     * Retrieves the length of the frame data at the specified index.
     *
     * @param i The index.
     * @return The length of the frame data at the specified index.
     */
    public int fLength(int i) {
        return this.type ? this.frame_byte[i].length : this.frame_short[i].length;
    }
}

