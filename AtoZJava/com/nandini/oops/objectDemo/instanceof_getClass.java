package com.nandini.oops.objectDemo;

class C { }
class D extends C { }  // D is a subclass of C

public class instanceof_getClass {
    static void main(String[] args) {
        C c = new C();
        D d = new D();

        // Question 1:
        System.out.println(d instanceof C);  // true, because D is-a C (inheritance)

        // Question 2:
        System.out.println(d.getClass() == c.getClass());  // false

/*getClass() doesn't return the "just above class" — it returns the exact runtime class of the object.
So:
c.getClass() → returns C
d.getClass() → returns D

That's why they're not equal — C != D.*/

    }
}
