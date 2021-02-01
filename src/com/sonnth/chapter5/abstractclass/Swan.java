package com.sonnth.chapter5.abstractclass;

public abstract class Swan extends Animal {
    @Override
    public String getName() {
        return "Swan";
    }

    public abstract String getNameA();

    public static void main(String[] args) {
        String swan = new Swan() {
            @Override
            public String getNameA() {
                return "new thing";
            }
        }.getName();
        System.out.println(swan);
    }
}
