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
    nullIMFA();
  }
  
  public static Sprite Create(Image paramImage, byte[][] paramArrayOfbyte, byte[][][] paramArrayOfbyte1, byte[][][] paramArrayOfbyte2) {
    Sprite sprite = new Sprite();
    sprite.type = true;
    sprite.img = paramImage;
    sprite.module_byte = paramArrayOfbyte;
    sprite.frame_byte = paramArrayOfbyte1;
    sprite.action_byte = paramArrayOfbyte2;
    return sprite;
  }
  
  public static Sprite Create(Image paramImage, short[][] paramArrayOfshort, short[][][] paramArrayOfshort1, short[][][] paramArrayOfshort2) {
    Sprite sprite = new Sprite();
    sprite.type = false;
    sprite.img = paramImage;
    sprite.module_short = paramArrayOfshort;
    sprite.frame_short = paramArrayOfshort1;
    sprite.action_short = paramArrayOfshort2;
    return sprite;
  }
  
  public void Set(Image paramImage, byte[][] paramArrayOfbyte, byte[][][] paramArrayOfbyte1, byte[][][] paramArrayOfbyte2) {
    nullIMFA();
    this.type = true;
    this.img = paramImage;
    this.module_byte = paramArrayOfbyte;
    this.frame_byte = paramArrayOfbyte1;
    this.action_byte = paramArrayOfbyte2;
  }
  
  public void Set(Image paramImage, short[][] paramArrayOfshort, short[][][] paramArrayOfshort1, short[][][] paramArrayOfshort2) {
    nullIMFA();
    this.type = false;
    this.img = paramImage;
    this.module_short = paramArrayOfshort;
    this.frame_short = paramArrayOfshort1;
    this.action_short = paramArrayOfshort2;
  }
  
  public int aLength() {
    return this.type ? this.action_byte.length : this.action_short.length;
  }
  
  public int aLength(int paramInt) {
    return this.type ? (this.action_byte[paramInt]).length : (this.action_short[paramInt]).length;
  }
  
  public int action(int paramInt1, int paramInt2, int paramInt3) {
    return this.type ? this.action_byte[paramInt1][paramInt2][paramInt3] : this.action_short[paramInt1][paramInt2][paramInt3];
  }
  
  public int fLength(int paramInt) {
    return this.type ? (this.frame_byte[paramInt]).length : (this.frame_short[paramInt]).length;
  }
  
  public int frame(int paramInt1, int paramInt2, int paramInt3) {
    return this.type ? this.frame_byte[paramInt1][paramInt2][paramInt3] : this.frame_short[paramInt1][paramInt2][paramInt3];
  }
  
  public int module(int paramInt1, int paramInt2) {
    return this.type ? this.module_byte[paramInt1][paramInt2] : this.module_short[paramInt1][paramInt2];
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


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/dm/Sprite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */