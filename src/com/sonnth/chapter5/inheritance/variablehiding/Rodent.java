package com.sonnth.chapter5.inheritance.variablehiding;

public class Rodent {
    protected  int tailLength = 4;

    public void getRodentDetails() {
        System.out.println("[parentTail=" + tailLength + "]");
    }
}
