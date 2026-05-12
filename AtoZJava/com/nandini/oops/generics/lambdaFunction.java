package com.nandini.oops.generics;

//Lambda is basically:
//shorter way to write objects of functional interfaces.
//That’s the core idea.

//MOST IMPORTANT RULE:
//Lambda works ONLY with: Functional Interfaces
//Meaning: interface having ONLY ONE abstract method.

import java.util.ArrayList;

import java.util.function.Consumer; // consumer is a built-in interface
// consumer means takes input and returns nothing, its abstract method is
// accept(T t)


public class lambdaFunction {
    static void main() {
//        Lambda does NOT create new syntax magic. It still creates an object internally.
//        Just shorter.

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<5; i++) arr.add(i+1);

        Consumer<Integer> fun = (item) -> System.out.println(item * 2); // this lambda implements accept()
        arr.forEach(fun); // means every item in "arr" call fun.accept(item)


        Operation sum = (a, b) -> a+b; // create Operation object whose operation() method returns addition.
        Operation prod = (a, b) -> a*b;
        Operation sub = (a, b) -> a-b;

        lambdaFunction myCal = new lambdaFunction();
        System.out.print(myCal.operate(5, 3, sum) + " ");
        System.out.print(myCal.operate(5, 3, prod) + " ");
        System.out.print(myCal.operate(5, 3, sub));
    }

    private int operate(int a, int b, Operation op){
        return op.operation(a, b);
    }
    // huge concept used here: passing functionality/behavior as argument
    // NOT just data.
    // That’s the real power of lambdas.
}

// functional interface
interface Operation {
    int operation(int a, int b);
}

/* SUPER IMPORTANT LAMBDA SYNTAX:

    (parameters) -> expression

OR

    (parameters) -> {
        multiple statements
    }

 final idea
 Lambda = concise implementation of functional interface.
 That’s all.
 */
