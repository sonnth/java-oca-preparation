package com.sonnth;

import com.sonnth.object.Person;

/*
 * Main method is the gateway between the startup of a Java process
 * Managed by JVM
 */
public class Main {
    public static void main(String... $n) {
        Person son = new Person("Son");
        Person son1 = son;
        son = null;
        System.out.println(son1);
        System.out.println(son);
    }

}
