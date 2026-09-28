package Trees.DigitDP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
issue:
before handling leading zeroes: why we need to handle them: got some WA on CSES
example L = 1, R = 100
11, 22, 33, 44, .... 99 and 100 are skipped - 100-10=90
next 000, 001, 002, 003, .... 009 are also skipped 9 more so my code gives ans as 80 not 90

so i need to handle leasing zeroes as they make skip these single digits as they have adj 0's in them

solution:
add started flag as extra state here:

now we have:
pos = current digit position
tight = whether you’re still bound by the upper limit
prev = previous digit (shifted by +1 to handle -1)
started = whether we’ve started the number (placed a nonzero digit yet)

*/

public class CountingNumbers_CSES {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        long L = Long.parseLong(parts[0]);
        long R = Long.parseLong(parts[1]);

        long ans = count(R)-count(L-1);
        System.out.println(ans);
    }

    private static long count(long N){
        String num = Long.toString(N);
        int len = num.length();
        long[][][][] dp = new long[len][2][11][2];
        for(long[][][] mat: dp) for(long[][] row: mat) for(long[] r: row) Arrays.fill(r, -1);
        return solve(0, 1, -1, 0, num, dp);
    }
    private static long solve(int pos, int tight, int prev, int started, String num, long[][][][]dp){
        if(pos == num.length()){
//            if(started == 1) {
//                return 1; // count only if we actually started
//            }
//            return 0; wrong as we need to count even if started == 0, because that means the number is 0

            return 1;
        }

        if(dp[pos][tight][prev+1][started] != -1) return dp[pos][tight][prev+1][started];
        int limit;
        if(tight == 1){
            limit = num.charAt(pos)-'0';
        } else {
            limit = 9;
        }

        long ans = 0;
        for(int dig=0; dig<=limit; dig++){
            int newStarted = started;
            if(dig!=0 || started==1) newStarted=1; // once non-zero places, we have started, started to 1

            if(newStarted == 1 && prev == dig) continue; // start hoo chuka hai aur
            // then also prev dig same hai to skip karroo bhaii

            int newTight;
            if(tight==1 && dig==limit){
                newTight = 1;
            } else {
                newTight = 0;
            }
            ans += solve(pos+1, newTight, dig, newStarted, num, dp);
        }
        return dp[pos][tight][prev+1][started] = ans;
    }
}
