🟢🟢🟢
que: 🚨 Challenge for you
You’ve seen the code.

👉 Tell me:
Why do we use:

while(queue.isEmpty()) wait();

instead of:

if(queue.isEmpty()) wait();

i answered: busy waiting

🟢🟢🟢
What you described (**busy waiting**) is a *different concept*.

Let’s clean this up properly 👇

---

# ❌ Your mistake: Busy waiting vs `wait()`

### 🔴 Busy waiting = CPU waste

Example:


while(queue.isEmpty()) {
    keep checking (CPU spinning 🔥)
}


👉 Thread is **running continuously** doing nothing useful
👉 CPU gets wasted

---

### 🟢 `wait()` = NOT busy waiting


while(queue.isEmpty()) {
    wait();
}

👉 Thread goes to **sleep 😴**
👉 CPU is FREE
👉 Wakes up only when `notify()` is called

---

# 💥 So what’s the REAL reason we use `while`?

It’s NOT for busy waiting.

👉 It’s for **correctness in multithreading**

---

## 🚨 Problem if you use `if`


if(queue.isEmpty()) {
    wait();
}

### Scenario:

1. Thread checks → queue empty → goes to wait
2. Another thread adds item + calls `notify()`
3. BUT multiple threads wake up ⚠️
4. Now queue may be empty again

👉 Your thread continues WITHOUT rechecking → ❌ bug

---

## ✅ Why `while` is correct


while(queue.isEmpty()) {
    wait();
}


👉 After waking up:

* it **rechecks condition**
* only proceeds if safe

👉 This handles:

* spurious wakeups
* multiple threads waking
* race conditions

---

# 🔥 One-line rule (remember this)

> Always use `while` with `wait()` in Java concurrency

