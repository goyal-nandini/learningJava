package extras_OA.repeatedQue;

/*
**Properly Framed Problem:**
> You are given a grid of size `N × M`. Each cell contains an integer. You must **completely tile the
* entire grid** using `1×2` dominoes (which can be placed **horizontally or vertically**).
> When a domino covers two cells, its **score contribution** is the **product of the two cell values** it covers.
> The **total score** is the **sum of products** of all placed dominoes.

> Find the **maximum possible total score**.
---
**Constraints:**
- `N ≤ 10^4`
- `M ≤ 8`
- Grid must be **fully covered** (implicitly N×M is even, or M is even as commenters noted)
---
**Example:**
```
Grid:
3  5
2  4
```
- Place horizontally: (3×5) + (2×4) = 15 + 8 = **23**
- Place vertically: (3×2) + (5×4) = 6 + 20 = **26** ✓
Answer = **26**
---
**Approach: Bitmask DP**
Since `M ≤ 8`, track which cells in the current row are already occupied by a vertical domino from the previous
* row using a **bitmask**.
```
dp[i][mask] = max score for rows [i..N-1]
              given that 'mask' represents which cells of row i
              are already filled by vertical dominoes from row i-1
```
This is similar to the classic **CSES Domino Tiling** problem — good reference to study.
*
*
*
* profile DP - bitmask dp on grid

---
🟢 Direct Match (90–100%)

These are MUST solve.

1. CSES – Counting Tilings ⭐⭐⭐⭐⭐
This is the single best practice problem.

Difference:
Counts tilings
Yours maximizes score
The DP state is almost identical.

2. SPOJ – M5TILE / GNY07H (Domino Tiling)
Classic profile DP.

3. UVA – Tri Tiling
Another famous domino tiling problem.
Very good for understanding transitions.

4. AtCoder Educational DP (Grid State problems)
Several tasks use the exact same profile DP idea.

🟡 Same Pattern (70–80%)
These don't use dominoes but use the same state compression idea.

5. LeetCode 1349 – Maximum Students Taking Exam ⭐⭐⭐⭐⭐
One of the best bitmask DP problems.
State:
row
+
mask
Very similar.

6. LeetCode 1931 – Painting a Grid With Three Colors
Classic profile DP.

7. LeetCode 1659 – Maximize Grid Happiness
Hard.
But one of the best profile DP questions.

8. LeetCode 1494 – Parallel Courses II
State compression DP.
Not on grids, but excellent bitmask training.

🔴 Advanced Variants
9. LeetCode 1434 – Number of Ways to Wear Different Hats
Bitmask DP on people/items.
Different story.
Same technique.

10. Traveling Salesman Problem (Bitmask DP)
Not profile DP.
But teaches state compression.
Very useful later.
*
---
Pattern Card – Question 5
🎯 Pattern Name

Profile DP / Bitmask DP on Grid

(also called State Compression DP)
*
*
* https://chatgpt.com/s/t_6a66e7a52140819184969a19847c7098*/

//public class grid_domino {
//}
