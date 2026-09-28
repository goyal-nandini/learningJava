package Strings.StringHashing;

import java.util.ArrayList;
import java.util.List;

// reach the PS https://cp-algorithms.com/string/rabin-karp.html
// i did lc 28 and 686 on this

/* METHOD : Prefix Hash + Multiply Method
Preprocessing:
Power array
O(n)
Prefix hash array
O(n)
Pattern hash
O(m)
Window Checking

Each substring hash extraction:

O(1)

because:

prefix[r] - prefix[l-1]
Total
Average
O(n + m)
Worst (with collisions)
O(n * m)
Space Complexity

Arrays:

pow[]
prefix[]

So:

O(n)*/

public class rabin_karp {
    long[] prefix;
    long[] power;
    static final long p = 31;
    static final long mod = 1000000007;

    static List<Integer> rabinKarp(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        List<Integer> ans = new ArrayList<>();

        if (m > n) return ans; // add this at the top

        long[] power = new long[n];

        // precompute powers as p^0, p^1, p^2...
        power[0] = 1;
        for(int i=1; i<n; i++){
            power[i] = (power[i-1]*p)%mod;
        }

        // text prefix hash
        long[] prefix = new long[n];
        // first prefix val
        prefix[0] = (text.charAt(0)-'a'+1); // +1 for numbering as a=1, b=2, c=3 etc else not doing +1 will get us a=0, b=1
        // etc.

        // build prefix array, using the formula here...
        for(int i=1; i<n; i++) {
            long val = text.charAt(i) - 'a' + 1;
            prefix[i] = (prefix[i - 1] + (val * power[i]) % mod) % mod;
        }

        // pattern hash
        long patternHash = 0;
        for(int i=0; i<m; i++){
            long val = pattern.charAt(i) - 'a' + 1;
            patternHash = (patternHash + val*power[i])%mod;
        }

        // compare every substring
        for(int l=0; l<=n-m; l++){
            int r = l+m-1;
            long currHash = prefix[r];

            if(l>0) {
                currHash = (currHash-prefix[l-1]+mod)%mod;
            }

            // normalize by multiplying pattern hash - "Move pattern hash to substring’s power level"
            long adjustedPatternHash = (patternHash*power[l])%mod;

            if(adjustedPatternHash == currHash){
//                if(text.substring(l, r+1).equals(pattern)){ // collision verification step.
//                    ans.add(l);
//                }

                // substring() is bad as it creates new string and then compares

                // optimized way write manual comaprison character by character
                boolean match = true;

                for(int j=0; j<m; j++){

                    if(text.charAt(l+j) != pattern.charAt(j)){
                        match = false;
                        break;
                    }
                }
                if(match) ans.add(l);

            }
        }
        // other we can double hashing :)

        return ans;
    }

    static void main() {
        String text = "abacaba";
        String pattern = "aba";

        System.out.println(rabinKarp(text, pattern));
    }
}
