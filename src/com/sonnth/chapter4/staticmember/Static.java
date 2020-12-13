package com.sonnth.chapter4.staticmember;

import static java.lang.System.*;


public class Static {
    private static final String test;
    static {
        test = "afa";
    }
    public static void main(String... args) {
        out.println("12421");
        out.println(Byte.MAX_VALUE);
    }
}
