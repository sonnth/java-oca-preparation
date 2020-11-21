package com.sonnth.primitivevalue;

public class PrimitiveType {
    public static void main(String[] args) {
//        int x = (int)1.0;
//        short y = (short)192122; // Stored as 20678
//        int z = (int)9l;
//        long t = 192301398193810323L;
//        System.out.println(x);
//        System.out.println(y);
//        System.out.println(z);
//        System.out.println(t);
//        System.out.print(2147483647+1); // -2147483648


        int m = 9, n = 1, x = 0; while(m > n) {
            m--;
            n += 2;
            x += m + n;
        }
        int s=1;
        s += 1 + 2+3;
        System.out.println(s);
    }
}
