package Hashing_BS_Heap;
// TODO: big code challenge question:

/*# The Chocolate Factory
## Problem Statement
A chocolate factory has **n machines**. Machine **i** takes exactly **t[i] minutes** to produce one chocolate.
All machines start working simultaneously at minute 0 and run continuously — a machine that finishes one chocolate
immediately starts the next. The factory needs to produce a total of at least **k chocolates**. Find the **minimum
number of minutes** required for the factory to produce at least k chocolates in total.

---

## Function Description

Implement the function **`minMinutes`**. The function should return the minimum number of minutes needed for all
machines together to produce at least **k** chocolates.

---

## Function Parameters

- **`int n`** — The number of machines.
- **`long long k`** — The total number of chocolates needed.
- **`vector<int> t`** — A list of n integers where **t[i]** is the time (in minutes) machine **i** takes to
produce one chocolate.

---

## Input Format

- **Line 1:** A single integer **n** — the number of machines.
- *(further lines likely contain k and the array t)*

---

## Approach (visible in code)

The solution uses **Binary Search on the answer**:
- For a given time `mid`, machine `i` produces `mid / t[i]` chocolates.
- Check if total chocolates `>= k` → if yes, try smaller time; else increase time.
- Search range: `low = 1`, `high = min(t) * k`*/
public class ChocolateFactory0 {
    public static void main(String[] args) {

    }
}
