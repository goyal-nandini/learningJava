package DPandGreedy;

import java.util.*;

public class ninjasTraining_2D_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // number of days
        int n = sc.nextInt();

        // points array: n rows, 3 columns
        int[][] points = new int[n][3];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
            points[i][2] = sc.nextInt();
        }
        
//        int result = recursion(n-1, 3, points, n); // day n-1 to 0

        int[][] dp = new int[n][4];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
//        int result = memoisation(n-1, 3, points, n, dp);

        int result = tabulation(points, n);
        System.out.println(result);
    }

    // recursion: top-down
    public static int recursion(int day, int last, int[][] points, int n){
        // base case:
        if(day == 0){
            // for day 0, we'll decide max points from act 0 to 2
            int maxPoints = 0; 
            for(int act=0; act<3; act++){
                if(act != last){
                    maxPoints = Math.max(maxPoints, points[0][act]);
                }
            }
            return maxPoints;
        }
        
        // recursive part:
        int maxPoints = 0;
        for(int act=0; act<3; act++){
            if(act!=last){
                int tPoints = points[day][act] + recursion(day-1, act, points, n); // recursive part be like
                // telling day-1 that act has been performed, then day-1 will try out left act!=last(this act)
                // check recursion tree top-down
                // We are telling the subproblem that on day (day-1), the activity performed was act.
                maxPoints = Math.max(maxPoints, tPoints);
            }
        }
        return maxPoints;
        
    }
    // memoization: managing overlapping subproblems
    public static int memoisation(int day, int last, int[][] points, int n, int[][] dp){
        // base case:
        if(day == 0){
            int maxPoints = 0;
            for(int act=0; act<3; act++){
                if(act != last)
                    maxPoints = Math.max(maxPoints, points[0][act]);
            }
            return maxPoints;
        }
        if(dp[day][last] != -1) return dp[day][last];
        int maxPoints = 0;
        for(int act=0; act<2; act++){
            if(act != last){
                int tPoints = points[day][act] + memoisation(day-1, act, points, n, dp);
                maxPoints = Math.max(maxPoints, tPoints);
            }
        }
        return dp[day][last] = maxPoints;
    }

    // Tabulation: bottom up
    public static int tabulation(int[][] points, int n){
        int[][] dp = new int[n][4];
        // base case handling:
//        for(int act=0; act<4; act++){ --> TO BE ASKED!! -> WILL MESS UP THis as its only for day1 so no need to worry at all
//            dp[0][act] = Math.max(dp[0][act])
//        } 👇👇

        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // or 👉👉
        for(int last = 0; last < 4; last++){
            int maxPoints = 0;
            for(int act = 0; act < 3; act++){
                if(act != last){
                    maxPoints = Math.max(maxPoints, points[0][act]);
                }
            }
            dp[0][last] = maxPoints;
        }

//        “I am filling DP day by day (bottom-up)”
        for(int day=1; day<n; day++){
//            “Assume what activity was done yesterday” This creates 4 states per day.
            for(int last=0; last<4; last++){
                int maxPoints = 0;
//                “Try all activities today except last”
                for(int act=0; act<3; act++){
                    if (act != last) {
                        int tPoints = points[day][act] + dp[day-1][act];
                        maxPoints = Math.max(tPoints, maxPoints);
                    }
                }
                dp[day][last] = maxPoints;
            }
        }
//        return dp[n-1][3]; // CORRECT and stdn way but
        // if u get stuck with why last as 3 as it is for day0 with no restriction on that day, then see
        // we have keep last=3 for all days.
        // dp[day][3] always means
        //best till this day with no restriction
        //So it automatically stores the max of 0,1,2,
//        dp[n-1][3] ⬇️ is just shorthand for ⬇️
        return Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2])); // CAN USE THIS
        // u can say this: The dummy state is logically needed only for day 0.
        //I reuse it till the end as a convenience to directly get the final answer.

    }

    // Space Optimization: need only one 4 sized array not n*4 sized one!!
    public static int SO(int[][] points, int n){
        int[] prev = new int[4];

        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day=1; day<n; day++){
            // Create a temporary array to store the maximum points for the current day's activities
            int[] temp = new int[4];
            for(int last=0; last<4; last++){
                int maxPoints = 0;
                for(int act=0; act<3; act++){
                    if (act != last) {
                        int tPoints = points[day][act] + prev[act];
                        maxPoints = Math.max(tPoints, maxPoints);
//                        temp[act] = maxPoints; WRONG
//                        You’re updating temp[act] = maxPoints.
//                        But temp is supposed to store values for each last, not for each act.
                        temp[last] = maxPoints;
                    }
                }
            }
            // Update prev with the maximum points for the current day
            prev = temp;
        }
        return prev[3];
    }

}

