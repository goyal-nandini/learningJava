package DPandGreedy;
import java.util.*;
public class FrogJump {
    public static void main(String[] args) {
        int[] h = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(6, h));
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here...tc: O(n) sc: O(n) dp array + recursion stack
        int[] dp = new int[n]; // dp size as n as no. of stairs
        Arrays.fill(dp, -1);

        // minimum energy to reach last stone
        memoise(n-1, heights, dp); // 0, 1, 2, .... n-1 that's why n-1 as starting
        System.out.println(Arrays.toString(dp));
        return memoise(n-1, heights, dp);
    }

    public static int memoise(int i, int[] h, int[] dp){
        // base case:
        if(i == 0) return 0;
        if(i == 1) return Math.abs(h[1] - h[0]);

        if(dp[i] != -1) return dp[i];

        int left = memoise(i-1, h, dp)+Math.abs(h[i]-h[i-1]);

        int right = Integer.MAX_VALUE;
        if(i > 1)
            right = memoise(i-2, h, dp)+Math.abs(h[i]-h[i-2]);

        return dp[i] = Math.min(left, right);
    }
}
