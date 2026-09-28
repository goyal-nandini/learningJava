package extras_OA.ClaudeMockTest_realQueBased.MT1;

// state on 30 july
// got failed in understanding the statement - what's been asked
// even if i get tje ps - either i don't know the data structure used
// or i don't figure out the algorithm and intuition :(
// its been 40 min i can't figure out que 2 and 3 anyway -

// edit: 4 august feeling confident - i can solve it easily

/*Question 2 (Medium) — Tiling a Corridor with Position Penalty
A corridor of length N must be fully covered using tiles of width 1, 2, or 3. Placing a tile of width w starting at position i costs cost[w] + penalty[i], where cost[1], cost[2], cost[3] are fixed base costs and penalty[i] is an extra charge applied once per tile based on its starting position. Positions are 0-indexed, spanning 0 to N-1.

Find the minimum total cost to tile the entire corridor (tiles cannot overhang past position N-1, and cannot overlap).

Input Format

Line 1: integer N, total length of the corridor.
Line 2: integer C1, base cost of a width-1 tile.
Line 3: integer C2, base cost of a width-2 tile.
Line 4: integer C3, base cost of a width-3 tile.
Line 5: N space-separated integers — penalty[0..N-1].
Constraints

1 <= N <= 10^5
1 <= C1, C2, C3 <= 10^5
0 <= penalty[i] <= 10^5
Sample Test Case

code

Input:
4
2
3
4
1 0 1 0

Output:
7
Explanation: One optimal tiling is a width-2 tile at position 0 (cost 3+1=4) and a width-2 tile at position 2
(cost 3+1=4)... check smaller combos; minimum achievable is 7 via width-3 at position 0 (4+1=5) + width-1 at position 3
(2+0=2) = 7.*/

import java.io.*;
import java.util.*;

public class TilingCorridorwithPositionPenalty {
    static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));

        st.nextToken(); int N = (int) st.nval;
        st.nextToken(); int C1 = (int) st.nval;
        st.nextToken(); int C2 = (int) st.nval;
        st.nextToken(); int C3 = (int) st.nval;

        int[] penalty = new int[N];
        for (int i = 0; i < N; i++) {
            st.nextToken();
            penalty[i] = (int) st.nval;
        }

        // Initialize memoization array with -1
        long[] dp = new long[N + 1];
        Arrays.fill(dp, -1);

        long ans_memo = solve(0, C1, C2, C3, N, penalty, dp);
        System.out.println(ans_memo);

        long ans = solve(C1, C2, C3, N, penalty);
        System.out.println(ans);

    }
    private static final long INF = (int)1e15;

    // tabu time O(N) Time, O(N) Space
    private static long solve(int c1, int c2, int c3, int n, int[] penalty){
        long[] dp = new long[n+1];
        dp[0] = 0; // 0 cost to cover 0 remaining distance
        for(int i=n-1; i>=0; i--){

            // 3-choices
            // Tabulation needs explicit checks before accessing dp[i + 2] or dp[i + 3]
            // because dp has length n + 1 (indices 0 to n). Accessing dp[n+1] causes ArrayIndexOutOfBoundsException!

            // guard: idx + tile_width <= n
            // Checking idx + width <= n ensures the entire tile stays inside N.

            long pick_width_1 = INF;
            if(i+1 <= n) pick_width_1 = c1 + penalty[i] + dp[i+1];

            long pick_width_2 = INF;
            if(i+2 <= n) pick_width_2 = c2 + penalty[i] + dp[i+2];

            long pick_width_3 = INF;
            if(i+3 <= n) pick_width_3 = c3 + penalty[i] + dp[i+3];

            dp[i] = Math.min(pick_width_1, Math.min(pick_width_2, pick_width_3));
        }
        return dp[0];

    }

    /*Note: For N = 10^5, top-down recursion will create up to 10^5 stack frames, which may risk a
    StackOverflowError depending on JVM stack size limits. The iterative tabulation approach is safer for
    production/online judges.*/

    // memo: O(N) Time, O(N) Space
    private static long solve(int idx, int c1, int c2, int c3, int n, int[] penalty, long[] dp){
        if(idx == n) return 0; // area got finished now, 0 cost added now...
        if(idx > n) return INF; // tile overhangs past pos n-1

        if(dp[idx] != -1) return dp[idx];

        // choices
        // guard: idx + tile_width <= n,
        // Checking idx + width <= n ensures the entire tile stays inside N.

        long pick_width_1 = INF;
        if(idx+1<=n) {
            long next = solve(idx+1, c1, c2, c3, n, penalty, dp);
            if(next != INF) pick_width_1 = c1 + penalty[idx] + next;
        }

        long pick_width_2 = INF;
        if(idx+2<=n) {
            long next = solve(idx+2, c1, c2, c3, n, penalty, dp);
            if(next != INF) pick_width_2 = c2 + penalty[idx] + next;
        }

        long pick_width_3 = INF;
        if(idx+3<=n) {
            long next = solve(idx+3, c1, c2, c3, n, penalty, dp);
            if(next != INF) pick_width_3 = c3 + penalty[idx] + next;
        }

        return dp[idx] = Math.min(pick_width_1, Math.min(pick_width_2, pick_width_3));
    }
}

