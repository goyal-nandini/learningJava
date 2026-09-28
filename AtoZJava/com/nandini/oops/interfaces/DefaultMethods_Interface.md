## Topic 2 — Default Methods in Interface

---

### First — feel the problem it solves

Say you shipped an interface to the world:

```java
interface Engine {
    void start();
    void stop();
}
```

1000 classes across different projects implement this.

Now you want to add a new method:

```java
interface Engine {
    void start();
    void stop();
    void selfDiagnose();  // new method added
}
```

**All 1000 classes break instantly** — because now they all must implement `selfDiagnose()` or they won't compile.

This is the problem default methods were created to solve.

---

### Default method — give a default body inside the interface

```java
interface Engine {
    void start();
    void stop();

    default void selfDiagnose() {
        System.out.println("Running standard diagnosis...");  // default body
    }
}
```

Now all 1000 existing classes — **zero changes needed.** They automatically inherit the default behavior.

---

### Class can override it if it wants

```java
class SportsCar implements Engine {
    public void start() { System.out.println("Sports start"); }
    public void stop()  { System.out.println("Sports stop");  }

    // overrides default — has its own special diagnosis
    public void selfDiagnose() {
        System.out.println("Sports car running advanced diagnosis...");
    }
}
```

```java
class NormalCar implements Engine {
    public void start() { System.out.println("Normal start"); }
    public void stop()  { System.out.println("Normal stop");  }

    // no selfDiagnose() — uses the default one ✅
}
```

```java
public class Main {
    public static void main(String[] args) {
        SportsCar s = new SportsCar();
        s.selfDiagnose();   // Sports car running advanced diagnosis...

        NormalCar n = new NormalCar();
        n.selfDiagnose();   // Running standard diagnosis...
    }
}
```

---

### Default vs Static method in interface

```java
interface Engine {
    default void selfDiagnose() {
        System.out.println("Default diagnosis");  // inherited by implementing class
    }

    static void description() {
        System.out.println("I am Engine interface");  // belongs to interface only
    }
}
```

```java
NormalCar n = new NormalCar();
n.selfDiagnose();           // ✅ default — inherited, called on object

Engine.description();       // ✅ static — called on interface itself
n.description();            // ❌ COMPILE ERROR — static not inherited
```

| | Default | Static |
|---|---|---|
| Has body | ✅ | ✅ |
| Inherited by class | ✅ | ❌ |
| Can be overridden | ✅ | ❌ |
| Called on | object | interface name |

---

### What if two interfaces have same default method?

```java
interface Engine {
    default void selfDiagnose() {
        System.out.println("Engine diagnosis");
    }
}

interface Robot {
    default void selfDiagnose() {
        System.out.println("Robot diagnosis");
    }
}
```

```java
class Transformer implements Engine, Robot {
    // ❌ COMPILE ERROR — which selfDiagnose to inherit? ambiguous
}
```

Java forces you to **override and resolve it yourself:**

```java
class Transformer implements Engine, Robot {
    public void selfDiagnose() {
        Engine.super.selfDiagnose();   // you pick which one explicitly
        // or Robot.super.selfDiagnose();
        // or write completely new logic
    }
}
```

---

## Summary

| | What it means |
|---|---|
| **Why default methods exist** | Add new methods to interface without breaking existing implementing classes |
| **Class doesn't override** | Gets the default body automatically |
| **Class overrides** | Uses its own body |
| **Two interfaces same default** | Must override in class and resolve manually |

---

