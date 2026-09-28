package extras_OA.communityAssign_feb;

import java.util.HashMap;
import java.util.Map;

public class que1 {
    public static void main(String[] args) {
        int[] arr1 = {10, 2, -2, -20, 10};
        int target1 = -10;
        System.out.println("Output: " + countSubarrays(arr1, target1));
        int[] arr2 = {9, 4, 20, 3, 10, 5};
        int target2 = 33;
        System.out.println("Output: " + countSubarrays(arr2, target2));
        int[] arr3 = {1, 3, 5};
        int target3 = 0;
        System.out.println("Output: " + countSubarrays(arr3, target3));
    }
    public static int countSubarrays(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currSum = 0;
        int cnt=0;
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            int rem = currSum - target;

            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }

            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return cnt;

    }
}
