package com.nandini.oops.polymorphism;

/*
Here’s a clear comparison table for **Overloading vs Overriding 📊**:

| Feature            | Overloading                          | Overriding                                |
|---------------------|--------------------------------------|-------------------------------------------|
| **When?**           | Compile-time                        | Runtime                                   |
| **Where?**          | Same class                          | Parent-child (inheritance) classes        |
| **Method name**     | Same                                | Same                                      |
| **Parameters**      | Different                          | Same                                      |
| **Return type**     | Can be different                   | Must be same (or covariant)               |
| **Access modifier** | Any                                | Same or less restrictive                  |
| **Purpose**         | Provide multiple ways to call a method | Change/extend parent class behavior        |

This table captures the essence: **overloading** is about flexibility in method signatures, while **overriding**
is about redefining inherited behavior.*/

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Square square = new Square();
        Triangle triangle = new Triangle();
        Circle circle = new Circle();

        shape.area();
        square.area();

        Shapes shp = new Square();
        shp.area(); // calling square method. but WHY??
// as we are told that obj can access the reference type properties only,
// so here it should be shape method!!

// type of method called in overriding depend upon what type of object is it!!
// what the obj is able to access is defined by the reference type and
// which one is it able to access is defined by the type of object

// the above case: if the type of reference variable is the parent class but the object is of type
// subclass
// basically overriding is done when the reference variable is of parent type and which particular method will be called
// will be decided by the object type, that the reference variable is referencing to
// -> this case is called UPCASTING, entire thing is how overriding happens!!
// parent obj = new child()

// Now the question arises how all this happening?? There is this thing called "dynamic method dispatch" this is why
// It is known as dynamic polymorphism What it is it is a mechanism By which a call to an over hidden method is resolved
// at runtime rather than the compile time.
// As we know that super class reference variable can refer to a subclass object
// And when an overridden method is called through a super class reference variable java determines which version to
// that method Call based on the type of object at the runtime, this call happens hence this determination is made at
// the runtime.

// In other words It is the type of object being referred to Not the type of reference variable that determine which
// version of overridden method will be executed Also this is marked that the reference variable type tells us which
// all things you can access.

// Also this is the thing I have to check basically the parent class must have that method That is overridden by the
// subclass And also where the type of object only decides which version  of the method to call at runtime.

// Also I have to verify does the Object class extends the super class too?? Maybe it is not !!
// ans: It's the opposite! Every class extends Object class!

//👉👈 this all reside its in best form here: https://share.evernote.com/note/47afccd8-39e7-5e1f-65e4-b3696c983c80
// enjoy it and gyan: moh maya se durr rhoo...beta Nandini from all emotions to succeed!!(written by me)


        //⭐ compile-time/static polymorphism:
        // Rules for Method Overloading 📋
        //✅ Valid Overloading (different parameters):
//        void display(int a) { }
//        void display(double a) { }          // ✅ Different type
//        void display(int a, int b) { }      // ✅ Different number
//        void display(int a, String b) { }   // ✅ Different type & number

        //❌ Invalid Overloading:
//        void display(int a) { }
//        int display(int a) { }  // ❌ Only return type different - NOT allowed!
        //Remember: Return type alone is NOT enough for overloading!

/*
* ⭐⭐Two types:

Compile-time (Overloading) - Same name, different parameters
Runtime (Overriding) - Same signature, different implementation in child

Why important:

Core OOP principle
Code flexibility
Extensibility
Maintainability
* */

        // A FULL EXAMPLE:
        // Array of parent type, but holding child objects!
        Shapes[] shapes = {
                new Circle(),
                new Square(),
                new Triangle()
        };

        ShapeCalculator calc = new ShapeCalculator();
        calc.calculateAllAreas(shapes);
    }
}
// The power of polymorphism! ✨
class ShapeCalculator{
    void calculateAllAreas(Shapes[] shapes) {
        //                    ↑
        //              Parent type array

        for (Shapes shape : shapes) {
            //   ↑
            // Parent reference

            shape.area();  // Calls correct version automatically!
        }
    }
/*Why This Is Powerful? 💪
Without Polymorphism (Bad way):
void calculateAreas(Circle c, Square s, Triangle t) {
    c.area();
    s.area();
    t.area();
}

// What if we add Rectangle? Pentagon? Hexagon?
// Need to change the method signature every time! ❌
With Polymorphism (Good way):
void calculateAllAreas(Shape[] shapes) {
    for (Shape shape : shapes) {
        shape.area();  // Works for ANY shape!
    }
}

// Add Rectangle? Pentagon? Just create the class!
// No need to change this method! ✅
```

**The method doesn't care about the EXACT type - it just works!** 🎯*/
}

