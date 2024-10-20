package main;

public class MD5 {
    String hex_chr;

    public MD5() {
        this.hex_chr = "0123456789abcdef";
    }

    private int add(int x, int y) {
        return (x & 0x7FFFFFFF) + (0x7FFFFFFF & y) ^ x & 0x80000000 ^ y & 0x80000000;
    }

    public String calcMD5(String str) {
        int[] arr_v = this.str2blks_MD5(str);
        int a = 0x67452301;
        int b = 0xEFCDAB89;
        int c = 0x98BADCFE;
        int d = 0x10325476;
        for(int i = 0; i < arr_v.length; i += 16) {
            int a = this.ff(a, b, c, d, arr_v[i], 7, -680876936);
            int d = this.ff(d, a, b, c, arr_v[i + 1], 12, 0xE8C7B756);
            int c = this.ff(c, d, a, b, arr_v[i + 2], 17, 0x242070DB);
            int b = this.ff(b, c, d, a, arr_v[i + 3], 22, -1044525330);
            int a = this.ff(a, b, c, d, arr_v[i + 4], 7, 0xF57C0FAF);
            int d = this.ff(d, a, b, c, arr_v[i + 5], 12, 1200080426);
            int c = this.ff(c, d, a, b, arr_v[i + 6], 17, 0xA8304613);
            int b = this.ff(b, c, d, a, arr_v[i + 7], 22, 0xFD469501);
            int a = this.ff(a, b, c, d, arr_v[i + 8], 7, 1770035416);
            int d = this.ff(d, a, b, c, arr_v[i + 9], 12, 0x8B44F7AF);
            int c = this.ff(c, d, a, b, arr_v[i + 10], 17, 0xFFFF5BB1);
            int b = this.ff(b, c, d, a, arr_v[i + 11], 22, -1990404162);
            int a = this.ff(a, b, c, d, arr_v[i + 12], 7, 1804603682);
            int d = this.ff(d, a, b, c, arr_v[i + 13], 12, -40341101);
            int c = this.ff(c, d, a, b, arr_v[i + 14], 17, -1502002290);
            int b = this.ff(b, c, d, a, arr_v[i + 15], 22, 0x49B40821);
            int a = this.gg(a, b, c, d, arr_v[i + 1], 5, -165796510);
            int d = this.gg(d, a, b, c, arr_v[i + 6], 9, 0xC040B340);
            int c = this.gg(c, d, a, b, arr_v[i + 11], 14, 0x265E5A51);
            int b = this.gg(b, c, d, a, arr_v[i], 20, -373897302);
            int a = this.gg(a, b, c, d, arr_v[i + 5], 5, 0xD62F105D);
            int d = this.gg(d, a, b, c, arr_v[i + 10], 9, 38016083);
            int c = this.gg(c, d, a, b, arr_v[i + 15], 14, 0xD8A1E681);
            int b = this.gg(b, c, d, a, arr_v[i + 4], 20, 0xE7D3FBC8);
            int a = this.gg(a, b, c, d, arr_v[i + 9], 5, 0x21E1CDE6);
            int d = this.gg(d, a, b, c, arr_v[i + 14], 9, -1019803690);
            int c = this.gg(c, d, a, b, arr_v[i + 3], 14, 0xF4D50D87);
            int b = this.gg(b, c, d, a, arr_v[i + 8], 20, 1163531501);
            int a = this.gg(a, b, c, d, arr_v[i + 13], 5, 0xA9E3E905);
            int d = this.gg(d, a, b, c, arr_v[i + 2], 9, 0xFCEFA3F8);
            int c = this.gg(c, d, a, b, arr_v[i + 7], 14, 0x676F02D9);
            int b = this.gg(b, c, d, a, arr_v[i + 12], 20, -1926607734);
            int a = this.hh(a, b, c, d, arr_v[i + 5], 4, 0xFFFA3942);
            int d = this.hh(d, a, b, c, arr_v[i + 8], 11, 0x8771F681);
            int c = this.hh(c, d, a, b, arr_v[i + 11], 16, 1839030562);
            int b = this.hh(b, c, d, a, arr_v[i + 14], 23, 0xFDE5380C);
            int a = this.hh(a, b, c, d, arr_v[i + 1], 4, -1530992060);
            int d = this.hh(d, a, b, c, arr_v[i + 4], 11, 0x4BDECFA9);
            int c = this.hh(c, d, a, b, arr_v[i + 7], 16, 0xF6BB4B60);
            int b = this.hh(b, c, d, a, arr_v[i + 10], 23, -1094730640);
            int a = this.hh(a, b, c, d, arr_v[i + 13], 4, 0x289B7EC6);
            int d = this.hh(d, a, b, c, arr_v[i], 11, 0xEAA127FA);
            int c = this.hh(c, d, a, b, arr_v[i + 3], 16, 0xD4EF3085);
            int b = this.hh(b, c, d, a, arr_v[i + 6], 23, 0x4881D05);
            int a = this.hh(a, b, c, d, arr_v[i + 9], 4, 0xD9D4D039);
            int d = this.hh(d, a, b, c, arr_v[i + 12], 11, 0xE6DB99E5);
            int c = this.hh(c, d, a, b, arr_v[i + 15], 16, 0x1FA27CF8);
            int b = this.hh(b, c, d, a, arr_v[i + 2], 23, 0xC4AC5665);
            int a = this.ii(a, b, c, d, arr_v[i], 6, -198630844);
            int d = this.ii(d, a, b, c, arr_v[i + 7], 10, 0x432AFF97);
            int c = this.ii(c, d, a, b, arr_v[i + 14], 15, -1416354905);
            int b = this.ii(b, c, d, a, arr_v[i + 5], 21, 0xFC93A039);
            int a = this.ii(a, b, c, d, arr_v[i + 12], 6, 1700485571);
            int d = this.ii(d, a, b, c, arr_v[i + 3], 10, 0x8F0CCC92);
            int c = this.ii(c, d, a, b, arr_v[i + 10], 15, 0xFFEFF47D);
            int b = this.ii(b, c, d, a, arr_v[i + 1], 21, 0x85845DD1);
            int a = this.ii(a, b, c, d, arr_v[i + 8], 6, 0x6FA87E4F);
            int d = this.ii(d, a, b, c, arr_v[i + 15], 10, 0xFE2CE6E0);
            int c = this.ii(c, d, a, b, arr_v[i + 6], 15, -1560198380);
            int b = this.ii(b, c, d, a, arr_v[i + 13], 21, 0x4E0811A1);
            int a = this.ii(a, b, c, d, arr_v[i + 4], 6, -145523070);
            int d = this.ii(d, a, b, c, arr_v[i + 11], 10, -1120210379);
            int c = this.ii(c, d, a, b, arr_v[i + 2], 15, 0x2AD7D2BB);
            a = this.add(a, a);
            b = this.add(this.ii(b, c, d, a, arr_v[i + 9], 21, 0xEB86D391), b);
            c = this.add(c, c);
            d = this.add(d, d);
        }
        return this.rhex(a) + this.rhex(b) + this.rhex(c) + this.rhex(d);
    }

    private int cmn(int q, int a, int b, int x, int s, int t) {
        return this.add(this.rol(this.add(this.add(a, q), this.add(x, t)), s), b);
    }

    private int ff(int a, int b, int c, int d, int x, int s, int t) {
        return this.cmn(~b & d | b & c, a, b, x, s, t);
    }

    private int gg(int a, int b, int c, int d, int x, int s, int t) {
        return this.cmn(~d & c | b & d, a, b, x, s, t);
    }

    private int hh(int a, int b, int c, int d, int x, int s, int t) {
        return this.cmn(b ^ c ^ d, a, b, x, s, t);
    }

    private int ii(int a, int b, int c, int d, int x, int s, int t) {
        return this.cmn(c ^ (~d | b), a, b, x, s, t);
    }

    private String rhex(int num) {
        String str = "";
        for(int j = 0; j <= 3; ++j) {
            str = String.valueOf(str) + this.hex_chr.charAt(num >> j * 8 + 4 & 15) + this.hex_chr.charAt(num >> j * 8 & 15);
        }
        return str;
    }

    private int rol(int num, int cnt) {
        return num << cnt | num >>> 0x20 - cnt;
    }

    private int[] str2blks_MD5(String str) {
        int nblk = (str.length() + 8 >> 6) + 1;
        int[] blks = new int[nblk * 16];
        for(int i = 0; i < nblk * 16; ++i) {
            blks[i] = 0;
        }
        int i;
        for(i = 0; i < str.length(); ++i) {
            blks[i >> 2] |= str.charAt(i) << i % 4 * 8;
        }
        blks[i >> 2] |= 0x80 << i % 4 * 8;
        blks[nblk * 16 - 2] = str.length() * 8;
        return blks;
    }
}

