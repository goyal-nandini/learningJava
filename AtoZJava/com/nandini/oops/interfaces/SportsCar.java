package com.nandini.oops.interfaces;

public class SportsCar implements PowerCar {
    @Override
    public void start() {
        System.out.println("Sports car started");
    }

    @Override
    public void stop() {
        System.out.println("Sports car stopped");
    }

    @Override
    public void turboBoost() {
        System.out.println("TURBO ACTIVATED");
    }
}
// SportsCar had to implement all three — the two inherited from Engine + the one from PowerEngine.
