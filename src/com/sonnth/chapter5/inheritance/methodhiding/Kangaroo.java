package com.sonnth.chapter5.inheritance.methodhiding;

public class Kangaroo extends Marsupial {
    public final boolean isBiped() {
        return true;
    }

    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: " + isBiped());
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        joey.getMarsupialDescription();
        joey.getKangarooDescription();
        new Marsupial().getMarsupialDescription();
    }
}
