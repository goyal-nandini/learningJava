package com.nandini.oops.interfaces;

public class PetrolEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Vroom! Petrol engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Ohh! Petrol engine stopped.");
    }
}
