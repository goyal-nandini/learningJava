package extras_OA.infosys_OA_Prep;

/*
## Q3 — Minimum Sum After One Swap (Greedy)

---

# 📝 Interview-Ready Statement

Given an array `A` of size `N`, select exactly `K` elements whose indices form an arithmetic progression with common difference `D`.

You may perform **at most one swap** between:

* one selected element, and
* one non-selected element.

Find the **minimum possible sum** of the selected elements.

---

# 🧠 Pattern Recognition Checklist

✅ Need minimum/maximum after one swap

✅ Swap only if beneficial

✅ Fixed candidate subsets

✅ Local optimization inside each subset

**Pattern:** Greedy + Simulation

---

# 💡 Intuition

For every valid AP selection:

* Compute current sum.
* Find the **largest selected** element.
* Find the **smallest non-selected** element.
* If swapping decreases the sum, perform it.

Repeat for every valid starting index.

---

# 💻 Optimal Idea

For each valid AP:

1. Build selected indices.
2. Compute sum.
3. Find:

   * max(selected)
   * min(non-selected)
4. Update answer.

Complexity depends on implementation:

* Basic: **O(N²)**
* With preprocessing: can be improved.

---

# ⚠️ Common Pitfalls

* Forgetting "at most one" swap.
* Swapping when it doesn't improve.
* Invalid AP starting indices.
* Wrong AP generation (`s + i*D`).
* Edge case: no non-selected element.

---

# 📚 Practice Problems ⭐⭐⭐⭐⭐

## 🟢 Direct Match

1. LeetCode 1509 — Minimum Difference Between Largest and Smallest Value in Three Moves ✅
2. LeetCode 1053 — Previous Permutation With One Swap
3. LeetCode 670 — Maximum Swap ✅
4. GeeksforGeeks — Maximize Array Sum After One Swap

---

## 🟡 Same Pattern

1. LeetCode 53 — Maximum Subarray (local optimization thinking) ✅
2. LeetCode 1005 — Maximize Sum After K Negations ✅
3. LeetCode 561 — Array Partition ✅
4. LeetCode 1798 — Maximum Consecutive Values

---

## 🔴 Advanced Variants

1. LeetCode 2171 — Removing Beans
2. LeetCode 1674 — Minimum Moves to Make Array Complementary
3. Codeforces — One Swap Optimization problems
4. AtCoder Greedy problems involving exchange arguments

---

# 🎯 Interview Follow-ups

* Allow **two swaps**.
* Swap any two selected elements.
* Minimize product instead of sum.
* Dynamic updates to the array.
* Large constraints (`N = 10⁵`) requiring preprocessing.

---

### 🏷️ Pattern Tag

**Greedy • One-Swap Optimization • Simulation**

---

# Q4 — DP on Trees (General Pattern)

> Since the exact problem isn't available, here's the interview pattern you should know.

---

# 📝 Interview-Ready Statement

Given a tree, compute an optimal value (maximum/minimum/count) using information from child subtrees.

Typical objectives:

* Maximum path sum
* Maximum independent set
* Subtree sizes
* Diameter
* Sum of distances
* Tree matching

---

# 🧠 Pattern Recognition Checklist

✅ Input is a tree

✅ Answer depends on children

✅ Parent-child dependency

✅ DFS + DP

**Pattern:** Tree DP

---

# 💡 Intuition

Run DFS.

Each node returns some information to its parent.

Parent combines results from children.

Sometimes a second DFS (rerooting) is needed to compute answers for every node.

---

# 💻 Common DP States

Examples:

* `dp[node]`
* `dp[node][0/1]` (take / don't take)
* `subtreeSize[node]`
* `down[node]`
* `up[node]`

---

# ⚠️ Common Pitfalls

* Revisiting parent (cycle).
* Wrong base case for leaves.
* Forgetting reroot transition.
* Stack overflow on deep trees.
* Mixing subtree answer with global answer.

---

# 📚 Practice Problems ⭐⭐⭐⭐⭐

## 🟢 Direct Match (Must Do)

1. LeetCode 337 — House Robber III ⭐⭐⭐⭐⭐
2. LeetCode 124 — Binary Tree Maximum Path Sum ⭐⭐⭐⭐⭐
3. LeetCode 543 — Diameter of Binary Tree
4. LeetCode 687 — Longest Univalue Path
5. CSES — Tree Distances I

---

## 🟡 Same Pattern

1. CSES — Tree Distances II (Rerooting)
2. CSES — Tree Matching
3. CSES — Subordinates
4. Codeforces 1528A — Parsa's Humongous Tree
5. AtCoder DP V — Subtree

---

## 🔴 Advanced Variants

1. LeetCode 834 — Sum of Distances in Tree ⭐⭐⭐⭐⭐
2. LeetCode 1617 — Count Subtrees With Max Distance
3. Codeforces — Tree Painting
4. AtCoder DP V — Subtree (Rerooting DP)
5. Codeforces — Tree DP + Knapsack problems

---

# 🎯 Interview Follow-ups

* Reconstruct the optimal nodes.
* Answer queries after updates.
* Weighted tree.
* N-ary tree instead of binary.
* Iterative DFS implementation.
* Rerooting optimization.

---

### 🏷️ Pattern Tag

**Tree DP • DFS + DP • Rerooting DP • Subtree DP**

---

## 📌 High-Priority Practice Roadmap

If your goal is OA + interviews, prioritize these patterns:

### 🟢 State DP

* LC 309
* LC 552
* LC 801
* LC 983

### 🟡 Greedy + One Swap

* LC 670
* LC 1053
* LC 1509
* LC 1005

### 🔴 Tree DP

* LC 337 ⭐
* LC 124 ⭐
* LC 543
* LC 834 ⭐
* CSES Tree Distances I & II

These problems will expose you to the core techniques behind the custom OA questions you've shared.

*/
//public class sumAfterSwap {
//}
