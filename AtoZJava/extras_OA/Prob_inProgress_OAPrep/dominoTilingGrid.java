package extras_OA.Prob_inProgress_OAPrep;

/*Domino Tiling Grid: Maximum Score

You are given an N × M grid where each cell contains an integer. Tile the entire grid using 1×2 dominoes (can be placed
horizontally or vertically, no overlaps, no gaps).

Each domino covers exactly 2 cells. Its score is the product of the two cell values it covers.

The total score is the sum of products of all dominoes placed.

Find the maximum possible total score.

Constraints: N ≤ 10^4, M ≤ 8 (grid dimensions always allow perfect tiling)

Example:
Grid:
3  5
2  4

Option 1 (horizontal): (3×5) + (2×4) = 15 + 8 = 23
Option 2 (vertical):   (3×2) + (5×4) = 6 + 20  = 26
Answer: 26

Approach: Bitmask DP — dp[i][mask] where mask tracks which cells of row i are already occupied by vertical dominoes
from row i-1. Since M ≤ 8, mask has at most 2^8 = 256 states.

---
*/
/*
Anchor Problem

🥇 CSES Counting Tilings

This is the one to master.

Tier 1
CSES Counting Tilings ⭐⭐⭐⭐⭐ ✅
LC1349 Maximum Students Taking Exam ⭐⭐⭐⭐
LC1931 Painting Grid ⭐⭐⭐⭐ ✅

edit: so i started counting tilings on 10/8/2026 late at night after doing lc 1931 and lc 1411 [n*3 grid paint wala hai] similar problem
so i was stuck - then its a bitmask dp problem, and without realising much those two lc 1931 were also of profile dp
or bitmask dp but anyways... i left it there just read and knowing its this, i slept

next 11/8/2026 i started it with claude it teaching me it
- tsp - memo/iterative done hai https://www.geeksforgeeks.org/problems/travelling-salesman-problem2732/1 ✅
- lc k doo que for practice this pattern - doing that now its 1.39 pm lets gooo edit: noo, these are subset-partitioning
bitmask problems, which is a different flavor than profile DP. They'd be a detour, not a prerequisite.
⁉️⁉️⁉️❓❓❓🙋‍♀️🙋‍♀️🙋‍♀️🙋‍♀️
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
https://leetcode.com/problems/minimum-xor-sum-of-two-arrays/description/
https://leetcode.com/problems/matchsticks-to-square/description/

- i'll this counting tilings and this intelliJ one and one leetocode domino and tremino tilings

wait: the order followed:
1. Tiling a 2×N board with 1×2 dominoes" (count ways only, no bitmask needed — it's just a Fibonacci-style recurrence:
f(n) = f(n-1) + f(n-2)). This is NOT hard. It just gets you thinking about "column by column" before we add bitmasks
to it.https://www.geeksforgeeks.org/problems/ways-to-tile-a-floor5836/1 ✅

2. https://www.geeksforgeeks.org/dsa/tiling-with-dominoes/ - "Tiling a 3×N board with dominoes" — this one genuinely
needs a small state machine (3 possible "profile" shapes for a partially-filled column). Still small, very manageable,
and it's the real bridge to bitmask profile DP. ✅

3. leetcode and ️✅
4. cses version ✅

5. this intelliJ version ✅

🟢 Direct Match (90–100%)

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


https://chatgpt.com/s/t_6a66fd09689c81918195f0202c9836d3*/

import java.util.*;

public class dominoTilingGrid {
    static long INF = (long)1e15;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] board = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = sc.nextInt();
            }
        }

        // no enough, transpose the board too
//        if(n>m){
//            int temp = n;
//            n = m;
//            m = temp;
//        }

        // column-wise mask DP: [n*m] and make 'n' smaller dimension as mask size is '2^n'
        // if n>m, transpose and swap n and m.

        if (n > m) {
            int[][] transposed = new int[m][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    transposed[j][i] = board[i][j];
            board = transposed;
            int temp = n; n = m; m = temp;
        }
        
        // col and mask, dp[col][mask] = maximum total score achievable to complete the tiling from here
        long[][] dp = new long[m+1][1<<n];
        for(long[] row: dp) Arrays.fill(row, Integer.MIN_VALUE);
        long ans = solve(0, 0, n, m, board, dp);
        System.out.println(ans);
    }
    private static long solve(int col, int mask, int n, int m, int[][] board, long[][] dp){
        if(col == m){
            return (mask==0) ? 0 : -INF;
        }
        
        if(dp[col][mask] != Integer.MIN_VALUE) return dp[col][mask];
        
        long ans = fillColumn(0, col, mask, 0, n, m, board, dp);
        return dp[col][mask] = ans;
    }
    private static long fillColumn(int row, int col, int currMask, int nextColMask, int n, int m, int[][] board, long[][] dp){
        if(row == n){
            // move to next column
            return solve(col+1, nextColMask, n, m, board, dp);
        }
        
        // this row/cell is visited
        if((currMask&(1<<row))!=0) {
            // go to next row, simple
            return fillColumn(row+1, col, currMask, nextColMask, n, m, board, dp);
            // no score added here
        }
        
        long best = -INF;
        // place vertical: pairs (row, col) with (row+1, col)
        if(row+1<n && (currMask&(1<<(row+1)))==0){
            long scores = (long)board[row][col] * board[row+1][col];
            long sub =  fillColumn(row+2, col, currMask, nextColMask, n, m, board, dp);
            if(sub != -INF){
                best = Math.max(best, scores+sub);
            }
        }
        
        // place horizontal: pairs (row, col) with (row, col+1)
        int new_nextColMask = nextColMask | (1<<row); // I'm placing a horizontal domino from the current column into
        // the next column, so mark this row as occupied in the next column

        if(col+1<m){
            long scores = (long)board[row][col] * board[row][col+1];
            long sub = fillColumn(row+1, col, currMask, new_nextColMask, n, m, board, dp);
            if(sub != -INF){
                best = Math.max(best, scores+sub);
            }
        }

        return best;
    }
}
