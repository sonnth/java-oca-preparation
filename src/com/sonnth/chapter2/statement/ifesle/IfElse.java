package com.sonnth.chapter2.statement.ifesle;

public class IfElse {
    public static void main(String[] args) {
        int hourOfDay = 3;
        int morningGreetingCount = 1;
        if(hourOfDay < 11)
            morningGreetingCount++;
        System.out.println("Good Morning");
        System.out.println(morningGreetingCount);

    }
}
