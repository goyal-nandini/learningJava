GOOD question 😄🔥
These two names sound similar but are VERY different things in Java.

Many beginners confuse them.

---

# ENUMS

```java id="ev1"
enum Week {
    Monday,
    Tuesday
}
```

Modern Java feature.

Used to create:

# fixed set of constants/objects.

---

# Purpose of Enum

Type safety + predefined values.

Examples:

* days
* months
* states
* directions
* payment status

---

# Enum Example

```java id="ev2"
Week day = Week.Monday;
```

---

# IMPORTANT

Enum is actually:

# special class type.

Can have:

* constructors
* methods
* variables
* interfaces

---

# ENUMERATION

Completely different thing 😄

```java id="ev3"
Enumeration<String> e
```

Old interface used for:

# traversing collection elements.

Mostly used with:

* Vector
* Hashtable

---

# Enumeration Example

```java id="ev4"
Vector<String> names = new Vector<>();

Enumeration<String> e = names.elements();

while(e.hasMoreElements()) {
    System.out.println(e.nextElement());
}
```

---

# Purpose of Enumeration

Iterating/traversing elements.

---

# BIG DIFFERENCE 🔥

| Enum                      | Enumeration               |
| ------------------------- | ------------------------- |
| keyword                   | interface                 |
| defines constants         | traverses collection      |
| modern feature            | legacy iteration tool     |
| creates objects/constants | reads collection elements |
| special class type        | iterator-like interface   |

---

# VERY IMPORTANT MEMORY TRICK 🧠

## enum

Think:

# constants

Example:

* Monday
* RED
* NORTH

---

## Enumeration

Think:

# element traversal

Example:

* nextElement()
* hasMoreElements()

---

# Why Names Similar?

Because both relate to:

# listing things.

But purposes totally different.

---

# Modern Java Reality

| Feature     | Usage Today |
| ----------- | ----------- |
| enum        | VERY common |
| Enumeration | rare/legacy |

Today mostly:

* Iterator
* for-each loop
  replace Enumeration.

---

# FINAL ONE-LINE SUMMARY ⭐

| Term        | Meaning                                  |
| ----------- | ---------------------------------------- |
| enum        | special class for fixed constants        |
| Enumeration | old interface for traversing collections |
