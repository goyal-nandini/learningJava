package extras_OA.ClaudeMockTest_realQueBased.MT1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

// this is knapsack problem - but see its constraint with this way or simple way its tc is O(10^12)
// ie O(N*B) not acceptable at all
// this is constraint:
//        N ≤ 5000
//        B ≤ 10^9
//        a[i] ≤ 10^9

/*just we did in knapsack 2 in AtCoder, we have to reverse the calculation:
* change the DP state from solve(idx, budget) to solve(idx, shelves)
* we have to find the max no of shelves selected?! also no two adj shelves be selected
* max is N/2 ie 5000/2 = 2500
* Maximum possible shelves = ceil(N/2) = (N + 1) / 2
*
* dp[N][N/2] -> solve(idx, shelves) return the min cost needed to select k shelves
*
* before: solve(idx, budget) get the max no. of shelves from idx to n-1 under this budget
* after: solve(idx, k) get the min budget to select these exact k non-adj shelves from index idx to n-1
*
* idx = current shelf
* k = number of shelves still to be selected
*
*
* Attention: use long as max total cost: 2500*10^9 = 2.5*10^12
* ie long[][] dp not int[][] dp
* */

public class NonAdjacentSelectionUnderBudget {
    static void main(String[] args) {
        FastReader51 fr = new FastReader51();
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = fr.nextInt();
        int B = fr.nextInt();

        int[] cost = new int[N];

        for(int i=0; i<N; i++){
            cost[i] = fr.nextInt();
        }

        int maxShelves = (N+1)/2; // +1 is for integer division

        long[][] dp = new long[N][maxShelves+1];
        for(long[] row: dp){
            Arrays.fill(row, -1);
        }

        int ans = 0;
        for(int i=maxShelves; i>=0; i--){
            // need max no of shelves
            if(solve(0, i, cost, dp) <= B){
                ans = i;
                break;
            }
        }
        out.println(ans);
        out.flush();
    }
    private static long solve(int idx, int k, int[] cost, long[][] dp){
        if(k==0){
            return 0;
        }
        if(idx >= cost.length){ // can't pick k items
            return (long)1e18;
        }

        if(dp[idx][k] != -1) return dp[idx][k];

        long pick = (long)1e18;
        long subres = solve(idx+2, k-1, cost, dp); // safe and secure
        if(subres != (long)1e18) pick = cost[idx]+subres;

        long not_pick = solve(idx+1, k, cost, dp);

        return dp[idx][k] = Math.min(pick, not_pick);

    }
}
