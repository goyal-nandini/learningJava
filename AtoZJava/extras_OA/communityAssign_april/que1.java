package extras_OA.communityAssign_april;

import java.util.*;

public class que1 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            int maxLen = 0;
            while (r < s.length()) {
                while (map.containsKey(s.charAt(r))) {
                    map.remove(s.charAt(l));
                    l++;
                }
                map.put(s.charAt(r), 1);
                maxLen = Math.max(maxLen, (r - l + 1));
                r++;
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Solution sol = new Solution();
        int result = sol.lengthOfLongestSubstring(s);
        System.out.println(result);
        sc.close();
    }
}

//public class que1 {
//    static class Solution {
//        public int subarraySum(int[] arr, int k) {
//            int count = 0;
//            long currSum = 0;
//            HashMap<Long, Integer> sumOccuranceMap = new HashMap<>();
//            sumOccuranceMap.put(0L, 1);
//            for (int i = 0; i < arr.length; i++) {
//                currSum += arr[i];
//                if (sumOccuranceMap.containsKey(currSum - k)) {
//                    count += sumOccuranceMap.get(currSum - k);
//                }
//                sumOccuranceMap.put(currSum, sumOccuranceMap.getOrDefault(currSum, 0) + 1);
//            }
//            return count;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int k = sc.nextInt();
//        Solution sol = new Solution();
//        int result = sol.subarraySum(arr, k);
//        System.out.println(result);
//        sc.close();
//    }
//}

