package extras_OA.infosys_OA_Prep;

/*
**Properly Framed Problem:**
> You are given a list of `N` strings and a target string `T`. A **merged subsequence** is formed by selecting a
* **subsequence** (subset maintaining order) from the list of strings and **concatenating** them.
> Find the **number of such merged subsequences** whose characters, when **sorted**, form a string that is
* **lexicographically ≤ sorted(T)**.
> Return the count (possibly modulo some value, typical in contests).
---
**Example:**
```
strings = ["ab", "bc", "a"]
target  = "abc"
sorted(target) = "abc"

Possible merged subsequences (non-empty subsets maintaining order):
- "ab"         → sorted = "ab"  ≤ "abc" ✓
- "bc"         → sorted = "bc"  > "abc" ✗
- "a"          → sorted = "a"   ≤ "abc" ✓
- "ab"+"bc"    → sorted = "abbc" > "abc" ✗
- "ab"+"a"     → sorted = "aab" ≤ "abc" ✓
- "bc"+"a"     → sorted = "abc" ≤ "abc" ✓
- "ab"+"bc"+"a"→ sorted = "abbc" > "abc" ✗

Answer: 4
```
---
**Key Observations:**
- Sorting both sides means **order within strings doesn't matter**, only **character frequencies**
- So comparison reduces to: does the merged character **frequency vector ≤ target's frequency vector** lexicographically (by a,b,c...z)?
- This hints at a **DP on character counts** or **frequency-based subset DP**
---
This feels like a **subset DP + frequency comparison** problem. Want me to work out the approach and code?
*
---
📚 Tier 1 (Most Important)

These teach the same counting/subset philosophy.

1. Partition Equal Subset Sum (LC416) ⭐⭐⭐⭐⭐
Learn subset DP.

2. Target Sum (LC494) ⭐⭐⭐⭐⭐
Count subsets.

Very important.

3. Ones and Zeroes (LC474) ⭐⭐⭐⭐⭐
This is probably the closest mainstream problem.
Why?
Each string contributes
(#zeros,#ones)
Exactly the same idea:
Each string contributes a vector.
This is the first problem I'd solve.

📈 Tier 2
4. Combination Sum IV
Counting DP.

5. Count Subsets with Given Sum (GFG)
Classic.

6. Number of Ways to Form a Target String Given a Dictionary (LC1639)
Very good string DP.

7. Distinct Subsequences (LC115)
Subsequence counting DP.

🚀 Tier 3
8. Stickers to Spell Word (LC691)
Excellent state-compression + strings.

Very relevant.

9. Smallest Sufficient Team (LC1125)
Subset/state compression DP.

10. Number of Ways to Wear Different Hats (LC1434)
Bitmask DP.


---
🎯 Primary Pattern
Subset DP / Knapsack-style DP on States

Possibly combined with:

Character Frequency
String DP
*
* */

//public class mergedSubs_lessSorted {
//}
