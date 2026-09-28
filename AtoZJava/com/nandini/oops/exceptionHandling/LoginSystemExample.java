package com.nandini.oops.exceptionHandling;

public class LoginSystemExample {
    private static void login(String password){
        if(!password.equals("admin123")){
            throw new ArithmeticException("Wrong password");
        }

        System.out.println("Login successful");
    }

    static void main() {
        try{
            login("abc");
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Program continues...");
    }
}
