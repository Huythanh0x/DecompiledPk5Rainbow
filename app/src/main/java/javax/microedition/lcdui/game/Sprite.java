package javax.microedition.lcdui.game;

/* loaded from: classes.dex */
/**
 * The {@code Sprite} class extends the {@code Layer} class and provides
 * constants for various transformation types that can be applied to a sprite.
 * These transformations include mirroring and rotating the sprite.
 * <p>
 * The available transformation constants are:
 * <ul>
 *   <li>{@code TRANS_NONE}: No transformation (value: 0)</li>
 *   <li>{@code TRANS_MIRROR}: Mirror transformation (value: 2)</li>
 *   <li>{@code TRANS_MIRROR_ROT180}: Mirror and rotate 180 degrees (value: 1)</li>
 *   <li>{@code TRANS_MIRROR_ROT270}: Mirror and rotate 270 degrees (value: 4)</li>
 *   <li>{@code TRANS_MIRROR_ROT90}: Mirror and rotate 90 degrees (value: 7)</li>
 *   <li>{@code TRANS_ROT180}: Rotate 180 degrees (value: 3)</li>
 *   <li>{@code TRANS_ROT270}: Rotate 270 degrees (value: 6)</li>
 *   <li>{@code TRANS_ROT90}: Rotate 90 degrees (value: 5)</li>
 * </ul>
 */
public class Sprite extends Layer {
    public static final int TRANS_MIRROR = 2;
    public static final int TRANS_MIRROR_ROT180 = 1;
    public static final int TRANS_MIRROR_ROT270 = 4;
    public static final int TRANS_MIRROR_ROT90 = 7;
    public static final int TRANS_NONE = 0;
    public static final int TRANS_ROT180 = 3;
    public static final int TRANS_ROT270 = 6;
    public static final int TRANS_ROT90 = 5;
}
