package extras_OA.communityAssign_feb;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class que3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt(); // number of distinct characters
        long result = countExactlyK(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);

    }
    public static long countExactlyK(String s, int k) {
        return atMostK(s, k) - atMostK(s, k-1);
    }
    public static long atMostK(String s, int k){
        // sliding window:
        if(k<0) return 0; // must add this edge case!!
        char[] arr = s.toCharArray();
        int r=0;
        int l=0;
        int n=s.length();
        int cntSubstring=0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<n){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while(map.size() > k){
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0)
                    map.remove(arr[l]);
                l++;
            }
            cntSubstring += r-l+1;
            r++;
        }
        return cntSubstring;
    }
}
