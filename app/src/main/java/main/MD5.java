package main;

public class MD5
{
    String hex_chr;
    
    public MD5() {
        super();
        this.hex_chr = "0123456789abcdef";
    }
    
    private int add(final int n, final int n2) {
        return (n & Integer.MAX_VALUE) + (Integer.MAX_VALUE & n2) ^ (n & Integer.MIN_VALUE) ^ (n2 & Integer.MIN_VALUE);
    }
    
    private int cmn(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return this.add(this.rol(this.add(this.add(n2, n), this.add(n4, n6)), n5), n3);
    }
    
    private int ff(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        return this.cmn((~n2 & n4) | (n2 & n3), n, n2, n5, n6, n7);
    }
    
    private int gg(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        return this.cmn((~n4 & n3) | (n2 & n4), n, n2, n5, n6, n7);
    }
    
    private int hh(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        return this.cmn(n2 ^ n3 ^ n4, n, n2, n5, n6, n7);
    }
    
    private int ii(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7) {
        return this.cmn(n3 ^ (~n4 | n2), n, n2, n5, n6, n7);
    }
    
    private String rhex(final int n) {
        String string = "";
        for (int i = 0; i <= 3; ++i) {
            string = String.valueOf(string) + this.hex_chr.charAt(n >> i * 8 + 4 & 0xF) + this.hex_chr.charAt(n >> i * 8 & 0xF);
        }
        return string;
    }
    
    private int rol(final int n, final int n2) {
        return n << n2 | n >>> 32 - n2;
    }
    
    private int[] str2blks_MD5(final String s) {
        final int n = (s.length() + 8 >> 6) + 1;
        final int[] array = new int[n * 16];
        for (int i = 0; i < n * 16; ++i) {
            array[i] = 0;
        }
        int j;
        for (j = 0; j < s.length(); ++j) {
            final int n2 = j >> 2;
            array[n2] |= s.charAt(j) << j % 4 * 8;
        }
        final int n3 = j >> 2;
        array[n3] |= 128 << j % 4 * 8;
        array[n * 16 - 2] = s.length() * 8;
        return array;
    }
    
    public String calcMD5(final String s) {
        final int[] str2blks_MD5 = this.str2blks_MD5(s);
        int add = 1732584193;
        int add2 = -271733879;
        int add3 = -1732584194;
        int add4 = 271733878;
        for (int i = 0; i < str2blks_MD5.length; i += 16) {
            final int ff = this.ff(add, add2, add3, add4, str2blks_MD5[i + 0], 7, -680876936);
            final int ff2 = this.ff(add4, ff, add2, add3, str2blks_MD5[i + 1], 12, -389564586);
            final int ff3 = this.ff(add3, ff2, ff, add2, str2blks_MD5[i + 2], 17, 606105819);
            final int ff4 = this.ff(add2, ff3, ff2, ff, str2blks_MD5[i + 3], 22, -1044525330);
            final int ff5 = this.ff(ff, ff4, ff3, ff2, str2blks_MD5[i + 4], 7, -176418897);
            final int ff6 = this.ff(ff2, ff5, ff4, ff3, str2blks_MD5[i + 5], 12, 1200080426);
            final int ff7 = this.ff(ff3, ff6, ff5, ff4, str2blks_MD5[i + 6], 17, -1473231341);
            final int ff8 = this.ff(ff4, ff7, ff6, ff5, str2blks_MD5[i + 7], 22, -45705983);
            final int ff9 = this.ff(ff5, ff8, ff7, ff6, str2blks_MD5[i + 8], 7, 1770035416);
            final int ff10 = this.ff(ff6, ff9, ff8, ff7, str2blks_MD5[i + 9], 12, -1958414417);
            final int ff11 = this.ff(ff7, ff10, ff9, ff8, str2blks_MD5[i + 10], 17, -42063);
            final int ff12 = this.ff(ff8, ff11, ff10, ff9, str2blks_MD5[i + 11], 22, -1990404162);
            final int ff13 = this.ff(ff9, ff12, ff11, ff10, str2blks_MD5[i + 12], 7, 1804603682);
            final int ff14 = this.ff(ff10, ff13, ff12, ff11, str2blks_MD5[i + 13], 12, -40341101);
            final int ff15 = this.ff(ff11, ff14, ff13, ff12, str2blks_MD5[i + 14], 17, -1502002290);
            final int ff16 = this.ff(ff12, ff15, ff14, ff13, str2blks_MD5[i + 15], 22, 1236535329);
            final int gg = this.gg(ff13, ff16, ff15, ff14, str2blks_MD5[i + 1], 5, -165796510);
            final int gg2 = this.gg(ff14, gg, ff16, ff15, str2blks_MD5[i + 6], 9, -1069501632);
            final int gg3 = this.gg(ff15, gg2, gg, ff16, str2blks_MD5[i + 11], 14, 643717713);
            final int gg4 = this.gg(ff16, gg3, gg2, gg, str2blks_MD5[i + 0], 20, -373897302);
            final int gg5 = this.gg(gg, gg4, gg3, gg2, str2blks_MD5[i + 5], 5, -701558691);
            final int gg6 = this.gg(gg2, gg5, gg4, gg3, str2blks_MD5[i + 10], 9, 38016083);
            final int gg7 = this.gg(gg3, gg6, gg5, gg4, str2blks_MD5[i + 15], 14, -660478335);
            final int gg8 = this.gg(gg4, gg7, gg6, gg5, str2blks_MD5[i + 4], 20, -405537848);
            final int gg9 = this.gg(gg5, gg8, gg7, gg6, str2blks_MD5[i + 9], 5, 568446438);
            final int gg10 = this.gg(gg6, gg9, gg8, gg7, str2blks_MD5[i + 14], 9, -1019803690);
            final int gg11 = this.gg(gg7, gg10, gg9, gg8, str2blks_MD5[i + 3], 14, -187363961);
            final int gg12 = this.gg(gg8, gg11, gg10, gg9, str2blks_MD5[i + 8], 20, 1163531501);
            final int gg13 = this.gg(gg9, gg12, gg11, gg10, str2blks_MD5[i + 13], 5, -1444681467);
            final int gg14 = this.gg(gg10, gg13, gg12, gg11, str2blks_MD5[i + 2], 9, -51403784);
            final int gg15 = this.gg(gg11, gg14, gg13, gg12, str2blks_MD5[i + 7], 14, 1735328473);
            final int gg16 = this.gg(gg12, gg15, gg14, gg13, str2blks_MD5[i + 12], 20, -1926607734);
            final int hh = this.hh(gg13, gg16, gg15, gg14, str2blks_MD5[i + 5], 4, -378558);
            final int hh2 = this.hh(gg14, hh, gg16, gg15, str2blks_MD5[i + 8], 11, -2022574463);
            final int hh3 = this.hh(gg15, hh2, hh, gg16, str2blks_MD5[i + 11], 16, 1839030562);
            final int hh4 = this.hh(gg16, hh3, hh2, hh, str2blks_MD5[i + 14], 23, -35309556);
            final int hh5 = this.hh(hh, hh4, hh3, hh2, str2blks_MD5[i + 1], 4, -1530992060);
            final int hh6 = this.hh(hh2, hh5, hh4, hh3, str2blks_MD5[i + 4], 11, 1272893353);
            final int hh7 = this.hh(hh3, hh6, hh5, hh4, str2blks_MD5[i + 7], 16, -155497632);
            final int hh8 = this.hh(hh4, hh7, hh6, hh5, str2blks_MD5[i + 10], 23, -1094730640);
            final int hh9 = this.hh(hh5, hh8, hh7, hh6, str2blks_MD5[i + 13], 4, 681279174);
            final int hh10 = this.hh(hh6, hh9, hh8, hh7, str2blks_MD5[i + 0], 11, -358537222);
            final int hh11 = this.hh(hh7, hh10, hh9, hh8, str2blks_MD5[i + 3], 16, -722521979);
            final int hh12 = this.hh(hh8, hh11, hh10, hh9, str2blks_MD5[i + 6], 23, 76029189);
            final int hh13 = this.hh(hh9, hh12, hh11, hh10, str2blks_MD5[i + 9], 4, -640364487);
            final int hh14 = this.hh(hh10, hh13, hh12, hh11, str2blks_MD5[i + 12], 11, -421815835);
            final int hh15 = this.hh(hh11, hh14, hh13, hh12, str2blks_MD5[i + 15], 16, 530742520);
            final int hh16 = this.hh(hh12, hh15, hh14, hh13, str2blks_MD5[i + 2], 23, -995338651);
            final int ii = this.ii(hh13, hh16, hh15, hh14, str2blks_MD5[i + 0], 6, -198630844);
            final int ii2 = this.ii(hh14, ii, hh16, hh15, str2blks_MD5[i + 7], 10, 1126891415);
            final int ii3 = this.ii(hh15, ii2, ii, hh16, str2blks_MD5[i + 14], 15, -1416354905);
            final int ii4 = this.ii(hh16, ii3, ii2, ii, str2blks_MD5[i + 5], 21, -57434055);
            final int ii5 = this.ii(ii, ii4, ii3, ii2, str2blks_MD5[i + 12], 6, 1700485571);
            final int ii6 = this.ii(ii2, ii5, ii4, ii3, str2blks_MD5[i + 3], 10, -1894986606);
            final int ii7 = this.ii(ii3, ii6, ii5, ii4, str2blks_MD5[i + 10], 15, -1051523);
            final int ii8 = this.ii(ii4, ii7, ii6, ii5, str2blks_MD5[i + 1], 21, -2054922799);
            final int ii9 = this.ii(ii5, ii8, ii7, ii6, str2blks_MD5[i + 8], 6, 1873313359);
            final int ii10 = this.ii(ii6, ii9, ii8, ii7, str2blks_MD5[i + 15], 10, -30611744);
            final int ii11 = this.ii(ii7, ii10, ii9, ii8, str2blks_MD5[i + 6], 15, -1560198380);
            final int ii12 = this.ii(ii8, ii11, ii10, ii9, str2blks_MD5[i + 13], 21, 1309151649);
            final int ii13 = this.ii(ii9, ii12, ii11, ii10, str2blks_MD5[i + 4], 6, -145523070);
            final int ii14 = this.ii(ii10, ii13, ii12, ii11, str2blks_MD5[i + 11], 10, -1120210379);
            final int ii15 = this.ii(ii11, ii14, ii13, ii12, str2blks_MD5[i + 2], 15, 718787259);
            final int ii16 = this.ii(ii12, ii15, ii14, ii13, str2blks_MD5[i + 9], 21, -343485551);
            add = this.add(ii13, add);
            add2 = this.add(ii16, add2);
            add3 = this.add(ii15, add3);
            add4 = this.add(ii14, add4);
        }
        return String.valueOf(this.rhex(add)) + this.rhex(add2) + this.rhex(add3) + this.rhex(add4);
    }
}
