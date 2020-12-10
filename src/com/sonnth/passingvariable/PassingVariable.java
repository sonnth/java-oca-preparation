package com.sonnth.passingvariable;

import com.sonnth.object.Person;

public class PassingVariable {
    public static void main(String[] args) {
//        Person person = new Person();
//        person.name = "SON";
//        newAge(person);
//        System.out.println(person.name);
        int num = 1;
        newNum(3);
        fly(3);
    }
    public static void fly(Integer numMiles) { }
    static int i;
    private static void newNum(int i) {
        i = 2;
    }

    private static void newAge(Person person) {
        person.name = "HOANG";
    }
}
