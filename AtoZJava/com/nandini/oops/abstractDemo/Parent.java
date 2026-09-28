package com.nandini.oops.abstractDemo;

// concrete methods - normal methods
// abstract methods

public abstract class Parent {

    int age;
    final int VALUE; // final variables need to be initialized while declared

    public Parent(int age) { // constructor
        this.age = age;
        VALUE = 32456789;
    }

    static void hello(){
        System.out.println("hey");
    }

    void normal() { // called concrete methods or normal methods
        System.out.println("this is a normal method");
    }

    abstract void career();
    abstract void partner();
}