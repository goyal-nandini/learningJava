package Contest_CC_CF_LC_CSES.CSES;

import java.util.Arrays;
import java.util.Scanner;

public class Frog2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] heights = new int[n];
        for(int i=0; i<n; i++){
            heights[i] = sc.nextInt();
        }

        int[] dp1 = new int[n+k+1];
        Arrays.fill(dp1, -1);
        int ans = solve(0, heights, k, dp1);
        System.out.println(ans);
    }
    private static int solve(int idx, int[] heights, int k, int[] dp){
        if(idx >= heights.length-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int minCost = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++){
            int cost = Integer.MAX_VALUE;
            if(idx+i<heights.length) cost = Math.abs(heights[idx]-heights[idx+i]) + solve(idx+i, heights, k, dp);
            minCost = Math.min(minCost, cost);
        }
        return dp[idx] = minCost;
    }
}
