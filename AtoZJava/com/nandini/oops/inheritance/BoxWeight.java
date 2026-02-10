package com.nandini.oops.inheritance;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight() {
        this.weight = -1;
    }

    // copy constructor it is!!
    BoxWeight (BoxWeight other){
        super(other); // this is same as using this: Box box5 = new BoxWeight(2, 3, 4, 8);
        // "other" ^ is a "BoxWeight type" and calls "Box" constructor which demands "Box type"
        // this Calls "Box(Box old)" with "other"
        // copies Box properties: l, h, w from "other"

        // This works because:
        // BoxWeight IS-A Box (inheritance)
        // In Java:
        // Child can be passed where parent is expected
        // This is polymorphism!
// overall, it does Copy parent properties via parent copy constructor

//Important Note ⚠️
//This works because Box has a copy constructor: Box (Box old) { ... }

        weight = other.weight; // has BoxWeight properties
    }

    public BoxWeight(double l, double h, double w, double weight) {
//📌RULE: super() must be the FIRST statement.
        super(l, h, w); // -> call the parent class constructor!!
        // used to initialise the values in parent class

/*What is super? 🤔
super is a reference variable used to refer to the parent class (superclass).
Think of it as:

this → refers to current class
super → refers to parent class

3 Main Uses of super 🎯

Call parent class constructor
Access parent class variables
Call parent class methods
*/
// IMP:
// 1. super.variable - Access Parent Variables 📦
//When child and parent have same variable name, use super to access parent's version.

// 2. super.method() - Call Parent Methods 🔧
//When child overrides parent's method, use super to call parent's version.

// 3. MISTAKE: Using super with static.
// super is for instance members, not static!

/*QUICK Q&A:
* Q: What is super keyword?
A: "super is a reference variable that refers to the parent class. It's used to call parent class constructors, access parent class variables when shadowed, and call parent class methods when overridden."

* Q: Can we use this() and super() together?
A: "No, both must be the first statement in a constructor, so we can only use one or the other."

* Q: What if we don't write super()?
A: "Java automatically adds super() to call the parent's no-argument constructor. If the parent doesn't have a no-arg constructor, we must explicitly call super() with appropriate arguments."
*/

        this.weight = weight;
    }

    BoxWeight(double side, double weight){
        super(side);
        this.weight = weight;
    }
}
