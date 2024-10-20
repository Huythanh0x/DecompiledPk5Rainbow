package main;

public class MD5 {
  String hex_chr = "0123456789abcdef";
  
  private int add(int paramInt1, int paramInt2) {
    return (paramInt1 & Integer.MAX_VALUE) + (Integer.MAX_VALUE & paramInt2) ^ paramInt1 & Integer.MIN_VALUE ^ paramInt2 & Integer.MIN_VALUE;
  }
  
  private int cmn(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    return add(rol(add(add(paramInt2, paramInt1), add(paramInt4, paramInt6)), paramInt5), paramInt3);
  }
  
  private int ff(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    return cmn((paramInt2 ^ 0xFFFFFFFF) & paramInt4 | paramInt2 & paramInt3, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  private int gg(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    return cmn((paramInt4 ^ 0xFFFFFFFF) & paramInt3 | paramInt2 & paramInt4, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  private int hh(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    return cmn(paramInt2 ^ paramInt3 ^ paramInt4, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  private int ii(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
    return cmn(paramInt3 ^ (paramInt4 ^ 0xFFFFFFFF | paramInt2), paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
  
  private String rhex(int paramInt) {
    String str = "";
    for (byte b = 0;; b++) {
      if (b > 3)
        return str; 
      str = String.valueOf(str) + this.hex_chr.charAt(paramInt >> b * 8 + 4 & 0xF) + this.hex_chr.charAt(paramInt >> b * 8 & 0xF);
    } 
  }
  
  private int rol(int paramInt1, int paramInt2) {
    return paramInt1 << paramInt2 | paramInt1 >>> 32 - paramInt2;
  }
  
  private int[] str2blks_MD5(String paramString) {
    int i = (paramString.length() + 8 >> 6) + 1;
    int[] arrayOfInt = new int[i * 16];
    for (byte b = 0;; b++) {
      if (b >= i * 16) {
        for (b = 0;; b++) {
          if (b >= paramString.length()) {
            int k = b >> 2;
            arrayOfInt[k] = arrayOfInt[k] | 128 << b % 4 * 8;
            arrayOfInt[i * 16 - 2] = paramString.length() * 8;
            return arrayOfInt;
          } 
          int j = b >> 2;
          arrayOfInt[j] = arrayOfInt[j] | paramString.charAt(b) << b % 4 * 8;
        } 
        break;
      } 
      arrayOfInt[b] = 0;
    } 
  }
  
  public String calcMD5(String paramString) {
    int[] arrayOfInt = str2blks_MD5(paramString);
    int m = 1732584193;
    int k = -271733879;
    int j = -1732584194;
    int i = 271733878;
    for (byte b = 0;; b += 16) {
      if (b >= arrayOfInt.length)
        return String.valueOf(rhex(m)) + rhex(k) + rhex(j) + rhex(i); 
      int i2 = ff(m, k, j, i, arrayOfInt[b + 0], 7, -680876936);
      int i1 = ff(i, i2, k, j, arrayOfInt[b + 1], 12, -389564586);
      int i3 = ff(j, i1, i2, k, arrayOfInt[b + 2], 17, 606105819);
      int n = ff(k, i3, i1, i2, arrayOfInt[b + 3], 22, -1044525330);
      i2 = ff(i2, n, i3, i1, arrayOfInt[b + 4], 7, -176418897);
      i1 = ff(i1, i2, n, i3, arrayOfInt[b + 5], 12, 1200080426);
      i3 = ff(i3, i1, i2, n, arrayOfInt[b + 6], 17, -1473231341);
      n = ff(n, i3, i1, i2, arrayOfInt[b + 7], 22, -45705983);
      i2 = ff(i2, n, i3, i1, arrayOfInt[b + 8], 7, 1770035416);
      i1 = ff(i1, i2, n, i3, arrayOfInt[b + 9], 12, -1958414417);
      i3 = ff(i3, i1, i2, n, arrayOfInt[b + 10], 17, -42063);
      n = ff(n, i3, i1, i2, arrayOfInt[b + 11], 22, -1990404162);
      i2 = ff(i2, n, i3, i1, arrayOfInt[b + 12], 7, 1804603682);
      int i4 = ff(i1, i2, n, i3, arrayOfInt[b + 13], 12, -40341101);
      i1 = ff(i3, i4, i2, n, arrayOfInt[b + 14], 17, -1502002290);
      i3 = ff(n, i1, i4, i2, arrayOfInt[b + 15], 22, 1236535329);
      n = gg(i2, i3, i1, i4, arrayOfInt[b + 1], 5, -165796510);
      int i5 = gg(i4, n, i3, i1, arrayOfInt[b + 6], 9, -1069501632);
      i4 = gg(i1, i5, n, i3, arrayOfInt[b + 11], 14, 643717713);
      i2 = gg(i3, i4, i5, n, arrayOfInt[b + 0], 20, -373897302);
      i1 = gg(n, i2, i4, i5, arrayOfInt[b + 5], 5, -701558691);
      i5 = gg(i5, i1, i2, i4, arrayOfInt[b + 10], 9, 38016083);
      n = gg(i4, i5, i1, i2, arrayOfInt[b + 15], 14, -660478335);
      i2 = gg(i2, n, i5, i1, arrayOfInt[b + 4], 20, -405537848);
      i3 = gg(i1, i2, n, i5, arrayOfInt[b + 9], 5, 568446438);
      i1 = gg(i5, i3, i2, n, arrayOfInt[b + 14], 9, -1019803690);
      n = gg(n, i1, i3, i2, arrayOfInt[b + 3], 14, -187363961);
      i2 = gg(i2, n, i1, i3, arrayOfInt[b + 8], 20, 1163531501);
      i5 = gg(i3, i2, n, i1, arrayOfInt[b + 13], 5, -1444681467);
      i1 = gg(i1, i5, i2, n, arrayOfInt[b + 2], 9, -51403784);
      i3 = gg(n, i1, i5, i2, arrayOfInt[b + 7], 14, 1735328473);
      i4 = gg(i2, i3, i1, i5, arrayOfInt[b + 12], 20, -1926607734);
      n = hh(i5, i4, i3, i1, arrayOfInt[b + 5], 4, -378558);
      i1 = hh(i1, n, i4, i3, arrayOfInt[b + 8], 11, -2022574463);
      i2 = hh(i3, i1, n, i4, arrayOfInt[b + 11], 16, 1839030562);
      i3 = hh(i4, i2, i1, n, arrayOfInt[b + 14], 23, -35309556);
      n = hh(n, i3, i2, i1, arrayOfInt[b + 1], 4, -1530992060);
      i1 = hh(i1, n, i3, i2, arrayOfInt[b + 4], 11, 1272893353);
      i2 = hh(i2, i1, n, i3, arrayOfInt[b + 7], 16, -155497632);
      i3 = hh(i3, i2, i1, n, arrayOfInt[b + 10], 23, -1094730640);
      n = hh(n, i3, i2, i1, arrayOfInt[b + 13], 4, 681279174);
      i1 = hh(i1, n, i3, i2, arrayOfInt[b + 0], 11, -358537222);
      i4 = hh(i2, i1, n, i3, arrayOfInt[b + 3], 16, -722521979);
      i5 = hh(i3, i4, i1, n, arrayOfInt[b + 6], 23, 76029189);
      n = hh(n, i5, i4, i1, arrayOfInt[b + 9], 4, -640364487);
      i2 = hh(i1, n, i5, i4, arrayOfInt[b + 12], 11, -421815835);
      i3 = hh(i4, i2, n, i5, arrayOfInt[b + 15], 16, 530742520);
      i1 = hh(i5, i3, i2, n, arrayOfInt[b + 2], 23, -995338651);
      n = ii(n, i1, i3, i2, arrayOfInt[b + 0], 6, -198630844);
      i4 = ii(i2, n, i1, i3, arrayOfInt[b + 7], 10, 1126891415);
      i2 = ii(i3, i4, n, i1, arrayOfInt[b + 14], 15, -1416354905);
      i3 = ii(i1, i2, i4, n, arrayOfInt[b + 5], 21, -57434055);
      i5 = ii(n, i3, i2, i4, arrayOfInt[b + 12], 6, 1700485571);
      n = ii(i4, i5, i3, i2, arrayOfInt[b + 3], 10, -1894986606);
      i1 = ii(i2, n, i5, i3, arrayOfInt[b + 10], 15, -1051523);
      i2 = ii(i3, i1, n, i5, arrayOfInt[b + 1], 21, -2054922799);
      i3 = ii(i5, i2, i1, n, arrayOfInt[b + 8], 6, 1873313359);
      n = ii(n, i3, i2, i1, arrayOfInt[b + 15], 10, -30611744);
      i1 = ii(i1, n, i3, i2, arrayOfInt[b + 6], 15, -1560198380);
      i2 = ii(i2, i1, n, i3, arrayOfInt[b + 13], 21, 1309151649);
      i3 = ii(i3, i2, i1, n, arrayOfInt[b + 4], 6, -145523070);
      n = ii(n, i3, i2, i1, arrayOfInt[b + 11], 10, -1120210379);
      i1 = ii(i1, n, i3, i2, arrayOfInt[b + 2], 15, 718787259);
      i2 = ii(i2, i1, n, i3, arrayOfInt[b + 9], 21, -343485551);
      m = add(i3, m);
      k = add(i2, k);
      j = add(i1, j);
      i = add(n, i);
    } 
  }
}


/* Location:              /Users/thanh0x/DevTools0x/Rb2.0vip-dex2jar.jar!/main/MD5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */