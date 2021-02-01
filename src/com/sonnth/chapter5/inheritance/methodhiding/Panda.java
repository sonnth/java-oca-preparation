package com.sonnth.chapter5.inheritance.methodhiding;

public class Panda extends Bear {
    public static void eat() {
        System.out.println("Panda bear is chewing");
    }

    public static void main(String[] args) {
        Panda.eat();
    }
}
