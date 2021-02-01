package com.sonnth.chapter5.inheritance.exception;

public class Snake extends Reptile {
    protected boolean hasLegs() throws NotFoundException{
        return false;
    }

    protected double getWeight() throws InsufficientDataException {
        return 2;
    }
}