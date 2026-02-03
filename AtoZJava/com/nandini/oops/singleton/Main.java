package com.nandini.oops.singleton;

public class Main {
    public static void main(String[] args) {
//        SingletonClass onj = new SingletonClass(); ERROR: we can't create object of this class
        // as its constructor is private!!

        SingletonClass obj1 = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        SingletonClass obj3 = SingletonClass.getInstance();
// OBSERVE: no new keyword while making object!!
/*Reason1: constructor is private. -> You CAN'T use new from outside the class because the constructor is private!

 * Reason2: getInstance() method used new internally.

Q: Why no new keyword?
A:
Constructor is private → Can't use new from outside
getInstance() uses new internally → Hidden from you
This gives control → Ensures only ONE object is created

The new keyword IS used, just not by you directly! 🎯
 */
        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println(obj3);

        // all objects have same reference
    }
}
