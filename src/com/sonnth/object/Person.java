package com.sonnth.object;

public class Person {
    public String name;
    public int age;
    public static String gender = "male";
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
