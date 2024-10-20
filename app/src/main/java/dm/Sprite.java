/*
 * Decompiled with CFR.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Image
 */
package dm;

import javax.microedition.lcdui.Image;

public class Sprite {
    private byte[][][] action_byte = null;
    private short[][][] action_short = null;
    private byte[][][] frame_byte = null;
    private short[][][] frame_short = null;
    public Image img;
    private byte[][] module_byte = null;
    private short[][] module_short = null;
    private boolean type = true;

    public Sprite() {
        this.nullIMFA();
    }

    public static Sprite Create(Image image, byte[][] byArray, byte[][][] byArray2, byte[][][] byArray3) {
        Sprite sprite = new Sprite();
        sprite.type = true;
        sprite.img = image;
        sprite.module_byte = byArray;
        sprite.frame_byte = byArray2;
        sprite.action_byte = byArray3;
        return sprite;
    }

    public static Sprite Create(Image image, short[][] sArray, short[][][] sArray2, short[][][] sArray3) {
        Sprite sprite = new Sprite();
        sprite.type = false;
        sprite.img = image;
        sprite.module_short = sArray;
        sprite.frame_short = sArray2;
        sprite.action_short = sArray3;
        return sprite;
    }

    public void Set(Image image, byte[][] byArray, byte[][][] byArray2, byte[][][] byArray3) {
        this.nullIMFA();
        this.type = true;
        this.img = image;
        this.module_byte = byArray;
        this.frame_byte = byArray2;
        this.action_byte = byArray3;
    }

    public void Set(Image image, short[][] sArray, short[][][] sArray2, short[][][] sArray3) {
        this.nullIMFA();
        this.type = false;
        this.img = image;
        this.module_short = sArray;
        this.frame_short = sArray2;
        this.action_short = sArray3;
    }

    /*
     * Enabled force condition propagation
     */
    public int aLength() {
        if (!this.type) return this.action_short.length;
        return this.action_byte.length;
    }

    /*
     * Enabled force condition propagation
     */
    public int aLength(int n) {
        if (!this.type) return this.action_short[n].length;
        return this.action_byte[n].length;
    }

    /*
     * Enabled force condition propagation
     */
    public int action(int n, int n2, int n3) {
        if (!this.type) return this.action_short[n][n2][n3];
        return this.action_byte[n][n2][n3];
    }

    /*
     * Enabled force condition propagation
     */
    public int fLength(int n) {
        if (!this.type) return this.frame_short[n].length;
        return this.frame_byte[n].length;
    }

    /*
     * Enabled force condition propagation
     */
    public int frame(int n, int n2, int n3) {
        if (!this.type) return this.frame_short[n][n2][n3];
        return this.frame_byte[n][n2][n3];
    }

    /*
     * Enabled force condition propagation
     */
    public int module(int n, int n2) {
        if (!this.type) return this.module_short[n][n2];
        return this.module_byte[n][n2];
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
