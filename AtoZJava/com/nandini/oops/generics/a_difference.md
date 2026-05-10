### 🟢🟢🟢
Que: difference in
```
ArrayList list = new ArrayList();
ArrayList<Integer> list2 = new ArrayList<>();
```

Ans:

The difference lies in **type safety** and **generics**:

- **Raw ArrayList**
  ```java
  ArrayList list = new ArrayList();
  ```
    - This creates a raw `ArrayList` without specifying a type.
    - You can add any type of object (Integer, String, custom objects, etc.).
    - But when retrieving, you must cast manually, which can lead to **runtime errors**.
    - Example:
      ```java
      list.add("Hello");
      list.add(10); // allowed
      String s = (String) list.get(0); // must cast
      ```

- **Generic ArrayList**
  ```java
  ArrayList<Integer> list2 = new ArrayList<>();
  ```
    - This uses **generics** to enforce type safety.
    - Only `Integer` objects can be added.
    - No need for casting when retrieving, since the compiler knows the type.
    - Example:
      ```java
      list2.add(10);   // allowed
      list2.add("Hi"); // compile-time error
      int x = list2.get(0); // no cast needed
      ```

### Key Differences
| **Raw ArrayList** | **Generic ArrayList** |
|------------------|------------------|
| No type specified | Type parameter specified (`<Integer>`) |
| Can store mixed types | Stores only specified type |
| Requires casting on retrieval | No casting needed |
| Errors appear at runtime | Errors caught at compile-time |

👉 In modern Java, **always prefer generics** (`ArrayList<Integer>`) for type safety and cleaner code.

### 🟢🟢🟢
A use showing raw arrayList

Using a **raw ArrayList** is straightforward, but it comes with trade-offs. Here’s how you can use it:

```java
import java.util.ArrayList;

public class RawArrayListDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList(); // raw ArrayList

        // You can add different types of objects
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        // Retrieving requires casting
        String s = (String) list.get(0);   // must cast
        int num = (Integer) list.get(1);   // must cast
        double d = (Double) list.get(2);   // must cast

        System.out.println(s + " " + num + " " + d);
    }
}
```

### Key Points
- **Mixed types**: You can store `String`, `Integer`, `Double`, or any object in the same list.
- **Casting required**: When retrieving, you must cast to the correct type. If you cast incorrectly, you’ll get a `ClassCastException` at runtime.
- **No compile-time safety**: The compiler won’t warn you if you add the wrong type. Errors only appear when running the program.

👉 Example of a runtime error:
```java
ArrayList list = new ArrayList();
list.add("Hello");
Integer num = (Integer) list.get(0); // Runtime error: ClassCastException
```

So, raw `ArrayList` is mostly used in **legacy code** (before Java 5, when generics were introduced). In modern Java, you should prefer **generic ArrayList** for type safety.

### 🟢🟢🟢
Here’s a **practical demo** of using a raw `ArrayList` in Java. Notice how it allows mixed types but requires casting when retrieving:

```java
import java.util.ArrayList;

public class RawArrayListPractice {
    public static void main(String[] args) {
        // Raw ArrayList (no type specified)
        ArrayList list = new ArrayList();

        // Adding different types of objects
        list.add("Hello");      // String
        list.add(25);           // Integer (autoboxed)
        list.add(3.14);         // Double
        list.add(true);         // Boolean

        // Retrieving values (must cast to correct type)
        String s = (String) list.get(0);
        int num = (Integer) list.get(1);
        double d = (Double) list.get(2);
        boolean flag = (Boolean) list.get(3);

        System.out.println("String: " + s);
        System.out.println("Integer: " + num);
        System.out.println("Double: " + d);
        System.out.println("Boolean: " + flag);

        // Example of runtime error (wrong cast)
        try {
            String wrong = (String) list.get(1); // Integer cast to String → error
        } catch (ClassCastException e) {
            System.out.println("Caught error: " + e);
        }
    }
}
```

### Output
```
String: Hello
Integer: 25
Double: 3.14
Boolean: true
Caught error: java.lang.ClassCastException
```

⚡ **Key takeaway:**  
Raw `ArrayList` lets you store anything, but you lose compile-time safety. If you cast incorrectly, you’ll get a runtime `ClassCastException`. That’s why modern Java prefers **generics** (`ArrayList<Integer>`, `ArrayList<String>`, etc.).

