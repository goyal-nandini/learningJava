package extras_OA.ClaudeMockTest_realQueBased.MT1;

import java.io.*;
import java.util.*;

// The intended solution is DP on total value, not DP on weight. This problem is specifically designed
// so that a weight-based DP is impossible, forcing you to recognize the alternate state definition.

/* see the constraints: 10^9 for W as a state in dp tc will become 10^11 as 10^2*10^9 O(n*W)
* so it RTE on AtCoder... lets tackle it
* max total value is 100 * 1000 = 10^5
* instead of dp[item][wt] we do dp[item][value]
*
* dp[idx][val] = min wt needed to achieve value from index idx to n-1
* dp size will be 10^5 not 10^11
*
* Before: solve(idx, wt) = The maximum value that can be obtained using items from idx to n-1 with remaining capacity w.
* after: solve(idx, val) = minimum weight required to obtain exactly 'value' starting from index idx.
*
*
* Instead of
* "Given a weight, what's the maximum value?"
* what if we ask
* "Given a value, what's the minimum weight needed?"
* That leads to
* dp[idx][value] = minimum weight required to obtain exactly this value till index idx
* Notice the reversal. Weight becomes the answer. Value becomes the index.*/

public class AtCoderKnapsack2 {
    public static void main(String[] args) {
        FastReader51 fr = new FastReader51();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = fr.nextInt();
        int W = fr.nextInt();

        int[] w = new int[N];
        int[] v = new int[N];

        for(int i=0; i<N; i++){
            w[i] = fr.nextInt();
            v[i] = fr.nextInt();
        }

        int totalVal = 0;
        for(int x: v) totalVal += x;

        int[][] dp = new int[N][totalVal+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for(int i=totalVal; i>=0; i--){
            // need max value
            if(solve(0, i, v, w, dp) <= W){
                ans = i;
                break;
            }
        }
        out.println(ans);
        out.flush();
    }
    private static int solve(int idx, int targetVal, int[] v, int[] w, int[][] dp){
        if(targetVal == 0){
            return 0; // achieved the target
        }
        
        if(idx >= w.length){ // can't made to the target, return undefined
            if(targetVal > 0) return (int)1e9;
        }

        if(dp[idx][targetVal] != -1) return dp[idx][targetVal];

        int pick = (int)1e9;
        if(targetVal>=v[idx]) pick = w[idx]+solve(idx+1, targetVal-v[idx], v, w, dp);

        int not_pick = solve(idx+1, targetVal, v, w, dp);

        return dp[idx][targetVal] = Math.min(pick, not_pick);
    }
}

