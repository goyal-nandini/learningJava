package OOPS;

public class swapConceptII {
    public static void main(String[] args) {
        Wrapper a = new Wrapper(30);
        Wrapper b = new Wrapper(40);

        swap(a, b);
        System.out.println(a.value + " " + b.value); // 40 30
    }

    static void swap(Wrapper x, Wrapper y) {
        Integer temp = x.value;
        x.value = y.value;
        y.value = temp;
    }
}

class Wrapper {
    Integer value;
    Wrapper(Integer value) {
        this.value = value;
    }
}

/*Okay let’s break this code down **very slowly and clearly** so it becomes easy to understand.
This example is important because it shows **how swap actually works in Java** using objects.

---

## 🧠 **What is happening here?**
### First, the `Wrapper` class:

```java
class Wrapper {
    Integer value;
    Wrapper(Integer value) {
        this.value = value;
    }
}
```

* `Wrapper` is a **normal class**.
* It contains **one variable**: `Integer value`
* Constructor sets the value.

So when you write:

```java
Wrapper a = new Wrapper(30);
Wrapper b = new Wrapper(40);
```

### **Memory understanding**

| Variable | Points to                              | Value stored inside object |
| -------- | -------------------------------------- | -------------------------- |
| `a`      | Wrapper object (object stored on heap) | value = 30                 |
| `b`      | Wrapper object                         | value = 40                 |

So:

```
a ----> [value: 30]
b ----> [value: 40]
```

---

## 🧠 **What happens inside swap()?**

```java
static void swap(Wrapper x, Wrapper y) {
    Integer temp = x.value;
    x.value = y.value;
    y.value = temp;
}
```

When you call:

```java
swap(a, b);
```

`x` receives a **copy of the reference a**
`y` receives a **copy of the reference b**

So:

```
x ----> [value: 30]
y ----> [value: 40]
```

### Now look at the swap logic:

```
temp = x.value;  // temp = 30
x.value = y.value;  // now x.value = 40
y.value = temp;  // now y.value = 30
```

So after swap:

        ```
x ----> [value: 40]
y ----> [value: 30]
        ```

But remember:
`x` and `y` point to the **same objects as `a` and `b`** in main.

So change also affects `a` and `b`.

---

## 📌 Final Output

```java
System.out.println(a.value + " " + b.value);
```

prints:

```
40 30
```

---

# 🧠 Why does this swap work, but `swap(Integer a, Integer b)` fails?

| Swap Method                  | Works? | Why                                              |
| ---------------------------- | ------ | ------------------------------------------------ |
| `swap(Integer a, Integer b)` | ❌ No   | reference copied, reassigned, original unchanged |
| `swap(Wrapper x, Wrapper y)` | ✅ Yes  | modifying **fields inside same object**          |

### KEY IDEA:

> Reassigning a reference does *not* change the original variable
> Modifying **data inside the same object** *does* change it

---

## 🎯 Simple analogy

Think of `Integer` swap like:

```
You give me photocopy of a key, I replace it with another copy,
but your original lock key stays same.
```

But in wrapper swap:

```
You give me the key to your room, I rearrange the furniture inside your room,
so the change is visible to you.
```

## ✨ Takeaway

✔ Swapping works when we modify **object contents**
❌ Swapping doesn't work when we only try to change **references**
*/

