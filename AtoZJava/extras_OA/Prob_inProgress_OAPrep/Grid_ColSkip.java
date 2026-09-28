package extras_OA.Prob_inProgress_OAPrep;

/*
Grid Path Maximum Value with Column Skip

You are given an N×M grid. Start at cell (1,1) and reach (N,M).

You can move horizontally (right) or vertically (down)
When you visit a cell, its value is added to your total
You have an optional ability to skip columns — jump from column c to any column c' > c+1, but the skipped cells' values
are NOT added

Find the maximum total value achievable from (1,1) to (N,M).
*/

/*
---
📚 Tier 1 (Must Solve)

These teach the exact base pattern.

1. LeetCode 64 – Minimum Path Sum  ✅
The most important.
Master this first.

2. GeeksforGeeks – Maximum Path Sum in Matrix ✅
Same DP.

3. CSES – Grid Paths (DP version)
Great grid DP practice.

📈 Tier 2 (Same Pattern)

These add extra movement rules.

4. Cherry Pickup (LC741) ✅
Grid DP with extra state.

5. Cherry Pickup II (LC1463) ✅
Excellent transition practice.

6. Dungeon Game (LC174) ✅
Classic grid DP.

7. Unique Paths II (LC63) ✅
Grid DP with obstacles.

🚀 Tier 3
8. Minimum Falling Path Sum II (LC1289) ⭐⭐⭐⭐⭐ ✅
This one is surprisingly close.
Why?
Because you cannot simply come from one previous cell—you consider many possible previous columns.
Very useful.

9. Ninja Training (Coding Ninjas) ⭐⭐⭐⭐⭐ ✅
Not a grid.

But "transition restrictions" DP.

10. Paint House II ️ https://www.naukri.com/code360/problems/ninja-s-contract_1459321 ✅
Optimizing DP transitions.

---
Pattern Card – Question
🎯 Primary Pattern

Grid DP + State Transition Optimization

https://chatgpt.com/s/t_6a66ef030ce881918bdfa78eb338e79b
*/

import java.util.*;

public class Grid_ColSkip {
    static void main(String[] args) {
        int[][] grid = {
                {5, -2, -10, 20},
                {3,  1,  -5,  4},
                {2, -8,   6,  2}
        };

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        System.out.println("Max Path Value: " + solve(0, 0, m, n, grid, dp));
    }
    private static int solve(int i, int j, int m, int n, int[][] grid, int[][] dp){
        if(i==m-1 && j==n-1) return grid[i][j];

        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];

        int right = (int)-1e9;
        if(j<n-1) right = solve(i, j+1, m, n, grid, dp);

        int down = (int)-1e9;
        if(i<m-1) down = solve(i+1, j, m, n, grid, dp);

        int skipCol = (int)-1e9;
        for(int c=j+2; c<n; c++){
            skipCol = Math.max(skipCol, solve(i, c, m, n, grid, dp));

        }

        return dp[i][j] = grid[i][j] + Math.max(right, Math.max(skipCol, down));
    }
}
