## Topic 3 — Nested Interface vs Top Level Interface

---

### Top Level Interface — what you already know

Any interface declared **directly in a file, outside any class or interface:**

```java
// Engine.java
interface Engine {
    void start();
    void stop();
}
```

That's it. You've been using these all along. Nothing new here.

---

### Nested Interface — interface declared INSIDE something

Two types:

- Interface inside a **class**
- Interface inside an **interface**

---

### Type 1 — Interface inside a Class

```java
class Car {
    int speed;

    // nested interface — lives inside Car
    interface Engine {
        void start();
        void stop();
    }
}
```

To implement it from outside:

```java
class PetrolEngine implements Car.Engine {   // Car.Engine — must use outer name
    public void start() { System.out.println("Petrol start"); }
    public void stop()  { System.out.println("Petrol stop");  }
}
```

To use in Main:

```java
public class Main {
    public static void main(String[] args) {
        Car.Engine e = new PetrolEngine();   // reference type is Car.Engine
        e.start();
    }
}
```

---

### Type 2 — Interface inside an Interface

```java
interface Vehicle {
    void move();

    // nested interface inside Vehicle
    interface FuelSystem {
        void refuel();
    }
}
```

To implement:

```java
class Car implements Vehicle, Vehicle.FuelSystem {
    public void move()   { System.out.println("Car moving");   }
    public void refuel() { System.out.println("Car refueling"); }
}
```

---

### Why would anyone do this?

**Grouping related things together.**

Imagine you're building a Car library and you want everything Car-related in one place:

```java
class Car {
    interface Engine    { void start();      }
    interface Brake     { void applyBrake(); }
    interface MusicSystem { void play();     }
}
```

Now anyone using your library knows — all Car-related contracts live under `Car`:

```java
Car.Engine e;
Car.Brake b;
Car.MusicSystem m;
```

Clean, organised, no pollution of the global namespace.

---

### Real world example you already know

```java
// Map.Entry is a nested interface inside Map
Map.Entry<String, Integer> entry;
```

`Entry` lives inside `Map` because it only makes sense in the context of a Map. You'd never use `Entry` without `Map`.

---

### Key Rules

| Rule | |
|---|---|
| Nested interface inside class | implicitly `static` — always |
| Nested interface inside interface | implicitly `public static` — always |
| Accessed using | `OuterName.InnerInterfaceName` |
| Can be implemented by any class | ✅ even outside the outer class |

---

### Why implicitly static?

Because a nested interface is not tied to any **object** of the outer class — it's a type definition. Type definitions always belong to the class itself, not to instances.

```java
Car car1 = new Car();
Car car2 = new Car();
// Car.Engine doesn't belong to car1 or car2
// it belongs to Car the TYPE — so static makes sense
```

---

## Summary

| | Top Level | Nested |
|---|---|---|
| Where declared | Outside everything | Inside a class or interface |
| Accessed as | `Engine` | `Car.Engine` |
| Why use | General contract | Group related contracts under one roof |
| Real example you know | `Engine`, `Brake` | `Map.Entry` |

---

