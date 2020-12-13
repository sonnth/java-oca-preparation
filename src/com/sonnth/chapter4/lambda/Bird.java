package com.sonnth.chapter4.lambda;

public class Bird {
    private String species;
    private boolean canFly;
    private boolean canSwim;

    public Bird(String species, boolean canFly, boolean canSwim) {
        this.species = species;
        this.canFly = canFly;
        this.canSwim = canSwim;
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean canSwim() {
        return canSwim;
    }
    public String toString() {
        return species;
    }


}
