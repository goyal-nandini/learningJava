package DPandGreedy;

import java.util.Arrays;

public class FrogJumpKSteps {
    public static void main(String[] args) {
        int[] h = {7, 4, 8, 2, 9, 1, 6};
        int k = 3; // can be any

        // memoisation:
        System.out.println(frogJumpKSteps_1(7, h, k));

        // tabulation
        System.out.println(frogJumpKSteps_2(7, h, k));

        // space optimization
        frogJumpKSteps_spaceOptimized(7, h, k);
    }

    public static int frogJumpKSteps_spaceOptimized(int n, int[] h, int k) {
        int[] lastK = new int[k];  // stores last k dp values
        Arrays.fill(lastK, Integer.MAX_VALUE);

        lastK[0] = 0; // dp[0]

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;

            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int prev = lastK[(i - j) % k];
                    int jump = prev + Math.abs(h[i] - h[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }

            lastK[i % k] = minSteps;
        }

        return lastK[(n - 1) % k];
    }

    public static int frogJumpKSteps_2(int n, int h[], int k) {
        // tabulation bottom up approach:

        int[] dp = new int[n];
        dp[0] = 0;
        // NESTED LOOP tc: O(n*k) sc: O(n)
        for(int i=1; i<n; i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++){
                if(i-j >= 0){
                    int jump = dp[i-j] + Math.abs(h[i]-h[i-j]);
                    minSteps = Math.min(jump, minSteps);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n-1];
    }


    public static int frogJumpKSteps_1(int n, int heights[], int k) {
//        tc: O(n*k) sc: O(2n)
        int[] dp = new int[n]; // dp size as n as no. of stairs
        Arrays.fill(dp, -1);

        memoise(n-1, heights, dp, k); // 0, 1, 2, .... n-1 that's why n-1 as starting
        System.out.println(Arrays.toString(dp));
        return memoise(n-1, heights, dp, k);
    }

    public static int memoise(int i, int[] h, int[] dp, int k){
        // base case:
        if(i == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];

        for(int j=1; j<=k; j++){
            if(i-j >= 0){
                int jump = memoise(i-j, h, dp, k)+Math.abs(h[i]-h[i-j]);
                minSteps = Math.min(jump, minSteps);
            }
        }
        return dp[i] = minSteps;
    }
}
