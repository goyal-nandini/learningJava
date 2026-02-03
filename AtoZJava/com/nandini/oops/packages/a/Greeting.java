package com.nandini.oops.packages.a;

import static com.nandini.oops.packages.b.Message.messages;

public class Greeting {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("You are at package 'a': ");
        messages();
    }
// NOTE: When a package is imported, only those items within the package
// declared as public will be available to non-subclasses
// in the importing code.
}
