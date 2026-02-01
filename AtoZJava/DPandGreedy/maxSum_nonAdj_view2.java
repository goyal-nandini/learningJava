package DPandGreedy;

import java.util.ArrayList;
import java.util.Arrays;

public class maxSum_nonAdj_view2 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
//        System.out.println(maxSumWithNonAdj(arr.length-1, arr));

        // tabulation
        int[] dp = new int[arr.length+1];
//        System.out.println(maxSumWithNonAdj_tabulation(arr, dp));

        // dpisation
        int[] dpm = new int[arr.length+1];
        Arrays.fill(dpm, -1);
//        System.out.println(maxSumWithNonAdj_dpization(arr.length-1, arr, dpm));

        // space optimization
        System.out.println(maxSumWithNonAdj_SP(arr));

    }
// ⭐⭐  🔵 View 2: Backward DP -> “What is the best answer up to index i?”

    public static int maxSumWithNonAdj_SP(int[] arr){
        if (arr.length == 0) return 0;
        if (arr.length == 1) return arr[0];

        int prev = arr[0]; // dp[i-1]
        int prev2 = 0; // dp[i-2]
        for(int i=1; i<arr.length; i++){

            int pick = arr[i] + prev2;
            int notPick = prev;

            int curri = Math.max(pick, notPick);
            prev2 = prev;
            prev = curri;
        }
        return prev;

    }
    public static int maxSumWithNonAdj_tabulation_2(int[] arr){
        // change in base case only!!
            if (arr.length == 0) return 0;
            int[] dp = new int[arr.length + 1];

            dp[0] = 0;
            dp[1] = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int val = arr[i];
                dp[i+1] = Math.max(dp[i], dp[i-1] + val);
            }
            return dp[arr.length];
        
    }
    public static int maxSumWithNonAdj_tabulation(int[] arr, int[] dp){
        // lets do with tabulation, only use on dp array to store the values ig
        if (arr.length == 1) return arr[0];

        dp[0] = arr[0];
        dp[1] = Math.max(dp[0], dp[1]); // ye use n krk loop 1 se start krn k lie check nb
        // else yehi better feel ho rha hai...!!
        for(int i=2; i<arr.length; i++){
            int pick = arr[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[arr.length-1];
    }
    public static int maxSumWithNonAdj_dpization(int i, int[] arr, int[] dp){
        // recursion with storing overlapping subproblems
        if(i==0) return arr[i];
        if(i<0) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + maxSumWithNonAdj_dpization(i-2, arr, dp);
        int notPick = maxSumWithNonAdj_dpization(i-1, arr, dp);
        return dp[i] = Math.max(pick, notPick);
    }
    public static int maxSumWithNonAdj(int i, int[] arr){
        if(i == 0) return arr[i];
        if(i < 0) return 0;

        int pick = arr[i] + maxSumWithNonAdj(i-2, arr);
        int notPick = maxSumWithNonAdj(i-1, arr);
        return Math.max(pick, notPick);
    }
//    Pick / Non-Pick — refined properly ✅
//    At index i:
//    🟢 Pick arr[i]
//    You automatically skip i-1
//    So you add arr[i] + best till i-2
//    🔵 Not Pick arr[i]
//    You just take best till i-1

//    That’s it.
//    The adjacency constraint is handled automatically by jumping to i-2.
//    No extra condition needed.
}
