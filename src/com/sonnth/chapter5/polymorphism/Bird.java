package com.sonnth.chapter5.polymorphism;

public class Bird implements AnimalAction {
    @Override
    public String say(String a) {
        return "twitter twitter";
    }

}
