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
      super();
      this.nullIMFA();
   }

   public static Sprite Create(Image var0, byte[][] var1, byte[][][] var2, byte[][][] var3) {
      Sprite var4 = new Sprite();
      var4.type = true;
      var4.img = var0;
      var4.module_byte = var1;
      var4.frame_byte = var2;
      var4.action_byte = var3;
      return var4;
   }

   public static Sprite Create(Image var0, short[][] var1, short[][][] var2, short[][][] var3) {
      Sprite var4 = new Sprite();
      var4.type = false;
      var4.img = var0;
      var4.module_short = var1;
      var4.frame_short = var2;
      var4.action_short = var3;
      return var4;
   }

   public void Set(Image var1, byte[][] var2, byte[][][] var3, byte[][][] var4) {
      this.nullIMFA();
      this.type = true;
      this.img = var1;
      this.module_byte = var2;
      this.frame_byte = var3;
      this.action_byte = var4;
   }

   public void Set(Image var1, short[][] var2, short[][][] var3, short[][][] var4) {
      this.nullIMFA();
      this.type = false;
      this.img = var1;
      this.module_short = var2;
      this.frame_short = var3;
      this.action_short = var4;
   }

   public int aLength() {
      int var1;
      if (this.type) {
         var1 = this.action_byte.length;
      } else {
         var1 = this.action_short.length;
      }

      return var1;
   }

   public int aLength(int var1) {
      if (this.type) {
         var1 = this.action_byte[var1].length;
      } else {
         var1 = this.action_short[var1].length;
      }

      return var1;
   }

   public int action(int var1, int var2, int var3) {
      short var4;
      if (this.type) {
         var4 = this.action_byte[var1][var2][var3];
      } else {
         var4 = this.action_short[var1][var2][var3];
      }

      return var4;
   }

   public int fLength(int var1) {
      if (this.type) {
         var1 = this.frame_byte[var1].length;
      } else {
         var1 = this.frame_short[var1].length;
      }

      return var1;
   }

   public int frame(int var1, int var2, int var3) {
      short var4;
      if (this.type) {
         var4 = this.frame_byte[var1][var2][var3];
      } else {
         var4 = this.frame_short[var1][var2][var3];
      }

      return var4;
   }

   public int module(int var1, int var2) {
      short var3;
      if (this.type) {
         var3 = this.module_byte[var1][var2];
      } else {
         var3 = this.module_short[var1][var2];
      }

      return var3;
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
