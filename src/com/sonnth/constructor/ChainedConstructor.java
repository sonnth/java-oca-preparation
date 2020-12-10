package com.sonnth.constructor;

public class ChainedConstructor {

    int weight;
    String color;
    public ChainedConstructor(int weight) {
        this(weight, "brown"); // DOES NOT COMPILE
        System.out.println("in constructor");
// ready to call this
    }
    public ChainedConstructor(int weight, String color) {
//        this(weight, "brown"); // DOES NOT COMPILE
        System.out.println("in constructor");
// ready to call this
    }

    public static void main(String[] args) {
        ChainedConstructor constructor = new ChainedConstructor(1);
    }
}
