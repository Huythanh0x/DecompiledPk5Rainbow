package main;

/* loaded from: classes.dex */
/**
 * The MD5 class provides methods to compute the MD5 hash of a given string.
 * It implements the MD5 hashing algorithm as defined in RFC 1321.
 */
public class MD5 {
    String hex_chr = "0123456789abcdef";

    /**
     * Converts an integer to a hexadecimal string.
     *
     * @param num The integer to convert.
     * @return The hexadecimal string representation of the integer.
     */
    private String rhex(int num) {
        String str = "";
        for (int j = 0; j <= 3; j++) {
            str = String.valueOf(str) + this.hex_chr.charAt((num >> ((j * 8) + 4)) & 15) + this.hex_chr.charAt((num >> (j * 8)) & 15);
        }
        return str;
    }

    /**
     * Converts a string to an array of integers representing the MD5 blocks.
     *
     * @param str The input string.
     * @return An array of integers representing the MD5 blocks.
     */
    private int[] str2blks_MD5(String str) {
        int nblk = ((str.length() + 8) >> 6) + 1;
        int[] blks = new int[nblk * 16];
        for (int i = 0; i < nblk * 16; i++) {
            blks[i] = 0;
        }
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 >> 2;
            blks[i3] = blks[i3] | (str.charAt(i2) << ((i2 % 4) * 8));
            i2++;
        }
        int i4 = i2 >> 2;
        blks[i4] = blks[i4] | (128 << ((i2 % 4) * 8));
        blks[(nblk * 16) - 2] = str.length() * 8;
        return blks;
    }

    /**
     * Adds two integers with overflow handling.
     *
     * @param x The first integer.
     * @param y The second integer.
     * @return The sum of the two integers.
     */
    private int add(int x, int y) {
        return (((x & Integer.MAX_VALUE) + (Integer.MAX_VALUE & y)) ^ (x & Integer.MIN_VALUE)) ^ (y & Integer.MIN_VALUE);
    }

    /**
     * Rotates an integer left by a specified number of bits.
     *
     * @param num The integer to rotate.
     * @param cnt The number of bits to rotate.
     * @return The rotated integer.
     */
    private int rol(int num, int cnt) {
        return (num << cnt) | (num >>> (32 - cnt));
    }

    /**
     * Common transformation function used by the MD5 algorithm.
     *
     * @param q The result of the transformation.
     * @param a The first integer.
     * @param b The second integer.
     * @param x The third integer.
     * @param s The number of bits to rotate.
     * @param t The fourth integer.
     * @return The result of the transformation.
     */
    private int cmn(int q, int a, int b, int x, int s, int t) {
        return add(rol(add(add(a, q), add(x, t)), s), b);
    }

    /**
     * The first transformation function used by the MD5 algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param c The third integer.
     * @param d The fourth integer.
     * @param x The fifth integer.
     * @param s The number of bits to rotate.
     * @param t The sixth integer.
     * @return The result of the transformation.
     */
    private int ff(int a, int b, int c, int d, int x, int s, int t) {
        return cmn(((b ^ (-1)) & d) | (b & c), a, b, x, s, t);
    }

    /**
     * The second transformation function used by the MD5 algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param c The third integer.
     * @param d The fourth integer.
     * @param x The fifth integer.
     * @param s The number of bits to rotate.
     * @param t The sixth integer.
     * @return The result of the transformation.
     */
    private int gg(int a, int b, int c, int d, int x, int s, int t) {
        return cmn(((d ^ (-1)) & c) | (b & d), a, b, x, s, t);
    }

    /**
     * The third transformation function used by the MD5 algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param c The third integer.
     * @param d The fourth integer.
     * @param x The fifth integer.
     * @param s The number of bits to rotate.
     * @param t The sixth integer.
     * @return The result of the transformation.
     */
    private int hh(int a, int b, int c, int d, int x, int s, int t) {
        return cmn((b ^ c) ^ d, a, b, x, s, t);
    }

    /**
     * The fourth transformation function used by the MD5 algorithm.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param c The third integer.
     * @param d The fourth integer.
     * @param x The fifth integer.
     * @param s The number of bits to rotate.
     * @param t The sixth integer.
     * @return The result of the transformation.
     */
    private int ii(int a, int b, int c, int d, int x, int s, int t) {
        return cmn(c ^ ((d ^ (-1)) | b), a, b, x, s, t);
    }

    /**
     * Computes the MD5 hash of a given string.
     *
     * @param str The input string.
     * @return The MD5 hash of the input string.
     */
    public String calcMD5(String str) {
        int[] x = str2blks_MD5(str);
        int a = 1732584193;
        int b = -271733879;
        int c = -1732584194;
        int d = 271733878;
        for (int i = 0; i < x.length; i += 16) {
            int olda = a;
            int oldb = b;
            int oldc = c;
            int oldd = d;
            int a2 = ff(a, b, c, d, x[i + 0], 7, -680876936);
            int d2 = ff(d, a2, b, c, x[i + 1], 12, -389564586);
            int c2 = ff(c, d2, a2, b, x[i + 2], 17, 606105819);
            int b2 = ff(b, c2, d2, a2, x[i + 3], 22, -1044525330);
            int a3 = ff(a2, b2, c2, d2, x[i + 4], 7, -176418897);
            int d3 = ff(d2, a3, b2, c2, x[i + 5], 12, 1200080426);
            int c3 = ff(c2, d3, a3, b2, x[i + 6], 17, -1473231341);
            int b3 = ff(b2, c3, d3, a3, x[i + 7], 22, -45705983);
            int a4 = ff(a3, b3, c3, d3, x[i + 8], 7, 1770035416);
            int d4 = ff(d3, a4, b3, c3, x[i + 9], 12, -1958414417);
            int c4 = ff(c3, d4, a4, b3, x[i + 10], 17, -42063);
            int b4 = ff(b3, c4, d4, a4, x[i + 11], 22, -1990404162);
            int a5 = ff(a4, b4, c4, d4, x[i + 12], 7, 1804603682);
            int d5 = ff(d4, a5, b4, c4, x[i + 13], 12, -40341101);
            int c5 = ff(c4, d5, a5, b4, x[i + 14], 17, -1502002290);
            int b5 = ff(b4, c5, d5, a5, x[i + 15], 22, 1236535329);
            int a6 = gg(a5, b5, c5, d5, x[i + 1], 5, -165796510);
            int d6 = gg(d5, a6, b5, c5, x[i + 6], 9, -1069501632);
            int c6 = gg(c5, d6, a6, b5, x[i + 11], 14, 643717713);
            int b6 = gg(b5, c6, d6, a6, x[i + 0], 20, -373897302);
            int a7 = gg(a6, b6, c6, d6, x[i + 5], 5, -701558691);
            int d7 = gg(d6, a7, b6, c6, x[i + 10], 9, 38016083);
            int c7 = gg(c6, d7, a7, b6, x[i + 15], 14, -660478335);
            int b7 = gg(b6, c7, d7, a7, x[i + 4], 20, -405537848);
            int a8 = gg(a7, b7, c7, d7, x[i + 9], 5, 568446438);
            int d8 = gg(d7, a8, b7, c7, x[i + 14], 9, -1019803690);
            int c8 = gg(c7, d8, a8, b7, x[i + 3], 14, -187363961);
            int b8 = gg(b7, c8, d8, a8, x[i + 8], 20, 1163531501);
            int a9 = gg(a8, b8, c8, d8, x[i + 13], 5, -1444681467);
            int d9 = gg(d8, a9, b8, c8, x[i + 2], 9, -51403784);
            int c9 = gg(c8, d9, a9, b8, x[i + 7], 14, 1735328473);
            int b9 = gg(b8, c9, d9, a9, x[i + 12], 20, -1926607734);
            int a10 = hh(a9, b9, c9, d9, x[i + 5], 4, -378558);
            int d10 = hh(d9, a10, b9, c9, x[i + 8], 11, -2022574463);
            int c10 = hh(c9, d10, a10, b9, x[i + 11], 16, 1839030562);
            int b10 = hh(b9, c10, d10, a10, x[i + 14], 23, -35309556);
            int a11 = hh(a10, b10, c10, d10, x[i + 1], 4, -1530992060);
            int d11 = hh(d10, a11, b10, c10, x[i + 4], 11, 1272893353);
            int c11 = hh(c10, d11, a11, b10, x[i + 7], 16, -155497632);
            int b11 = hh(b10, c11, d11, a11, x[i + 10], 23, -1094730640);
            int a12 = hh(a11, b11, c11, d11, x[i + 13], 4, 681279174);
            int d12 = hh(d11, a12, b11, c11, x[i + 0], 11, -358537222);
            int c12 = hh(c11, d12, a12, b11, x[i + 3], 16, -722521979);
            int b12 = hh(b11, c12, d12, a12, x[i + 6], 23, 76029189);
            int a13 = hh(a12, b12, c12, d12, x[i + 9], 4, -640364487);
            int d13 = hh(d12, a13, b12, c12, x[i + 12], 11, -421815835);
            int c13 = hh(c12, d13, a13, b12, x[i + 15], 16, 530742520);
            int b13 = hh(b12, c13, d13, a13, x[i + 2], 23, -995338651);
            int a14 = ii(a13, b13, c13, d13, x[i + 0], 6, -198630844);
            int d14 = ii(d13, a14, b13, c13, x[i + 7], 10, 1126891415);
            int c14 = ii(c13, d14, a14, b13, x[i + 14], 15, -1416354905);
            int b14 = ii(b13, c14, d14, a14, x[i + 5], 21, -57434055);
            int a15 = ii(a14, b14, c14, d14, x[i + 12], 6, 1700485571);
            int d15 = ii(d14, a15, b14, c14, x[i + 3], 10, -1894986606);
            int c15 = ii(c14, d15, a15, b14, x[i + 10], 15, -1051523);
            int b15 = ii(b14, c15, d15, a15, x[i + 1], 21, -2054922799);
            int a16 = ii(a15, b15, c15, d15, x[i + 8], 6, 1873313359);
            int d16 = ii(d15, a16, b15, c15, x[i + 15], 10, -30611744);
            int c16 = ii(c15, d16, a16, b15, x[i + 6], 15, -1560198380);
            int b16 = ii(b15, c16, d16, a16, x[i + 13], 21, 1309151649);
            int a17 = ii(a16, b16, c16, d16, x[i + 4], 6, -145523070);
            int d17 = ii(d16, a17, b16, c16, x[i + 11], 10, -1120210379);
            int c17 = ii(c16, d17, a17, b16, x[i + 2], 15, 718787259);
            int b17 = ii(b16, c17, d17, a17, x[i + 9], 21, -343485551);
            a = add(a17, olda);
            b = add(b17, oldb);
            c = add(c17, oldc);
            d = add(d17, oldd);
        }
        return String.valueOf(rhex(a)) + rhex(b) + rhex(c) + rhex(d);
    }
}
