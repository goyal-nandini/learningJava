package DPandGreedy;
import java.util.*;
public class UniquePaths_DPonGrid {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(recursion(m-1, n-1));

        // lets do memoization -> tc: O(m*n) sc: O(n+m)+O(m*n) recursion stack space and dp array -> AC
         int[][] dp1 = new int[m][n];
         for(int[] row: dp1) Arrays.fill(row, -1);
        System.out.println(memoisation(m-1, n-1, dp1));  // needs m-1, n-1 -> works with 0-indexed recursion base case

        // lets do tabulation -> tc: O(m*n) nested for loop, sc: O(m*n) for dp array
         int[][] dp = new int[m][n]; // for 0 to m-1 and 0 to n-1 indexes -> dp array size m*n
        System.out.println(tabulation(m, n, dp));// array needs full size, loops handle 0 → m-1

        // time for SO -> tc: O(m*n) sc: O(n)
        System.out.println(SO(m, n));
    }
    public static int SO(int m, int n) {
        int[] prev = new int[n];
        for(int i=0; i<m; i++){
            int[] curr = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0) curr[j]=1; // base case
                else if(j==0) curr[j] = 1; // first column
                else curr[j] = curr[j-1] + prev[j];
            }
            prev = curr;
        }
        return prev[n-1];
    }
    public static int tabulation(int m, int n, int[][] dp){

        // dp[0][0] = 1; ->alone won't work, u have to set the for first row and first column, because they represent the unique straight-line paths from the start.
        // WAY1
        // for(int i=0; i<m; i++) dp[i][0] = 1;
        // for(int i=0; i<n; i++) dp[0][i] = 1;
        // for(int i=1; i<m; i++){
        //     for(int j=1; j<n; j++){
        //         dp[i][j] = dp[i-1][j]+dp[i][j-1];
        //     }
        // }

        // WAY2
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[i][j]=1;
                else{
                    int up=0, left=0;
                    if(i>0) up = dp[i-1][j];
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static int memoisation(int i, int j, int[][]dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = memoisation(i-1, j, dp);
        int left = memoisation(i, j-1, dp);

        return dp[i][j] = up+left;
    }

    // lets do it with recursion for now:
    public static int recursion(int i, int j){
        // base case:
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        // basically its moves are right and down -> here we've done up and left as
        // for downward dp technique recursion only (pov rem we did that in all prev
        // dp problem from sheet like from day 0 to day d or day d to 0)
        int up = recursion(i-1, j);
        int left = recursion(i, j-1);

        return up+left;
    }
}
