package com.nandini.oops.objectCloning;

import java.util.Arrays;

public class Main {
    static void main() throws CloneNotSupportedException {
        Human kunal = new Human(34, "Kunal Kushwaha");

        // cloning object
        Human twin = (Human) kunal.clone(); // creates shallow copy

        System.out.println("Before changing array:");
        System.out.println(Arrays.toString(kunal.arr));
        System.out.println(Arrays.toString(twin.arr));

        // changing cloned object's array
        twin.arr[0] = 100; // changes the twin array only

        System.out.println("\nAfter changing twin array:");

        System.out.println("Original object array:");
        System.out.println(Arrays.toString(kunal.arr));

        System.out.println("Cloned object array:");
        System.out.println(Arrays.toString(twin.arr));
    }
}
