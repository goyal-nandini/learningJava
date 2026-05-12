package com.nandini.oops.objectCloning;

// reference assignment it is
// case 1.

class Student{
    int marks;

    public Student(int marks) {
        this.marks = marks;
    }
}
public class NoCopy {
    static void main() {
        Student s1 = new Student(90);

        Student s2 = s1; // no copy, It only copies: reference/address
        // Both variables point to SAME object.
        // not shallow copy
        // same object, two references
        // memory one object only

        s2.marks = 50;

        System.out.println(s1.marks); // 50 not 90 as only reference is copied, one object two references.

        // now we want real copy, want independent object, then changing won't affect others.
        // this is where cloning/cpoying comes.
    }
}
