package com.nandini.oops.initializationOrder;

// 2. Instance Initializer Block (Non-Static Block) 📦
//Similar to static block, but for instance variables. Runs every time an object is created.
//Instance blocks run **every time** an object is created!

public class instanceBlock {
    int y;

    {
        System.out.println("Instance block 1");
        y = 100;
    }

    {
        System.out.println("Instance block 2");
        y = 200;
    }

    public instanceBlock() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        System.out.println("Main starts");
        instanceBlock obj1 = new instanceBlock();
        System.out.println("y = " + obj1.y);
        System.out.println("---");
        instanceBlock obj2 = new instanceBlock();
        System.out.println("y = " + obj2.y);

    }
/*3. Complete Initialization Order 🎯

When a class is loaded and objects are created, here's the **exact order**:

### The Full Order:
```
1. Static variables initialization (in order of declaration)
2. Static blocks (in order of appearance)
3. Instance variables initialization (in order of declaration)
4. Instance blocks (in order of appearance)
5. Constructor*/
}
