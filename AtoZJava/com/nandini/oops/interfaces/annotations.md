## Topic 4 — Annotations are also Interface

---

### First — what is an annotation?

You've already SEEN annotations — you just didn't know what they were:

```java
@Override
public void start() { }

@FunctionalInterface
interface Calculator { }
```

That `@` thing — that's an annotation.

---

### What does it actually do?

An annotation is a **label/tag** you stick on your code.

It doesn't change logic — it gives **extra information** to the compiler or JVM.

Think of it like a sticky note on a file:
- `@Override` → "hey compiler, verify this is actually overriding something"
- `@Deprecated` → "hey developer, this method is old, don't use it"
- `@SuppressWarnings` → "hey compiler, stop warning me about this"

---

### Why is it an interface internally?

When you create a custom annotation:

```java
@interface MyAnnotation {
    String value();
}
```

That `@interface` keyword — Java internally treats this as a **special interface** that extends `java.lang.annotation.Annotation`.

You're not writing `interface` — you're writing `@interface` — but under the hood it IS an interface.

---

### Creating your own annotation

```java
// defining the annotation
@interface CarInfo {
    String brand();
    int year();
}
```

```java
// using it
@CarInfo(brand = "Toyota", year = 2024)
class Car {
    void start() { System.out.println("Started"); }
}
```

You stuck a label on `Car` that says — brand is Toyota, year is 2024.

---

### Who reads these annotations?

Three possible readers:

```
@Retention(SOURCE)   → only compiler reads it, gone after compile
@Retention(CLASS)    → stays in .class file, JVM ignores it
@Retention(RUNTIME)  → stays at runtime, YOUR code can read it via Reflection
```

Most useful ones are `RUNTIME` — frameworks like Spring, Hibernate read your annotations at runtime to decide what to do.

---

### Real world — you use annotations every day

```java
// Spring Boot
@RestController          // marks this as a web controller
@GetMapping("/home")     // marks this method handles GET /home
public String home() { return "Hello"; }
```

Spring reads these annotations at runtime and wires everything automatically. The annotations are just labels — Spring does the actual work based on those labels.

---

### Key difference from normal interface

| | Normal Interface | Annotation (`@interface`) |
|---|---|---|
| Keyword | `interface` | `@interface` |
| Implemented by | classes | applied on classes/methods/fields |
| Purpose | define contract | attach metadata/labels |
| Methods | abstract methods | elements (like `brand()`, `year()`) |

---

### Common built-in annotations you'll use

| Annotation | What it tells |
|---|---|
| `@Override` | Compiler — verify this overrides a parent method |
| `@Deprecated` | Developer — don't use this anymore |
| `@SuppressWarnings` | Compiler — stop showing this warning |
| `@FunctionalInterface` | Compiler — verify this has only one abstract method |

---

## All 4 Topics Done ✅

```
✅ Extending Interface
✅ Default Methods in Interface
✅ Nested vs Top Level Interface
✅ Annotations are also Interface
```

Tomorrow — **Marker Interface** then **Functional Interface** and you'll have the complete interface module locked down! 🎯