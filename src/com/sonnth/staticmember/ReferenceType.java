package com.sonnth.staticmember;

public class ReferenceType {
    public void fly(String s) {
        System.out.print(s);
    }

    public void fly(Object o) {
        System.out.print(o);
    }

    public static void main(String[] args) {
        ReferenceType r = new ReferenceType();
        r.fly("3");
        r.fly(3);
    }
}