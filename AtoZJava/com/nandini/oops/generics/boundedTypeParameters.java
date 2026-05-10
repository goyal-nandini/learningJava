package com.nandini.oops.generics;

// Bounded Type Parameters
// This is where generics become actually useful instead of “just flexible”.
class boundedgenMethodDemo{
    static <T extends Number> void show(T num){ // <T extends Number> means controlled flexibility
//        System.out.println(num);

        System.out.println(num.doubleValue());
        System.out.println(num.floatValue());
        System.out.println(num.intValue());

        // every T has inherited "Number" class so java guarantees every "T" has all the methods available to "Number" class.
        // or Every type used as T must extend the Number class, so Java guarantees that T has access to all methods of Number.

    }
/*MOST IMPORTANT OBSERVATION => This:
"extends"
does NOT only mean inheritance here.
It also means:
“extends OR implements”
because interfaces also supported.*/
}
public class boundedTypeParameters {
    static void main() {
        boundedgenMethodDemo.show(10);
        System.out.println();

        boundedgenMethodDemo.show(3.14);


//        boundedgenMethodDemo.show("Hello"); // Error
    }

    static <T> void square(T num) {
        // System.out.println(num * num); // Compile error

        // because compiler says what if T becomes String?
        //  Then: "Hello" * "Hello" => makes no sense.
    }
/*So We Need RESTRICTIONS, We tell Java:
“T must belong to Number family.”

Syntax => <T extends Number> Read as: 
“T can be Number or child classes of Number.”

Examples:

Integer
Double
Float
Long*/
}
