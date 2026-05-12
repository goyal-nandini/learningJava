package com.nandini.oops.objectCloning;

public class Human implements Cloneable{ // Human objects are allowed to be cloned.
    // Without this[implements Cloneable]: super.clone() would throw: CloneNotSupportedException

    int age; // primitive
    String name; // object reference
    int[] arr; // object reference

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
        this.arr = new int[]{3, 4, 5, 6, 9, 1};
    }

// this is shallow copy
//    @Override
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }

    // this is deep copy
    @Override
    public Object clone() throws CloneNotSupportedException{

        Human twin = (Human)super.clone(); // this is actually shallow copy

        /*
            After shallow copy:

            twin.age  -> copied
            twin.name -> reference copied (safe because String immutable)
            twin.arr  -> SAME array reference shared
        */

        // make a deep copy
        twin.arr = new int[twin.arr.length]; // new array object
        for (int i = 0; i < twin.arr.length; i++) { // this loop copies values one-by-one.
            twin.arr[i] = this.arr[i]; // Copies values from old array to new array.
        }

        // returned clones object
        return twin;
    }

}
