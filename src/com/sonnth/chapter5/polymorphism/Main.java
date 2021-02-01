package com.sonnth.chapter5.polymorphism;

public class Main {
    public static void main(String[] args) {
        AnimalAction animalAction = (a -> "say abcd" + a);
        say(animalAction);
    }

    public static void say(AnimalAction animal) {
        System.out.println(animal.say("cccc"));
    }
}
