package com.nandini.oops.abstractDemo;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(30);
        son.career();

        son.normal();

        Parent daughter = new Son(28);
        daughter.career();

        Parent.hello(); // static method from Parent class
    }
}
