🟢🟢🟢
**In Java, an abstract class is a class that cannot be instantiated directly. It can contain both abstract methods
(without implementation) and concrete methods (with implementation). Abstract methods must be implemented by subclasses,
while concrete methods can be inherited or overridden.**

---

## 🔑 Key Concepts

### 1. Abstract Class
- Declared using the `abstract` keyword.
- **Cannot be instantiated** directly.
- Can contain:
  - **Abstract methods** (no body, only signature).
  - **Concrete methods** (normal methods with implementation).
  - Fields, constructors, and even static/final methods.
- Used for **partial abstraction** — sharing common code while forcing subclasses to implement specific behavior.
 [GeeksForGeeks](https://www.geeksforgeeks.org/java/abstract-classes-in-java/)

---

### 2. Abstract Methods
- Declared with `abstract` keyword, no body:
  ```java
  abstract void draw();
  ```
- Must be implemented by subclasses unless the subclass is also declared abstract.
- Provide a **contract** that subclasses must fulfill.
 [docs.oracle.com](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

---

### 3. Concrete Methods
- Normal methods with full implementation inside an abstract class:
  ```java
  void getColor() {
      System.out.println("Color: " + color);
  }
  ```
- Subclasses **inherit** them automatically.
- Can be **overridden** unless marked `final`.  [Stack Overflow](https://stackoverflow.com/questions/16675642/concrete-method-in-abstract-class)

---

## 📊 Comparison Table

| Feature | Abstract Class | Abstract Method | Concrete Method |
|---------|----------------|-----------------|-----------------|
| **Definition** | Class declared with `abstract` keyword | Method without body | Method with full implementation |
| **Instantiation** | Cannot be instantiated | Cannot be called directly | Can be called directly |
| **Subclass Requirement** | Must extend to use | Must be implemented in subclass | Optional to override |
| **Purpose** | Provide base + partial abstraction | Define contract for subclasses | Provide reusable functionality |

---

## ✅ Example

```java
abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    // Abstract method
    abstract double area();

    // Concrete method
    void getColor() {
        System.out.println("Color: " + color);
    }
}

class Circle extends Shape {
    int radius;

    Circle(String color, int radius) {
        super(color);
        this.radius = radius;
    }

    // Implement abstract method
    double area() {
        return Math.PI * radius * radius;
    }
}

public class Demo {
    public static void main(String[] args) {
        Shape s = new Circle("Red", 5);
        s.getColor(); // Concrete method
        System.out.println("Area: " + s.area()); // Abstract method implemented
    }
}
```

**Output:**
```
Color: Red
Area: 78.53981633974483
```

---

## ⚡ Quick Recap
- **Abstract class** = blueprint with partial abstraction.
- **Abstract method** = must be implemented by subclass.
- **Concrete method** = already implemented, can be reused or overridden.

---

🟢🟢🟢
Ah, I see — you meant **concrete classes**, not concrete methods. Let’s clarify that distinction:

---

## 🔹 Concrete Classes
- A **concrete class** is a normal class in Java that can be **instantiated** (you can create objects from it).
- It provides **full implementation** of all its methods.
- Unlike abstract classes, it **cannot** have abstract methods.
- Example:
  ```java
  class Dog {
      void bark() {
          System.out.println("Woof!");
      }
  }

  public class Demo {
      public static void main(String[] args) {
          Dog d = new Dog(); // concrete class instantiation
          d.bark();
      }
  }
  ```

---

## 🔹 Abstract vs Concrete Classes

| Feature | Abstract Class | Concrete Class |
|---------|----------------|----------------|
| Instantiation | Cannot be instantiated | Can be instantiated |
| Methods | Can have abstract + concrete methods | Only concrete methods |
| Purpose | Provide a blueprint, enforce contracts | Provide full implementation |
| Usage | Extended by subclasses | Used directly to create objects |

---

## 🔹 How They Relate
- **Abstract classes** are like **blueprints** — they define what must exist but don’t fully implement everything.
- **Concrete classes** are the **actual buildings** — they provide complete implementation and can be used directly.
- If a class extends an abstract class, it must implement all abstract methods to become a **concrete class**.

---

✅ **Quick Recap:**  
- **Abstract class** = cannot be instantiated, may contain abstract methods.  
- **Concrete class** = fully implemented, can be instantiated.  
- Subclasses of abstract classes become **concrete classes** once they implement all abstract methods.

---

