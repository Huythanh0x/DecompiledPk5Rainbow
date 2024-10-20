package main;

public class MD5 {
   String hex_chr = "0123456789abcdef";

   public MD5() {
      super();
   }

   private int add(int var1, int var2) {
      return (var1 & Integer.MAX_VALUE) + (Integer.MAX_VALUE & var2) ^ var1 & Integer.MIN_VALUE ^ var2 & Integer.MIN_VALUE;
   }

   private int cmn(int var1, int var2, int var3, int var4, int var5, int var6) {
      return this.add(this.rol(this.add(this.add(var2, var1), this.add(var4, var6)), var5), var3);
   }

   private int ff(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return this.cmn(~var2 & var4 | var2 & var3, var1, var2, var5, var6, var7);
   }

   private int gg(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return this.cmn(~var4 & var3 | var2 & var4, var1, var2, var5, var6, var7);
   }

   private int hh(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return this.cmn(var2 ^ var3 ^ var4, var1, var2, var5, var6, var7);
   }

   private int ii(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      return this.cmn(var3 ^ (~var4 | var2), var1, var2, var5, var6, var7);
   }

   private String rhex(int var1) {
      String var3 = "";

      for(int var2 = 0; var2 <= 3; ++var2) {
         var3 = var3 + this.hex_chr.charAt(var1 >> var2 * 8 + 4 & 15) + this.hex_chr.charAt(var1 >> var2 * 8 & 15);
      }

      return var3;
   }

   private int rol(int var1, int var2) {
      return var1 << var2 | var1 >>> 32 - var2;
   }

   private int[] str2blks_MD5(String var1) {
      int var3 = (var1.length() + 8 >> 6) + 1;
      int[] var5 = new int[var3 * 16];

      int var2;
      for(var2 = 0; var2 < var3 * 16; ++var2) {
         var5[var2] = 0;
      }

      int var4;
      for(var2 = 0; var2 < var1.length(); ++var2) {
         var4 = var2 >> 2;
         var5[var4] |= var1.charAt(var2) << var2 % 4 * 8;
      }

      var4 = var2 >> 2;
      var5[var4] |= 128 << var2 % 4 * 8;
      var5[var3 * 16 - 2] = var1.length() * 8;
      return var5;
   }

   public String calcMD5(String var1) {
      int[] var14 = this.str2blks_MD5(var1);
      int var6 = 1732584193;
      int var5 = -271733879;
      int var4 = -1732584194;
      int var3 = 271733878;

      for(int var2 = 0; var2 < var14.length; var2 += 16) {
         int var10 = this.ff(var6, var5, var4, var3, var14[var2 + 0], 7, -680876936);
         int var9 = this.ff(var3, var10, var5, var4, var14[var2 + 1], 12, -389564586);
         int var8 = this.ff(var4, var9, var10, var5, var14[var2 + 2], 17, 606105819);
         int var7 = this.ff(var5, var8, var9, var10, var14[var2 + 3], 22, -1044525330);
         int var11 = this.ff(var10, var7, var8, var9, var14[var2 + 4], 7, -176418897);
         var9 = this.ff(var9, var11, var7, var8, var14[var2 + 5], 12, 1200080426);
         var8 = this.ff(var8, var9, var11, var7, var14[var2 + 6], 17, -1473231341);
         var10 = this.ff(var7, var8, var9, var11, var14[var2 + 7], 22, -45705983);
         var11 = this.ff(var11, var10, var8, var9, var14[var2 + 8], 7, 1770035416);
         var7 = this.ff(var9, var11, var10, var8, var14[var2 + 9], 12, -1958414417);
         int var12 = this.ff(var8, var7, var11, var10, var14[var2 + 10], 17, -42063);
         var8 = this.ff(var10, var12, var7, var11, var14[var2 + 11], 22, -1990404162);
         var10 = this.ff(var11, var8, var12, var7, var14[var2 + 12], 7, 1804603682);
         var9 = this.ff(var7, var10, var8, var12, var14[var2 + 13], 12, -40341101);
         var7 = this.ff(var12, var9, var10, var8, var14[var2 + 14], 17, -1502002290);
         var11 = this.ff(var8, var7, var9, var10, var14[var2 + 15], 22, 1236535329);
         var8 = this.gg(var10, var11, var7, var9, var14[var2 + 1], 5, -165796510);
         var10 = this.gg(var9, var8, var11, var7, var14[var2 + 6], 9, -1069501632);
         var9 = this.gg(var7, var10, var8, var11, var14[var2 + 11], 14, 643717713);
         var7 = this.gg(var11, var9, var10, var8, var14[var2 + 0], 20, -373897302);
         var11 = this.gg(var8, var7, var9, var10, var14[var2 + 5], 5, -701558691);
         var8 = this.gg(var10, var11, var7, var9, var14[var2 + 10], 9, 38016083);
         var9 = this.gg(var9, var8, var11, var7, var14[var2 + 15], 14, -660478335);
         var10 = this.gg(var7, var9, var8, var11, var14[var2 + 4], 20, -405537848);
         var11 = this.gg(var11, var10, var9, var8, var14[var2 + 9], 5, 568446438);
         var7 = this.gg(var8, var11, var10, var9, var14[var2 + 14], 9, -1019803690);
         var8 = this.gg(var9, var7, var11, var10, var14[var2 + 3], 14, -187363961);
         var9 = this.gg(var10, var8, var7, var11, var14[var2 + 8], 20, 1163531501);
         var10 = this.gg(var11, var9, var8, var7, var14[var2 + 13], 5, -1444681467);
         var7 = this.gg(var7, var10, var9, var8, var14[var2 + 2], 9, -51403784);
         var8 = this.gg(var8, var7, var10, var9, var14[var2 + 7], 14, 1735328473);
         var9 = this.gg(var9, var8, var7, var10, var14[var2 + 12], 20, -1926607734);
         var10 = this.hh(var10, var9, var8, var7, var14[var2 + 5], 4, -378558);
         var7 = this.hh(var7, var10, var9, var8, var14[var2 + 8], 11, -2022574463);
         var11 = this.hh(var8, var7, var10, var9, var14[var2 + 11], 16, 1839030562);
         var9 = this.hh(var9, var11, var7, var10, var14[var2 + 14], 23, -35309556);
         var10 = this.hh(var10, var9, var11, var7, var14[var2 + 1], 4, -1530992060);
         var8 = this.hh(var7, var10, var9, var11, var14[var2 + 4], 11, 1272893353);
         var7 = this.hh(var11, var8, var10, var9, var14[var2 + 7], 16, -155497632);
         var9 = this.hh(var9, var7, var8, var10, var14[var2 + 10], 23, -1094730640);
         var10 = this.hh(var10, var9, var7, var8, var14[var2 + 13], 4, 681279174);
         var11 = this.hh(var8, var10, var9, var7, var14[var2 + 0], 11, -358537222);
         var8 = this.hh(var7, var11, var10, var9, var14[var2 + 3], 16, -722521979);
         var12 = this.hh(var9, var8, var11, var10, var14[var2 + 6], 23, 76029189);
         var7 = this.hh(var10, var12, var8, var11, var14[var2 + 9], 4, -640364487);
         var9 = this.hh(var11, var7, var12, var8, var14[var2 + 12], 11, -421815835);
         int var13 = this.hh(var8, var9, var7, var12, var14[var2 + 15], 16, 530742520);
         var10 = this.hh(var12, var13, var9, var7, var14[var2 + 2], 23, -995338651);
         var11 = this.ii(var7, var10, var13, var9, var14[var2 + 0], 6, -198630844);
         var8 = this.ii(var9, var11, var10, var13, var14[var2 + 7], 10, 1126891415);
         var7 = this.ii(var13, var8, var11, var10, var14[var2 + 14], 15, -1416354905);
         var10 = this.ii(var10, var7, var8, var11, var14[var2 + 5], 21, -57434055);
         var9 = this.ii(var11, var10, var7, var8, var14[var2 + 12], 6, 1700485571);
         var11 = this.ii(var8, var9, var10, var7, var14[var2 + 3], 10, -1894986606);
         var7 = this.ii(var7, var11, var9, var10, var14[var2 + 10], 15, -1051523);
         var10 = this.ii(var10, var7, var11, var9, var14[var2 + 1], 21, -2054922799);
         var8 = this.ii(var9, var10, var7, var11, var14[var2 + 8], 6, 1873313359);
         var11 = this.ii(var11, var8, var10, var7, var14[var2 + 15], 10, -30611744);
         var9 = this.ii(var7, var11, var8, var10, var14[var2 + 6], 15, -1560198380);
         var12 = this.ii(var10, var9, var11, var8, var14[var2 + 13], 21, 1309151649);
         var10 = this.ii(var8, var12, var9, var11, var14[var2 + 4], 6, -145523070);
         var7 = this.ii(var11, var10, var12, var9, var14[var2 + 11], 10, -1120210379);
         var8 = this.ii(var9, var7, var10, var12, var14[var2 + 2], 15, 718787259);
         var9 = this.ii(var12, var8, var7, var10, var14[var2 + 9], 21, -343485551);
         var6 = this.add(var10, var6);
         var5 = this.add(var9, var5);
         var4 = this.add(var8, var4);
         var3 = this.add(var7, var3);
      }

      return this.rhex(var6) + this.rhex(var5) + this.rhex(var4) + this.rhex(var3);
   }
}
