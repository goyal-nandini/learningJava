package com.nandini.oops.polymorphism;

public class Square extends Shapes{
    @Override
    public void area(){
        System.out.println("Square area: side×side");
    }

    public void parameter(){
        System.out.println("Area of shape.");
    }
}
