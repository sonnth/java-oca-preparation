package com.sonnth.chapter5.polymorphism;

public class Cat implements AnimalAction {
    @Override
    public String say(String a) {
        return "meow meow";
    }

    public String name;
    public boolean canHunt;
    public Cat(String name) {
        canHunt = huntingMouse();
        this.name = name;
    }

    public boolean huntingMouse() {
        return false;
    }
}
