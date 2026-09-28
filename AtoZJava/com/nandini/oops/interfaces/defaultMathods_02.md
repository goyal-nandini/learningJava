##### 🟢🟢🟢i read this on github page: it has many imp things:

### Default Interface Methods (aka extension method) :
A primary motivation for the default method was to provide a means by which interfaces could be expanded without breaking existing code.
i.e. suppose you add another method without body in an interface. Then you will have to provide the body of that method
in all the classes that implement that interface.
Ex:
```
default String getString() {
    return "Default String";
}
```

For example, you might have a class that implements two interfaces.
If each of these interfaces provides default methods, then some behavior is inherited from both.
1. In all cases, a class implementation takes priority over an interface default implementation.
2. In cases in which a class implements two interfaces that both have the same default method, but the class does not
override that method, then an error will result.
3. In cases in which one interface inherits another, with both defining a common default method, the inheriting
interface’s version of the method takes precedence.

##### 🟢🟢🟢its complete understanding is as follows:

You’re getting confused because this topic mixes **inheritance**, **interfaces**, and **method priority rules** together.
Let’s untangle it carefully 🔥

---

# Why were default methods introduced?

Before Java 8:

Interfaces could only contain:

```java
void show();
```

NO method body.

---

Suppose millions of classes implement an interface.

Example:

```java
interface Vehicle {
    void start();
}
```

Classes:

```java
class Car implements Vehicle
class Bike implements Vehicle
class Bus implements Vehicle
```

All good.

---

Now imagine Java developers later decide:

> “We want every Vehicle to also have a `stop()` method.”

So they update interface:

```java
interface Vehicle {
    void start();
    void stop(); // newly added
}
```

🚨 Problem:

Now EVERY existing class breaks.

Because:

```java
class Car implements Vehicle
```

must now implement BOTH methods.

Compiler error everywhere.

---

# Solution: Default Methods 🎯

Java 8 introduced:

```java
default void stop() {
    System.out.println("Stopping");
}
```

Now interface itself gives a default implementation.

So old classes continue working.

---

# Example

```java
interface Vehicle {

    void start();

    default void stop() {
        System.out.println("Stopping");
    }
}
```

Now:

```java
class Car implements Vehicle {

    public void start() {
        System.out.println("Car starts");
    }
}
```

Even though `Car` didn't write `stop()`:

```java
Car c = new Car();
c.stop();
```

works.

Because interface provided default behavior.

---

# Now the confusing part:

## Multiple interfaces having same default method

Example:

```java
interface A {
    default void show() {
        System.out.println("A");
    }
}

interface B {
    default void show() {
        System.out.println("B");
    }
}
```

Now:

```java
class Test implements A, B {
}
```

🚨 ERROR

Why?

Because Java gets confused:

> “Which show() should I inherit? A’s or B’s?”

This is called:

## Diamond Problem ⚠️

---

# So Java forces you to override

```java
class Test implements A, B {

    public void show() {
        System.out.println("My own version");
    }
}
```

Now ambiguity removed.

---

# Statement 1:

## “Class implementation takes priority over interface default implementation”

Example:

```java
interface A {
    default void show() {
        System.out.println("Interface");
    }
}
```

Class:

```java
class Test implements A {

    public void show() {
        System.out.println("Class");
    }
}
```

Now:

```java
Test t = new Test();
t.show();
```

Output:

```text
Class
```

NOT "Interface"

---

# Why?

Because:

## Class methods are more powerful/specific than interface defaults.

Java rule:

```text
Class > Interface
```

Always.

---

# Statement 2:

## “If two interfaces have same default method → error”

We already saw:

```java
interface A {
    default void show() {}
}

interface B {
    default void show() {}
}

class Test implements A, B {} // ERROR
```

Because compiler cannot decide.

So you MUST override.

---

# Statement 3:

## “Inherited interface version takes precedence”

This is the trickiest one 👀

Example:

```java
interface A {
    default void show() {
        System.out.println("A");
    }
}
```

Another interface extends A:

```java
interface B extends A {

    default void show() {
        System.out.println("B");
    }
}
```

Now:

```java
class Test implements B {
}
```

Question:
Which `show()` gets used?

Answer:

```text
B
```

---

# Why?

Because:

```text
B is more specific than A
```

B inherited A and then provided newer behavior.

So Java prefers the child interface version.

Exactly like class inheritance.

---

# Final Priority Rules 🚀

Java resolves default methods in this order:

## Rule 1️⃣

```text
Class methods win over interface methods
```

---

## Rule 2️⃣

```text
More specific interface wins
```

(child interface > parent interface)

---

## Rule 3️⃣

```text
If unrelated interfaces conflict → compiler error
```

You must override manually.

---

# Super Important Insight 🔥

Default methods were NOT added to make interfaces behave like classes.

They were mainly added to:

* maintain backward compatibility
* avoid breaking old code
* evolve APIs safely

That’s the real reason behind them.
