package Trees.DigitDP;
// find the count of numbers between L and R which have a sum of digits = S
// 1 <= L <= R <= 10^18
// 1 <= S <= 100

// https://www.hackerearth.com/problem/algorithm/sum-of-digits-8/

import java.util.*;

public class CountInRange_sumX {
    static int[][][] dp;
    static void main(String[] args) {
//        int L = 1;
//        int R = 100;
//        int S = 5;

//        long L = 1;
//        long R = 1000000000000000000L;  // 10^18
//        int S = 1;

//        long L = 1;
//        long R = 1000000000000000000L;
//        int S = 100;

//        long L = 0;
//        long R = 100;
//        int S = 0;

        long L = 123;
        long R = 456;
        int S = 10;

        long res = getCount(R, S) - getCount(L-1, S);
        System.out.println(res);
    }
    /*
    * eg. L=1, R=100, S=5
    * numbers are 5, 14, 23, 32, 41, 50 -> ans is 6
    * ans: solve(R) - solve(L-1)
    * where solve(N) counts numbers from 0 to N with digit sum = S
    * 0.........L........R
    * f(L, R) = f(0, R) - f(0, L-1)
    * */

    // Method to find the smallest number in range [A, B] with digit sum = S
    private static long findSmallest(long A, long B, int S) {
        // If A is less than 0, start from 0
        if (A < 0) A = 0;

        // Simple approach: iterate from A to B
        // Since we need the smallest, we start from A and go up
        for (long i = A; i <= B; i++) {
            if (sumOfDigits(i) == S) {
                return i;
            }
        }
        return -1; // Should not reach here if count > 0
    }

    // Helper method to calculate sum of digits
    private static int sumOfDigits(long n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    private static long getCount(long N, int S){
        if(N<0) return 0;

        String num = Long.toString(N);
        int targetSum = S;
        int len = num.length();

        long[][][] dp = new long[len][2][S+1];
        for(long[][] mat: dp) for(long[] row: mat) Arrays.fill(row, -1);

        return solve(0, 1, 0, num, targetSum, dp);
    }
    private static long solve(int pos, int tight, int sum, String num, int S, long[][][] dp){
        // base case:
        if(pos == num.length()){
            if(sum == S){
                return 1; // count this number whose digits reach S
            } else {
                return 0;
            }
        }

        if(dp[pos][tight][sum] != -1) return dp[pos][tight][sum];

        int limit; // maximum digit we can place
        if(tight == 1) {
            limit = num.charAt(pos)-'0';
        } else {
            limit = 9;
        }

        long ans = 0;
        for(int dig=0; dig<=limit; dig++){
            int newSum = sum + dig;

            if(newSum > S) continue;

            int newTight;
            if(tight == 1 && dig == limit){
                newTight = 1;
            } else {
                newTight = 0;
            }

            ans += solve(pos+1, newTight, newSum, num, S, dp);
        }
        return dp[pos][tight][sum] = ans;
    }
}
