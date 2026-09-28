package Trees.DigitDP;

import java.util.Scanner;

/*
Q4 — Count Numbers in Range with Adjacent Digit Difference = 1 or K (Digit DP)

You are given an integer K and two large integers as strings low and high representing an inclusive range.

Count all numbers in [low, high] such that the absolute difference between every pair of adjacent digits is either 1 or K.

Return the total count.

Example:
K=2, low="1", high="100"

Check each number:
1: single digit → no adjacent pairs → valid? (score=0, neither 1 nor K... edge case)
12: |2-1|=1 ✓ valid
21: |2-1|=1 ✓ valid
13: |3-1|=2=K ✓ valid
31: |3-1|=2=K ✓ valid
23: |3-2|=1 ✓ valid
...
Count all valid numbers in [1,100]

Pattern: Digit DP — dp[pos][lastDigit][tight][started]

At each position, place digit d where |d - lastDigit| == 1 or |d - lastDigit| == K
tight: bounds by high string
started: handle leading zeros

Count(high) - Count(low-1) using standard digit DP template.

State space: 22 × 10 × 2 × 2 = 880 states — very fast. O(len × 10 × 2 × 2).

This is similar to Q4 from the earlier set (digit difference score in range) but simpler — each adjacent diff must be exactly 1 or K rather than sum in range.

Repeat tracker:

Q4 digit DP on digit differences — 3rd time this pattern appears across collected sets
 */
import java.util.*;
public class AdjDigDifference {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        int K = sc.nextInt();

        String num1 = Integer.toString(R);
        String num2 = Integer.toString(L-1);

        long[][][][] dp1 = new long[num1.length()][2][11][2]; // be careful prev is total 0-9 = 10 in total, but +1 for safety no issues :)
        long[][][][] dp2 = new long[num2.length()][2][11][2];
        for(long[][][] dp: dp1) for(long[][] mat: dp) for(long[] row: mat) Arrays.fill(row, -1);
        for(long[][][] dp: dp2) for(long[][] mat: dp) for(long[] row: mat) Arrays.fill(row, -1);

        long ans = solve(0, 1, 0, 0, K, num1, dp1)-solve(0, 1, 0, 0, K, num2, dp2);
        System.out.println(ans);
    }
    /*
    que: why we need started state: see we have prev as 0, so for single dig numbers there's no adj, so no prev but
    still code doesn't know about if its fake for starters, so we need started state to just skip those single dig or can
    set started and skip only when started and still the adj diff is not correct as per requirement.

    more formal lang:
    if(Math.abs(dig-prev) != 1 && Math.abs(dig-prev) != k) continue;

This line is comparing dig against prev to decide whether to allow it. Now ask: at pos=0, is there a real "previous
digit"? No — there isn't one yet, because you haven't placed any digit. So whatever value you initialize prev to
(you used 0) is fake — it doesn't represent an actual digit of the number.

But your code doesn't know it's fake — it just blindly does Math.abs(dig - 0) and applies the same rule as if 0 were a
real previous digit. That's the bug. So the fix is: tell the code "hey, ignore this comparison rule until we've placed
 at least one real digit" — that's exactly what started does.

 // note: single digits are counted here as there's not adj pairs, so no rule to violate, trivially counted
     */
    private static long solve(int pos, int tight, int prev, int started, int k, String num, long[][][][] dp){
        if(pos == num.length()){
            if(started==1) return 1;
            else return 0;
        }
        if(dp[pos][tight][prev][started] != -1) return dp[pos][tight][prev][started];

        int limit;
        if(tight == 1){
            limit = num.charAt(pos)-'0';
        } else {
            limit = 9;
        }

        long ans=0;
        for(int dig=0; dig<=limit; dig++){
            int newStarted = 0;

            // set newStarted to 1 when there is not one digit number or has already started
            if(started==1 || dig!=0) {
                newStarted = 1;
            }

            // if started and still the adj pairs diff is not correct, then continue
            if(started==1 && Math.abs(dig-prev) != 1 && Math.abs(dig-prev) != k) continue; // be carefull, continue only when both are
            // not equal...

            int newTight;
            if(tight == 1 && dig==limit){
                newTight = 1;
            } else {
                newTight = 0;
            }
            ans += solve(pos+1, newTight, dig, newStarted, k, num, dp);
        }
        return dp[pos][tight][prev][started] = ans;
    }
}
