package main.MD5;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;

public class MD5	// class@000164 from classes.dex
{
    String hex_chr;

    public void MD5(){
       super();
       this.hex_chr = "0123456789abcdef";
    }
    private int add(int x,int y){
       return ((((x & Integer.MAX_VALUE) + (Integer.MAX_VALUE & y)) ^ (x & Integer.MIN_VALUE)) ^ (y & Integer.MIN_VALUE));
    }
    private int cmn(int q,int a,int b,int x,int s,int t){
       return this.add(this.rol(this.add(this.add(a, q), this.add(x, t)), s), b);
    }
    private int ff(int a,int b,int c,int d,int x,int s,int t){
       return this.cmn((((b ^ 0xff) & d) | (b & c)), a, b, x, s, t);
    }
    private int gg(int a,int b,int c,int d,int x,int s,int t){
       return this.cmn((((d ^ 0xff) & c) | (b & d)), a, b, x, s, t);
    }
    private int hh(int a,int b,int c,int d,int x,int s,int t){
       return this.cmn(((b ^ c) ^ d), a, b, x, s, t);
    }
    private int ii(int a,int b,int c,int d,int x,int s,int t){
       return this.cmn((c ^ ((d ^ 0xff) | b)), a, b, x, s, t);
    }
    private String rhex(int num){
       String str = "";
       int j = 0;
       while (j <= 3) {
          int i = j * 8;
          i = i + 4;
          i = num >> i;
          i = i & 0x0f;
          i = j * 8;
          i = num >> i;
          i = i & 0x0f;
          str = String.valueOf(str).append(this.hex_chr.charAt(i)).append(this.hex_chr.charAt(i)).toString();
          j++;
       }
       return str;
    }
    private int rol(int num,int cnt){
       return ((num << cnt) | (num >> (32 - cnt)));
    }
    private int[] str2blks_MD5(String str){
       int ix;
       int nblk = ((str.length() + 8) >> 6) + 1;
       int[] blks = new int[(nblk * 16)];
       int i = 0;
       i = 0;
       while (true) {
          ix = nblk * 16;
          if (i >= ix) {
             break ;
          }else {
             blks[i] = 0;
             i++;
          }
       }
       for (i = 0; i < str.length(); i++) {
          ix = i >> 2;
          int ix1 = i % 4;
          ix1 = ix1 * 8;
          int ix2 = str.charAt(i) << ix1;
          int ix3 = blks[ix] | ix2;
          blks[ix] = ix3;
       }
       ix = i >> 2;
       blks[ix] = blks[ix] | (128 << ((i % 4) * 8));
       blks[((nblk * 16) - 2)] = str.length() * 8;
       return blks;
    }
    public String calcMD5(String str){
       int[] x = this.str2blks_MD5(str);
       int a = 0x67452301;
       int b = -271733879;
       int c = -1732584194;
       int d = 0x10325476;
       int i = 0;
       while (i < x.length) {
          int olda = a;
          int oldb = b;
          int oldc = c;
          int oldd = d;
          int ix = i + 0;
          a = this.ff(a, b, c, d, x[ix], 7, -680876936);
          ix = i + 1;
          d = this.ff(d, a, b, c, x[ix], 12, -389564586);
          ix = i + 2;
          c = this.ff(c, d, a, b, x[ix], 17, 0x242070db);
          ix = i + 3;
          b = this.ff(b, c, d, a, x[ix], 22, -1044525330);
          ix = i + 4;
          a = this.ff(a, b, c, d, x[ix], 7, -176418897);
          ix = i + 5;
          d = this.ff(d, a, b, c, x[ix], 12, 0x4787c62a);
          ix = i + 6;
          c = this.ff(c, d, a, b, x[ix], 17, -1473231341);
          ix = i + 7;
          b = this.ff(b, c, d, a, x[ix], 22, -45705983);
          ix = i + 8;
          a = this.ff(a, b, c, d, x[ix], 7, 0x698098d8);
          ix = i + 9;
          d = this.ff(d, a, b, c, x[ix], 12, -1958414417);
          ix = i + 10;
          c = this.ff(c, d, a, b, x[ix], 17, -42063);
          ix = i + 11;
          b = this.ff(b, c, d, a, x[ix], 22, -1990404162);
          ix = i + 12;
          a = this.ff(a, b, c, d, x[ix], 7, 0x6b901122);
          ix = i + 13;
          d = this.ff(d, a, b, c, x[ix], 12, -40341101);
          ix = i + 14;
          c = this.ff(c, d, a, b, x[ix], 17, -1502002290);
          ix = i + 15;
          b = this.ff(b, c, d, a, x[ix], 22, 0x49b40821);
          ix = i + 1;
          a = this.gg(a, b, c, d, x[ix], 5, -165796510);
          ix = i + 6;
          d = this.gg(d, a, b, c, x[ix], 9, -1069501632);
          ix = i + 11;
          c = this.gg(c, d, a, b, x[ix], 14, 0x265e5a51);
          ix = i + 0;
          b = this.gg(b, c, d, a, x[ix], 20, -373897302);
          ix = i + 5;
          a = this.gg(a, b, c, d, x[ix], 5, -701558691);
          ix = i + 10;
          d = this.gg(d, a, b, c, x[ix], 9, 0x2441453);
          ix = i + 15;
          c = this.gg(c, d, a, b, x[ix], 14, -660478335);
          ix = i + 4;
          b = this.gg(b, c, d, a, x[ix], 20, -405537848);
          ix = i + 9;
          a = this.gg(a, b, c, d, x[ix], 5, 0x21e1cde6);
          ix = i + 14;
          d = this.gg(d, a, b, c, x[ix], 9, -1019803690);
          ix = i + 3;
          c = this.gg(c, d, a, b, x[ix], 14, -187363961);
          ix = i + 8;
          b = this.gg(b, c, d, a, x[ix], 20, 0x455a14ed);
          ix = i + 13;
          a = this.gg(a, b, c, d, x[ix], 5, -1444681467);
          ix = i + 2;
          d = this.gg(d, a, b, c, x[ix], 9, -51403784);
          ix = i + 7;
          c = this.gg(c, d, a, b, x[ix], 14, 0x676f02d9);
          ix = i + 12;
          b = this.gg(b, c, d, a, x[ix], 20, -1926607734);
          ix = i + 5;
          a = this.hh(a, b, c, d, x[ix], 4, -378558);
          ix = i + 8;
          d = this.hh(d, a, b, c, x[ix], 11, -2022574463);
          ix = i + 11;
          c = this.hh(c, d, a, b, x[ix], 16, 0x6d9d6122);
          ix = i + 14;
          b = this.hh(b, c, d, a, x[ix], 23, -35309556);
          ix = i + 1;
          a = this.hh(a, b, c, d, x[ix], 4, -1530992060);
          ix = i + 4;
          d = this.hh(d, a, b, c, x[ix], 11, 0x4bdecfa9);
          ix = i + 7;
          c = this.hh(c, d, a, b, x[ix], 16, -155497632);
          ix = i + 10;
          b = this.hh(b, c, d, a, x[ix], 23, -1094730640);
          ix = i + 13;
          a = this.hh(a, b, c, d, x[ix], 4, 0x289b7ec6);
          ix = i + 0;
          d = this.hh(d, a, b, c, x[ix], 11, -358537222);
          ix = i + 3;
          c = this.hh(c, d, a, b, x[ix], 16, -722521979);
          ix = i + 6;
          b = this.hh(b, c, d, a, x[ix], 23, 0x4881d05);
          ix = i + 9;
          a = this.hh(a, b, c, d, x[ix], 4, -640364487);
          ix = i + 12;
          d = this.hh(d, a, b, c, x[ix], 11, -421815835);
          ix = i + 15;
          c = this.hh(c, d, a, b, x[ix], 16, 0x1fa27cf8);
          ix = i + 2;
          b = this.hh(b, c, d, a, x[ix], 23, -995338651);
          ix = i + 0;
          a = this.ii(a, b, c, d, x[ix], 6, -198630844);
          ix = i + 7;
          d = this.ii(d, a, b, c, x[ix], 10, 0x432aff97);
          ix = i + 14;
          c = this.ii(c, d, a, b, x[ix], 15, -1416354905);
          ix = i + 5;
          b = this.ii(b, c, d, a, x[ix], 21, -57434055);
          ix = i + 12;
          a = this.ii(a, b, c, d, x[ix], 6, 0x655b59c3);
          ix = i + 3;
          d = this.ii(d, a, b, c, x[ix], 10, -1894986606);
          ix = i + 10;
          c = this.ii(c, d, a, b, x[ix], 15, -1051523);
          ix = i + 1;
          b = this.ii(b, c, d, a, x[ix], 21, -2054922799);
          ix = i + 8;
          a = this.ii(a, b, c, d, x[ix], 6, 0x6fa87e4f);
          ix = i + 15;
          d = this.ii(d, a, b, c, x[ix], 10, -30611744);
          ix = i + 6;
          c = this.ii(c, d, a, b, x[ix], 15, -1560198380);
          ix = i + 13;
          b = this.ii(b, c, d, a, x[ix], 21, 0x4e0811a1);
          ix = i + 4;
          a = this.ii(a, b, c, d, x[ix], 6, -145523070);
          ix = i + 11;
          d = this.ii(d, a, b, c, x[ix], 10, -1120210379);
          ix = i + 2;
          c = this.ii(c, d, a, b, x[ix], 15, 0x2ad7d2bb);
          ix = i + 9;
          b = this.ii(b, c, d, a, x[ix], 21, -343485551);
          a = this.add(a, olda);
          b = this.add(b, oldb);
          c = this.add(c, oldc);
          d = this.add(d, oldd);
          i = i + 16;
       }
       a = this.rhex(a);
       return String.valueOf(a)+this.rhex(b)+this.rhex(c)+this.rhex(d);
    }
}
