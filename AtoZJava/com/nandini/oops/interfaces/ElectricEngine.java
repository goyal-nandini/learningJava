package com.nandini.oops.interfaces;

public class ElectricEngine implements Engine{
    @Override
    public void start() {
        System.out.println("Silent. Electric engine started.");
    }

    @Override
    public void stop() {
        System.out.println("Wow, Electric engine stopped.");
    }
}
