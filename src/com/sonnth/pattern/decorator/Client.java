package com.sonnth.pattern.decorator;

public class Client {
    public static void main(String[] args) {
        ChristmasTree tree1 = new Garland(new Garland(new ChristmasTreeImpl()));

        System.out.println(tree1);
    }

}
