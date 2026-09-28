package Strings.StringHashing;

import java.util.ArrayList;
import java.util.List;

// tc: O(m+n) sc: O(m+n) for z-array, n = text length and m = pattern length
// Z algorithm achieves linear time because every character is processed at most once while
// expanding the right boundary of the Z-box.
/*For every iteration ask:

Am I inside the box?
What is mirror?
What is remaining?
Can I copy safely?
Do I need extension?

If you can mentally answer these,
you ACTUALLY know Z algorithm.*/

public class Z_Algorithm {
    private static int[] calcZArray(String input){
        int n = input.length();
        int[] z = new int[n]; // Z[i] = length of substring starting at i which matches prefix

        int r = 0, l = 0;
        for(int i=1; i<n; i++){

            // case 1. outside the box
            if(i>r){
                r = l = i;
                while(r<n && input.charAt(r) == input.charAt(r-l)){
                    r++;
                }

                z[i] = r-l; // gives number of matched chars
                r--; // we've to do this as in the loop 'r' gets one index more the valid length so we have to
                // move back one index to restore the last valid index
            }
            // case 2. inside the box
            else {
                int mirror = i - l; // exact prefix matched char with the box
                int remaining = r - i + 1; // how much safe area/length remains inside current box
                // z[mirror] means how long did the match go when we are at pos mirror


                // case 2a.
                if(z[mirror] < remaining){
                    z[i] = z[mirror]; // copy safely || mirror result completely safe → direct copy
                }
                // case 2b.
                else {
                    // start from right and expand || mirror result may continue beyond known boundary → must extend
                    l = i;
                    while(r<n && input.charAt(r) == input.charAt(r-l)){
                        r++;
                    }
                    z[i] = r-l;
                    r--;
                }
            }
        }

        return z;
    }

    private static List<Integer> matchPattern(String text, String pattern){
        int n = pattern.length();
        List<Integer> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder(pattern);
        sb.append("$").append(text); // QUE why we appending a special char
        // ANS: https://leetcode.com/problems/shortest-palindrome/ check 'notes' section

        int[] zVal = calcZArray(sb.toString());
        for(int i=0; i<sb.length(); i++){
            if(zVal[i] == n){
                res.add(i - (n+1));
            }
        }
        return res;
    }

    static void main(String[] args) {
        String text = "abacaba";
        String pattern = "aba";

        System.out.println(matchPattern(text, pattern));
    }
}
