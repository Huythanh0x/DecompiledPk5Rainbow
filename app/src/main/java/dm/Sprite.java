package dm;

import javax.microedition.lcdui.Image;

public class Sprite
{
    private byte[][][] action_byte;
    private short[][][] action_short;
    private byte[][][] frame_byte;
    private short[][][] frame_short;
    public Image img;
    private byte[][] module_byte;
    private short[][] module_short;
    private boolean type;
    
    public Sprite() {
        super();
        this.type = true;
        this.module_byte = null;
        this.frame_byte = null;
        this.action_byte = null;
        this.module_short = null;
        this.frame_short = null;
        this.action_short = null;
        this.nullIMFA();
    }
    
    public static Sprite Create(final Image img, final byte[][] module_byte, final byte[][][] frame_byte, final byte[][][] action_byte) {
        final Sprite sprite = new Sprite();
        sprite.type = true;
        sprite.img = img;
        sprite.module_byte = module_byte;
        sprite.frame_byte = frame_byte;
        sprite.action_byte = action_byte;
        return sprite;
    }
    
    public static Sprite Create(final Image img, final short[][] module_short, final short[][][] frame_short, final short[][][] action_short) {
        final Sprite sprite = new Sprite();
        sprite.type = false;
        sprite.img = img;
        sprite.module_short = module_short;
        sprite.frame_short = frame_short;
        sprite.action_short = action_short;
        return sprite;
    }
    
    public void Set(final Image img, final byte[][] module_byte, final byte[][][] frame_byte, final byte[][][] action_byte) {
        this.nullIMFA();
        this.type = true;
        this.img = img;
        this.module_byte = module_byte;
        this.frame_byte = frame_byte;
        this.action_byte = action_byte;
    }
    
    public void Set(final Image img, final short[][] module_short, final short[][][] frame_short, final short[][][] action_short) {
        this.nullIMFA();
        this.type = false;
        this.img = img;
        this.module_short = module_short;
        this.frame_short = frame_short;
        this.action_short = action_short;
    }
    
    public int aLength() {
        int n;
        if (this.type) {
            n = this.action_byte.length;
        }
        else {
            n = this.action_short.length;
        }
        return n;
    }
    
    public int aLength(int n) {
        if (this.type) {
            n = this.action_byte[n].length;
        }
        else {
            n = this.action_short[n].length;
        }
        return n;
    }
    
    public int action(int n, final int n2, final int n3) {
        if (this.type) {
            n = this.action_byte[n][n2][n3];
        }
        else {
            n = this.action_short[n][n2][n3];
        }
        return n;
    }
    
    public int fLength(int n) {
        if (this.type) {
            n = this.frame_byte[n].length;
        }
        else {
            n = this.frame_short[n].length;
        }
        return n;
    }
    
    public int frame(int n, final int n2, final int n3) {
        if (this.type) {
            n = this.frame_byte[n][n2][n3];
        }
        else {
            n = this.frame_short[n][n2][n3];
        }
        return n;
    }
    
    public int module(int n, final int n2) {
        if (this.type) {
            n = this.module_byte[n][n2];
        }
        else {
            n = this.module_short[n][n2];
        }
        return n;
    }
    
    public void nullIMFA() {
        this.img = null;
        this.module_byte = null;
        this.frame_byte = null;
        this.action_byte = null;
        this.module_short = null;
        this.frame_short = null;
        this.action_short = null;
    }
}
