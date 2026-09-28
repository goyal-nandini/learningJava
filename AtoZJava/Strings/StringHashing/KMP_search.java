package Strings.StringHashing;

import java.util.ArrayList;
import java.util.List;

public class KMP_search {
    // lets do this pure O(m+n) tc and O(n) sc for lps array
    // lps: (Longest Proper Prefix which is also Suffix) array for the pattern

    public static int[] buildLPS(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];

        int i=1, j=0;
        lps[0] = 0;
        while(i<n){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[i] = j+1;
                i++;
                j++;
            } else if(j != 0){
                j = lps[j-1]; // mismatch - jump j, don't touch i IMP
            } else {
                lps[i] = 0;
                i++;  // j==0, nothing to fall back to
            }
        }
        return lps;
    }

    public static List<Integer> kmp_search(String text, String pattern){
        int m = text.length();
        int n = pattern.length();
        int[] lps = buildLPS(pattern);
        for(int val: lps){
            System.out.print(val + " ");
        }
        System.out.println();
        List<Integer> res = new ArrayList<>(); // stores the starting index of each match in the text

        int i=0, j=0;
        while(i<m){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }

            if(j == n){
                res.add(i-j); // full pattern match IMP
                j = lps[j-1]; // continue the search and reset j for getting more starting indexes of pattern in text
            } else if(i<m && text.charAt(i) != pattern.charAt(j)){
                if(j!=0){
                    j = lps[j-1]; // mismatch - jump j, don't touch i IMP
                } else {
                    i++; // j==0, nothing to fall back to
                }
            }
        }
        return res;
    }

    static void main() {
        String text = "abacaba";
        String pattern = "ab";
//        String pattern = "abcabcabc";
//        String pattern = "aaaa";
//        String pattern = "ababab";
//        String pattern = "abcd#dcba";
//        String pattern = "aacecaaa#aaacecaa";
//        String pattern = "aacecaaaa#aaaacecaa";

        System.out.println(kmp_search(text, pattern));
    }
}
