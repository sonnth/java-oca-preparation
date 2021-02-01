package com.sonnth.chapter5.inheritance.exception;

public class Reptile {
    protected boolean hasLegs() throws InsufficientDataException, NotFoundException{
        throw new InsufficientDataException();
    }

    protected double getWeight() throws Exception {
        return 2;
    }
}
