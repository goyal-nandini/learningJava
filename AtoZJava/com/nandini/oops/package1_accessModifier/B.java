package com.nandini.oops.package1_accessModifier;

public class B {
    static void main(String[] args) {
        A obj = new A();

//        System.out.println(obj.privateVar);  can't access
        System.out.println(obj.defaultVar); // access in same package only
        System.out.println(obj.protectedVar);  // Same package accessed
        System.out.println(obj.publicVar);
    }
}
