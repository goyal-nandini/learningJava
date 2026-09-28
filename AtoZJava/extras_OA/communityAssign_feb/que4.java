package extras_OA.communityAssign_feb;

import java.util.*;

public class que4 {
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int r=0;
        int l=0;
        int n=s.length();

        int minLen = Integer.MAX_VALUE;
        int startInd = -1;
        int cnt=0; // How many characters of t have been matched so far (including duplicates)
        Map<Character, Integer> map = new HashMap<>();

        // t string into map
        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while(r<n){
            char ch = s.charAt(r);

            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1); // decreasing the freq in map
                if(map.get(ch) >= 0) cnt++; // valid match
            }

            else{ // this else as per video but not needed at all ig, ❌ It’s not required
                map.put(ch, map.getOrDefault(ch, -1)-1);
            }

            while(cnt == t.length()){ // all characters matched
                char chl = s.charAt(l);

                // update the window if smaller found[as we need min length]
                if(r-l+1 < minLen){
                    startInd = l;
                    minLen = r-l+1;
                }

                // try to remove from left
                if(map.containsKey(chl)){
                    map.put(chl, map.get(chl)+1);
                    if(map.get(chl) > 0) cnt--;
                }
                l++;
            }
            r++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startInd, startInd+minLen);
    }


    public static void main(String[] args) {
        // Custom Test Case 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindow(s1, t1)); // Expected: "BANC"

        // Custom Test Case 2
        String s2 = "a";
        String t2 = "aa";
        System.out.println(minWindow(s2, t2)); // Expected: ""

        // Custom Test Case 3
        String s3 = "aaabdecf";
        String t3 = "abc";
        System.out.println(minWindow(s3, t3)); // Expected: "abdec"
    }

}

