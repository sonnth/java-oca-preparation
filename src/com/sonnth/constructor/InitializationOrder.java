package com.sonnth.constructor;

public class InitializationOrder {
    private String name = "Torchie";

    {
        System.out.println(name);
    }

    private static int COUNT = 0;

    static {
        for (int i = 0; i < 18; i++) {
            System.out.println(String.format("sonnth %s", i));
        }
        System.out.println(COUNT);
    }

    {
        COUNT++;
        System.out.println(COUNT);
    }

    public InitializationOrder() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("read to construct");
//        new InitializationOrder();
    }
}
