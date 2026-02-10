package com.nandini.oops.inheritance;

public class Box {
    private double l; // can use l in this file only, class Box only!!
    double h;
    double w;

    Box(){
        super(); // Object class -> refer to the class just above it!!
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    Box(double side){
        this.l = side;
        this.h = side;
        this.w = side;
    }

    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }

    Box(Box old){
        this.l = old.l;
        this.h = old.h;
        this.w = old.w;
    }

    public void information(){
        System.out.println("Running this Box Class.");
    }

}
