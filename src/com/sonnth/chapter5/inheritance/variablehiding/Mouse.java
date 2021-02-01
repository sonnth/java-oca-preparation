package com.sonnth.chapter5.inheritance.variablehiding;

import com.sonnth.chapter5.abstractclass.Swan;

public class Mouse extends Rodent {
    protected static int tailLength = 8;

    public void getMouseDetails() {
        System.out.println("[tail=" + tailLength + ",parentTail=" + super.tailLength + "]");
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        mouse.getRodentDetails();
        mouse.getMouseDetails();
        String swan = new Swan() {
            @Override
            public String getNameA() {
                return "new thing";
            }
        }.getName();
    }
}
