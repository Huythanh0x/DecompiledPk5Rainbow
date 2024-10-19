package dm;

import javax.microedition.lcdui.Image;

/* loaded from: classes.dex */
public class Sprite {
    public Image img;
    private boolean type = true;
    private byte[][] module_byte = null;
    private byte[][][] frame_byte = null;
    private byte[][][] action_byte = null;
    private short[][] module_short = null;
    private short[][][] frame_short = null;
    private short[][][] action_short = null;

    public Sprite() {
        nullIMFA();
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

    public static Sprite Create(Image _img, byte[][] _module, byte[][][] _frame, byte[][][] _action) {
        Sprite sp = new Sprite();
        sp.type = true;
        sp.img = _img;
        sp.module_byte = _module;
        sp.frame_byte = _frame;
        sp.action_byte = _action;
        return sp;
    }

    public void Set(Image _img, byte[][] _module, byte[][][] _frame, byte[][][] _action) {
        nullIMFA();
        this.type = true;
        this.img = _img;
        this.module_byte = _module;
        this.frame_byte = _frame;
        this.action_byte = _action;
    }

    public static Sprite Create(Image _img, short[][] _module, short[][][] _frame, short[][][] _action) {
        Sprite sp = new Sprite();
        sp.type = false;
        sp.img = _img;
        sp.module_short = _module;
        sp.frame_short = _frame;
        sp.action_short = _action;
        return sp;
    }

    public void Set(Image _img, short[][] _module, short[][][] _frame, short[][][] _action) {
        nullIMFA();
        this.type = false;
        this.img = _img;
        this.module_short = _module;
        this.frame_short = _frame;
        this.action_short = _action;
    }

    public int module(int i, int j) {
        return this.type ? this.module_byte[i][j] : this.module_short[i][j];
    }

    public int frame(int i, int j, int k) {
        return this.type ? this.frame_byte[i][j][k] : this.frame_short[i][j][k];
    }

    public int action(int i, int j, int k) {
        return this.type ? this.action_byte[i][j][k] : this.action_short[i][j][k];
    }

    public int aLength(int i) {
        return this.type ? this.action_byte[i].length : this.action_short[i].length;
    }

    public int aLength() {
        return this.type ? this.action_byte.length : this.action_short.length;
    }

    public int fLength(int i) {
        return this.type ? this.frame_byte[i].length : this.frame_short[i].length;
    }
}
