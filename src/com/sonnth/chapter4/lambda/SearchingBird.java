package com.sonnth.chapter4.lambda;

import java.util.ArrayList;
import java.util.List;

public class SearchingBird  {
   static int a =2;
    public static void main(String... args) {
        List<Bird> birds = new ArrayList<>();
        birds.add(new Bird("chicken", true, false));
        birds.add(new Bird("phoenix", true, false));
        birds.add(new Bird("penguin", false, true));
        birds.removeIf(bird -> bird.canFly());
        print(birds, bird -> !bird.canSwim()); // pass class that does check
    }

    void sss() {
        aaaa(true, new boolean[2]);
    }

    void aaaa(boolean sa, boolean... afsa) {

    }

    private static void print(List<Bird> birds, CheckFly<Bird> checker) {
        for (Bird bird : birds) {
            if (checker.test(bird))
                System.out.println(bird + " ");
        }
        System.out.println();
    }
}
