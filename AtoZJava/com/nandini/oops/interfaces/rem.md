Note: i have used it in NiceeCar class in a good and proper manner

## Definition of Composition — In Simple Words

> **Composition means: a class USES objects of other classes as its parts, instead of inheriting from them.**

The class doesn't try to BE those things — it just HOLDS them and delegates work to them.

---

### Three keywords to remember

| Keyword | Meaning |
|---|---|
| **HAS-A** | Car HAS-A Engine — the core relationship |
| **Delegate** | Car doesn't do the work itself, it passes it to the engine object |
| **Inject** | You pass (inject) the part from outside — so it's swappable |

---

### Smallest possible code definition

```java
class Car {
    private Engine engine;        // HAS-A → this is composition

    Car(Engine engine) {
        this.engine = engine;     // INJECT → passed from outside
    }

    void startCar() {
        engine.start();           // DELEGATE → Car doesn't start itself
    }                             //            it asks engine to do it
}
```

These three things together = **Composition.**

---

### One line you can write in any exam or interview

> *"Composition is a design principle where a class achieves complex behaviour by containing references to objects of other classes and delegating work to them, rather than inheriting from them."*