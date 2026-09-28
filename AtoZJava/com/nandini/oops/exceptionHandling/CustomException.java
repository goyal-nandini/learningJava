package com.nandini.oops.exceptionHandling;

// custom exception

class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
        super(message); // IMP line: WHY Needed?
//        Because: Exception class already stores message internally. You’re
//        passing your custom message to parent Exception class.
//        Then later: e.getMessage() can retrieve it.

        // passes message to parent Exception class.
    }
}
public class CustomException {
    static void checkAge(int age) throws InvalidAgeException{
        if(age<18){
            throw new InvalidAgeException("You are not eligible to vote");
        }

        System.out.println("you can vote");
    }
    static void main() {
        try{
            checkAge(15);
        } catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        } finally{
            System.out.println("program ended");
        }

/*
One imp thing:
Exceptions are:
OBJECTS

Example:
new ArithmeticException()
creates exception object.

That’s why:

inheritance works
polymorphism works
catch hierarchy works*/
    }
}
