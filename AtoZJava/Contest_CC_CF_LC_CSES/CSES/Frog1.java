package Contest_CC_CF_LC_CSES.CSES;

import java.util.*;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i=0; i<n; i++){
            heights[i] = sc.nextInt();
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
//
//        int[] dp2 = new int[n];
//        Arrays.fill(dp2, -1);

//        int ans = Math.min(solve(0, heights, dp1), solve(1, heights, dp2));
        int ans = solve(0, heights, dp1);
        System.out.println(ans);

    }
    private static int solve(int idx, int[] heights, int[] dp){
        if(idx >= heights.length-1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int jumpOne = Integer.MAX_VALUE;
        if(idx+1<heights.length) jumpOne = Math.abs(heights[idx]-heights[idx+1]) + solve(idx+1, heights, dp);

        int jumpTwo = Integer.MAX_VALUE;
        if(idx+2<heights.length) jumpTwo = Math.abs(heights[idx]-heights[idx+2]) + solve(idx+2, heights, dp);

        return dp[idx] = Math.min(jumpOne, jumpTwo);
    }
}
