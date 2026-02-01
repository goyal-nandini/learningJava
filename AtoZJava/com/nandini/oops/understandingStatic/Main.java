package com.nandini.oops.understandingStatic;

public class Main {
    public static void main(String[] args) {
        Human nandini = new Human(20, "Nandini", 20000, false);
        Human kartik = new Human(16, "kartik", 20000, false);
        Human laksh = new Human(25, "Laksh", 20000, true);

//        System.out.println(nandini.population); // not recommended!!
        System.out.println(Human.population); // prints 3 but que is why??

/*
The Key Point 🔑
static variables are NOT independent of objects - they are SHARED by all objects!
Think of it like this:

There's only ONE population variable in memory
ALL objects share this same variable
When ANY object modifies it, everyone sees the change!

Step-by-Step Execution 🪜
Let's trace through your code:

static long population;  // Initially 0 (default value for long)

Object 1: nandini
javaHuman nandini = new Human(20, "Nandini", 20000, false);
// Constructor runs: this.population += 1;
// population = 0 + 1 = 1
Population is now: 1

Object 2: kartik
javaHuman kartik = new Human(16, "Kartik", 20000, false);
// Constructor runs: this.population += 1;
// population = 1 + 1 = 2  (NOT starting from 0!)
Population is now: 2

Object 3: laksh
javaHuman laksh = new Human(25, "Laksh", 20000, true);
// Constructor runs: this.population += 1;
// population = 2 + 1 = 3  (still the SAME variable!)
Population is now: 3

Why It Prints 3, Not Different Values?
javaSystem.out.println(Human.population);  // 3
System.out.println(nandini.population); // 3
System.out.println(kartik.population);  // 3
System.out.println(laksh.population);   // 3
```

All print **3** because they're all accessing the **SAME** variable!

## Visual Representation
```
Memory Layout:

Static Area (Class level):
┌─────────────────────┐
│ Human.population: 3 │ ← ONE variable, shared by ALL
└─────────────────────┘
         ↑   ↑   ↑
         │   │   │
         │   │   └─── laksh can access it
         │   └─────── kartik can access it
         └─────────── nandini can access it

Your Confusion Cleared
You said: "shouldn't it be different for each object like 1 then 2 then 3"
No! Because:
It's not a separate variable for each object
It's ONE shared variable
Each constructor increments the same variable
After creating 3 objects, the shared population = 3
*/

        //📌new topic: accessing non-static methods inside static??!! possible or not!!
        // greeting(); // ❌ its an ERROR, from static u can't access non-static stuff!!
/*Concept:
The Core Reason 🎯:
Static things exist BEFORE any object is created.
Non-static things exist ONLY when an object is created.
So, how can something (static) that exists before objects reference something (non-static) that doesn't exist yet?*/
    }
//⭐ FUN FACT: EVERY NON-STATIC IS GOING TO BE CALLED FROM MAIN FUNCTION(STATIC) ULTIMATELY!!

    static void fun(){
        // this fun is not dependent on object

//        greeting(); // you can't use it b/c it req an instance,
        // but the function u are using it in, does not depend on instances

        // u cannot access non-static stuff without referencing their instances in a static context
        // here see i am referencing:
        Main obj = new Main();
        obj.greeting(); //correct !!
    }
    void greeting(){
        System.out.println("Hello");
    }

}
