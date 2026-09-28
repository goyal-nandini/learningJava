package extras_OA.infosys_OA_Prep;
/***Problem Statement:**
> Given an array of integers and an integer `K`, select a subset of exactly `K` elements from the array.
From this subset, multiply the **smallest element by -1** (i.e. negate it), then **subtract it from the largest element**.
> Formally, for a chosen subset, compute:
> **largest - (-1 × smallest) = largest + smallest**
> Return the **maximum possible value** of this expression over all valid subsets of size `K`.
---
**Example:**
Array = `[1, 2, 3, 4, 5]`, K = 3
One subset: `{1, 3, 5}` → largest=5, smallest=1 → 5 + 1 = **6**
Another subset: `{3, 4, 5}` → largest=5, smallest=3 → 5 + 3 = **8** ✓
So answer = **8**
---
**Key Insight:**
Since you only care about the **smallest and largest** of the chosen subset, and want to maximize
`largest + smallest`, you should just **sort the array** and think about which pairs of (min, max) are achievable
with at least K elements between them.
*/

//---
// choose exactly k ele such that (min+max) is maximized.
// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements/description/

//---
/*
Practice Set
🟢 Must Solve (very close)
LeetCode 1509 - Minimum Difference Between Largest and Smallest Value in Three Moves
Same focus on reasoning about extremes after sorting.
LeetCode 1984 - Minimum Difference Between Highest and Lowest of K Scores
Choose K elements after sorting; only the endpoints matter.
GeeksforGeeks - Minimize the Heights
Different wording, but endpoint reasoning after sorting.
🟡 Same Pattern
LeetCode 910 - Smallest Range II
LeetCode 1675 - Minimize Deviation in Array
Aggressive Cows (Binary Search + sorted feasibility)

These won't look identical, but they'll strengthen the same habit of analyzing sorted endpoints and constraints.
*/

// ---
/*Pattern Card 📝
Primary Pattern

✅ Sorting + Greedy Observation

Trigger Words
subset
only min/max matter
maximize expression
exactly K elements
Important realization

The middle elements don't affect the score.

They only determine whether the pair (min, max) is feasible.

https://chatgpt.com/s/t_6a66e4e637fc819188c37ac6ad4d164b4
https://chatgpt.com/s/t_6a66e4f8478c81918bf196c1b9d2b589

*/

// public class que2 {
//}
