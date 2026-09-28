package DPandGreedy;

import java.util.*;

/*
- at each cell, we have two independent decisions:
1. which matrix? G1 or G2
2. where to move? right or down

there are 4 possibilities:
*/
public class Grid {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int switchCost = sc.nextInt();

        long[][] grid1 = new long[n][m];
        long[][] grid2 = new long[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid1[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                grid2[i][j] = sc.nextInt();
            }
        }

        long[][][] dp = new long[n][m][3];
        for(long[][] mat: dp) for(long[] row: mat) Arrays.fill(row, Long.MAX_VALUE);
        long ans = solve(0, 0, n, m, grid1, grid2, switchCost, 0, dp);
        System.out.println(ans);
    }

    /*
    right1 = choose G1 + move right
    down1  = choose G1 + move down

    right2 = choose G2 + move right
    down2  = choose G2 + move down

    overall sum-up:
    same grid as previous grid choose krn ki cost grid_curr[i][j]
    diff grid as previous grid choose krn ki cost grid_curr[i][j]-switchCost
    */

    private static long solve(int i, int j, int n, int m, long[][] grid1, long[][] grid2, long switchCost, int prevPick, long[][][] dp){
//        if(i>=n || j>=m) return Long.MIN_VALUE; -- don't use this, only add check before calling next recurrence

        if(i==n-1 && j==m-1){
            // pick from prev same grid not penalty, else sub penalty if we did grid switch
            if(prevPick==1) return Math.max(grid1[i][j], grid2[i][j]-switchCost);

            if(prevPick==2) return Math.max(grid2[i][j], grid1[i][j]-switchCost);

            return Math.max(grid1[i][j], grid2[i][j]); // when prevPick == 0,
            // for first cell, may it be 1*1 matrix, as no switching cost from something that doesn't exist
        }

        if(dp[i][j][prevPick] != Long.MAX_VALUE) return dp[i][j][prevPick];

        long right1 = Long.MIN_VALUE; // these checks ensure, you'll never make an invalid recursive call.
        if(j+1<m){
            if(prevPick==0 || prevPick==1)
                right1 = grid1[i][j] + solve(i, j+1, n, m, grid1, grid2, switchCost, 1, dp);
            else right1 = grid1[i][j] - switchCost + solve(i, j+1, n, m, grid1, grid2, switchCost, 1, dp);
        }

        long down1 = Long.MIN_VALUE;
        if(i+1<n) {
            if (prevPick == 0 || prevPick == 1)
                down1 = grid1[i][j] + solve(i + 1, j, n, m, grid1, grid2, switchCost, 1, dp);
            else down1 = grid1[i][j] - switchCost + solve(i + 1, j, n, m, grid1, grid2, switchCost, 1, dp);
        }

        long right2 = Long.MIN_VALUE;
        if(j+1<m) {
            if (prevPick == 0 || prevPick == 2)
                right2 = grid2[i][j] + solve(i, j + 1, n, m, grid1, grid2, switchCost, 2, dp);
            else right2 = grid2[i][j] - switchCost + solve(i, j + 1, n, m, grid1, grid2, switchCost, 2, dp);
        }

        long down2 = Long.MIN_VALUE;
        if(i+1<n) {
            if (prevPick == 0 || prevPick == 2)
                down2 = grid2[i][j] + solve(i + 1, j, n, m, grid1, grid2, switchCost, 2, dp);
            else down2 = grid2[i][j] - switchCost + solve(i + 1, j, n, m, grid1, grid2, switchCost, 2, dp);
        }

        return dp[i][j][prevPick] = Math.max(down2, Math.max(right1, Math.max(down1, right2)));
    }
}
