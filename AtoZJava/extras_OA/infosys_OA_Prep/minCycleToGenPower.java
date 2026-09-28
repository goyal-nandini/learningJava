package extras_OA.infosys_OA_Prep;

/*# Minimum Cycles to Generate Required Power

---

# 📝 Interview-Ready Statement

You are given an array `arr[]` of `N` integers representing core temperatures and an integer `T`.

In one cycle:

* Select **exactly two unused cores**.
* Power generated = `|a - b|`.
* Each core can be used **only once**.

Return the **minimum number of cycles** required to achieve **total power ≥ T**.

Return **-1** if impossible.

---

# 🧠 Pattern Recognition Checklist

✅ Need **minimum operations**

✅ Each element used **once**

✅ Pairing problem

✅ Need **maximum contribution per operation**

✅ Order doesn't matter → **Sort first**

**Pattern:** **Greedy + Sorting + Two Pointers**

---

# 💡 Intuition

To minimize the number of cycles, each cycle should contribute as much power as possible.

The maximum difference is obtained by pairing:

* **Smallest remaining** element
* **Largest remaining** element

After using them, repeat with the remaining extremes.

This is a classic **exchange argument**: pairing extremes maximizes the sum of pairwise absolute differences.

---

# 💻 Optimal Idea

1. Sort the array.
2. Use two pointers:

   * `left = 0`
   * `right = N-1`
3. Pair `arr[left]` with `arr[right]`.
4. Add difference to total power.
5. Count cycles.
6. Stop once total ≥ `T`.

**Time:** `O(N log N)`

**Space:** `O(1)` (excluding sorting)

---

# ⚠️ Common Pitfalls

* Forgetting each element can be used **only once**.
* Pairing adjacent elements instead of extremes.
* Not checking if total power is impossible after all pairs.
* Odd `N` leaves one unused element.
* `T = 0` → answer is `0`.

---

# 📚 Practice Problems ⭐⭐⭐⭐⭐

## 🟢 Direct Match (Greedy Pairing)

1. **LeetCode 881** — Boats to Save People
2. **LeetCode 1877** — Minimize Maximum Pair Sum in Array ✅
3. **LeetCode 455** — Assign Cookies
4. **GeeksforGeeks** — Maximize Sum of Absolute Differences
5. **GeeksforGeeks** — Minimum Platforms (greedy scheduling intuition)

---

## 🟡 Same Pattern (Sorting + Two Pointers)

1. **LeetCode 16** — 3Sum Closest
2. **LeetCode 167** — Two Sum II
3. **LeetCode 948** — Bag of Tokens
4. **LeetCode 1838** — Frequency of the Most Frequent Element
5. **LeetCode 1498** — Number of Subsequences That Satisfy the Given Sum Condition

---

## 🔴 Advanced Variants

1. **LeetCode 502** — IPO (Greedy + Priority Queue)
2. **LeetCode 857** — Minimum Cost to Hire K Workers
3. **LeetCode 1383** — Maximum Performance of a Team
4. **Codeforces** — Pairing to maximize/minimize objective function
5. **AtCoder** — Greedy pairing and matching problems

---

# 🎯 Interview Follow-ups

* What if each core can be used **multiple times**?
* What if each cycle can select **3 cores**?
* Return the **actual pairs** instead of only the count.
* Minimize the **maximum difference** while still reaching `T`.
* Each pair has a different weight/cost.

---

# 🏷️ Pattern Tag

**Greedy • Sorting • Two Pointers • Pairing Strategy**

> **Interview trigger:** Whenever you see *"pair elements exactly once"* and *"maximize/minimize contribution per pair"*, think **Sort + Two Pointers** first.
*/

//public class minCycleToGenPower {
//}
