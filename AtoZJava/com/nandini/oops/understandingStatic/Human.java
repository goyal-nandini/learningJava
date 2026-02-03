package com.nandini.oops.understandingStatic;

public class Human {
    int age; // non-static -> instance variable
    String name;
    int salary;
    boolean isMarried;
    static long population; // static -> class variable

    public Human(int age, String name, int salary, boolean isMarried) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.isMarried = isMarried;
        population += 1;
//        Human.population += 1; also correct!! and recommended

    }

    public static void main(String[] args) {
        // This is a static context!!
        System.out.println(population); // ✅ Works! static accessing static

//        System.out.println(age); // ❌ ERROR! as static accessing non-static
//        // Which object's age? nandini's? kartik's? No object exists yet!
         // non-static, cannot access from static context.!!
/*Concept:
The Core Reason 🎯:
Static things exist BEFORE any object is created.
Non-static things exist ONLY when an object is created.
So, how can something (static) that exists before objects reference something (non-static) that doesn't exist yet?*/
    }

    // Static method
    public static void staticMethod() {
        System.out.println(population);  // ✅ Works
        // System.out.println(age);      // ❌ ERROR
        // System.out.println(name);     // ❌ ERROR

        // System.out.println(this.name);     // ❌ ERROR, this is a reference to the current object
        // But in a static method, there's NO object! So this has nothing to point to!

        // But this works:
        Human h = new Human(20, "Test", 0, false);
        System.out.println(h.age);  // ✅ Works! We have an object now
    }

    // Non-static method
    public void nonStaticMethod() {
        System.out.println(age);        // ✅ Works (this object's age)
        System.out.println(population); // ✅ Works (static always accessible)
    }

/*The Rules 📝
From ↓ / To →   Static      Non-static
Static          ✅ Yes       ❌ No (need object)
Non-static      ✅ Yes       ✅ Yes*/

}
