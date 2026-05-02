package com.nandini.oops.objectDemo;

// what Object class has, it, does !?
// java.lang.Object is the topmost parent of every class in java

// class A { }  <- this means class A extends Object { }
// A obj = new A(); <- every object in java automatically has:
// toString(),
// equals(),
// hashCode(),
// getClass(),
// wait(), notify() (threads)
// Because they come from Object.


class A{
    @Override
    public String toString(){
        return "I am A";
    }

    A(){}

    int x;
    A(int x){
        this.x = x;
    }
}

class B{
    B(){}

    int x;
    B(int x){
        this.x = x;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof A)) return false;
        B other = (B) obj; // cast 'obj' of type Object to object 'other' of type B
        if(this.x == other.x) return true; // compare by value, not reference
        return false;
    }
/*So in equals(), which one should you use depends on your intention:

Use instanceof → if you want subclasses to be considered equal to parent
Use getClass() → if you want only exact same class to be considered equal

Most of the time in real code, getClass() is preferred inside equals()*/
}

// The golden rule: default equals() = == = reference. Overridden equals() = whatever YOU define.

public class ObjectClassDemo {
    public static void main(String[] args) {
        Object obj2 = new Object();
        System.out.println(obj2); // default: class name + hashcode
        System.out.println(obj2.getClass()); // class java.lang.Object

        A obj = new A();
        System.out.println(obj.toString());
        // default: class name + hashcode
        // after overriding it prints I am A

        // scenario 1. default equal()
        // default constructor
        A a1 = new A(); // a1.x = 0 (java default for int)
        A a2 = new A();
        System.out.println(a1.equals(a2)); // false - different references
        //  by default compare are they same object in memory as '==' does
        // Since you haven't overridden equals() in class A, it's using Object's default equals() —
        // which just does == under the hood (reference comparison).
        A a3 = a2;
        System.out.println(a3.equals(a2)); // true - same reference

        // parameterised constructor
        A a4 = new A(2);
        A a5 = new A(2);
        System.out.println(a4.equals(a5)); // false - different references
        // "Are a4 and a5 the same object in memory?"
        // And they're not — they were created with two separate new calls.

        // scenario 2. overridden equals()
        // default constructor
        B b1 = new B(); // b1.x = 0
        B b2 = new B(); // b2.x = 0
        System.out.println(b1.equals(b2)); // true - x values are equal (0 == 0)

        // parameterised constructor
        B b3 = new B(5);
        B b4 = new B(5);
        B b5 = new B(7);
        System.out.println(b3.equals(b4)); // true - x values are same
        System.out.println(b3.equals(b5)); // false - diff values

        // edge case
        System.out.println(b3.equals(null)); // false - null check
        System.out.println(b3.equals("hello")); // false - instanceof check
    }
}
