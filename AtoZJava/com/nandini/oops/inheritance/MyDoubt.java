package com.nandini.oops.inheritance;

class A {
    int a = 1;
    void display(){
        System.out.println("A");
    }
}

class B extends A{
    int b = 2;
    void display(){
        System.out.println("B");
    }
}

class C extends A{
    int c = 3;
    void display(){
        System.out.println("C");
    }
}

// ❌❗not allowed multi-level inheritance of classes, follow this guide
// https://www.geeksforgeeks.org/java/diamond-problem-in-java/
//class D extends B C{
//    int c = 3;
//    void display(){
//        System.out.println("C");
//    }
//}

//the correct statement is:
//Java supports multilevel inheritance, but not multiple inheritance of classes.

public class MyDoubt {
    public static void main(String[] args) {
        A objA = new B();
        objA.display(); // B <- this is late binding, dynamic/runtime polymorphism,
// it is decided at runtime that the method will print will be of object type.
// Because Java uses runtime polymorphism for methods.
// The reference type decides what you can access,
// the object type decides what actually runs.
// So even though the reference is A, the object is B, so B.display() runs.
// Late binding happens when Java waits until runtime to decide which overridden method to execute. ⚡

        System.out.println(objA.a); // 1 -> variables are non-polymorphic
// Fields use compile-time binding, not runtime binding.
// Variable access depends only on the reference type.
// Here the reference is A, so Java reads A.a


//        Important rule:
//👉 Methods → runtime polymorphism
//👉 Variables → compile-time binding
//        Methods follow object type. Fields follow reference type. ⚡

        // System.out.println(objA.b); // ERROR
    }
}


