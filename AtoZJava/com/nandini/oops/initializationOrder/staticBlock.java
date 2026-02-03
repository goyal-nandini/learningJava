package com.nandini.oops.initializationOrder;

public class staticBlock {
    static int a = 5;
    static int b;

// 1. Static block:
// THE static block (also called static initializer) is a block of code that runs once when the class is first loaded into
// memory.
// runs BEFORE main!
// run only once, when first obj is created is when class is loaded for first time.
// runs even if you never create an object!

    static{
        System.out.println("This is static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        staticBlock obj = new staticBlock();

        System.out.println(staticBlock.a);
        System.out.println(staticBlock.b);

        staticBlock.b += 3;

        System.out.println(staticBlock.b);

        staticBlock obj2 = new staticBlock();
        System.out.println(staticBlock.a);
        System.out.println(staticBlock.b);

        System.out.println(a);
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
