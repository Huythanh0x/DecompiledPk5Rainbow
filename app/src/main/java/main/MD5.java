/*
 * Decompiled with CFR.
 */
package main;

public class MD5 {
    String hex_chr = "0123456789abcdef";

    private int add(int n, int n2) {
        return (n & Integer.MAX_VALUE) + (Integer.MAX_VALUE & n2) ^ n & Integer.MIN_VALUE ^ n2 & Integer.MIN_VALUE;
    }

    private int cmn(int n, int n2, int n3, int n4, int n5, int n6) {
        return this.add(this.rol(this.add(this.add(n2, n), this.add(n4, n6)), n5), n3);
    }

    private int ff(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.cmn(~n2 & n4 | n2 & n3, n, n2, n5, n6, n7);
    }

    private int gg(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.cmn(~n4 & n3 | n2 & n4, n, n2, n5, n6, n7);
    }

    private int hh(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.cmn(n2 ^ n3 ^ n4, n, n2, n5, n6, n7);
    }

    private int ii(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        return this.cmn(n3 ^ (~n4 | n2), n, n2, n5, n6, n7);
    }

    private String rhex(int n) {
        String string = "";
        int n2 = 0;
        while (n2 <= 3) {
            string = String.valueOf(string) + this.hex_chr.charAt(n >> n2 * 8 + 4 & 0xF) + this.hex_chr.charAt(n >> n2 * 8 & 0xF);
            ++n2;
        }
        return string;
    }

    private int rol(int n, int n2) {
        return n << n2 | n >>> 32 - n2;
    }

    /*
     * Unable to fully structure code
     */
    private int[] str2blks_MD5(String var1_1) {
        var3_2 = (var1_1.length() + 8 >> 6) + 1;
        var5_3 = new int[var3_2 * 16];
        var2_4 = 0;
        block0: while (true) {
            if (var2_4 >= var3_2 * 16) {
                var2_4 = 0;
lbl7:
                // 2 sources

                while (true) {
                    if (var2_4 < var1_1.length()) break block0;
                    var4_5 = var2_4 >> 2;
                    var5_3[var4_5] = var5_3[var4_5] | 128 << var2_4 % 4 * 8;
                    var5_3[var3_2 * 16 - 2] = var1_1.length() * 8;
                    return var5_3;
                }
            }
            var5_3[var2_4] = 0;
            ++var2_4;
        }
        var4_5 = var2_4 >> 2;
        var5_3[var4_5] = var5_3[var4_5] | var1_1.charAt(var2_4) << var2_4 % 4 * 8;
        ++var2_4;
        ** while (true)
    }

    public String calcMD5(String object) {
        object = this.str2blks_MD5((String)object);
        int n = 1732584193;
        int n2 = -271733879;
        int n3 = -1732584194;
        int n4 = 271733878;
        int n5 = 0;
        while (n5 < ((Object)object).length) {
            int n6 = this.ff(n, n2, n3, n4, (int)object[n5 + 0], 7, -680876936);
            int n7 = this.ff(n4, n6, n2, n3, (int)object[n5 + 1], 12, -389564586);
            int n8 = this.ff(n3, n7, n6, n2, (int)object[n5 + 2], 17, 606105819);
            int n9 = this.ff(n2, n8, n7, n6, (int)object[n5 + 3], 22, -1044525330);
            int n10 = this.ff(n6, n9, n8, n7, (int)object[n5 + 4], 7, -176418897);
            n7 = this.ff(n7, n10, n9, n8, (int)object[n5 + 5], 12, 1200080426);
            n8 = this.ff(n8, n7, n10, n9, (int)object[n5 + 6], 17, -1473231341);
            n6 = this.ff(n9, n8, n7, n10, (int)object[n5 + 7], 22, -45705983);
            n10 = this.ff(n10, n6, n8, n7, (int)object[n5 + 8], 7, 1770035416);
            n9 = this.ff(n7, n10, n6, n8, (int)object[n5 + 9], 12, -1958414417);
            int n11 = this.ff(n8, n9, n10, n6, (int)object[n5 + 10], 17, -42063);
            n8 = this.ff(n6, n11, n9, n10, (int)object[n5 + 11], 22, -1990404162);
            n6 = this.ff(n10, n8, n11, n9, (int)object[n5 + 12], 7, 1804603682);
            n7 = this.ff(n9, n6, n8, n11, (int)object[n5 + 13], 12, -40341101);
            n9 = this.ff(n11, n7, n6, n8, (int)object[n5 + 14], 17, -1502002290);
            n10 = this.ff(n8, n9, n7, n6, (int)object[n5 + 15], 22, 1236535329);
            n8 = this.gg(n6, n10, n9, n7, (int)object[n5 + 1], 5, -165796510);
            n6 = this.gg(n7, n8, n10, n9, (int)object[n5 + 6], 9, -1069501632);
            n7 = this.gg(n9, n6, n8, n10, (int)object[n5 + 11], 14, 643717713);
            n9 = this.gg(n10, n7, n6, n8, (int)object[n5 + 0], 20, -373897302);
            n10 = this.gg(n8, n9, n7, n6, (int)object[n5 + 5], 5, -701558691);
            n8 = this.gg(n6, n10, n9, n7, (int)object[n5 + 10], 9, 38016083);
            n7 = this.gg(n7, n8, n10, n9, (int)object[n5 + 15], 14, -660478335);
            n6 = this.gg(n9, n7, n8, n10, (int)object[n5 + 4], 20, -405537848);
            n10 = this.gg(n10, n6, n7, n8, (int)object[n5 + 9], 5, 568446438);
            n9 = this.gg(n8, n10, n6, n7, (int)object[n5 + 14], 9, -1019803690);
            n8 = this.gg(n7, n9, n10, n6, (int)object[n5 + 3], 14, -187363961);
            n7 = this.gg(n6, n8, n9, n10, (int)object[n5 + 8], 20, 1163531501);
            n6 = this.gg(n10, n7, n8, n9, (int)object[n5 + 13], 5, -1444681467);
            n9 = this.gg(n9, n6, n7, n8, (int)object[n5 + 2], 9, -51403784);
            n8 = this.gg(n8, n9, n6, n7, (int)object[n5 + 7], 14, 1735328473);
            n7 = this.gg(n7, n8, n9, n6, (int)object[n5 + 12], 20, -1926607734);
            n6 = this.hh(n6, n7, n8, n9, (int)object[n5 + 5], 4, -378558);
            n9 = this.hh(n9, n6, n7, n8, (int)object[n5 + 8], 11, -2022574463);
            n10 = this.hh(n8, n9, n6, n7, (int)object[n5 + 11], 16, 1839030562);
            n7 = this.hh(n7, n10, n9, n6, (int)object[n5 + 14], 23, -35309556);
            n6 = this.hh(n6, n7, n10, n9, (int)object[n5 + 1], 4, -1530992060);
            n8 = this.hh(n9, n6, n7, n10, (int)object[n5 + 4], 11, 1272893353);
            n9 = this.hh(n10, n8, n6, n7, (int)object[n5 + 7], 16, -155497632);
            n7 = this.hh(n7, n9, n8, n6, (int)object[n5 + 10], 23, -1094730640);
            n6 = this.hh(n6, n7, n9, n8, (int)object[n5 + 13], 4, 681279174);
            n10 = this.hh(n8, n6, n7, n9, (int)object[n5 + 0], 11, -358537222);
            n8 = this.hh(n9, n10, n6, n7, (int)object[n5 + 3], 16, -722521979);
            n11 = this.hh(n7, n8, n10, n6, (int)object[n5 + 6], 23, 76029189);
            n9 = this.hh(n6, n11, n8, n10, (int)object[n5 + 9], 4, -640364487);
            n7 = this.hh(n10, n9, n11, n8, (int)object[n5 + 12], 11, -421815835);
            int n12 = this.hh(n8, n7, n9, n11, (int)object[n5 + 15], 16, 530742520);
            n6 = this.hh(n11, n12, n7, n9, (int)object[n5 + 2], 23, -995338651);
            n10 = this.ii(n9, n6, n12, n7, (int)object[n5 + 0], 6, -198630844);
            n8 = this.ii(n7, n10, n6, n12, (int)object[n5 + 7], 10, 1126891415);
            n9 = this.ii(n12, n8, n10, n6, (int)object[n5 + 14], 15, -1416354905);
            n6 = this.ii(n6, n9, n8, n10, (int)object[n5 + 5], 21, -57434055);
            n7 = this.ii(n10, n6, n9, n8, (int)object[n5 + 12], 6, 1700485571);
            n10 = this.ii(n8, n7, n6, n9, (int)object[n5 + 3], 10, -1894986606);
            n9 = this.ii(n9, n10, n7, n6, (int)object[n5 + 10], 15, -1051523);
            n6 = this.ii(n6, n9, n10, n7, (int)object[n5 + 1], 21, -2054922799);
            n8 = this.ii(n7, n6, n9, n10, (int)object[n5 + 8], 6, 1873313359);
            n10 = this.ii(n10, n8, n6, n9, (int)object[n5 + 15], 10, -30611744);
            n7 = this.ii(n9, n10, n8, n6, (int)object[n5 + 6], 15, -1560198380);
            n11 = this.ii(n6, n7, n10, n8, (int)object[n5 + 13], 21, 1309151649);
            n6 = this.ii(n8, n11, n7, n10, (int)object[n5 + 4], 6, -145523070);
            n9 = this.ii(n10, n6, n11, n7, (int)object[n5 + 11], 10, -1120210379);
            n8 = this.ii(n7, n9, n6, n11, (int)object[n5 + 2], 15, 718787259);
            n7 = this.ii(n11, n8, n9, n6, (int)object[n5 + 9], 21, -343485551);
            n = this.add(n6, n);
            n2 = this.add(n7, n2);
            n3 = this.add(n8, n3);
            n4 = this.add(n9, n4);
            n5 += 16;
        }
        return String.valueOf(this.rhex(n)) + this.rhex(n2) + this.rhex(n3) + this.rhex(n4);
    }
}
