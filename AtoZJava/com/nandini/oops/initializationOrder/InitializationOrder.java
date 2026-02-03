package com.nandini.oops.initializationOrder;

/*
| Feature        | Static Block            | Instance Block             |
|----------------|-------------------------|----------------------------|
| **Syntax**     | `static { }`            | `{ }`                      |
| **When?**      | Runs once during **class loading** | Runs **each time an object is created** |
| **Access**     | Can access **only static members** | Can access **both static and instance members** |
| **Use Case**   | Used to **initialize static resources** | Used to **initialize instance variables** |
| **Execution Order** | Executes **before `main()`** | Executes **before constructor** |
*/

public class InitializationOrder {
    // Step 1: Static variable
    static int staticVar = staticMethod();

    // Step 3: Instance variable
    int instanceVar = instanceMethod();

    // Step 2: Static block
    static {
        System.out.println("3. Static block");
    }

    // Step 4: Instance block
    {
        System.out.println("6. Instance block");
    }

    // Step 5: Constructor
    public InitializationOrder() {
        System.out.println("7. Constructor");
    }

    // Helper methods
    static int staticMethod() {
        System.out.println("1. Static variable initialization");
        return 100;
    }

    int instanceMethod() {
        System.out.println("5. Instance variable initialization");
        return 200;
    }

    // Step 2 continued: Another static block
    static {
        System.out.println("2. Another static block");
    }

    // Step 4 continued: Another instance block
    {
        System.out.println("6.5. Another instance block");
    }

    public static void main(String[] args) {
        System.out.println("4. Main method starts");
        InitializationOrder obj = new InitializationOrder();
        System.out.println("8. Main method ends");
    }
}
/*

        **Output:**
        ```
        1. Static variable initialization
3. Static block
2. Another static block
4. Main method starts
5. Instance variable initialization
6. Instance block
6.5. Another instance block
7. Constructor
8. Main method ends
```

        ---

        ## 4. Visual Flow Chart 📊
        ```
Class Loading Phase (happens ONCE):
        ┌─────────────────────────────────────┐
        │ 1. Static variables initialized     │
        │ 2. Static blocks executed (in order)│
        └─────────────────────────────────────┘
        ↓
        ┌─────────────────────────────────────┐
        │ 3. main() method starts              │
        └─────────────────────────────────────┘
        ↓
Object Creation Phase (happens EACH TIME):
        ┌─────────────────────────────────────┐
        │ 4. Instance variables initialized   │
        │ 5. Instance blocks executed (in order)│
        │ 6. Constructor executed              │
        └─────────────────────────────────────┘
*/