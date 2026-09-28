package com.nandini.oops.exceptionHandling;

public class Demo {
    static int divide(int a, int b) throws ArithmeticException{
        if(b == 0){
            throw new ArithmeticException("cannot divide by zero");
        }

        return a/b;
    }
    static void main() {
        try{
            System.out.println(divide(10, 0));
        } catch(ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
