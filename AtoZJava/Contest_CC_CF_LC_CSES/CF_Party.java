package Contest_CC_CF_LC_CSES;

import java.util.Scanner;

// as constraints are small will give TLE so let's do it with memoization, THE IDEAL WAY!!
// 1 <= n <= 200,000 as given in tutorial expected constraints

public class CF_Party {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            p[i] = sc.nextInt();
        }

        // goal is to get the max no of levels made in this whole tree[employee-manager relation],
        // each level is made to a group
        // as in each level there is no one superior to one another, which is required in the problem!
        int maxCnt = 0;
        for(int i=0; i<n; i++){
            int curr = p[i];
            int cnt = 1; // every emp is a group in itself
            while(curr != -1){
                cnt++;
                curr = p[curr-1]; // as we have 1-based emp given so have to made it to 0-based for accessing them
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
//        System.out.println(maxCnt);

        int[] dp = new int[n];
        int max = 0;
        for(int i=0; i<n; i++){
            findDepth(i, p, dp);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);

        int max2 = 0;
        for(int i=0; i<n; i++){
            int ans = solve(i, p, dp);
            max2 = Math.max(ans, max2);
        }
        System.out.println(max2);
    }

    // dp - recursion/memoization, i'm with this version
    private static void findDepth(int idx, int[] arr, int[] dp){
        if(arr[idx] == -1){
            dp[idx] = 1;
            return;
        }

        if(dp[idx]!=0) return;

//        for(int i=idx; i<arr.length; i++){
//            findDepth(i+1, arr, dp);
//            dp[i] = 1 + dp[idx];
//        } -> it tries to recurse on i+1 instead of following the manager chain. What you really want is:
//        for each employee idx, compute depth by recursively calling on their manager, not on the next index.

        int manager = arr[idx]-1;
        findDepth(manager, arr, dp);
        dp[idx] = 1 + dp[manager];
    }

    // just wrote eewvenyii...
    static int solve(int idx, int[] arr, int[] dp){
        if(arr[idx] == -1){
            return dp[idx] = 1;
        }

        if(dp[idx] != 0) return dp[idx];

        int parent = arr[idx] - 1;
        int depth = 1 + solve(parent, arr, dp);
        return dp[idx] = depth;
    }
}

/*
no cycle, grp such that no emp is superior to other emp -> max depth in a tree
employee -> immediate manager
1-based indexes -> given immediate managers -> trying to get to the ult manager
* 1 -> -1
* 2 -> 1 -> -1
* 3 -> 2 -> 1 -> -1 => 3
* 4 -> 1 -> -1
* 5 -> -1
* 6 -> 5 -> -1
* 7 -> 6 -> 5 -> -1
* 8 -> 7 -> 6 -> 5 -> -1 => 4

trees be like:

     1     5
    /  \    \
   2    4    6
  /           \
 3             7
                \
                 8

 we can see total 4 levels made to 4 groups


⚠️ One mistake you still might make later
You may confuse this with:
diameter ❌
longest path between any two nodes ❌

👉 This problem is NOT that.

It is:
longest path from node → root
* */

