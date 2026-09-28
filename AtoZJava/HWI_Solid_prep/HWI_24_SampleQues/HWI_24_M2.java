package HWI_Solid_prep.HWI_24_SampleQues;
import java.util.*;

/*You are given three integers X,Y and Z and two
arrays A and B both of length N. You are also given an
integer sum which is initially equal to 0.
You have perform N operations and in each i

th operation you

must do only one of the following :
1. Subtract B[i] from sum.
2. Decrease both of X and Y by 1, then add A[i] * X * Y *
Z to sum.
3. Decrease both of Y and Z by 1, then add A[i] * X * Y *
Z to sum.
However, after each operation, X,Y and Z must all remain greater
than or equal to 0.
Find the maximum sum you can obtain after performing all
operations. Since answer can be large, return it modulo 109
+7.*/
public class HWI_24_M2 {
    static final long MOD = 1_000_000_007L;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int[] A = new int[n];
        for(int i=0; i<n; i++) A[i] = sc.nextInt();
        int[] B = new int[n];
        for(int i=0; i<n; i++) B[i] = sc.nextInt();

        long[][][] dp = new long[n+1][y+1][y+1];
        // initilizaing with -1 won't work as ans might be negative, so safest would be use MIN_VALUE
        for(long[][] mat: dp){
            for(long[] row: mat){
                Arrays.fill(row, Long.MIN_VALUE);
            }
        }

        solve(0, 0, 0, n, A, B, dp, x, y, z);
        long ans = dp[0][0][0];
        System.out.println(((ans % MOD) + MOD) % MOD);

        long tabu_ans = solve(n, A, B, x, y, z);
        System.out.println(((tabu_ans % MOD) + MOD) % MOD);

        long SO_ans = solve_SO(n, A, B, x, y, z);
        System.out.println(((SO_ans % MOD) + MOD) % MOD);

        /* Why `(ans % MOD + MOD) % MOD` and not just `ans % MOD`?
        If ans is POSITIVE → ans % MOD works fine
        If ans is NEGATIVE → Java % gives negative result!
        Example: -10 % (10^9+7) = -10 in Java ❌
         ((-10 % MOD) + MOD) % MOD = 999999997 ✅
        So always use the `+MOD` trick to be safe.
        */


//        p = how many times we have used op2 so far
//        q = how many times we have used op3 so far
//        and initially both are 0, so start from 0, 0 for p and q

    }
    /* 4d dp problem -> 4 states: i, x, y, z -> dp[i][x][y][z]
    * 3 operations:
    * op1: dp[i][x][y][z] = -B[i] + dp[i+1][x][y][z]
    * op2: dp[i][x][y][z] = A[i]*(x-1)*(y-1)*z + dp[i+1][x-1][y-1][z]
    * only when x>=1 and y>=1
    * op3: dp[i][x][y][z] = A[i]*x*(y-1)*(z-1) + dp[i+1][x][y-1][z-1]
    * only when y>=1 and z>=1
    *
    * final dp transitions:
    * at every state:  max sum till index i //??!@@
    *
    * but this 4d dp is huge!!
    * try to convert 4d dp to 3d dp !!?? ->
    *
    * 📌pattern spotting: 👉 When a variable is always reduced in all choices,
      you can often replace it with a count of operations
      When stuck in DP:
      Ask:
     “Which variable changes in ALL transitions?”
     “Can I represent it as a count instead?”
*
      * if we have done 'p' times op1 and 'q' times op2, then
      * currx = xinit - p
      * curry = yinit - p - q
      * currz = zinit - q
      * we have State: dp[i][p][q] = max sum from i to N means i onwards
      * having done op2 p times and op3 q times
      *
      * op1: dp[i][p][q] = -B[i] + dp[i+1][p][q]
      * op2: 1 operation p added hoga so new p = p+1,
      * gain: A[i] * (currx-1) * (curry-1) * currz only when currx>=1 and curry>=1
      * transition: gain + dp[i+1][p+1][q]
      * op3: 1 operation q added new q = q+1,
      * gain: A[i] * currx * (curry-1) * (currz-1) only when curry>=1 and currz>=1
      * transition: gain + dp[i+1][p][q+1]
      * also as curry = yinit - p - q = yinit - (p+q) so p+q <= yinit also
      *
      * final combined state:
      * dp[i][p][q] = max(
            -B[i] + dp[i+1][p][q],
            A[i]*(currX-1)*(currY-1)*currZ + dp[i+1][p+1][q],   (if valid)
            A[i]*currX*(currY-1)*(currZ-1) + dp[i+1][p][q+1]    (if valid)
        )
      * constraints : p ≤ Xinit, q ≤ Zinit, p + q ≤ Yinit
      * these are conditions to allow transition !! :)
      *
      * base case depend on index i and validity depends on (p, q) and derived x, y, z
      * base case: dp[N][p][q] = 0 for all valid p and q, means when i == N
      *
      * A[i] * currX * currY * currZ
        👉 Max values:
        A[i] = 1e6
        X,Y,Z = 1e3
        👉 Product ≈ 1e15 😬 int will overflow, use long
        *
        * remember: 👉 In DP:
        If answer can be 0 or negative → ❌ don’t use 0 or -1
        Use something like -∞ (Long.MIN_VALUE)
        *
        * dp size n*y+1*y+1 because we have [i][p][q] and p+q<=y the worst case can be p=y and q=0 or vice versa
    * */

    private static void solve(int i, int p, int q, int n,
                              int[] A, int[] B,
                              long[][][] dp,
                              int x, int y, int z){

        if(p>x || q>z || p+q>y) return;

        if(i == n){
            dp[i][p][q] = 0;
            return;
        }

        if(dp[i][p][q] != Long.MIN_VALUE) return;

        int currx = x - p;
        int curry = y - p - q;
        int currz = z - q;

        // compute needed state first
        solve(i+1, p, q, n, A, B, dp, x, y, z);

        long op1 = -B[i] + dp[i+1][p][q];

        long op2 = Long.MIN_VALUE;
        long op3 = Long.MIN_VALUE;

        if(currx>=1 && curry>=1){
            solve(i+1, p+1, q, n, A, B, dp, x, y, z);
            op2 = (long)A[i]*(currx-1)*(curry-1)*currz +
                    dp[i+1][p+1][q];
        }

        if(currz>=1 && curry >=1){
            solve(i+1, p, q+1, n, A, B, dp, x, y, z);
            op3 = (long)A[i]*currx*(curry-1)*(currz-1) +
                    dp[i+1][p][q+1];
        }

        dp[i][p][q] = Math.max(op1, Math.max(op2, op3));
    }
    /*
    * time for tabulation ans above will be giving TLE :)
    * as we are calc dp[i+1] so we need i+1 to be filled first so we do iteration from n to 0 [remember when we did
    * LIS where we focus on learning how to iterative/iterative direction at one stage!!
    * */

    private static long solve(int n,
                              int[] A, int[] B,
                              int x, int y, int z){
        long[][][] dp = new long[n+1][y+1][y+1];
        // base case: i == N, nothing left to do
        // dp[N][p][q] = 0 for all p, q → already 0 by default ✅


        for(int i=n-1; i>=0; i--){
            // two more states p and q from 0 to y+1 or take any direction 0 to y+1 or y+1 to 0
            for(int p=y; p>=0; p--){
                for(int q=y; q>=0; q--){
                    // now copy recursion :)
                    if(p>x || q>z || p+q>y) continue;
                    // dp states lets write them
                    int currx = x - p;
                    int curry = y - p - q;
                    int currz = z - q;

                    long op1 = -B[i] + dp[i+1][p][q];
                    long op2 = Long.MIN_VALUE;
                    long op3 = Long.MIN_VALUE;

                    if(currx>=1 && curry>=1)
                        op2 = (long)A[i] * (currx-1) * (curry-1) * currz +
                            dp[i+1][p+1][q];

                    if(curry>=1 && currz>=1)
                        op3 = (long)A[i] * currx * (curry-1) * (currz-1) +
                            dp[i+1][p][q+1];

                    dp[i][p][q] = Math.max(op1, Math.max(op2, op3));
                }
            }
        }
        return dp[0][0][0];
    }
    // SO:
    private static long solve_SO(int n,
                              int[] A, int[] B,
                              int x, int y, int z){
        long[][] next = new long[y+1][y+1];
        // base case: i == N, nothing left to do
        // dp[N][p][q] = 0 for all p, q → already 0 by default ✅


        for(int i=n-1; i>=0; i--){
            // two more states p and q from 0 to y+1 or take any direction 0 to y+1 or y+1 to 0
            long[][] curr = new long[y+1][y+1];
            for(int p=y; p>=0; p--){
                for(int q=y; q>=0; q--){
                    // now copy recursion :)
                    if(p>x || q>z || p+q>y) continue;
                    // dp states lets write them
                    int currx = x - p;
                    int curry = y - p - q;
                    int currz = z - q;

                    long op1 = -B[i] + next[p][q];
                    long op2 = Long.MIN_VALUE;
                    long op3 = Long.MIN_VALUE;

                    if(currx>=1 && curry>=1)
                        op2 = (long)A[i] * (currx-1) * (curry-1) * currz +
                                next[p+1][q];

                    if(curry>=1 && currz>=1)
                        op3 = (long)A[i] * currx * (curry-1) * (currz-1) +
                                next[p][q+1];

                    curr[p][q] = Math.max(op1, Math.max(op2, op3));
                }
            }
            next = curr;
        }
        return next[0][0];
    }


    // further optimised: refer this: https://chatgpt.com/s/t_69c423fdca388191be5b9637b71261a2
}
